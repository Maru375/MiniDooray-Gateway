package com.nhnacademy.minidooray.gateway.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Project {
    private Integer projectId;

    private String projectName;

    private String projectContent;

    private Tag tagId;

    private MileStone milestoneId;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
