package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.adaptor.MemberAdaptor;
import com.nhnacademy.minidooray.gateway.request.JoinRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final MemberAdaptor memberAdaptor;

    @GetMapping("/accounts")
    public String joinForm(Model model) {
        model.addAttribute("joinRequest", new JoinRequest());
        return "login/joinForm";
    }

    @PostMapping("/accounts")
    public String join(JoinRequest request, Model model) {
        memberAdaptor.createMember(request);
        return "redirect:/main";
    }

}
