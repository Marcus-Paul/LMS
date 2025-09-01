package com.lms.EntityClasses;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
	
	@Id
	@Column(name = "membership_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int membershipId;
	
	@Column(name = "first_name")
    private  String firstName;
	
	@Column(name = "last_name")
    private String lastName;
	
	@Column(name = "phone", length = 10)
    private String phone;
	
	@Column(name = "membership_start")
    private String membershipStart;
	
	@Column(name = "membership_end")
    private String membershipEnd;
	
	@Column(name = "isActive")
    private String isActive;
	
	@OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Reservation> reservations;
	
	@OneToOne(mappedBy = "member")
	private  User user;
	

    public Member(){}

    public Member(int membershipId, String firstName, String lastName, String phone, String membershipStart, String membershipEnd, String isActive) {
        this.membershipId = membershipId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.membershipStart = membershipStart;
        this.membershipEnd = membershipEnd;
        this.isActive = isActive;
    }

    public Member(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMembershipStart() {
        return membershipStart;
    }

    public void setMembershipStart(String membershipStart) {
        this.membershipStart = membershipStart;
    }

    public String getMembershipEnd() {
        return membershipEnd;
    }

    public void setMembershipEnd(String membershipEnd) {
        this.membershipEnd = membershipEnd;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Members{" +
                "membershipId=" + membershipId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", membershipStart='" + membershipStart + '\'' +
                ", membershipEnd='" + membershipEnd + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
