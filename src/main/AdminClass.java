package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bean.Book;
import bean.User;
import dao.DaoClass;
import exception.InvalidFieldsException;

public class AdminClass {
	public static boolean addUser() {
		try{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id(eg ST0001,ST1003): ");
		String userId = bufferedReader.readLine();
		System.out.println("Enter username: ");
		String username = bufferedReader.readLine();
		System.out.println("Enter department(COMP/IT/E&TC/MECH/CIVIL): ");
		String department = bufferedReader.readLine();
		System.out.println("Enter year(FE/SE/TE/BE): ");
		String year = bufferedReader.readLine();
		System.out.println("Enter division(A/B/C): ");
		String division = bufferedReader.readLine();
		System.out.println("Enter Contact number: ");
		String contactNo = bufferedReader.readLine();
		String inValidFieldsValidator = Validator.isValidUser(userId, department, year, division, contactNo);
		if(inValidFieldsValidator.isEmpty()){
			return new DaoClass().addUser(new User(userId,username,department,year,division,contactNo));			
		}
		throw new InvalidFieldsException(inValidFieldsValidator);
		}catch(InvalidFieldsException e){
			System.out.println("Connot add user. "+e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean removeUser(){
		try {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id(eg ST0001, ST1003): ");
		String userId = bufferedReader.readLine();
		if(Validator.isValidUserId(userId)){
			return new DaoClass().removeUser(new User(userId));
		}
		throw new InvalidFieldsException("userId");
		
		} catch (InvalidFieldsException e) {
			System.out.println("Connot remove user. "+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean addBook(){
		try{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter book id(eg BK0001, BK1003): ");
		String bookId = bufferedReader.readLine();
		if(!Validator.isValidBookId(bookId)){
			throw new InvalidFieldsException("BookId");
		}
		System.out.println("Enter book name: ");
		String bookName = bufferedReader.readLine();
		System.out.println("Enter author name: ");
		String authorName = bufferedReader.readLine();
		
		return new DaoClass().insertBook(new Book(bookId,bookName,authorName));
		
		}catch(InvalidFieldsException e){
			System.out.println("Connot add book. "+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean removeBook(){
		try{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter book id(eg BK0001, BK1003): ");
		String bookId = bufferedReader.readLine();
		if(Validator.isValidBookId(bookId)){
			return new DaoClass().removeBook(new Book(bookId));
			
		}
		throw new InvalidFieldsException("BookId");
		}catch(InvalidFieldsException e){
			System.out.println("Connot remove book. "+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
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
	
}
