package com.lms.EntityClasses;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@EmbeddedId
	private ReservationId id;
	
	@ManyToOne
	@MapsId("membershipId")
	@JoinColumn(name = "membership_id")
    private Member member;
	
	@ManyToOne
	@MapsId("bookId")
	@JoinColumn(name = "book_id")
    private Book book;
	
	@Column(name = "current_status", insertable = false)
    private String status;

    public Reservation(){}
    
    public Reservation(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.id = new ReservationId(member.getMembershipId(), book.getBookId());
    }


    public Reservation(Member member, Book book, String status) {
        this(member, book);
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "member=" + member +
                ", book=" + book +
                ", status='" + status + '\'' +
                '}';
    }
}
