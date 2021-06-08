package com.kwetter.userGateway.controller;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.ProfileDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import com.kwetter.userGateway.grpcClient.ProfileClientService;
import com.kwetter.userGateway.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
