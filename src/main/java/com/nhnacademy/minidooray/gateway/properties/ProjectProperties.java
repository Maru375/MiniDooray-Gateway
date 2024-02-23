package com.nhnacademy.minidooray.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.task")
@Data
public class ProjectProperties {
    private String address;
}