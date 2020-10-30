package dao;

public interface DaoInterface <T,P>{
	T insertBook(P p);
	T removeBook(P p);
	T addUser(P p);
	T removeUser(P p);
	
	ArrayList<T> viewAllBooks();
}