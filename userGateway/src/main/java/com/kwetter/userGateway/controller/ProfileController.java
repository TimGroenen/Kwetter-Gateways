package com.kwetter.userGateway.controller;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.FollowDTO;
import com.kwetter.userGateway.dto.ProfileDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import com.kwetter.userGateway.grpcClient.ProfileClientService;
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
    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final AuthClientService authService;
    private final ProfileClientService profileService;

    public ProfileController(@Autowired AuthClientService authService, @Autowired ProfileClientService profileService) {
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

    @GetMapping("/account/{id}")
    public ResponseEntity<ProfileDTO> getProfileByAccountId(@PathVariable Long id) {
        ProfileResponse response = profileService.getProfileByAccountId(id);

        if(!response.getStatus()) {
            logger.info("Profile with AccountId: " + id + ", not found");
            return ResponseEntity.notFound().build();
        }

        //Profile is found
        ProfileDTO dto = new ProfileDTO(response.getProfile());

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/follow")
    public ResponseEntity<String> followUser(@RequestBody FollowDTO dto, @RequestHeader("Authorization") String token) {
        //Check if user matches id
        RegisterResponse response = authService.getAccountByEmail(JwtUtil.getEmailFromToken(token));

        if(!response.getStatus()) {
            return ResponseEntity.notFound().build();
        }

        //Account is found
        AccountDTO accountDTO = new AccountDTO(response.getAccount());

        //Get profile and check id
        if(dto.getId() == profileService.getProfileByAccountId(accountDTO.getId()).getProfile().getId()) {
            //Follow user
            SimpleResponse followResponse = profileService.followUser(dto.getId(), dto.getFollowedId());

            if(followResponse.getStatus()) {
                return ResponseEntity.ok("Successful follow");
            }
        }
        return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/unfollow")
    public ResponseEntity<String> unfollowUser(@RequestBody FollowDTO dto, @RequestHeader("Authorization") String token) {
        //Check if user matches id
        RegisterResponse response = authService.getAccountByEmail(JwtUtil.getEmailFromToken(token));

        if(!response.getStatus()) {
            return ResponseEntity.notFound().build();
        }

        //Account is found
        AccountDTO accountDTO = new AccountDTO(response.getAccount());

        //Get profile and check id
        if(dto.getId() == profileService.getProfileByAccountId(accountDTO.getId()).getProfile().getId()) {
            //Follow user
            SimpleResponse followResponse = profileService.unfollowUser(dto.getId(), dto.getFollowedId());

            if(followResponse.getStatus()) {
                return ResponseEntity.ok("Successful unfollow");
            }
        }
        return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/followed/{id}")
    public ResponseEntity<List<ProfileDTO>> getFollowed(@PathVariable Long id) {
        ProfilesResponse profilesResponse = profileService.getFollowed(id);
        List<ProfileDTO> response = new ArrayList<>();

        for (Profile p: profilesResponse.getProfilesList()) {
            response.add(new ProfileDTO(p));
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/followers/{id}")
    public ResponseEntity<List<ProfileDTO>> getFollowers(@PathVariable Long id) {
        ProfilesResponse profilesResponse = profileService.getFollowers(id);
        List<ProfileDTO> response = new ArrayList<>();

        for (Profile p: profilesResponse.getProfilesList()) {
            response.add(new ProfileDTO(p));
        }

        return ResponseEntity.ok(response);
    }
}
