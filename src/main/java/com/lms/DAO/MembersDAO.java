package com.lms.DAO;

import com.lms.TableClassess.Members;

import java.util.List;

public interface MembersDAO {
    void newMembership(Members member);
    void getMemberByID(int id);
    List<Members> getAllMembers();
    void updateMember(Members member);
    void deleteMember(Members member);
}
