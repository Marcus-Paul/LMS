package com.lms.EntityClasses;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReservationId implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
	 @Column(name = "membership_id")
	private int membershipId;
	 
	 @Column(name = "book_id")
	private int bookId;
	
	public ReservationId() {}

	public ReservationId(int membershipId, int bookId) {
		
		this.membershipId = membershipId;
		this.bookId = bookId;
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

	@Override
	public int hashCode() {
		return Objects.hash(bookId, membershipId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ReservationId))
			return false;
		ReservationId other = (ReservationId) obj;
		return bookId == other.bookId && membershipId == other.membershipId;
	}
	
	
	
	
}
