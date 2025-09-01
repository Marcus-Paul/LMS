package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.Transactions;

public interface TransactionsDAO {
    void addTransaction(int membershipId,int bookId);
    Transactions getTransactionByID(int id);
    Transactions getTransactionByMembershipIdBookId(int membershipId, int bookId);
    List<Transactions> listOfTransactions();
    void updateTransaction(Transactions transaction);
    void deleteTransaction(Transactions transaction);
}
