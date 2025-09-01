package com.lms.EntityClasses;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
    private int authorId;
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "last_name")
    private String lastName;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> listOfBooks;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Transactions> listOfTransactions;

    public Author(int authorId, String firstName, String lastName){
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {}

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Book> getBooks() {
        return listOfBooks;
    }

    public void setBooks(List<Book> books) {
        this.listOfBooks = books;
    }
    
    public List<Transactions> getTransactions() {
        return listOfTransactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.listOfTransactions = transactions;
    }
    
    public String getAuthorName() {
        return firstName + " " + lastName;
    }

    
    
    @Override
    public String toString() {
        return "Authors{" +
                "author_id=" + authorId +
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
