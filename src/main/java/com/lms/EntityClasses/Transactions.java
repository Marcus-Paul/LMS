package com.lms.EntityClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
	
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
	
	@ManyToOne
	@JoinColumn(name = "membership_id")
    private Member member;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
    private Book book;
	
	@Column(name = "issue_date")
    private String issuedDate;
	
	@Column(name = "due_date")
    private String dueDate;
	
	@Column(name = "return_date")
    private String returnDate;
	
	@Column(name = "late_fee")
    private int lateFee;

    public Transactions(int transactionId, Member member, Book book, String issuedDate, String dueDate, String returnDate, int lateFee) {
        this.transactionId = transactionId;
        this.member = member;
        this.book = book;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.lateFee = lateFee;
    }

    public Transactions(Member member, Book book, String issuedDate, String dueDate, String returnDate) {
        this.member = member;
        this.book = book;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }
    
    public Transactions(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public Transactions(){}

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member membershipId) {
        this.member = membershipId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
                ", membershipId=" + member +
                ", bookId=" + book +
                ", issuedDate='" + issuedDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", lateFee=" + lateFee +
                '}';
    }
}
