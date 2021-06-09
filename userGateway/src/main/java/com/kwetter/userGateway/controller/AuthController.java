package com.kwetter.userGateway.controller;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.AuthDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import com.kwetter.userGateway.grpcClient.ProfileClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);
    private AuthClientService authService;
    private ProfileClientService profileService;

    public AuthController(@Autowired AuthClientService authService, @Autowired ProfileClientService profileService) {
        this.authService = authService;
        this.profileService = profileService;
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDTO> registerAccount(@RequestBody AuthDTO authDTO) {
        if(authDTO.getEmail().equals("") || authDTO.getPassword().equals("")) {
            logger.info("Empty register request");
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        RegisterResponse response = authService.register(authDTO.getEmail(), authDTO.getPassword());

        if(!response.getStatus()) {
            logger.info("User is not registered");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //User is registered -> create profile in profileService
        ProfileResponse profileResponse = profileService.createProfile(response.getAccount().getId(), authDTO.getName());

        logger.info("New account registered, email: " + response.getAccount().getEmail());
        return new ResponseEntity<>(new AccountDTO(response.getAccount()), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO authDTO) {
        if(authDTO.getEmail().equals("") || authDTO.getPassword().equals("")) {
            logger.info("Empty login request");
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        LoginResponse response = authService.login(authDTO.getEmail(), authDTO.getPassword());

        if(!response.getStatus()) {
            logger.info("User is not logged in");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", "Bearer " + response.getMessage());

        logger.info("Login successful");
        return ResponseEntity.ok().headers(responseHeaders).build();
    }

    @PostMapping("/email")
    public ResponseEntity<AccountDTO> getAccountByEmail(@RequestBody AuthDTO dto) {
        RegisterResponse response = authService.getAccountByEmail(dto.getEmail());

        if(!response.getStatus()) {
            logger.info("Account with Email not found");
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(new AccountDTO(response.getAccount()), HttpStatus.OK);
    }
}
