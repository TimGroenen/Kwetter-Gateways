package com.kwetter.userGateway.controller;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.FollowDTO;
import com.kwetter.userGateway.dto.ProfileDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import com.kwetter.userGateway.grpcClient.ProfileClientService;
import com.kwetter.userGateway.kafka.KafkaSender;
import com.kwetter.userGateway.kafka.message.KafkaLoggingType;
import com.kwetter.userGateway.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final KafkaSender kafkaSender;
    private final AuthClientService authService;
    private final ProfileClientService profileService;

    public ProfileController(@Autowired AuthClientService authService, @Autowired ProfileClientService profileService, @Autowired KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
        this.authService = authService;
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> updateProfile(@RequestBody ProfileDTO dto, @RequestHeader("Authorization") String token) {
        //check if profile matches user that sends the request
        RegisterResponse response = authService.getAccountByEmail(JwtUtil.getEmailFromToken(token));

        if(!response.getStatus()) {
            return ResponseEntity.notFound().build();
        }

        //Account is found
        AccountDTO accountDTO = new AccountDTO(response.getAccount());

        //Get profile and check id
        if(dto.getId() == profileService.getProfileByAccountId(accountDTO.getId()).getProfile().getId()) {
            //Profile matches request, update profile
            ProfileResponse profileResponse = profileService.updateProfile(dto.getProfileClass());
            if(profileResponse.getStatus()) {
                return ResponseEntity.ok(new ProfileDTO(profileResponse.getProfile()));
            }
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable Long id) {
        ProfileResponse response = profileService.getProfileById(id);

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("Profile with id: " + id + ", not found", KafkaLoggingType.WARN);
            return ResponseEntity.notFound().build();
        }

        //Profile is found
        ProfileDTO dto = new ProfileDTO(response.getProfile());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<ProfileDTO> getProfileByAccountId(@PathVariable Long id) {
        ProfileResponse response = profileService.getProfileByAccountId(id);

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("Profile with AccountId: " + id + ", not found", KafkaLoggingType.WARN);
            return ResponseEntity.notFound().build();
        }

        //Profile is found
        ProfileDTO dto = new ProfileDTO(response.getProfile());

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/follow")
    public ResponseEntity followUser(@RequestBody FollowDTO dto, @RequestHeader("Authorization") String token) {
        //Check if user matches id
        RegisterResponse response = authService.getAccountByEmail(JwtUtil.getEmailFromToken(token));

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("User to follow not found", KafkaLoggingType.WARN);
            return ResponseEntity.notFound().build();
        }

        //Account is found
        AccountDTO accountDTO = new AccountDTO(response.getAccount());

        //Get profile and check id
        if(dto.getId() == profileService.getProfileByAccountId(accountDTO.getId()).getProfile().getId()) {
            //Follow user
            SimpleResponse followResponse = profileService.followUser(dto.getId(), dto.getFollowedId());

            if(followResponse.getStatus()) {
                return ResponseEntity.ok().build();
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/unfollow")
    public ResponseEntity unfollowUser(@RequestBody FollowDTO dto, @RequestHeader("Authorization") String token) {
        //Check if user matches id
        RegisterResponse response = authService.getAccountByEmail(JwtUtil.getEmailFromToken(token));

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("User to unfollow not found", KafkaLoggingType.WARN);
            return ResponseEntity.notFound().build();
        }

        //Account is found
        AccountDTO accountDTO = new AccountDTO(response.getAccount());

        //Get profile and check id
        if(dto.getId() == profileService.getProfileByAccountId(accountDTO.getId()).getProfile().getId()) {
            //Follow user
            SimpleResponse followResponse = profileService.unfollowUser(dto.getId(), dto.getFollowedId());

            if(followResponse.getStatus()) {
                return ResponseEntity.ok().build();
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/followed/{id}")
    public ResponseEntity<List<ProfileDTO>> getFollowed(@PathVariable Long id) {
        ProfilesResponse profilesResponse = profileService.getFollowed(id);
        List<ProfileDTO> response = new ArrayList<>();

        for (Profile p: profilesResponse.getProfilesList()) {
            response.add(new ProfileDTO(p));
        }

        kafkaSender.sendKafkaLogging("Returning followed for id: " + id, KafkaLoggingType.INFO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/followers/{id}")
    public ResponseEntity<List<ProfileDTO>> getFollowers(@PathVariable Long id) {
        ProfilesResponse profilesResponse = profileService.getFollowers(id);
        List<ProfileDTO> response = new ArrayList<>();

        for (Profile p: profilesResponse.getProfilesList()) {
            response.add(new ProfileDTO(p));
        }

        kafkaSender.sendKafkaLogging("Returning followers for id: " + id, KafkaLoggingType.INFO);
        return ResponseEntity.ok(response);
    }
}
