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
public class UserInterfaceLD {
  public static HashTableMap<String, String> library = new HashTableMap<String, String>();
  private static LibraryDB libraryAccess;
  
  //constructor
  public UserInterfaceLD() {
     libraryAccess = new LibraryDB();
    System.out.println("Welcome to the CB CS 400 library database!");
    System.out.println("");
    mainMenu();
  }


  
  public static void mainMenu() {
    System.out.println("");
    System.out.println("MAIN MENU: ");
    Scanner scan = new Scanner(System.in); 
    String userInput = "";
    System.out.println("Are you a librarian or a student? Enter (L) for librarian or (S) for student.");
    userInput = scan.next();
    if ((userInput.charAt(0) == 'L') || (userInput.charAt(0) == 'l')) {
      librarianMenu();    }
    else if ((userInput.charAt(0) == 'S') || (userInput.charAt(0) == 's')) {
      studentMenu();
    }
    else {
      System.out.println("Enter a valid letter.");
      System.out.println("");
      mainMenu();
    }
    
    
  }
  
  public static void studentMenu() {
    Scanner scan = new Scanner(System.in); 
    int userInput;
    System.out.println("STUDENT MENU: ");
    System.out.println("");
    System.out.println("1) Search for book details");
    System.out.println("2) Check out book"); 
    System.out.println("3) Return book");
    System.out.println("4) End session");
    System.out.println("Choose the corresponding number to the function you would like to perform.");
    userInput = scan.nextInt();
    scan.nextLine();
    switch(userInput) {
    case 1: searchBook();
    break;
    case 2: checkOut();
    break;
    case 3: returnBook();
    break;
    case 4: mainMenu();
    }
  }
  
  public static void librarianMenu() {
    Scanner scan = new Scanner(System.in); 
    int userInput;
    System.out.println("LIBRARIAN MENU: ");
    System.out.println("");
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
  
  public static void searchBook() {
    System.out.println("");
    System.out.println("Type in the tile of the book you are looking for.");
    Scanner scan = new Scanner(System.in);
    String bookTitle = scan.nextLine();
    if(libraryAccess.getBook(bookTitle).getTitle().equals(bookTitle)) {
      System.out.println("");
     System.out.println(libraryAccess.getBook(bookTitle).getString());
     System.out.println("");
 System.out.println("The book was found in the library!");
 System.out.println("");
    studentMenu();
    }
    else {
      System.out.println("Sorry, the book was not found.");
      System.out.println("");
      studentMenu();
    }
  
  }
  //get rid of checkout and change once actual interface given
  public static void checkOut()
  {
    System.out.println("Enter the name of the book you would like to check out.");
    Scanner scan = new Scanner(System.in);
    String bookTitle = scan.nextLine();
    //check if the book is checked out by calling isCheckedOut
    if (libraryAccess.isBookAvailable(bookTitle)) {
      System.out.println("Would you like to check this book out? Type (Y) for yes and (N) for no.");
      String userInput = "";
      userInput = scan.next();
   
    if ((userInput.charAt(0) == 'Y') || (userInput.charAt(0) == 'y')) {
      libraryAccess.checkOut(bookTitle);
      System.out.println("Your book is now checked out."); //boolean checked out should be updated if that's a thing
      System.out.println("");
      studentMenu();
    }
    }
    else {
      System.out.println("Sorry! The book is already checked out.");
      System.out.println("");
      studentMenu();
    }
   
  }
  
  private static void returnBook() {
    Scanner scan = new Scanner(System.in);
    System.out.println("What is the name of the book you'd like to return?");
    String bookTitle = scan.nextLine();
    if(libraryAccess.checkIn(bookTitle)) {
    System.out.println(bookTitle + " successfully returned."); //boolean checked out should be updated if that's a thing
    System.out.println("");    
    studentMenu();
    }
    else {
      System.out.println("Problems occured when returning the book. Please try again later.");
      System.out.println("");
      studentMenu();
    }
  }

  private static void addBook() {
    System.out.println("There is/are " + libraryAccess.librarySize() + " book/s in the library. Type in the tile of the book you are looking for.");
    System.out.println("");
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

    
    if (libraryAccess.addBook(bookTitle, authorName, genre, ISBNNumber)) {
      System.out.println("The book was added successfully.");
    } else {
      System.out.println("This book is already in the library!");
    }
    System.out.println("There is/are now " + libraryAccess.librarySize() + " book/s in the library.");
    System.out.println("");
    librarianMenu();
  }
 
  private static void removeBook() {
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    System.out.println("Enter the name of the book to be removed.");
    String bookTitle = scan.nextLine();
    System.out.println("Are you sure you would like to remove this book from the database? Type (Y) for yes and (N) for no.");
    String userInput = scan2.nextLine();
    if ((userInput.charAt(0) == 'Y') || (userInput.charAt(0)) == 'y'){
        if(libraryAccess.removeBook(bookTitle)) {
        System.out.println("The book was removed successfully.");
        System.out.println("");
        librarianMenu();
        }
        else {
          System.out.println("The library does not contain that book.");
        }
    }  
    else {
      System.out.println("Book remained in library.");
      librarianMenu(); 
    }
  }
  
 
  public static void main(String[] args) {
    UserInterfaceLD userInterface = new UserInterfaceLD();
  
  }


  
}
