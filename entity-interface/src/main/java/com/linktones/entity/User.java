package com.linktones.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String account;
    private String password;
    private String token;
    private String name;
    private int level;
    private long gmt_create;
    private long gmt_last_login;

}
