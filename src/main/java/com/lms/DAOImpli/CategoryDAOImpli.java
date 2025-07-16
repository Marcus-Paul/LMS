package com.lms.DAOImpli;

import com.lms.DAO.CategoryDAO;
import com.lms.TableClassess.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpli implements CategoryDAO {
    private final Connection connection;
    public CategoryDAOImpli(Connection connection){
        this.connection = connection;
    }
    @Override
    public void addCategory(Category category) {
        String query = "insert into category (category_name) values (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
           preparedStatement.setString(1,category.getCategory_name());
           int result = preparedStatement.executeUpdate();
           if (result>0){
               System.out.println(result + "row(s) inserted");
           }
           else{
               System.out.println("No rows inserted");
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getCategoryByID(int id) {
        String query = "select * from category where category_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                Category category = new Category(rs.getInt(1), rs.getString(2));
                System.out.println(category);
            }
            else {
                System.out.println("No category found with id : "+ id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        try{
            String query = "select * from category";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Category category = new Category(rs.getInt(1), rs.getString(2));
                categoryList.add(category);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  categoryList;
    }

    @Override
    public void updateCategory(Category category) {
        String query  = "update category set category_name = ? where category_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,category.getCategory_name());
            preparedStatement.setInt(2,category.getCategory_id());
            int result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + "Row(s) updated");
            }
            else {
                System.out.println("No rows updated");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCategory(Category category) {
        String query  = "delete from category where category_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,category.getCategory_id());
            int result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + "Row(s) Deleted");
            }
            else {
                System.out.println("No rows Deleted");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
