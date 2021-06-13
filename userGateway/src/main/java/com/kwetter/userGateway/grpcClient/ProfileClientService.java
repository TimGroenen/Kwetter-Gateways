package com.kwetter.userGateway.grpcClient;

import com.kwetter.profileService.proto.ProfileServiceGrpc;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProfileClientService {
    private final String ip = "10.0.193.214";

    public ProfileResponse createProfile(Long accountId, String name) {
        NewProfileRequest request = NewProfileRequest.newBuilder().setAccountId(accountId).setName(name).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        ProfileResponse response = stub.createNewProfile(request);

        channel.shutdown();
        return response;
    }

    public ProfileResponse updateProfile(Profile profile) {
        UpdateProfileInfoRequest request = UpdateProfileInfoRequest.newBuilder().setProfile(profile).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        ProfileResponse response = stub.updateProfileInfo(request);

        channel.shutdown();
        return response;
    }

    public ProfileResponse getProfileById(Long profileId) {
        GetByProfileIdRequest request = GetByProfileIdRequest.newBuilder().setProfileId(profileId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        ProfileResponse response = stub.getProfileById(request);

        channel.shutdown();
        return response;
    }

    public ProfileResponse getProfileByAccountId(Long accountId) {
        GetProfileByUserIdRequest request = GetProfileByUserIdRequest.newBuilder().setUserId(accountId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        ProfileResponse response = stub.getProfileByUserId(request);

        channel.shutdown();
        return response;
    }

    public SimpleResponse followUser(Long userId, Long userFollowedId) {
        FollowUserRequest request = FollowUserRequest.newBuilder().setUserFollowingId(userId).setUserFollowedId(userFollowedId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        SimpleResponse response = stub.followUser(request);

        channel.shutdown();
        return response;
    }

    public SimpleResponse unfollowUser(Long userId, Long userFollowedId) {
        FollowUserRequest request = FollowUserRequest.newBuilder().setUserFollowingId(userId).setUserFollowedId(userFollowedId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        SimpleResponse response = stub.unfollowUser(request);

        channel.shutdown();
        return response;
    }

    public ProfilesResponse getFollowed(Long profileId) {
        GetByProfileIdRequest request = GetByProfileIdRequest.newBuilder().setProfileId(profileId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        ProfilesResponse response = stub.getFollowed(request);

        channel.shutdown();
        return response;
    }

    public ProfilesResponse getFollowers(Long profileId) {
        GetByProfileIdRequest request = GetByProfileIdRequest.newBuilder().setProfileId(profileId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, 5001).usePlaintext().build();
        ProfileServiceGrpc.ProfileServiceBlockingStub stub = ProfileServiceGrpc.newBlockingStub(channel);

        ProfilesResponse response = stub.getFollowers(request);

        channel.shutdown();
        return response;
    }
}
