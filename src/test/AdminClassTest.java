package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Book;
import dao.DaoClass;
import main.AdminClass;

public class AdminClassTest {
	InputStream inputStream;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddUser() {
		String userInputs = "ST0016" +"/" + "Test User 2"+ "/"+ "mech"+"/"+"BE"+"/"+"A" + "/"+"7123456789";
		userInputs= userInputs.replaceAll("/",System.getProperty("line.separator"));
		inputStream = new ByteArrayInputStream(userInputs.getBytes());
		System.setIn(inputStream);
		assertEquals("Should Add user to USERS table.",true,AdminClass.addUser());
		
		inputStream = new ByteArrayInputStream(userInputs.getBytes());
		System.setIn(inputStream);
		assertEquals("Should not add same user again to USERS table. Print message user already exists ",false,AdminClass.addUser());
		
		userInputs = "ST00000014" +"/" + "Test User 2"+ "/"+ "random"+"/"+"random"+"/"+"random" + "/"+"12345";
		userInputs= userInputs.replaceAll("/",System.getProperty("line.separator"));
		inputStream = new ByteArrayInputStream(userInputs.getBytes());
		System.setIn(inputStream);
		assertEquals("Should not add same user again to USERS table. Print message Cannot add user. Invalid fields userId department year division contactNo",false,AdminClass.addUser());
		
	}

	@Test
	public void testRemoveUser() {
		String userId= "ST0016";
		System.setIn(new ByteArrayInputStream(userId.getBytes()));
		assertEquals("Should remove user from USERS table.",true,AdminClass.removeUser());
		
		System.setIn(new ByteArrayInputStream(userId.getBytes()));
		assertEquals("Should print message user not found",false,AdminClass.removeUser());
		
		userId= "ST0000012";
		System.setIn(new ByteArrayInputStream(userId.getBytes()));
		assertEquals("Should print message Cannot remove user invalid field userId ",false,AdminClass.removeUser());
		
		userId= "ST0001";
		System.setIn(new ByteArrayInputStream(userId.getBytes()));
		assertEquals("Should not remove user from USERS tables. Print message Unsupported Delete: Record linked to Transaction table.",false,AdminClass.removeUser());
	}

	@Test
	public void testAddBook() {
		String bookInputs = "BK0016"+"/"+"Test book name"+"/"+"Test author name";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Should add book to BOOK table. Print message book added",true,AdminClass.addBook());
		
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Should not add book to BOOK table. Print message bookId already exists",false,AdminClass.addBook());
		
		bookInputs = "BK000015"+"/"+"Test book name"+"/"+"Test author name";
		bookInputs = bookInputs.replaceAll("/", System.getProperty("line.separator"));
		System.setIn(new ByteArrayInputStream(bookInputs.getBytes()));
		assertEquals("Should not add book to BOOK table. Print message Connot add book. Invalid Field BookId",false,AdminClass.addBook());
	}

	@Test
	public void testRemoveBook() {
		String bookId = "BK0016";
		System.setIn(new ByteArrayInputStream(bookId.getBytes()));
		assertEquals("Should remove book from BOOK table.",true, AdminClass.removeBook());
		
		System.setIn(new ByteArrayInputStream(bookId.getBytes()));
		assertEquals("Should not be able to remove unpresent book details from BOOK table.",false, AdminClass.removeBook());
	
		bookId = "BK000014";
		System.setIn(new ByteArrayInputStream(bookId.getBytes()));
		assertEquals("Should print message Connot remove book. Invalid fields bookId.",false, AdminClass.removeBook());
		
		bookId = "BK0007";
		System.setIn(new ByteArrayInputStream(bookId.getBytes()));
		assertEquals("Should not remove book from BOOK table. Print message Unsupported Delete: Record linked to Transaction table.",false, AdminClass.removeBook());
		
	}

	@Test
	public void testViewAllBooks() {
		boolean testStatus = true;
		AdminClass.viewAllBooks();
		ArrayList<Book> books = new DaoClass().viewAllBooks();
		if(!books.isEmpty()){
			assertEquals("Should print all books details.",true, testStatus);
		} else {
			testStatus = false;
			assertEquals("Should print message no record found.", true,testStatus);
		}
		
	}
//
	@Test
	public void testPendingReturn() {
		boolean testStatus = true;
		AdminClass.pendingReturn();
		ArrayList<Book> books = new DaoClass().pendingReturn();
		if(!books.isEmpty()){
			assertEquals("Should print all issued books details.",true, testStatus);
		} else {
			testStatus = false;
			assertEquals("Should print message no record found.", true,testStatus);
		}
	}

}
