package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.Member;

public interface MemberDAO {
    void newMembership(Member member);
    Member getMemberByID(int id);
    List<Member> getAllMembers();
    void updateMember(Member member);
    void deleteMember(Member member);
}
