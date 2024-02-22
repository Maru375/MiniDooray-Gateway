package com.nhnacademy.minidooray.gateway.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProjectMember {
    private Pk pk;

    private AuthType authType;

    private Project projectId;

    public static class Pk implements Serializable {

        private String memberId;

        private Integer projectId;

    }
}
