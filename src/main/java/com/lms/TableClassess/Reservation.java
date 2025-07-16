package com.lms.TableClassess;

public class Reservation {
    private int membership_id;
    private int book_id;
    private String status;

    public Reservation(){}
    
    public Reservation(int membership_id, int book_id) {
        this.membership_id = membership_id;
        this.book_id = book_id;
    }

    public Reservation(int membership_id, int book_id, String status) {
        this.membership_id = membership_id;
        this.book_id = book_id;
        this.status = status;
    }

    public int getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(int membership_id) {
        this.membership_id = membership_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "membership_id=" + membership_id +
                ", book_id=" + book_id +
                ", status='" + status + '\'' +
                '}';
    }
}
