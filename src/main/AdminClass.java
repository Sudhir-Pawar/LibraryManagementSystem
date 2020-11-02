package main;

import java.util.Scanner;

import bean.User;
import dao.DaoClass;

public class AdminClass {
	public boolean addUser(){
		boolean status = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user id(eg ST0001,ST1003): ");
		String userId = scanner.next();
		System.out.println("Enter username: ");
		String username = scanner.next();
		System.out.println("Enter department(COMP/IT/E&TC/MECH/CIVIL): ");
		String department = scanner.next();
		System.out.println("Enter year(FE/SE/TE/BE): ");
		String year = scanner.next();
		System.out.println("Enter division(A/B/C): ");
		String division = scanner.next();
		System.out.println("Enter Contact number: ");
		String contactNo = scanner.next();
		
		return new DaoClass().addUser(new User(userId,username,department,year,division,contactNo));
	}
}
