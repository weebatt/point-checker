package com.example.weebat.WebLab4.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}