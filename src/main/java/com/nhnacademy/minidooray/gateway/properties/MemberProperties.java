package com.nhnacademy.minidooray.gateway.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.account")
@Data
public class MemberProperties {
    private String address;
}
