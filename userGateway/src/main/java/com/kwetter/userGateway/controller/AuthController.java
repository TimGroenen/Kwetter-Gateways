package com.kwetter.userGateway.controller;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.AuthDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import com.kwetter.userGateway.grpcClient.ProfileClientService;
import com.kwetter.userGateway.kafka.KafkaSender;
import com.kwetter.userGateway.kafka.message.KafkaLoggingType;
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
    private KafkaSender kafkaSender;
    private AuthClientService authService;
    private ProfileClientService profileService;

    public AuthController(@Autowired AuthClientService authService, @Autowired ProfileClientService profileService, @Autowired KafkaSender kafkaSender) {
        this.authService = authService;
        this.profileService = profileService;
        this.kafkaSender = kafkaSender;
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDTO> registerAccount(@RequestBody AuthDTO authDTO) {
        if(authDTO.getEmail().equals("") || authDTO.getPassword().equals("")) {
            kafkaSender.sendKafkaLogging("Empty register request", KafkaLoggingType.WARN);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        RegisterResponse response = authService.register(authDTO.getEmail(), authDTO.getPassword());

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("User is not registered", KafkaLoggingType.WARN);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //User is registered -> create profile in profileService
        ProfileResponse profileResponse = profileService.createProfile(response.getAccount().getId(), authDTO.getName());

        kafkaSender.sendKafkaLogging("New account registered, email: " + response.getAccount().getEmail(), KafkaLoggingType.INFO);
        return new ResponseEntity<>(new AccountDTO(response.getAccount()), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO authDTO) {
        if(authDTO.getEmail().equals("") || authDTO.getPassword().equals("")) {
            kafkaSender.sendKafkaLogging("Empty login request", KafkaLoggingType.WARN);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        LoginResponse response;
        try {
            response = authService.login(authDTO.getEmail(), authDTO.getPassword());
        } catch (Exception e) {
            kafkaSender.sendKafkaLogging("Login: " + e.getMessage(), KafkaLoggingType.ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("User is not logged in", KafkaLoggingType.WARN);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", "Bearer " + response.getMessage());

        kafkaSender.sendKafkaLogging("Login successful", KafkaLoggingType.INFO);
        return ResponseEntity.ok().headers(responseHeaders).build();
    }

    @PostMapping("/email")
    public ResponseEntity<AccountDTO> getAccountByEmail(@RequestBody AuthDTO dto) {
        RegisterResponse response = authService.getAccountByEmail(dto.getEmail());

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("Account with email not found: " + dto.getEmail(), KafkaLoggingType.WARN);
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(new AccountDTO(response.getAccount()), HttpStatus.OK);
    }
}
