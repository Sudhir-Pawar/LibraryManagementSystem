package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bean.Book;
import bean.Transaction;
import bean.User;
import dao.DaoClass;
import exception.InvalidFieldsException;

public class UserClass{
	public static boolean issueBook() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Enter the book ID(eg BK0014): ");
			String bookId = bufferedReader.readLine();
			System.out.println("Enter the User ID(eg ST0015): ");
			String userId = bufferedReader.readLine();
			System.out.println("Enter the issue Date(eg 2020-03-23)");
			String issueDate = bufferedReader.readLine();
			if(!Validator.isValidDate(issueDate)){
				throw new InvalidFieldsException("IssueDate");
			}
			return new DaoClass().issueBook(new Transaction (bookId,userId,issueDate,false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFieldsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		return false;
				
	}
	
	public static boolean returnBook() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Enter the book ID(eg BK0014): ");
			String bookId = bufferedReader.readLine();
			System.out.println("Enter the User ID(eg ST0015): ");
			String userId = bufferedReader.readLine();
			System.out.println("Enter the return Date(eg 2020-03-23)");
			String returnDate = bufferedReader.readLine();
			if(!Validator.isValidDate(returnDate)){
				throw new InvalidFieldsException("Return Date");
			}
			return new DaoClass().returnBook(new Transaction (bookId,userId,returnDate,true));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFieldsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		
		
		return false;
	}
	
	public static void viewAllBooks(){
		Book book;
		ArrayList<Book> books = new DaoClass().viewAllBooks();
		if(!books.isEmpty()){
			System.out.println("----------------------------Books Avaiable----------------------------");
			System.out.printf("%-4s %-7s %-50s %-50s\n","Srno","Book ID","Book Names","Author Names");
			for(int itr = 0;itr < books.size();itr++){
				book = books.get(itr);
				System.out.printf("%-4s %-7s %-50s %-50s\n",itr+1,book.getBookId(),book.getBookName(),book.getAuthorName());
//				System.out.println(itr+1+" "+book.getBookName()+" "+book.getAuthorName());
			}
			return;
		}
		System.out.println("No records found.");
	}
	
	public static void pendingReturn() {
		Book book;
		ArrayList<Book> books = new DaoClass().pendingReturn();
		if(!books.isEmpty()){
			System.out.println("----------------------------All Issued Books----------------------------");
			System.out.printf("%-4s %-7s %-50s %-50s\n","Srno","Book ID","Book Names","Author Names");
			for(int itr = 0;itr < books.size();itr++){
				book = books.get(itr);
				System.out.printf("%-4s %-7s %-50s %-50s\n",itr+1,book.getBookId(),book.getBookName(),book.getAuthorName());
//				System.out.println(itr+1+" "+book.getBookName()+" "+book.getAuthorName());
			}
			return;
		}
		System.out.println("No records found.");
	}
}