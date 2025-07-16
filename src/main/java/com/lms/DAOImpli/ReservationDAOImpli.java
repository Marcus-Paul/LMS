package com.lms.DAOImpli;

import com.lms.DAO.ReservationDAO;
import com.lms.TableClassess.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpli implements ReservationDAO {
    private Connection connection;
    public ReservationDAOImpli(Connection connection){
        this.connection = connection;
    }
    @Override
    public void createReservation(Reservation reservation) {
        String query = "insert into reservation (membership_id, book_id) values (?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,reservation.getMembership_id());
            preparedStatement.setInt(2,reservation.getBook_id());
//            preparedStatement.setString(3,reservation.getStatus());
            int result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + "Row(s) insert");
            }
            else{
                System.out.println("No rows inserted");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> getAllReservation() {
        List<Reservation> listOfReservation = new ArrayList<>();
        String query = "select * from reservation";
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Reservation reservation = new Reservation(rs.getInt(1), rs.getInt(2), rs.getString(3));
                listOfReservation.add(reservation);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listOfReservation;
    }

    @Override
    public void updateReservation(Reservation reservation) {
        String query  = "update reservation set current_status = ? where membership_id = ? and book_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, reservation.getStatus());
            preparedStatement.setInt(2, reservation.getMembership_id());
            preparedStatement.setInt(3, reservation.getBook_id());
            int  result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + "Row(s) updated");
            }
            else{
                System.out.println("No rows updated");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        String query  = "delete from reservation where membership_id = ? and book_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, reservation.getMembership_id());
            preparedStatement.setInt(2, reservation.getBook_id());
            int  result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println(result + "Row(s) Deleted");
            }
            else{
                System.out.println("No rows Deleted");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
