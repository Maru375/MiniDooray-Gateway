package com.nhnacademy.minidooray.gateway.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Task {
    private int taskId;

    private ProjectMember projectId;

    private ProjectMember managerId;

    private Tag tag;

    private MileStone milestone;

    private String taskName;

    private String taskContent;

    private TaskState taskState;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
