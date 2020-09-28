import java.util.NoSuchElementException;

// --== CS400 File Header Information ==--
// Name: Yiyang Jiang
// Email: yjiang285@wisc.edu
// Team: CB
// TA: Yeping Wang
// Lecturer: Gary

public class LibraryTest {
    /**
     * Test the Book class
     * 
     * @return true if pass tests, false otherwise
     */
    public static boolean testBook() {
      Book book = new Book("HelloWolrd", "Joe", "CS", 101, true);
      //test title
      if(!book.getTitle().equals("HelloWolrd")) {
        System.out.println("Book's title can't be written correctly.");
        return false;
      }
      //test author
      if(!book.getAuthor().equals("Joe")) {
        System.out.println("Book's author can't be written correctly.");
        return false;
      }
      //test genre
      if(!book.getGenre().equals("CS")) {
        System.out.println("Book's genre can't be written correctly.");
        return false;
      }
      //test Isbn
      if(book.getIsbn() != 101) {
        System.out.println("Book's Isbn can't be written correctly.");
        return false;
      }
      //test check in
      if(!book.getChekedIn()) {
        System.out.println("Book's storage status can't be written correctly.");
        return false;
      }
      //test change book's status
      book.setChekedIn();
      if(book.getChekedIn() != false) {
        System.out.println("Book's setChekedIn method can't work correctly.");
        return false;
      }
      System.out.println("Class Book works well.");
     return true;
    }
    
    /**
     * Test the get method in LibraryDB
     * 
     * @return true if pass tests, false otherwise
     */
   public static boolean testGet() {
     LibraryDB library1 = new LibraryDB();
     if (!library1.getBook("Frankenstein").getAuthor().equals("Mary Shelley")) {
       System.out.println("LibraryDB can't get the right book.");
       return false;
     }
     try {
       library1.getBook("123");
     }catch (NoSuchElementException e) {
       return true;
     }
     System.out.println("When try to get a Unexisted book, the expected exception haven't been thrown.");
     return false;
   }
   
   
    /**
     * Test the add and remove method in LibraryDB
     * 
     * @return true if pass tests, false otherwise
     */
   public static boolean testAddRemove() {
     LibraryDB library1 = new LibraryDB();
     library1.addBook("What", "who", "where", 11111);
     if(!library1.getBook("What").getAuthor().equals("who")) {
       System.out.println("LibraryDB can't add the right book.");
       return false;
     }
     
     if(library1.addBook("To Kill a Mockingbird", "Harper Lee", "Fiction", 555)) {
       System.out.println("It successfully adding a already existed book.");
       return false;
     }
     
     //problem here
     if(library1.addBook(null,null,null, 0)) {
       System.out.println("It successfully adding a 'null' book.");
       return false;
     }
     
     library1.removeBook("What");
     try {
       library1.getBook("What");
     }catch (NoSuchElementException e) {
       return true;
     }
     System.out.println("Library can't remove the book.");
     return false;
   }
   
   
}
