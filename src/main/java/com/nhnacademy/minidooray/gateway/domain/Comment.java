package com.nhnacademy.minidooray.gateway.domain;

import java.time.LocalDateTime;

public class Comment {
    private Integer commentId;

    private Task taskId;

    private String name;

    private String commentsContent;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
