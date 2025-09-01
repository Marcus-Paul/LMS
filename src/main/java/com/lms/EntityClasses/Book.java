package com.lms.EntityClasses;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
	
	@Column(name = "book_name")
    private String bookName;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
    private Author author;
	
	@Column(name = "publish_date")
    private String publishDate;
	
	@Column(name = "total_Copies")
    private int totalCopies;
	
	@Column(name = "available_copies")
    private int availableCopies;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
    private Category category;
	
	@OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Reservation> listOfReservations ;
	
	@OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Transactions> listOfTransactions;

    public Book(){}

    public Book(int bookId, String bookName, Author author, String publishDate, int totalCopies, int availableCopies, Category category) {

        this.bookName = bookName;
        this.author = author;
        this.publishDate = publishDate;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.category = category;
    }
    public Book(String bookName, Author author, String publishDate, int totalCopies, int availableCopies, Category category) {

        this.bookName = bookName;
        this.author = author;
        this.publishDate = publishDate;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.category = category;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public List<Reservation> getReservations() {
        return listOfReservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.listOfReservations = reservations;
    }
    
    public void setTransactions(List<Transactions> transactions) {
        this.listOfTransactions = transactions;
    }
    
    
    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author=" + (author != null ? author.getAuthorName() : "null") +
                ", publishDate='" + publishDate + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                ", category=" + (category != null ? category.getCategoryName() : "null") +
                '}';
    }
}
