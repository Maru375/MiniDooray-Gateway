package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.domain.Task;
import com.nhnacademy.minidooray.gateway.properties.ProjectProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
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
    public List<Project> getProjects(String memberId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-USER-ID", memberId);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Project>> exchange = restTemplate.exchange(projectProperties.getAddress() + "/projects",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Project>>() {
                });
        return exchange.getBody();
    }

    @Override
    public List<Task> getProject(String memberId, Integer projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        log.debug(requestEntity.toString());

        ResponseEntity<List<Task>> exchange = restTemplate.exchange(projectProperties.getAddress() + "/tasks/project/{id}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Task>>() {
                }, projectId);
        return exchange.getBody();
    }

    @Override
    public Project createProject(String memberId, Project project) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Project> requestEntity = new HttpEntity<>(project, httpHeaders);
        ResponseEntity<Project> exchange = restTemplate.exchange(projectProperties.getAddress() + "/projects",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        return exchange.getBody();
    }

    @Override
    public String deleteProject(String memberId, Integer projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(projectProperties.getAddress() + "/projects/{id}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, projectId);
        return exchange.getBody();
    }
}
