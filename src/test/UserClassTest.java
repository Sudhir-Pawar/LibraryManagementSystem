package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Book;
import bean.User;
import connection.DatabaseConnection;
import dao.DaoClass;
import main.UserClass;

public class UserClassTest{
	InputStream inputStream;
	static Connection connection;
	static ResultSet books, userPendingReturns;
	static{
		connection = new DatabaseConnection().getConnection();
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		books  = connection.prepareStatement("select * from book").executeQuery();
		userPendingReturns = connection.prepareStatement("select Book.book_id, Book.book_name, Book.author_name from Book inner join Transaction on (Book.book_id = Transaction.book_id) where return_date IS NULL and user_id = 'ST0001'").executeQuery();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connection.prepareStatement("delete from transaction where BOOK_ID = 'BK0015' and user_id='ST0002'").executeUpdate();
	}
	
	@Test
	public void issueBook() {
		String bookInputs = "BK0015"+"/"+"ST0002"+"/"+"2020-02-24";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Should issue the book to the user. ",true,UserClass.issueBook());
		
		bookInputs = "BK0015"+"/"+"ST0010"+"/"+"2020-01-24";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Print messange Book already issued. ",false,UserClass.issueBook());
		
		bookInputs = "BK0007"+"/"+"ST0003"+"/"+"13/02/2020";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Date not entered in proper format. Invalid Field issueDate. ",false,UserClass.issueBook());
	}
	
	@Test
	public void returnBook() {
		String bookInputs = "BK0015"+"/"+"ST0002"+"/"+"2020-12-25";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Should return the book to the Books table. ",true,UserClass.returnBook());
		
		bookInputs = "BK0015"+"/"+"ST1002"+"/"+"2020-01-24";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Print messange Book already returned. ",false,UserClass.returnBook());
		
		bookInputs = "BK0012"+"/"+"ST0001"+"/"+"13/02/2020";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Date not entered in proper format. Invalid Field returnDate. ",false,UserClass.returnBook());
	}
	
	
	@Test
	public void testViewAllBooks() {
		try {
			boolean testStatus = !new DaoClass().viewAllBooks().isEmpty();
			System.out.println("IsEmpty : "+testStatus);
			boolean containsBooks = books.isBeforeFirst();
			assertEquals("Should print all books details.",containsBooks, testStatus);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
	}
	
	@Test
	public void userPendingBooks() {
		try {
			boolean testStatus = !new DaoClass().userPendingBooks(new User("ST0001")).isEmpty();
			System.out.println("IsEmpty : "+testStatus);
			boolean containsBooks = userPendingReturns.isBeforeFirst();
			assertEquals("Should print all books details.",containsBooks, testStatus);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
