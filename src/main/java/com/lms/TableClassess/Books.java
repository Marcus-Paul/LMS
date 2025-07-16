package com.lms.TableClassess;

public class Books {
    private int book_id;
    private String book_name;
    private int author_id;
    private String publish_date;
    private int total_copies;
    private int available_copies;
    private int category_id;

    public Books(){}

    public Books(int book_id, String book_name, int author_id, String publish_date, int total_copies, int available_copies, int category_id) {

        this.book_name = book_name;
        this.author_id = author_id;
        this.publish_date = publish_date;
        this.total_copies = total_copies;
        this.available_copies = available_copies;
        this.category_id = category_id;
    }
    public Books(String book_name, int author_id, String publish_date, int total_copies, int available_copies, int category_id) {

        this.book_name = book_name;
        this.author_id = author_id;
        this.publish_date = publish_date;
        this.total_copies = total_copies;
        this.available_copies = available_copies;
        this.category_id = category_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public int getTotal_copies() {
        return total_copies;
    }

    public void setTotal_copies(int total_copies) {
        this.total_copies = total_copies;
    }

    public int getAvailable_copies() {
        return available_copies;
    }

    public void setAvailable_copies(int available_copies) {
        this.available_copies = available_copies;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", author_id=" + author_id +
                ", publish_date='" + publish_date + '\'' +
                ", total_copies=" + total_copies +
                ", available_copies=" + available_copies +
                ", category_id=" + category_id +
                '}';
    }
}
