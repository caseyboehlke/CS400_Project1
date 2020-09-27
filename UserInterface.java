// --== CS400 File Header Information ==--
// Name: Lindsay Dyjach
// Email: ldyjach@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.Scanner; 
/**
 * @author Lindsay
 *
 */
public class UserInterface {
  public static HashTableMap<String, String> library = new HashTableMap<String, String>();
  public UserInterface() {
    System.out.println("Welcome to the CB CS 400 library database!");
    System.out.println("");
    mainMenu();
  }


  
  public static void mainMenu() {
    System.out.println("MAIN MENU: ");
    Scanner scan = new Scanner(System.in); 
    String userInput = "";
    System.out.println("Are you a librarian or a student? Enter (L) for librarian or (S) for student.");
    userInput = scan.next();
    if (userInput.charAt(0) == 'L') {
      studentMenu();
    }
    else {
      librarianMenu();
    }
    
    
  }
  
  public static void studentMenu() {
    Scanner scan = new Scanner(System.in); 
    int userInput;
    System.out.println("STUDENT MENU: ");
    System.out.println("1) Search for book details");
    System.out.println("2) Check out status"); 
    System.out.println("3) End session");
    System.out.println("Choose the corresponding number to the function you would like to perform.");
    userInput = scan.nextInt();
    scan.nextLine();
    switch(userInput) {
    case 1: searchBook();
    break;
    case 2: checkOutStatus();
    break;
    case 3: mainMenu();
    }
  }
  
  public static void librarianMenu() {
    Scanner scan = new Scanner(System.in); 
    int userInput;
    System.out.println("LIBRARIAN MENU: ");
    System.out.println("1) Add a book");
    System.out.println("2) Remove a book");
    System.out.println("3) End session");
    System.out.println("Choose the corresponding number to the function you would like to perform.");
    userInput = scan.nextInt();
    scan.nextLine();
    switch(userInput) {
    case 1: addBook();
    break;
    case 2: removeBook();
    break;
    case 3: mainMenu();
    }
  }
  
  private static void searchBook() {
    System.out.println("Type in the tile of the book you are looking for.");
    Scanner scan = new Scanner(System.in);
    String bookTitle = scan.nextLine();
    if(retrieveBook(bookTitle)) {
 System.out.println("The book was found in the library!");
    studentMenu();
    }
    else {
      System.out.println("Sorry, the book was not found.")
      studentMenu();
    }
  
  }
  //get rid of checkout and change once actual interface given
  private static void checkOutStatus()
  {
    Scanner scan = new Scanner(System.in);
    String bookTitle = scan.nextLine();
    //check if the book is checked out by calling isCheckedOut
    if (!(checkoutBook(bookTitle))) {
      System.out.println("Would you like to check this book out? Type (Y) for yes and (N) for no.");
      String userInput = "";
      userInput = scan.next();
   
    if (userInput.charAt(0) == 'Y') {
      checkoutBook(bookTitle);
      System.out.println("Your book is now checked out."); //boolean checked out should be updated if that's a thing
      System.out.println("");
      studentMenu();
    }
    else {
      System.out.println("Sorry! The book is already checked out.");
      studentMenu();
    }
   
  }
  }
  private static void returnBook() {
    Scanner scan = new Scanner(System.in);
    System.out.println("What is the name of the book you'd like to return?");
    String bookTitle = scan.nextLine();
    if(dropOffBook(bookTitle)) {
    System.out.println(bookTitle + " successfully returned."); //boolean checked out should be updated if that's a thing
  //code should update boolean somewhere
    studentMenu();
    }
    else {
      System.out.println("Problems occured when returning the book. Please try again later.");
      studentMenu();
    }
  }

  private static void addBook() {
    System.out.println("There are " + getLibrarySize() + " books in the library. Type in the tile of the book you are looking for.");
    Scanner scan = new Scanner(System.in);
    System.out.println("\nPlease add the following information about the book to the database");
    System.out.println("Book title: ");
    String bookTitle = scan.nextLine();
    System.out.println("Author name: ");
    String authorName = scan.nextLine();
    System.out.println("Genre: ");
    String genre = scan.nextLine();
    System.out.println("ISBN Number: ");
    int ISBNNumber = scan.nextInt();

    
    if (addBook(bookTitle, authorName, genre, ISBNNumber)) {
      System.out.println("The book was added successfully.");
    } else {
      System.out.println("This book is already in the library!");
    }
    System.out.println("There are now" + getLibrarySize() + " books in the library.");
    librarianMenu();
  }
  private static void removeBook() {
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    System.out.println("Enter the name of the book to be removed.");
    String bookTitle = scan.nextLine();
    System.out.println("Are you sure you would like to remove this book from the database? Type (Y) for yes and (N) for no.");
    String userInput = scan2.nextLine();
    if (userInput.charAt(0) == 'Y') {
        if(removeBook(bookTitle)) {
        System.out.println("The book was removed successfully.");
        librarianMenu();
        }
        else {
          System.out.println("The library does not contain that book.");
        }
    }  
    else {
      librarianMenu(); 
    }
  }
  
 
  public static void main(String[] args) {
    //implement back end interface in front end/instance of backend class
  LibraryDB library = new LibraryDB();
  }


  
}
