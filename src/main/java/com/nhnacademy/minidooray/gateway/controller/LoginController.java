package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.adaptor.MemberAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Member;
import com.nhnacademy.minidooray.gateway.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final MemberAdaptor memberAdaptor;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(LoginRequest request, Model model, HttpSession session) {
//        Member loginMember = memberAdaptor.getMember(request.getId());
//        if (loginMember != null && request.getPassword().equals(loginMember.getPassword())) {
//            session.setAttribute("member", loginMember);
//            return "redirect:/";
//        }
        Member member = memberAdaptor.getMember(request.getId());
        log.debug(member.toString());
        return "redirect:/main/";
    }

}
