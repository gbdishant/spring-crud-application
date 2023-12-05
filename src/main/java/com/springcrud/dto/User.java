package com.springcrud.dto;

import lombok.Data;

@Data
public class User {

    private int id;
    private String email;
    private String gender;
    private String name;
    private String status;
    private String userId;
}