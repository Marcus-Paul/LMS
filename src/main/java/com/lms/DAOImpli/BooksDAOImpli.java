package com.lms.DAOImpli;

import com.lms.TableClassess.Books;
import com.lms.DAO.BooksDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOImpli implements BooksDAO {

    private Connection connection;

    public  BooksDAOImpli(Connection connection){
        this.connection = connection;
    }

    @Override
    public void addBook(Books book) {
        try{
            String query = "insert into books (book_name, author_id, publish_date, total_copies, available_copies, category_id)" +
                    "values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,book.getBook_name());
            ps.setInt(2,book.getAuthor_id());
            ps.setString(3,book.getPublish_date());
            ps.setInt(4,book.getTotal_copies());
            ps.setInt(5,book.getAvailable_copies());
            ps.setInt(6,book.getCategory_id());

            int result = ps.executeUpdate();

            if(result>0){
                System.out.println(result + "Rows Inserted");
            }
            else{
                System.out.println("No Rows Inserted");
            }


        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getBookById(int id) {
        try{
            String query = "select * from books where book_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                Books book = new Books();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_name(rs.getString("book_name"));
                book.setAuthor_id(rs.getInt("author_id"));
                book.setPublish_date(rs.getString("publish_date"));
                book.setTotal_copies(rs.getInt("total_copies"));
                book.setAvailable_copies(rs.getInt("available_copies"));
                book.setCategory_id(rs.getInt("catogery_id"));

                System.out.println(book);
            }
            else{
                System.out.println("No book found with the id : " + id);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Books> getAllBooks() {

        List<Books> bookList = new ArrayList<>();
        try {
            String query = "select * from books";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Books book = new Books();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_name(rs.getString("book_name"));
                book.setAuthor_id(rs.getInt("author_id"));
                book.setPublish_date(rs.getString("publish_date"));
                book.setTotal_copies(rs.getInt("total_copies"));
                book.setAvailable_copies(rs.getInt("available_copies"));
                book.setCategory_id(rs.getInt("catogery_id"));

                bookList.add(book);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return bookList;
    }

    @Override
    public void updateBook(Books book) {

        try{
            String query = "update books set book_name = ?, author_id = ?, publish_date = ?, total_copies = ?, available_copies = ?, category_id = ? where book_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,book.getBook_name());
            preparedStatement.setInt(2, book.getAuthor_id());
            preparedStatement.setString(3, book.getPublish_date());
            preparedStatement.setInt(4,book.getTotal_copies());
            preparedStatement.setInt(5,book.getAvailable_copies());
            preparedStatement.setInt(6,book.getCategory_id());
            preparedStatement.setInt(7,book.getBook_id());
            int result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + " Rows updated");
            }
            else {
                System.out.println("No Rows Updated");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteBook(Books book) {
        try{
            String query = "delete from books where book_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,book.getBook_id());
            int result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + " Row Deleted");
            }
            else {
                System.out.println("No Rows Deleted");
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
