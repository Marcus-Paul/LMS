package com.lms.TableClassess;

public class Authors {
    private int author_id;
    private String firstName;
    private String lastName;

    public Authors(int author_id, String firstName, String lastName){
        this.author_id = author_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Authors(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Authors() {}

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "author_id=" + author_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
