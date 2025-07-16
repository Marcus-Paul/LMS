package com.lms.DAO;

import com.lms.TableClassess.Transactions;

import java.util.List;

public interface TransactionDAO {
    void addTransaction(Transactions transaction);
    void getTransactionByID(int id);
    void getTransactionByMembershipIdBookId(int membershipId, int bookId);
    List<Transactions> listOfTransactions();
    void updateTransaction(Transactions transaction);
    void deleteTransaction(Transactions transaction);
}
