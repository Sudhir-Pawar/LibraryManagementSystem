package main;

import java.util.Scanner;

public class MainClass {
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		int choiceMain ;
		while(true){
			System.out.println("-----------------------Library Management System-----------------------");
			System.out.println("1. Admin\n2. User\n3. Exit");
			System.out.println("Enter your choice: ");
			choiceMain = scanner.nextInt();
			switch(choiceMain){
				case 1:{
					String continueAdmin = null;
					int choiceAdmin;
					do {
						System.out.println("-----------------------ADMIN-----------------------");
						System.out.println("1. Add user\n2. Remove user\n3. Add book\n4. Remove book\n5. View All books");
						System.out.println("Enter your choice: ");
						choiceAdmin = scanner.nextInt();
						switch(choiceAdmin){
							case 1:{
								System.out.println("Add user");
								break;
							}
							case 2:{
								System.out.println("Remove user");
								break;
							}
							case 3:{
								System.out.println("Add book");
								break;
							}
							case 4:{
								System.out.println("Remove book");
								break;
							}
							case 5:{
								System.out.println("View All books");
								break;
							}
							default:{
								System.out.println("Invalid chocie.");
								break;
							}
						}
					System.out.println("Do you want to continue(Y/n): ");
					continueAdmin = scanner.next();
					}while(continueAdmin.equalsIgnoreCase("Y"));
					break;
				}
				case 2:{
					String continueUser = null;
					int choiceUser;
					do{
						System.out.println("-----------------------USER-----------------------");
						System.out.println("1. Issue Book\n2. Return Book\n3. View issued books\n4. View All books");
						System.out.println("Enter your choice: ");
						choiceUser = scanner.nextInt();
						switch(choiceUser){
							case 1:{
								System.out.println("Issue Book");
								break;
							}
							case 2:{
								System.out.println("Return Book");
								break;
							}
							case 3:{
								System.out.println("View Issued books");
								break;
							}
							case 4:{
								System.out.println("View All books");
								break;
							}
							default:{
								System.out.println("Invalid Choice");
								break;
							}
						}
						System.out.println("Do you want to continue(Y/N): ");
						continueUser = scanner.next();
					}while(continueUser.equalsIgnoreCase("Y"));
					break;
				}
				case 3:{
					System.out.println("Exiting from application...");
					System.exit(0);
					break;
				}
				default:{
					System.out.println("Invalid chocie.");
					break;
				}
			}
		}
	}
}
