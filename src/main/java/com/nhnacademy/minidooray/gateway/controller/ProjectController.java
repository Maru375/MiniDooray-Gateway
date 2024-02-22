package com.nhnacademy.minidooray.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/task")
public class ProjectController {
    @GetMapping("/{projectId}")
    public String viewProject(Integer projectId) {
        return null;
    }
}
