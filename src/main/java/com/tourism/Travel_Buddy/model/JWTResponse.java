package com.tourism.Travel_Buddy.model;

public class JWTResponse {

    private String jwtToken;
    private String username;

    private String role;


    public JWTResponse() {
    }

    public JWTResponse(String jwtToken, String username,String role) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.role = role;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "JWTResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
