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
					boolean continueAdmin = true;
					int choiceAdmin;
					do {
						System.out.println("-----------------------ADMIN-----------------------");
						System.out.println("1. Add user\n2. Remove user\n3. Add book\n4. Remove book\n5. View All books\n6. Exit");
						System.out.println("Enter your choice: ");
						choiceAdmin = scanner.nextInt();
						switch(choiceAdmin){
							case 1:{			
								if(AdminClass.addUser()){
									System.out.println("User Added");
								}
								break;
							}
							case 2:{
								if(AdminClass.removeUser()){
									System.out.println("User Removed");
								}
								break;
							}
							case 3:{
								if(AdminClass.addBook()){
									System.out.println("Book Added");
								}
								break;
							}
							case 4:{
								if(AdminClass.removeBook()){
									System.out.println("Book removed");
								}
								break;
							}
							case 5:{
								AdminClass.viewAllBooks();
								break;
							}
							case 6:{
								continueAdmin  = false;
								break;
							}
							default:{
								System.out.println("Invalid choice.");
								break;
							}
						}
					
					}while(continueAdmin);
					break;
				}
				case 2:{
					boolean continueUser = true;
					int choiceUser;
					do{
						System.out.println("-----------------------USER-----------------------");
						System.out.println("1. Issue Book\n2. Return Book\n3. View issued books\n4. View All books\n5. Exit");
						System.out.println("Enter your choice: ");
						choiceUser = scanner.nextInt();
						switch(choiceUser){
							case 1:{
								if(UserClass.issueBook()){
									System.out.println("Book Issed");
								}
								break;
							}
							case 2:{
								if(UserClass.returnBook()){
									System.out.println("Book Returned");
								}
								break;
							}
							case 3:{
								UserClass.pendingReturn();
								break;
							}
							case 4:{
								UserClass.viewAllBooks();
								break;
							}
							case 5:{
								continueUser = false;
								break;
							}
							default:{
								System.out.println("Invalid Choice");
								break;
							}
						}
					}while(continueUser);
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
