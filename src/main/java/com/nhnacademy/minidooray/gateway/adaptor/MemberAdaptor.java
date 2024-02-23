package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Member;

import java.util.List;

public interface MemberAdaptor {

    List<Member> getMembers();

    Member getMember(String id);

    Member createMember(Member member);

    String deleteMember(String id);
}
