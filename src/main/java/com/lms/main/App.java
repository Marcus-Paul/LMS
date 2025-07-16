package com.lms.main;
import com.lms.DAO.*;
import com.lms.DAOImpli.*;
import com.lms.DB_Connection.DBConnection;
import com.lms.TableClassess.*;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	try {
    	
			Connection connection = DBConnection.getConnection();
		    BooksDAO dao = new BooksDAOImpli(connection);
		    AuthorsDAO authorsDAO = new AuthorDAOImpli(connection);
		    MembersDAO membersDAO = new MembersDAOImpli(connection);
	        TransactionDAO transactionDAO = new TransactionDAOImpli(connection);
	        BooksDAO book = new BooksDAOImpli(connection);
	        AuthorsDAO author = new AuthorDAOImpli(connection);
	        ReservationDAO reservation = new ReservationDAOImpli(connection);
	    	
	    	
	    	System.out.println("Welcome to the library");
	    	System.out.println("Choose your option");
	    	
	    	System.out.println("1. Get Book By ID \n"
	    			+ "2. Get All Books \n"
	    			+ "3. Get All Authors \n"
	    			+ "4. Get Author by ID \n"
	    			+ "5. Reserve a Book");
	    	
	    	int option = sc.nextInt();
	    	
	    	switch(option){
	    		case 1:
	    			System.out.print("Enter the book ID :");
	    			
	    			book.getBookById(sc.nextInt());
	    			break;
	    		case 2:
	    			System.out.println("All The available books");
	    			List<Books> listOfBooks = book.getAllBooks();
	    			for(Books books : listOfBooks) {
	    				System.out.println(books);
	    			}
	    			break;
	    		case 3:
	    			System.out.println("All The available Authors");
	    			List<Authors> listOfAuthors = author.getAllAuthors();
	    			for(Authors authors : listOfAuthors) {
	    				System.out.println(authors);
	    			}
	    			break;
	    		case 4:
	    			System.out.print("Enter the Author ID :");
	    			author.getAuthorByID(sc.nextInt());
	    			break;
	    		case 5:
	    			System.out.println("Choose a Book to reserve");
	    			System.out.print("Enter Membership ID : ");
	    			int m_id = sc.nextInt();
	    			System.out.println("Enter Book ID");
	    			int b_id = sc.nextInt();
	    			Reservation res = new Reservation(m_id, b_id);
	    			reservation.createReservation(res);
	    			System.out.println("Reserved");
	    			
	    	}
    	

        } 
    	catch (Exception e) {
            e.printStackTrace();
        }
    	finally{
    		sc.close();
    	}
    }
        
}