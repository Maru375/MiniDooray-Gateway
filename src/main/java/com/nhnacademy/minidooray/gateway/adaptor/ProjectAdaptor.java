package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.domain.Task;

import java.util.List;

public interface ProjectAdaptor {
    List<Project> getProjects(String memberId);

    List<Task> getProject(String memberId, Integer projectId);

    Project createProject(String memberId, Project project);

    String deleteProject(String memberId, Integer projectId);
}
