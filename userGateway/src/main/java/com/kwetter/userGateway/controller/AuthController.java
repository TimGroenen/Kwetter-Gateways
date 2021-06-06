package com.kwetter.userGateway.controller;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.AuthDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);
    private AuthClientService authService;

    public AuthController(@Autowired AuthClientService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDTO> registerAccount(@RequestBody AuthDTO authDTO) {
        if(authDTO.getEmail() == null || authDTO.getPassword() == null) {
            logger.info("Empty register request");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        RegisterResponse response = authService.register(authDTO.getEmail(), authDTO.getPassword());

        if(!response.getStatus()) {
            logger.info("User is not registered");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        logger.info("New account registered, email: " + response.getAccount().getEmail());
        return new ResponseEntity<>(new AccountDTO(response.getAccount()), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthDTO authDTO) {
        if(authDTO.getEmail() == null || authDTO.getPassword() == null) {
            logger.info("Empty login request");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        LoginResponse response = authService.login(authDTO.getEmail(), authDTO.getPassword());

        if(!response.getStatus()) {
            logger.info("User is not logged in");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        logger.info("Login successful");
        return new ResponseEntity<>("Bearer " + response.getMessage(), HttpStatus.OK);
    }
}
