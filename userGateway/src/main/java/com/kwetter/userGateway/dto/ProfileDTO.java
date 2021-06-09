package com.kwetter.userGateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.protobuf.ByteString;
import com.kwetter.profileService.proto.ProfileServiceOuterClass.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
    private Long id;
    private Long accountId;
    private String name;
    private String bio;
    private String location;
    private String website;
    private byte[] image;

    public ProfileDTO() {}

    @JsonIgnore
    public ProfileDTO(Profile profile) {
        this.id = profile.getId();
        this.accountId = profile.getAccountId();
        this.name = profile.getName();
        this.bio = profile.getBio();
        this.location = profile.getLocation();
        this.website = profile.getWebsite();
        this.image = profile.getImage().toByteArray();
    }

    @JsonIgnore
    public Profile getProfileClass() {
        return Profile.newBuilder()
                .setId(id)
                .setAccountId(accountId)
                .setName(name)
                .setBio(bio)
                .setLocation(location)
                .setWebsite(website)
                .setImage(ByteString.copyFrom(image))
                .build();
    }
}
