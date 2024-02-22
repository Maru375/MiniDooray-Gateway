package com.nhnacademy.minidooray.gateway.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MileStone {
    private Integer milestoneId;

    private String name;

    private LocalDateTime startedAt;

    private LocalDateTime endDate;
}
