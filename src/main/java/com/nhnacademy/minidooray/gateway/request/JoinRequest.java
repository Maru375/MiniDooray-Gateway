package com.nhnacademy.minidooray.gateway.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequest {
    private String id;

    private String email;

    private String password;

    private String name;
}
