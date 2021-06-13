package com.kwetter.userGateway.grpcClient;

import com.kwetter.authService.proto.AuthServiceGrpc;
import com.kwetter.authService.proto.AuthServiceOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class AuthClientService {
    private final String ip = "10.0.132.212";

    public RegisterResponse register(String email, String password) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5000).usePlaintext().build();

        AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);

        RegisterResponse response = stub.register(RegisterRequest.newBuilder().setEmail(email).setPassword(password).build());

        channel.shutdown();
        return response;
    }

    public LoginResponse login(String email, String password) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5000).usePlaintext().build();

        AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);

        LoginResponse response = stub.login(LoginRequest.newBuilder().setEmail(email).setPassword(password).build());

        channel.shutdown();
        return response;
    }

    public ValidationResponse validateToken(String token) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5000).usePlaintext().build();

        AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);

        ValidationResponse response = stub.validateToken(ValidationRequest.newBuilder().setToken(token).build());

        channel.shutdown();
        return response;
    }

    public RegisterResponse getAccountByEmail(String email) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5000).usePlaintext().build();
        AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);

        RegisterResponse response = stub.getAccountByEmail(EmailRequest.newBuilder().setEmail(email).build());

        channel.shutdown();
        return response;
    }
}
