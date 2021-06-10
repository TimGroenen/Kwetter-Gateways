package com.kwetter.userGateway.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDTO {
    Long profileId;
    Long tweetId;

    public LikeDTO() {}
}
