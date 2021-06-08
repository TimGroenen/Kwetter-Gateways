package com.kwetter.userGateway.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowDTO {
    private Long id;
    private Long followedId;

    public FollowDTO() {}
}
