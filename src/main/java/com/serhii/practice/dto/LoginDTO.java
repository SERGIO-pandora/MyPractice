package com.serhii.practice.dto;

import jakarta.validation.constraints.NotNull;

public class LoginDTO {
    @NotNull
    private String username;

    @NotNull
    private String password;

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

}
