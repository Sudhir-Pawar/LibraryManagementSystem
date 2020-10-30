package test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Book;
import dao.BookDao;

public class BookDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
//		assertEquals(true,new BookDao().insert(new Book("BK0007","An Autobiography","Jawaharlal Nehru")));
		assertEquals(false,new BookDao().insert(new Book("BK0007","An Autobiography","Jawaharlal Nehru")));
	}

}
