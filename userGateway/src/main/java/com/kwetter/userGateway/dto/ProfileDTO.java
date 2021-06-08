package com.kwetter.userGateway.dto;

import com.kwetter.profileService.proto.ProfileServiceOuterClass;
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

    public ProfileDTO() {}

    public ProfileDTO(ProfileServiceOuterClass.Profile profile) {
        this.id = profile.getId();
        this.accountId = profile.getAccountId();
        this.name = profile.getName();
        this.bio = profile.getBio();
        this.location = profile.getLocation();
        this.website = profile.getWebsite();
    }

    public ProfileServiceOuterClass.Profile getProfileClass() {
        return ProfileServiceOuterClass.Profile.newBuilder()
                .setId(id)
                .setAccountId(accountId)
                .setName(name)
                .setBio(bio)
                .setLocation(location)
                .setWebsite(website)
                .build();
    }
}
