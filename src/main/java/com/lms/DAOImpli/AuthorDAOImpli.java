package com.lms.DAOImpli;

import com.lms.DAO.AuthorsDAO;
import com.lms.DB_Connection.DBConnection;
import com.lms.TableClassess.Authors;
import com.lms.TableClassess.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpli implements AuthorsDAO {

    private final Connection connection;

    public AuthorDAOImpli(Connection connection){
        this.connection = connection;
    }

    @Override
    public void addAuthor(Authors author) {
        try{
            String query = "insert into authors (first_name, last_name) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            int result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + "Rows Inserted");
            }
            else {
                System.out.println("No Rows Inserted");
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getAuthorByID(int id) {

        try{
            String query = "Select * from authors where author_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                Authors author = new Authors();
                author.setAuthor_id(rs.getInt("author_id"));
                author.setFirstName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));

                System.out.println(author);
            }
            else {
                System.out.println("No Authors Found with id : "+id);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Authors> getAllAuthors() {
        List<Authors> authorsList = new ArrayList<>();
        try{
            String query = "select * from authors";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Authors author = new Authors();
                author.setAuthor_id(rs.getInt("author_id"));
                author.setFirstName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));

                authorsList.add(author);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return authorsList;
    }

    @Override
    public void updateAuthor(Authors author) {

        try{
            String query = "update authors set first_name = ?, last_name = ? where author_id = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            preparedStatement.setString(1,author.getFirstName());
            preparedStatement.setString(2,author.getLastName());
            preparedStatement.setInt(3, author.getAuthor_id());
            int result = preparedStatement.executeUpdate();

            if(result>0){
                System.out.println(result + " Row(s) Updated");
            }
            else {
                System.out.println("No Rows Updated");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAuthor(Authors author) {
        try{
            String query = "delete from authors where author_id = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            preparedStatement.setInt(1,author.getAuthor_id());
            int result = preparedStatement.executeUpdate();

            if(result>0){
                System.out.println(result + " Row(s) Deleted");
            }
            else {
                System.out.println("No Rows Deleted");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
