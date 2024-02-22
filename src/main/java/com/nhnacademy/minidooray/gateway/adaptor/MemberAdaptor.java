package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Member;
import com.nhnacademy.minidooray.gateway.request.JoinRequest;

import java.util.List;

public interface MemberAdaptor {

    List<Member> getMembers();

    Member getMember(String id);

    Member createMember(JoinRequest joinRequest);

    String deleteMember(Long id);
}
