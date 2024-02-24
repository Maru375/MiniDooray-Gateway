package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Member;
import com.nhnacademy.minidooray.gateway.properties.MemberProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class MemberAdaptorImpl implements MemberAdaptor {

    private final RestTemplate restTemplate;
    private final MemberProperties memberProperties;

    public MemberAdaptorImpl(RestTemplate restTemplate, MemberProperties memberProperties) {
        this.restTemplate = restTemplate;
        this.memberProperties = memberProperties;
    }

    @Override
    public List<Member> getMembers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Member>> exchange = restTemplate.exchange(memberProperties.getAddress() + "/accounts",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Member>>() {
                });
        return exchange.getBody();
    }


    @Override
    public Member getLoginMember(String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        log.debug(requestEntity.toString());

        ResponseEntity<Member> exchange = restTemplate.exchange(memberProperties.getAddress() + "/login/{id}",
                HttpMethod.GET,
                requestEntity,
                Member.class,
                id);
        log.debug(exchange.getBody().toString());
        return exchange.getBody();
    }

    @Override
    public Member getMember(String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        log.debug(requestEntity.toString());

        ResponseEntity<Member> exchange = restTemplate.exchange(memberProperties.getAddress() + "/accounts/{id}",
                HttpMethod.GET,
                requestEntity,
                Member.class,
                id);
        log.debug(exchange.getBody().toString());
        return exchange.getBody();
    }

    @Override
    public Member createMember(Member member) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Member> requestEntity = new HttpEntity<>(member, httpHeaders);
        ResponseEntity<Member> exchange = restTemplate.exchange(memberProperties.getAddress() + "/accounts",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        return exchange.getBody();
    }

    @Override
    public String deleteMember(String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(memberProperties.getAddress() + "/accounts/{id}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, id);
        return exchange.getBody();
    }
}
