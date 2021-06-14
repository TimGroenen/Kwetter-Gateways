package com.kwetter.userGateway.controller;

import com.kwetter.messageService.proto.MessageServiceOuterClass.*;
import com.kwetter.userGateway.dto.LikeDTO;
import com.kwetter.userGateway.dto.NewTweetDTO;
import com.kwetter.userGateway.dto.ProfileIdsDTO;
import com.kwetter.userGateway.dto.TweetDTO;
import com.kwetter.userGateway.grpcClient.MessageClientService;
import com.kwetter.userGateway.kafka.KafkaSender;
import com.kwetter.userGateway.kafka.message.KafkaLoggingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tweet")
public class MessageController {
    private KafkaSender kafkaSender;
    private MessageClientService messageService;

    public MessageController(@Autowired MessageClientService messageService, @Autowired KafkaSender kafkaSender) {
        this.messageService = messageService;
        this.kafkaSender = kafkaSender;
    }

    @PostMapping
    public ResponseEntity createNewTweet(@RequestBody NewTweetDTO dto) {
        SimpleResponse response = messageService.createNewTweet(dto.getProfileId(), dto.getContent());

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("Create new tweet failed", KafkaLoggingType.WARN);
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/ids")
    public ResponseEntity<List<TweetDTO>> getTweetsByProfileIds(@RequestBody ProfileIdsDTO dto) {
        TweetsResponse response = messageService.getTweetsByProfileIds(dto.getIds(), dto.getProfileId());

        List<TweetDTO> tweetList = new ArrayList<>();
        for (Tweet t: response.getTweetsList()) {
            tweetList.add(new TweetDTO(t));
        }

        return ResponseEntity.ok(tweetList);
    }

    @PostMapping("/like")
    public ResponseEntity likeTweet(@RequestBody LikeDTO dto) {
        SimpleResponse response = messageService.likeTweet(dto.getProfileId(), dto.getTweetId());

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("Like tweet failed", KafkaLoggingType.WARN);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/unlike")
    public ResponseEntity unlikeTweet(@RequestBody LikeDTO dto) {
        SimpleResponse response = messageService.unlikeTweet(dto.getProfileId(), dto.getTweetId());

        if(!response.getStatus()) {
            kafkaSender.sendKafkaLogging("Unlike tweet failed", KafkaLoggingType.WARN);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
