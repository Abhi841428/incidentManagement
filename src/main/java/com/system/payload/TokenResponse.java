package com.system.payload;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {

    private  String type = "Bearer";
    private  String token;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
