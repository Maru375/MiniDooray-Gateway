package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.adaptor.MemberAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WelcomeController {
    private final MemberAdaptor memberAdaptor;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

//    @GetMapping("/test")
//    public String test() {
//        List<Member> list = memberAdaptor.getMembers();
//        return "main";
//    }
//
//    @DeleteMapping("/test/1")
//    public String test1() {
//        String test = memberAdaptor.deleteMember("gatewaytest");
//        return "main";
//    }
//
//    @PostMapping("/test")
//    public String join(Member member) {
//        memberAdaptor.createMember(member);
//        return "main";
//    }
}
