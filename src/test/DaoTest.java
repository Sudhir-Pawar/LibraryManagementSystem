package test;


import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
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
//		LocalDate startDate = LocalDate.parse("2020-10-30");
//		LocalDate endDate = LocalDate.parse("2020-11-03");
//		long noOdDays = ChronoUnit.DAYS.between(startDate, endDate);
//		System.out.println(noOdDays);
//		assertEquals(true,new BookDao().insert(new Book("BK0007","An Autobiography","Jawaharlal Nehru")));
//		assertEquals(false,new DaoClass().insertBook(new Book("BK0007","An Autobiography","Jawaharlal Nehru")));
//		assertEquals(true,new DaoClass().insertBook(new Book("BK0008","Dr. A.P.J. Abdul Kalam","My Journey")));
//		assertEquals(true,new DaoClass().insertBook(new Book("BK0012","Test Book 2","Unknown")));
//		assertEquals(true,new DaoClass().removeBook(new Book("BK0011")));
//		assertEquals(true,new DaoClass().removeBook(new Book("BK0008")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0001","Sudhir Pawar","Computer","BE","B","9850613685")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0002","Vaishnav Gaikwad","Computer","BE","B","6434736434")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0003","Gaurav Kondhare","Computer","BE","B","8738263763")));
//		assertEquals(true,new DaoClass().addUser(new User("ST0004","Test User1","Computer","BE","B","1234567890")));
//		assertEquals(false,new DaoClass().removeUser(new User("ST000122")));
//		assertEquals(false,new DaoClass().addUser(new User("ST0003","Gaurav Kondhare","Computer","BE","B","8738263763")));
		
//		assertEquals(false,new DaoClass().issueBook(new Transaction("BK0012","ST0001","2020-10-30",false)));
//		assertEquals(true,new DaoClass().returnBook(new Transaction("BK0010", "ST1004", "2020-12-31",true)));
//		assertEquals(true, new DaoClass().viewAllBooks());
//		assertEquals(true, new DaoClass().viewAllBooks(new User("ST0002")));
//		assertEquals(true, new DaoClass().pendingReturn());
	}

}
