package com.website.managerProduct.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePass {
    public BCryptPasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }
}
