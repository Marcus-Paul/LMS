package com.lms.TableClassess;

public class Transactions {
    private int transactionId;
    private int membershipId;
    private int bookId;
    private String issuedDate;
    private String dueDate;
    private String returnDate;
    private int lateFee;

    public Transactions(int transactionId, int membershipId, int bookId, String issuedDate, String dueDate, String returnDate, int lateFee) {
        this.transactionId = transactionId;
        this.membershipId = membershipId;
        this.bookId = bookId;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.lateFee = lateFee;
    }

    public Transactions(int membershipId, int bookId, String issuedDate, String dueDate, String returnDate) {
        this.membershipId = membershipId;
        this.bookId = bookId;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public Transactions(){}

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getLateFee() {
        return lateFee;
    }

    public void setLateFee(int lateFee) {
        this.lateFee = lateFee;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", membershipId=" + membershipId +
                ", bookId=" + bookId +
                ", issuedDate='" + issuedDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", lateFee=" + lateFee +
                '}';
    }
}
