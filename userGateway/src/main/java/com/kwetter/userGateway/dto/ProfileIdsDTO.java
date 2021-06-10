package com.kwetter.userGateway.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileIdsDTO {
    List<Long> ids;
    Long profileId;

    public ProfileIdsDTO() {}
}
