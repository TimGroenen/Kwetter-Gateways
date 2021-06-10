package com.kwetter.userGateway;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import com.kwetter.userGateway.controller.ProfileController;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.ProfileDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import com.kwetter.userGateway.grpcClient.ProfileClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProfileControllerTests {
    private ProfileController controller;

    @Mock
    private AuthClientService authService;

    @Mock
    private ProfileClientService profileService;

    private Account account;
    private Profile profile;
    private String token;

    @BeforeEach
    void setUp() {
        controller = new ProfileController(authService, profileService);
        account = Account.newBuilder().setId(1).setEmail("test@test.nl").setPassword("123").setIsAdmin(false).build();
        profile = Profile.newBuilder().setId(1).setAccountId(1).setName("Test").setBio("").setLocation("").setWebsite("").build();
        token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3QubmwiLCJleHAiOjE3MjMzNjAwNjIsImlhdCI6MTYyMzI3MzY2Mn0.0QXSp1aJpV4iz4PA_mWnIDRG6uDzO3080JZrg3BDX7ij7JXkdIeCTmGE2-s-LxCzJP7iEGfeuS-xnzz7x_DQjA";
    }

    @Test
    void updateProfileTest() {
        RegisterResponse response = RegisterResponse.newBuilder().setStatus(true).setAccount(account).build();
        ProfileResponse profileResponse = ProfileResponse.newBuilder().setProfile(profile).setStatus(true).build();
        ProfileDTO dto = new ProfileDTO(profile);

        when(authService.getAccountByEmail(any())).thenReturn(response);
        doReturn(profileResponse).when(profileService).getProfileByAccountId(1L);
        doReturn(profileResponse).when(profileService).updateProfile(dto.getProfileClass());

        ResponseEntity<ProfileDTO> responseEntity = controller.updateProfile(dto, token);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void updateProfileNoTokenMatchTest() {
        RegisterResponse response = RegisterResponse.newBuilder().setStatus(false).build();
        ProfileDTO dto = new ProfileDTO(profile);

        when(authService.getAccountByEmail(any())).thenReturn(response);

        ResponseEntity<ProfileDTO> responseEntity = controller.updateProfile(dto, token);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void updateProfileNoIdMatchTest() {
        RegisterResponse response = RegisterResponse.newBuilder().setStatus(true).setAccount(account).build();
        ProfileResponse profileResponse = ProfileResponse.newBuilder().setProfile(profile).setStatus(true).build();
        ProfileDTO dto = new ProfileDTO(profile);
        dto.setId(999L);

        when(authService.getAccountByEmail(any())).thenReturn(response);
        doReturn(profileResponse).when(profileService).getProfileByAccountId(1L);
        doReturn(profileResponse).when(profileService).updateProfile(dto.getProfileClass());

        ResponseEntity<ProfileDTO> responseEntity = controller.updateProfile(dto, token);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void updateProfileUpdateFailedTest() {
        RegisterResponse response = RegisterResponse.newBuilder().setStatus(true).setAccount(account).build();
        ProfileResponse profileResponse = ProfileResponse.newBuilder().setProfile(profile).setStatus(false).build();
        ProfileDTO dto = new ProfileDTO(profile);

        when(authService.getAccountByEmail(any())).thenReturn(response);
        doReturn(profileResponse).when(profileService).getProfileByAccountId(1L);
        doReturn(profileResponse).when(profileService).updateProfile(dto.getProfileClass());

        ResponseEntity<ProfileDTO> responseEntity = controller.updateProfile(dto, token);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
    }
}
