package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Project;

import java.util.List;

public interface ProjectAdaptor {
    List<Project> getProjects();

    Project getProject(Integer projectId);

    Project createProject(Project project);

    String deleteProject(Integer projectId);
}
