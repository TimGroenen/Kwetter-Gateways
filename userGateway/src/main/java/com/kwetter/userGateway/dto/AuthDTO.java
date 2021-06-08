package com.kwetter.userGateway.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {
    private String email;
    private String password;
    private String name;

    public AuthDTO() {}
}
