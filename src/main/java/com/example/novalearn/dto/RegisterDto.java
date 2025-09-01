package com.example.novalearn.dto;

import java.math.BigDecimal;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

/**
 * firstName
 * lastName
 * email
 * ?username
 * !password
 */
@Getter
@Setter
public class RegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    private List<String> qualifications;
    private BigDecimal netWorth;
    
    private int discountPoints;
    private String education;
    public Object userNameEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userNameEmail'");
    }
}
