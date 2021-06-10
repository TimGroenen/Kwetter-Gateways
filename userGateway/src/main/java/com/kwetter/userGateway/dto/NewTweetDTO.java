package com.kwetter.userGateway.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewTweetDTO {
    Long profileId;
    String content;

    public NewTweetDTO() {}
}
