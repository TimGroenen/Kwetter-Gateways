package com.kwetter.userGateway;

import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import com.kwetter.userGateway.controller.AuthController;
import com.kwetter.userGateway.dto.AccountDTO;
import com.kwetter.userGateway.dto.AuthDTO;
import com.kwetter.userGateway.grpcClient.AuthClientService;
import com.kwetter.userGateway.grpcClient.ProfileClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
public class AuthControllerTests {
    private AuthController authController;

    @Mock
    private AuthClientService authService;
    @Mock
    private ProfileClientService profileService;

    @BeforeEach
    public void setup() {
        authController = new AuthController(authService, profileService);
    }

    ///Register tests
    @Test
    public void AuthControllerRegisterTest() {
        String email = "test@test.nl";
        String name = "Test Testinsons";
        String password = "test";
        AuthDTO dto = new AuthDTO();
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setName(name);
        RegisterResponse serviceResponse = RegisterResponse.newBuilder().setStatus(true).setAccount(Account.newBuilder().setEmail(email).build()).build();

        doReturn(serviceResponse).when(authService).register(dto.getEmail(), dto.getPassword());
        doReturn(null).when(profileService).createProfile(any(), any());

        ResponseEntity<AccountDTO> response = authController.registerAccount(dto);
        verify(profileService, times(1)).createProfile(any(), any());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void AuthControllerRegisterEmptyInputTest() {
        String email = "";
        String password = "";
        AuthDTO dto = new AuthDTO();
        dto.setEmail(email);
        dto.setPassword(password);

        ResponseEntity<AccountDTO> response = authController.registerAccount(dto);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void AuthControllerRegisterBadRequestTest() {
        String email = "test@test.nl";
        String password = "test";
        AuthDTO dto = new AuthDTO();
        dto.setEmail(email);
        dto.setPassword(password);
        RegisterResponse serviceResponse = RegisterResponse.newBuilder().setStatus(false).setAccount(Account.newBuilder().setEmail(email).build()).build();

        doReturn(serviceResponse).when(authService).register(dto.getEmail(), dto.getPassword());

        ResponseEntity<AccountDTO> response = authController.registerAccount(dto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    ///Login tests
    @Test
    public void AuthControllerLoginTest() {
        String email = "test@test.nl";
        String password = "test";
        AuthDTO dto = new AuthDTO();
        dto.setEmail(email);
        dto.setPassword(password);
        LoginResponse serviceResponse = LoginResponse.newBuilder().setStatus(true).setMessage("Token").build();

        doReturn(serviceResponse).when(authService).login(dto.getEmail(), dto.getPassword());

        ResponseEntity<String> response = authController.login(dto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void AuthControllerLoginEmptyInputTest() {
        String email = "";
        String password = "";
        AuthDTO dto = new AuthDTO();
        dto.setEmail(email);
        dto.setPassword(password);

        ResponseEntity<String> response = authController.login(dto);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void AuthControllerLoginBadRequestTest() {
        String email = "test@test.nl";
        String password = "test";
        AuthDTO dto = new AuthDTO();
        dto.setEmail(email);
        dto.setPassword(password);
        LoginResponse serviceResponse = LoginResponse.newBuilder().setStatus(false).setMessage("Token").build();

        doReturn(serviceResponse).when(authService).login(dto.getEmail(), dto.getPassword());

        ResponseEntity<String> response = authController.login(dto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
