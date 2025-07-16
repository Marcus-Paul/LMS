package com.lms.TableClassess;

public class Members {
    private int membership_id;
    private  String firstName;
    private String lastName;
    private String phone;
    private String membership_start;
    private String membership_end;
    private String isActive;

    public Members(){}

    public Members(int membership_id, String firstName, String lastName, String phone, String membership_start, String membership_end, String isActive) {
        this.membership_id = membership_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.membership_start = membership_start;
        this.membership_end = membership_end;
        this.isActive = isActive;
    }

    public Members(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(int membership_id) {
        this.membership_id = membership_id;
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

    public String getMembership_start() {
        return membership_start;
    }

    public void setMembership_start(String membership_start) {
        this.membership_start = membership_start;
    }

    public String getMembership_end() {
        return membership_end;
    }

    public void setMembership_end(String membership_end) {
        this.membership_end = membership_end;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Members{" +
                "membership_id=" + membership_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", membership_start='" + membership_start + '\'' +
                ", membership_end='" + membership_end + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
