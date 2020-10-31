package test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Book;
import bean.Transaction;
import bean.User;
import dao.DaoClass;

public class DaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
//		assertEquals(true,new BookDao().insert(new Book("BK0007","An Autobiography","Jawaharlal Nehru")));
//		assertEquals(false,new DaoClass().insertBook(new Book("BK0007","An Autobiography","Jawaharlal Nehru")));
//		assertEquals(true,new DaoClass().insertBook(new Book("BK0008","Dr. A.P.J. Abdul Kalam","My Journey")));
//		assertEquals(true,new DaoClass().insertBook(new Book("BK0011","Test Book","Unknown")));
//		assertEquals(true,new DaoClass().removeBook(new Book("BK0011")));
//		assertEquals(true,new DaoClass().removeBook(new Book("BK0008")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0001","Sudhir Pawar","Computer","BE","B","9850613685")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0002","Vaishnav Gaikwad","Computer","BE","B","6434736434")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0003","Gaurav Kondhare","Computer","BE","B","8738263763")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0004","Test User1","Computer","BE","B","1234567890")));
//		assertEquals(false,new DaoClass().removeUser(new User("ST000122")));
//		assertEquals(false,new DaoClass().addUser(new User("ST0003","Gaurav Kondhare","Computer","BE","B","8738263763")));
		
//		assertEquals(false,new DaoClass().issueBook(new Transaction("BK0010","ST0001","2020-10-30")));
		
//		assertEquals(true, new DaoClass().viewAllBooks());
		assertEquals(true, new DaoClass().viewAllBooks(new User("ST0002")));
	}

}
