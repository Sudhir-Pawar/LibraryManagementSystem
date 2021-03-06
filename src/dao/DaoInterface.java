package dao;

import java.util.ArrayList;

public interface DaoInterface <T,P,S,R>{
	T insertBook(P p);
	T removeBook(P p);
	T addUser(S s);
	T removeUser(S s);
	T issueBook(R r);
	T returnBook(R r);
	ArrayList<P> pendingReturn();
	ArrayList<P> userPendingBooks(S s);
	ArrayList<P> viewAllBooks(S s);
	ArrayList<P> viewAllBooks();
}