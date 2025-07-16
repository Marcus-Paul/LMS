package com.lms.DAOImpli;

import com.lms.DAO.MembersDAO;
import com.lms.TableClassess.Members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembersDAOImpli implements MembersDAO {

    private final Connection connection;

    public  MembersDAOImpli(Connection connection){
        this.connection = connection;
    }

    @Override
    public void newMembership(Members member) {
        try{
            String query = "insert into members (first_name, last_name, phone) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.setString(3, member.getPhone());

            int result = preparedStatement.executeUpdate();
            if(result > 0){
                System.out.println(result + " : row(s) Inserted");
            }
            else{
                System.out.println("No rows Inserted");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getMemberByID(int id) {
        try{
            String query = "select * from members where membership_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Members member = new Members();
                member.setMembership_id(rs.getInt("membership_id"));
                member.setFirstName(rs.getString("first_name"));
                member.setLastName(rs.getString("last_name"));
                member.setPhone(rs.getString("phone"));
                member.setMembership_start(rs.getString("membership_start"));
                member.setMembership_end(rs.getString("membership_end"));
                member.setIsActive(rs.getString("isActive"));

                System.out.println(member);
            }
            else{
                System.out.println("No Member found with ID : " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Members> getAllMembers() {
        List<Members> membersList = new ArrayList<>();
        try{
            String query = "select * from members";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Members member = new Members();
                member.setMembership_id(rs.getInt("membership_id"));
                member.setFirstName(rs.getString("first_name"));
                member.setLastName(rs.getString("last_name"));
                member.setPhone(rs.getString("phone"));
                member.setMembership_start(rs.getString("membership_start"));
                member.setMembership_end(rs.getString("membership_end"));
                member.setIsActive(rs.getString("isActive"));

                membersList.add(member);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return membersList;
    }

    @Override
    public void updateMember(Members member) {
        try{
            String query = "update members set first_name = ?, last_name = ?, phone = ?, membership_start = ? where membership_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.setString(3, member.getPhone());
            preparedStatement.setString(4, member.getMembership_start());
            preparedStatement.setInt(5,member.getMembership_id());
            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println(result + " Row(s) updated");
            }
            else {
                System.out.println("No Rows updated");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteMember(Members member) {

        try {
            String query = "delete from members where membership_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,member.getMembership_id());
            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println(result + " Rows updated");
            }
            else {
                System.out.println("No rows deleted");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
