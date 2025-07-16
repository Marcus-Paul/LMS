package com.lms.DAOImpli;

import com.lms.DAO.TransactionDAO;
import com.lms.TableClassess.Transactions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpli implements TransactionDAO {

    private final Connection connection;

    public TransactionDAOImpli(Connection connection){
        this.connection = connection;
    }

    @Override
    public void addTransaction(Transactions transaction) {
        String query = "insert into transactions (membership_id, book_id, issue_date, due_date, return_date) values (?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,transaction.getMembershipId());
            preparedStatement.setInt(2,transaction.getBookId());
            preparedStatement.setString(3,transaction.getIssuedDate());
            preparedStatement.setString(4,transaction.getDueDate());
            preparedStatement.setString(5,transaction.getReturnDate());
            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println(result + "Row(s) Inserted");
            }
            else {
                System.out.println("No Rows Inserted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getTransactionByID(int id) {
        String query = "Select * from transactions where transaction_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Transactions transactions = new Transactions(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                System.out.println(transactions);
            }
            else{
                System.out.println("No Transactions Found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getTransactionByMembershipIdBookId(int membershipId, int bookId) {
        String query = "select * from transactions where membership_id = ? and book_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, membershipId);
            preparedStatement.setInt(2, bookId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Transactions transactions = new Transactions(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                System.out.println(transactions);
            }
            else{
                System.out.println("No Transactions Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Transactions> listOfTransactions() {
        List<Transactions> listTransactions = new ArrayList<>();
        String query = "select * from transactions";
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Transactions transactions = new Transactions(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listTransactions.add(transactions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listTransactions;

    }

    @Override
    public void updateTransaction(Transactions transaction) {
        String query = "update transactions set return_date = ? where transaction_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,transaction.getReturnDate());
            preparedStatement.setInt(2,transaction.getTransactionId());
            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println(result + "Row(s) Updated");
            }
            else {
                System.out.println("No Rows Updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTransaction(Transactions transaction) {
        String query = "delete from transactions where transaction_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,transaction.getTransactionId());
            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println(result + "Row(s) Deleted");
            }
            else {
                System.out.println("No Rows Deleted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
