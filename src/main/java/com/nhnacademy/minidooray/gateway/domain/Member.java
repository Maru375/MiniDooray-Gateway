package com.nhnacademy.minidooray.gateway.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String memberId;

    private String email;

    private String password;

    private String name;

    private String state;
}
