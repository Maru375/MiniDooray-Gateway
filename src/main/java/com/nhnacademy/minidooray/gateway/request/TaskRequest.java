package com.nhnacademy.minidooray.gateway.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    String title;
    String recorder;
    Integer projectId;
    String endDate;
    Integer tagId;
    Integer milestoneId;
}
