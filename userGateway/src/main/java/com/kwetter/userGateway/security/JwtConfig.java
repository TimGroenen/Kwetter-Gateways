package com.kwetter.userGateway.security;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class JwtConfig {
    private final String Uri = "/auth/**";

    private final String header = "Authorization";

    private final String prefix = "Bearer ";

    private final int expiration = 24*60*60;

    private String secret = "KwetterSecretKey";
}
