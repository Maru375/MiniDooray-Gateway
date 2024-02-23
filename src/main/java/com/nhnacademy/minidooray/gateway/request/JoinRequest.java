package com.nhnacademy.minidooray.gateway.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequest {
    private String memberId;

    private String email;

    private String password;

    private String name;
}
