package com.kwetter.userGateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kwetter.authService.proto.AuthServiceOuterClass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountDTO {
    private Long id;
    private String email;
    private String password;
    private boolean isAdmin;

    public AccountDTO() {}

    @JsonIgnore
    public AccountDTO(AuthServiceOuterClass.Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.isAdmin = account.getIsAdmin();
    }
}
