package com.kwetter.userGateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kwetter.messageService.proto.MessageServiceOuterClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TweetDTO {
    Long id;
    Long profileId;
    String content;
    Long date;
    int likes;
    boolean isLiked;

    public TweetDTO() {}

    @JsonIgnore
    public TweetDTO(MessageServiceOuterClass.Tweet tweet) {
        this.id = tweet.getId();
        this.profileId = tweet.getProfileId();
        this.content = tweet.getContent();
        this.date = tweet.getDate();
        this.likes = tweet.getLikes();
        this.isLiked = tweet.getIsLiked();
    }

    @JsonIgnore
    public MessageServiceOuterClass.Tweet getTweetClass() {
        return MessageServiceOuterClass.Tweet.newBuilder()
                .setId(id)
                .setProfileId(profileId)
                .setContent(content)
                .setDate(date)
                .setLikes(likes)
                .setIsLiked(isLiked)
                .build();
    }
}
