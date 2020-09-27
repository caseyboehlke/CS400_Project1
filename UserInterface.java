// --== CS400 File Header Information ==--
// Name: ABHIJEET MANOHAR
// Email: amanohar@wisc.edu
// Team: CB
// TA: Yeping Wang
// Lecturer: Gary

import java.util.Scanner;

public class UserInterface {

	//Create a new interface
	public UserInterface() {
		//Header 
		System.out.println("Welcome to Library Database at UW-Madison!\n");
		
		//Menu
		menu();
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		String input ="";
		System.out.println("Are you a librarian (L) or a student(S)? : ");
		input = scan.next();
		if(input.charAt(0) == 'L') 
			menuLibrarian();
		else
			menuStudents();
	}
	
	public static void menuLibrarian() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n"
				+ "Librarian Mode ON..");
		System.out.println("1. Add a book");
		System.out.println("2. Modify a book"); //Moddify a book.
		System.out.println("3. Delete a book");
		int input = 0;
		System.out.println("Enter your choice: ");
		input = sc.nextInt();
		switch(input) {
			case 1: addABook();break;
			case 2: removeABook(); break;
		}
	}
	
	public static void menuStudents() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n Student Mode ON..");
		System.out.println("1. Retrieve a book"); 
		System.out.println("2. Check out a book");
		System.out.println("3. Drop off book");
		int input = 0;
		System.out.println("Enter your choice: ");
		input = sc.nextInt();
		switch(input) {
			case 1: retrieveABook();break;
			case 2: checkoutABook(); break;
			case 3: dropOffABook(); 
		}
	}
	
	public static void addABook() {
		//@BACKEND - int getlibrarySize() should return the size of the library.
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNum of Books in Library: "+getLibrarySize());
		
		System.out.println("\nEnter book title: "); //BOOK TITLE
		String bookTitle = sc.nextLine();
		System.out.println("Enter author name: ");  //AUTHOR NAME
		String authorName = sc.nextLine();
		System.out.println("Enter genre name: ");   //GENRE 
		String genre = sc.nextLine();
		System.out.println("Enter Book Description"); //BOOK DESCRIPTION
		String description = sc.nextLine();
		System.out.println("Enter ISBN number: ");  //ISBN NUMBER
		int ISBN = sc.nextInt();
		
		//@BACKEND - create boolean addBook()
		if(addBook(bookTitle, authorName, genre, description, ISBN))
			System.out.println("Book added successfully!! You are a genius..");
		else
			System.out.println("Sorry! I think the book title already exist..");
		
		System.out.println("\nNum of Books in Library: "+getLibrarySize()+"\n");
		menu();
	}
	
	public static void removeABook() {
		System.out.println("\nEnter exact book title to remove : ");
		Scanner sc = new Scanner(System.in);
		String bookRemove = sc.nextLine();
		//@BACKEND - Need boolean removeBook()
		if(removeBook(bookRemove))
			System.out.println("Book Removed");
		else
			System.out.println("Book doesn't exist in the library!");
		
		menu();
	}
	
	public static void retrieveABook() {
		System.out.println("\nEnter book title to retrieve : ");
		Scanner sc = new Scanner(System.in);
		String retrieveBook = sc.nextLine();
		//@BACKEND - Need boolean retrieveBook()
		if(retrieveBook(retrieveBook))
			System.out.println("Book Removed");
		else
			System.out.println("Book doesn't exist in the library!");
		
		menu();
	}
	
	public static void checkoutABook() {
		System.out.println("\nEnter book title to checkout : ");
		Scanner sc = new Scanner(System.in);
		String checkoutBookTitle = sc.nextLine();
		//@BACKEND - boolean checkoutBook()
		if(checkoutBook(checkoutBookTitle))
			System.out.println("Book Checked Out for you. Enjoy!");
		else
			System.out.println("Sorry! Book is already checked out.");
		
		menu();
	}
	
	public static void dropOffABook() {
		System.out.println("\nEnter book title to dropoff : ");
		Scanner sc = new Scanner(System.in);
		String dropoffBookTitle = sc.nextLine();
		//@BACKEND - boolean checkoutBook()
		if(dropOffBook(dropoffBookTitle))
			System.out.println("Book checked in! Thanks for using the library!");
		else
			System.out.println("Sorry! Book couldn't be checked in back.");
		
		menu();		
	}
	
	public static void main(String args[]) {
		//@BACKEND - Instance of Backend class name.
		LibraryDB library = new LibraryDB();
	}
}
