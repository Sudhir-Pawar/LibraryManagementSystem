package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Book;
import connection.DatabaseConnection;
import dao.DaoClass;
import main.UserClass;

public class UserClassTest{
	InputStream inputStream;
	static Connection connection;
	static{
		connection = new DatabaseConnection().getConnection();
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		boolean testStatus = true;
		UserClass.viewAllBooks();
		ArrayList<Book> books = new DaoClass().viewAllBooks();
		if(!books.isEmpty()){
			assertEquals("Should print all books details.",true, testStatus);
		} else {
			testStatus = false;
			assertEquals("Should print message no record found.", true,testStatus);
		}
		
	}
	
	@Test
	public void userPendingBooks() {
		boolean testStatus = true;
		String bookInputs = "ST0014";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		UserClass.userPendingBooks();
		ArrayList<Book> books = new DaoClass().viewAllBooks();
		if(!books.isEmpty()){
			assertEquals("Should print all the issued books details.",true, testStatus);
		} else {
			testStatus = false;
			assertEquals("Should print message no books issued.", true,testStatus);
		}
	}
}
