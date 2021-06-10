package com.kwetter.userGateway.grpcClient;

import com.kwetter.messageService.proto.MessageServiceGrpc;
import com.kwetter.messageService.proto.MessageServiceOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageClientService {
    public SimpleResponse createNewTweet(Long profileId, String content) {
        NewTweetRequest request = NewTweetRequest.newBuilder().setProfileId(profileId).setContent(content).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5002).usePlaintext().build();
        MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);

        SimpleResponse response = stub.createNewTweet(request);

        channel.shutdown();
        return response;
    }

    public TweetsResponse getTweetsByProfileIds(List<Long> profileIds, Long profileId) {
        TweetsByProfileRequest request = TweetsByProfileRequest.newBuilder().addAllProfileIds(profileIds).setProfileId(profileId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5002).usePlaintext().build();
        MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);

        TweetsResponse response = stub.getTweetsByProfileIds(request);

        channel.shutdown();
        return response;
    }

    public SimpleResponse likeTweet(Long profileId, Long tweetId) {
        LikeTweetRequest request = LikeTweetRequest.newBuilder().setTweetId(tweetId).setProfileId(profileId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5002).usePlaintext().build();
        MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);

        SimpleResponse response = stub.like(request);

        channel.shutdown();
        return response;
    }

    public SimpleResponse unlikeTweet(Long profileId, Long tweetId) {
        LikeTweetRequest request = LikeTweetRequest.newBuilder().setTweetId(tweetId).setProfileId(profileId).build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5002).usePlaintext().build();
        MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);

        SimpleResponse response = stub.unlike(request);

        channel.shutdown();
        return response;
    }
}
