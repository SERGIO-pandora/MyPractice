package com.serhii.practice.dto;

public class TokenDTO {

    public TokenDTO(String token){
        this.token = token;
    }

    private String token;

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }
}
