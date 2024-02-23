package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.properties.ProjectProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProjectAdaptorImpl implements ProjectAdaptor {
    private final RestTemplate restTemplate;
    private final ProjectProperties projectProperties;

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public Project getProject(Integer projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        log.debug(requestEntity.toString());

        ResponseEntity<Project> exchange = restTemplate.exchange(projectProperties.getAddress() + "/projects/{id}",
                HttpMethod.GET,
                requestEntity,
                Project.class,
                projectId);
        Project project = exchange.getBody();
        return exchange.getBody();
    }

    @Override
    public Project createProject(Project project) {
        return null;
    }

    @Override
    public String deleteProject(Integer projectId) {
        return null;
    }
}
