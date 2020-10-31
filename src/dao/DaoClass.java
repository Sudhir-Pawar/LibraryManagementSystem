package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Book;
import bean.Transaction;
import bean.User;
import connection.DatabaseConnection;

public class DaoClass implements DaoInterface<Boolean,Book,User,Transaction>{
	Connection connection = null;
	@Override
	public Boolean insertBook(Book book) {
		Boolean status = false;
		connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement;
		try {
			if(!isPresent("book_id", book.getBookId(), "Book")){
				preparedStatement = connection.prepareStatement("insert into Book values(?,?,?)");
				preparedStatement.setString(1,book.getBookId());
				preparedStatement.setString(2,book.getBookName());
				preparedStatement.setString(3,book.getAuthorName());
				int count = preparedStatement.executeUpdate();
				if(count > 0){
					status = true;
				}
			}else{
				//Raise Exception: bookId already exists. 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean removeBook(Book book) {
		Boolean status = false;
		connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement;
		try {
			if(!isPresent("Book_id", book.getBookId(), "Transaction")){
				preparedStatement = connection.prepareStatement("delete from Book where book_id = ?");
				preparedStatement.setString(1, book.getBookId());
				int count = preparedStatement.executeUpdate();
				if(count > 0){
					status = true;
				}
			}else{
				//Raise Exception: BookId cannot be delete as already being used in transction data.;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return status;
	}

	@Override
	public Boolean addUser(User user) {
		
		Boolean status = false;
		PreparedStatement preparedStatement;
		try {
			connection = DatabaseConnection.getConnection();
			if(!isPresent("user_id", user.getUserId(), "users")){
				preparedStatement = connection.prepareStatement("insert into Users values(?,?,?,?,?,?)");
				preparedStatement.setString(1,user.getUserId());
				preparedStatement.setString(2,user.getUserName());
				preparedStatement.setString(3,user.getDepartment());
				preparedStatement.setString(4,user.getYear());
				preparedStatement.setString(5,user.getDivision());
				preparedStatement.setString(6,user.getContactNo());
				int count = preparedStatement.executeUpdate();
				if(count > 0){
					status = true;
				}
			}else{
				System.out.println("userId already exists.");
				//Raise Exception: userId already exists. 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean removeUser(User user) {
		
		Boolean status = false;
		connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement;
		try {
			if(!isPresent("user_id", user.getUserId(),"Transaction")){
				preparedStatement = connection.prepareStatement("delete from Users where user_id = ?");
				preparedStatement.setString(1, user.getUserId());
				int count = preparedStatement.executeUpdate();
				if(count > 0){
					status = true;
				}
			}else{
				System.out.println("cannot be deleted as already being used in transction data.");
				//Raise Exception: UserId cannot be deleted as already being used in transction data.;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return status;
	}

	@Override
	public Boolean issueBook(Transaction transaction) {
		Boolean status = false;
		connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement;
		try {			
			if(isPresent("Book_id", transaction.getBookId(),"Book")){
				
				if(isPresent("User_id", transaction.getUserId(), "Users")){
					
					if(!isPresent("Book_id",transaction.getBookId(), "TRANSACTION")){
						preparedStatement = connection.prepareStatement("insert into TRANSACTION(BOOK_ID,USER_ID,issue_date) VALUES(?,?,TO_DATE(?,'YYYY-MM-DD'))");
						preparedStatement.setString(1,transaction.getBookId());
						preparedStatement.setString(2, transaction.getUserId());
						preparedStatement.setString(3,transaction.getIssueDate());
						int count  = preparedStatement.executeUpdate();
						if(count >0){
							status = true;
						}	
					} else {
						// Raise Exception Book_id already present in Transaction table
					}
				} else {
					//Raise Exception USer_id Not present in USer Table
				}
			} else {
				//Raise Exception Book_id Not present in Book Table
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean returnBook(Transaction r) {
		return null;
	}

	@Override
	public ArrayList<Book> viewAllBooks() {
		connection = DatabaseConnection.getConnection();
		ArrayList<Book> books = new ArrayList<>();
		try {
			ResultSet resultSet = connection.prepareStatement("select * from book").executeQuery();
				while(resultSet.next()){
					books.add(new Book(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(books);
		return books;
	}
	@Override
	public ArrayList<Book> viewAllBooks(User user) {
		connection = DatabaseConnection.getConnection();
		ArrayList<Book> books = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement =  connection.prepareStatement("select * from book where book_id in(select book_id from transaction where user_id = ?)");
			preparedStatement.setString(1, user.getUserId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				books.add(new Book(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(books);
		return books;
	}
	private Boolean isPresent(String fieldName,String fieldValue,String tableName) throws SQLException{
		connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("select * from "+tableName+" where "+fieldName+" = ?");
		preparedStatement.setString(1,fieldValue);
		if(preparedStatement.executeQuery().isBeforeFirst()){
			return true;
		}
		return false;
	}
}
