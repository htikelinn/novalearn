package com.example.novalearn.entity;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("SITE_OWNER")
public class SiteOwner extends User {

    private BigDecimal platformShare;

    public SiteOwner(String firstName, String lastName, String email, String username, String password,
            BigDecimal platformShare) {
        super(firstName, lastName, email, username, password);
        this.platformShare = platformShare;
    }

}
