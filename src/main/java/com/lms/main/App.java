package com.lms.main;
import com.lms.Auth.AuthService;
import com.lms.DAO.*;
import com.lms.DAOImpli.*;
import com.lms.DB_Connection.DBConnection;
import com.lms.TableClassess.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import javax.management.relation.Role;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	Authors author = new Authors();
    	Books book = new Books();
    	Category category = new Category();
    	Members members = new Members();
    	Transactions transactions = new Transactions();
    	Reservation reservation = new Reservation();
    	Roles role = new Roles();
    	Users users = new Users();
    	UserRole userRole = new UserRole();
        String fName, lName;
        int authId;
        String bookName, publishDate;
        int bookId,totalCopies, availableCopies, categoryId;
        String categoryName;
        int membershipId;
        String membfName, memblName, phoneNum;
        int transactionID;
        String issueDate, dueDate, returnDate;
        int roleID;
        String roleName;
        int userId;
        String userEmail, userPassword;
        boolean enabled;
        
        
    	
    	try {
    	
			Connection connection = DBConnection.getConnection();
		    BooksDAO bookDAO = new BooksDAOImpli(connection);
		    CategoryDAO categoryDAO = new CategoryDAOImpli(connection);
		    MembersDAO membersDAO = new MembersDAOImpli(connection);
		    ReservationDAO reservationDAO = new ReservationDAOImpli(connection);
		    RolesDAO rolesDAO = new RoleDAOImpli(connection);
	        TransactionDAO transactionDAO = new TransactionDAOImpli(connection);
	        UserDAO userDAO = new UserDAOImpli(connection);
	        UserRoleDAO userRoleDAO = new UserRoleDAOImpli(connection);
	        AuthorsDAO authorDAO = new AuthorDAOImpli(connection);
	        
	        
	        
	        
	    	
	    	
	    	System.out.println("Welcome to the library");
	    	
	    	System.out.print("Enter your email: ");
	    	String email = sc.nextLine();
	    	System.out.print("Enter your password: ");
	    	String password = sc.nextLine();
	    	
	    	ResultSet rs = AuthService.login(email, password);
	    	
	    	if(rs.next()) {
	    		if(password.equals(rs.getString(3))) {
	    			if(rs.getBoolean(5)) {
	    				ResultSet userSet = AuthService.accessCheck(rs.getInt(1));
	    				if(userSet.next()) {
	    					if(userSet.getInt(2) == 1) {
	    						System.out.println("Welcome To Admin Tasks");
		    					System.out.println("Choose your option");
		    			    	
		    			    	System.out.println("1. Authors \n"
		    			    			+ "2. Books \n"
		    			    			+ "3. Category \n"
		    			    			+ "4. Members \n"
		    			    			+ "5. Reservations \n"
		    			    			+ "6. Transactions \n"
		    			    			+ "7. Roles \n"
		    			    			+ "8. Users \n"
		    			    			+ "9. User_roles");
		    			    	
		    			    	int option = sc.nextInt();
		    			    	switch (option) {
								case 1:
									System.out.println("Author Operations");
									System.out.println("1. Add Author \n"
											+ "2. Get Author By ID \n"
											+ "3. Get All Author \n"
											+ "4. Update Author \n"
											+ "5. Delete Author");
									
									int authSelection = sc.nextInt();
									
									switch (authSelection) {
									case 1:
										
										System.out.print("Enter First Name: ");
										fName = sc.nextLine();
										System.out.println("Enter Last Name: ");
										lName = sc.nextLine();
										author.setFirstName(fName);
										author.setLastName(lName);
										authorDAO.addAuthor(author);
									break;
									case 2:
										System.out.print("Enter Author ID: ");
										authId = sc.nextInt();
										authorDAO.getAuthorByID(authId);
									break;
									case 3:
										System.out.println("List of Authors: ");
										for(Authors auth : authorDAO.getAllAuthors()) {
											System.out.println(auth);
										}
									break;
									case 4:
										System.out.print("Enter First Name: ");
										fName = sc.nextLine();
										System.out.println("Enter Last Name: ");
										lName = sc.nextLine();
										System.out.println("Enter Author ID");
										authId = sc.nextInt();
										author.setFirstName(fName);
										author.setLastName(lName);
										author.setAuthor_id(authId);
										authorDAO.updateAuthor(author);
									break;
									case 5:
										System.out.println("Enter Author ID");
										authId = sc.nextInt();
										author.setAuthor_id(authId);
										authorDAO.deleteAuthor(author);
									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
										
								break;
								case 2:
									System.out.println("Book Operations");
									System.out.println("1. Add Book \n"
											+ "2. Get Book By ID \n"
											+ "3. Get All Books \n"
											+ "4. Update book \n"
											+ "5. Delete Book");
									int bookSelection = sc.nextInt();
									
									switch (bookSelection) {
									case 1:
										
										System.out.print("Enter Book Name: ");
										bookName = sc.nextLine();
										System.out.println("Enter Author ID: ");
										authId = sc.nextInt();
										System.out.println("Enter Publish Date: ");
										publishDate = sc.nextLine();
										System.out.println("Enter Total copies: ");
										totalCopies = sc.nextInt();
										System.out.println("Enter Available copies: ");
										availableCopies = sc.nextInt();
										System.out.println("Enter Category ID: ");
										categoryId = sc.nextInt();
										book.setBook_name(bookName);
										book.setAuthor_id(authId);
										book.setPublish_date(publishDate);
										book.setTotal_copies(totalCopies);
										book.setAvailable_copies(availableCopies);
										book.setCategory_id(categoryId);
										bookDAO.addBook(book);
									break;
									case 2:
										System.out.print("Enter Book ID: ");
										bookId = sc.nextInt();
										bookDAO.getBookById(bookId);
									break;
									case 3:
										System.out.println("List of Books: ");
										for(Books books : bookDAO.getAllBooks()) {
											System.out.println(books);
										}
									break;
									case 4:
										System.out.print("Enter First Name: ");
										bookName = sc.nextLine();
										System.out.print("Enter Author ID: ");
										authId = sc.nextInt();
										System.out.print("Enter Publish Date: ");
										publishDate = sc.nextLine();
										System.out.print("Enter Total Copies: ");
										totalCopies = sc.nextInt();
										System.out.print("Enter Available Copies: ");
										availableCopies = sc.nextInt();
										System.out.print("Enter Category ID: ");
										categoryId = sc.nextInt();
										System.out.print("Enter Book ID: ");
										bookId = sc.nextInt();
										
										book.setBook_name(bookName);
										book.setAuthor_id(authId);
										book.setPublish_date(publishDate);
										book.setTotal_copies(totalCopies);
										book.setAvailable_copies(availableCopies);
										book.setCategory_id(categoryId);
										book.setBook_id(bookId);
										bookDAO.updateBook(book);
										
									break;
									case 5:
										System.out.println("Enter Book ID");
										bookId = sc.nextInt();
										book.setBook_id(bookId);
										bookDAO.deleteBook(book);
									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									break;
								case 3:
									System.out.println("Category Operations");
									System.out.println("1. Add Category \n"
											+ "2. Get Category By ID \n"
											+ "3. Get All Category \n"
											+ "4. Update Category \n"
											+ "5. Delete Category");
									int categorySelection = sc.nextInt();
									
									switch (categorySelection) {
									case 1:
										
										System.out.print("Enter Category Name: ");
										categoryName = sc.nextLine();
									
										category.setCategory_name(categoryName);
										categoryDAO.addCategory(category);
									break;
									case 2:
										System.out.print("Enter Category ID: ");
										categoryId = sc.nextInt();
										categoryDAO.getCategoryByID(categoryId);
									break;
									case 3:
										System.out.println("List of Category: ");
										for(Category categories : categoryDAO.getAllCategory()) {
											System.out.println(categories);
										}
									break;
									case 4:
										System.out.print("Enter Category Name: ");
										categoryName = sc.next();
									
										category.setCategory_name(categoryName);
										categoryDAO.updateCategory(category);

									break;
									case 5:
										System.out.println("Enter Category ID");
										categoryId = sc.nextInt();
										book.setBook_id(categoryId);
										categoryDAO.deleteCategory(category);
									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									break;
								case 4:
									System.out.println("Members Operations");
									System.out.println("1. Add Members \n"
											+ "2. Get Members By ID \n"
											+ "3. Get All Members \n"
											+ "4. Update Members \n"
											+ "5. Delete Members");
									int memberSelection = sc.nextInt();
									
									switch (memberSelection) {
									case 1:
										
										System.out.print("Enter First Name: ");
										membfName = sc.nextLine();
										System.out.print("Enter Last Name: ");
										memblName = sc.nextLine();
										System.out.println("Enter Phone Number");
										phoneNum = sc.nextLine();
										
										members.setFirstName(membfName);
										members.setLastName(memblName);
										members.setPhone(phoneNum);
										
										membersDAO.newMembership(members);
									break;
									case 2:
										System.out.print("Enter Membership ID: ");
										membershipId = sc.nextInt();
										categoryDAO.getCategoryByID(membershipId);
									break;
									case 3:
										System.out.println("List of Members: ");
										for(Members member : membersDAO.getAllMembers()) {
											System.out.println(member);
										}
									break;
									case 4:
										System.out.print("Enter First Name: ");
										membfName = sc.nextLine();
										System.out.print("Enter Last Name: ");
										memblName = sc.nextLine();
										System.out.println("Enter Phone Number");
										phoneNum = sc.nextLine();
										
										members.setFirstName(membfName);
										members.setLastName(memblName);
										members.setPhone(phoneNum);
										
										membersDAO.updateMember(members);

									break;
									case 5:
										System.out.print("Enter Membership ID: ");
										membershipId = sc.nextInt();
										book.setBook_id(membershipId);
										membersDAO.deleteMember(members);
									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									break;
								case 5:
									System.out.println("Reservation Operations");
									System.out.println("1. Create Reservation \n"
											+ "2. Get All Reservation \n"
											+ "3. Update Reservation \n"
											+ "4. Delete Reservation");
									int reservtionSelection = sc.nextInt();
									
									switch (reservtionSelection) {
									case 1:
										
										System.out.println("Enter MembershipID: ");
										membershipId = sc.nextInt();
										System.out.println("Enter Book ID: ");
										bookId = sc.nextInt();
										
										reservation.setMembership_id(membershipId);
										reservation.setBook_id(bookId);
										
										reservationDAO.createReservation(reservation);
									break;
									case 2:
										System.out.println("List of Resevtions: ");
										for(Reservation reservations : reservationDAO.getAllReservation()) {
											System.out.println(reservations);
										}
									break;
									case 3:
										System.out.println("Enter MembershipID: ");
										membershipId = sc.nextInt();
										System.out.println("Enter Book ID: ");
										bookId = sc.nextInt();
										
										reservation.setMembership_id(membershipId);
										reservation.setBook_id(bookId);
										
										reservationDAO.updateReservation(reservation);

									break;
									
									case 4:
										System.out.println("Enter MembershipID: ");
										membershipId = sc.nextInt();
										System.out.println("Enter Book ID: ");
										bookId = sc.nextInt();
										
										reservation.setMembership_id(membershipId);
										reservation.setBook_id(bookId);
										
										reservationDAO.deleteReservation(reservation);

									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									break;
								case 6:
									System.out.println("Transactions Operations");
									System.out.println("1. Add Transactions \n"
											+ "2. Get Transaction by Membership ID and Book ID \n"
											+ "3. Get All Transactions \n"
											+ "4. Update Transaction \n"
											+ "5. Delete Transaction");
									int transactionSelection = sc.nextInt();
									
									switch (transactionSelection) {
									case 1:
										
										System.out.print("Enter Membership ID: ");
										membershipId = sc.nextInt();
										System.out.print("Enter Book ID: ");
										bookId = sc.nextInt();
										System.out.println("Enter Issue Date");
										issueDate = sc.nextLine();
										System.out.println("Enter Due Date");
										dueDate = sc.nextLine();
										System.out.println("Enter Return Date");
										returnDate = sc.nextLine();
										
										transactions.setMembershipId(membershipId);
										transactions.setBookId(bookId);
										transactions.setIssuedDate(issueDate);
										transactions.setDueDate(dueDate);
										transactions.setReturnDate(returnDate);
										
										transactionDAO.addTransaction(transactions);
									break;
									case 2:
										System.out.print("Enter Membership ID: ");
										membershipId = sc.nextInt();
										System.out.print("Enter Book ID: ");
										bookId = sc.nextInt();
										transactionDAO.getTransactionByMembershipIdBookId(membershipId, bookId);
									break;
									case 3:
										System.out.println("List of Transactions: ");
										for(Transactions transaction: transactionDAO.listOfTransactions()) {
											System.out.println(transaction);
										}
									break;
									case 4:
										
										System.out.println("Enter Return Date");
										returnDate = sc.nextLine();
										System.out.print("Enter Transactions ID: ");
										transactionID = sc.nextInt();
										
										transactions.setReturnDate(returnDate);
										transactions.setTransactionId(transactionID);
										
										transactionDAO.updateTransaction(transactions);

									break;
									case 5:
										System.out.print("Enter Transactions ID: ");
										transactionID = sc.nextInt();
										
										transactions.setTransactionId(transactionID);
										
										transactionDAO.deleteTransaction(transactions);
										
									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									
									
									break;
								case 7:
									System.out.println("Role Operations");
									System.out.println("1. Create Role \n"
											+ "2. Get All Role \n"
											+ "3. Update Role \n"
											+ "4. Delete Role");
									
									int roleSelection = sc.nextInt();
									
									switch (roleSelection) {
									case 1:
										
										System.out.println("Enter Role Name: ");
										roleName = sc.nextLine();
										
										role.setRole_name(roleName);
										
										rolesDAO.createRoles(role);
									break;
									case 2:
										System.out.println("List of Roles: ");
										for(Roles roles : rolesDAO.getAllRoles()) {
											System.out.println(roles);
										}
									break;
									case 3:
										System.out.println("Enter Role Name: ");
										roleName = sc.nextLine();
										System.out.println("Enter Role ID: ");
										roleID = sc.nextInt();
										
										role.setRole_name(roleName);
										role.setRole_id(roleID);
										
										rolesDAO.updateRole(role);

									break;
									
									case 4:
										System.out.println("Enter Role ID: ");
										roleID = sc.nextInt();
										
										role.setRole_id(roleID);
										
										rolesDAO.deleteRole(role);

									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									
									break;
								case 8:
									System.out.println("User Operations");
									System.out.println("1. Create User \n"
											+ "2. Get All User \n"
											+ "3. Update User \n"
											+ "4. Delete User");
									
									int userSelection = sc.nextInt();
									
									switch (userSelection) {
									case 1:
										
										System.out.println("Enter Email: ");
										userEmail = sc.nextLine();
										System.out.println("Enter Password: ");
										userPassword = sc.nextLine();
										System.out.println("Enter Membership ID: ");
										membershipId = sc.nextInt();
										System.out.println("Is the account enabled: ");
										enabled = sc.nextBoolean();
										
										users.setEmail(userEmail);
										users.setPassword(userPassword);
										users.setMembership_id(membershipId);
										users.setEnabled(enabled);
										
										userDAO.createUser(users);
									break;
									case 2:
										System.out.println("List of Users: ");
										for(Users user : userDAO.getAllUser()) {
											System.out.println(user);
										}
									break;
									case 3:
										System.out.println("Enter Email: ");
										userEmail = sc.nextLine();
										System.out.println("Enter Password: ");
										userPassword = sc.nextLine();
										System.out.println("Enter Membership ID: ");
										membershipId = sc.nextInt();
										System.out.println("Enter User ID: ");
										userId = sc.nextInt();
										
										users.setEmail(userEmail);
										users.setPassword(userPassword);
										users.setMembership_id(membershipId);
										users.setUser_id(userId);
										
										userDAO.updateUser(users);

									break;
									
									case 4:
										System.out.println("Enter User ID: ");
										userId = sc.nextInt();
										
										users.setUser_id(userId);
										
										userDAO.deleteUser(users);

									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									
									break;
								case 9:
									System.out.println("User_Role Operations");
									System.out.println("1. Create User_Role \n"
											+ "2. Get All User_Role \n"
											+ "3. Update User_Role \n"
											+ "4. Delete User_Role");
									
									int userRoleSelection = sc.nextInt();
									
									switch (userRoleSelection) {
									case 1:
										
										System.out.println("Enter User ID: ");
										userId = sc.nextInt();
										System.out.println("Enter Role ID: ");
										roleID = sc.nextInt();
										
										
										userRole.setRole_id(roleID);
										userRole.setUser_id(userId);
										
										userRoleDAO.insertUserRole(userRole);
									break;
									case 2:
										System.out.println("List of Users Roles: ");
										for(UserRole userRoles : userRoleDAO.getAllUserRole()) {
											System.out.println(userRoles);
										}
									break;
									case 3:
										System.out.println("Enter User ID: ");
										userId = sc.nextInt();
										System.out.println("Enter Role ID: ");
										roleID = sc.nextInt();
										
										
										userRole.setRole_id(roleID);
										userRole.setUser_id(userId);
										
										userRoleDAO.updateRole(userRole);

									break;
									
									case 4:
										System.out.println("Enter User ID: ");
										userId = sc.nextInt();
										
										userRole.setUser_id(userId);
										
										userRoleDAO.deleteRole(userRole);

									break;
									default:
										System.out.println("Invalid Option");
									break;
										
									}
									
									break;

								default:
									break;
								}
		    			    	
		    				} else {
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
		    			    			
		    			    			bookDAO.getBookById(sc.nextInt());
		    			    			break;
		    			    		case 2:
		    			    			System.out.println("All The available books");
		    			    			List<Books> listOfBooks = bookDAO.getAllBooks();
		    			    			for(Books books : listOfBooks) {
		    			    				System.out.println(books);
		    			    			}
		    			    			break;
		    			    		case 3:
		    			    			System.out.println("All The available Authors");
		    			    			List<Authors> listOfAuthors = authorDAO.getAllAuthors();
		    			    			for(Authors authors : listOfAuthors) {
		    			    				System.out.println(authors);
		    			    			}
		    			    			break;
		    			    		case 4:
		    			    			System.out.print("Enter the Author ID :");
		    			    			authorDAO.getAuthorByID(sc.nextInt());
		    			    			break;
		    			    		case 5:
		    			    			System.out.println("Choose a Book to reserve");
		    			    			System.out.print("Enter Membership ID : ");
		    			    			int m_id = sc.nextInt();
		    			    			System.out.println("Enter Book ID");
		    			    			int b_id = sc.nextInt();
		    			    			Reservation res = new Reservation(m_id, b_id);
		    			    			reservationDAO.createReservation(res);
		    			    			System.out.println("Reserved");
		    			    			break;
		    			    		default:
		    			    			System.out.println("Invalid Option");	
		    			    			
		    			    	}
		    				}
	    				} else {
	    					System.out.println("User account Does not exists");
	    				}
	    			} else {
	    				System.out.println("Account Disabled");
	    			}
	    		} else {
	    			System.out.println("Incorrect Password");
	    		}
	    	} else {
	    		System.out.println("No User Exists");
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