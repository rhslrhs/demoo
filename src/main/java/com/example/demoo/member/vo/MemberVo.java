package com.example.demoo.member.vo;

import java.time.LocalDateTime;

public class MemberVo {

    private String email;
    private String name;
    private LocalDateTime registDateTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegistDateTime() {
        return registDateTime;
    }
    public void setRegistDateTime(LocalDateTime registDateTime) {
        this.registDateTime = registDateTime;
    }
}