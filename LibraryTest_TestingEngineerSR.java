// --== CS400 File Header Information ==--
// Name: Sushanth Rao
// Email: srao32@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("bookTest: " + bookTest());
        System.out.println("getBookTest: " + getBookTest());
        System.out.println("checkOutBookTest: " + checkOutBookTest());
        System.out.println("checkInBookTest: " + checkInBookTest());
    }

    /**
     * FOR DATA WRANGLERS: Tests the Book class constructor and methods
     * @return false if the test fails, true otherwise
     */
    public static boolean bookTest() {
        Book myBook = new Book( "The Great Gatsby", "Fitzgerald","Classic",439594,true);

        // 1. Get values the Book was created with
        // Author name
        if(!myBook.getAuthor().equals("Fitzgerald")) {
            System.out.println("The author name that was returned did not match the name the Book was " +
                    "created with");
            return false;
        }
        // book title
        if(!myBook.getTitle().equals("The Great Gatsby")) {
            System.out.println("The book title that was returned did not match the title the Book was " +
                    "created with");
            return false;
        }
        // ISBN number
        if(myBook.getIsbn() != 439594) {
            System.out.println("The isbn number that was returned did not match the number the Book was " +
                    "created with");
            return false;
        }
        // genre
        if(!myBook.getGenre().equals("Classic")) {
            System.out.println("The genre that was returned did not match the genre the Book was " +
                    "created with");
            return false;
        }
        // checked in/out
        if(!myBook.getCheckedIn()) {
            System.out.println("The checkedIn status that was returned was false before the value was changed");
            return false;
        }

        // 2. Set checkedIn and make sure the Book is updated accordingly
        myBook.setCheckedIn();
        if(myBook.getCheckedIn()) {
            System.out.println("The checkedIn status that was returned was true after the Book's status" +
                    "was changed to false");
            return false;
        }
        myBook.setCheckedIn();
        if(!myBook.getCheckedIn()) {
            System.out.println("The checkedIn status that was returned was false after the Book's status" +
                    "was changed to true");
            return false;
        }
        return true;
    }

    /**
     * FOR BACK END DEVELOPERS: Tests getBook method
     * @return false if the test fails, true otherwise
     */
    public static boolean getBookTest() {
        // 1. Try to get an existing Book
        LibraryDB myLibrary = new LibraryDB();
        Book a = new Book("Frankenstein", "Mary Shelley", "Fiction", 111, true);
        Book b = new Book("King Lear", "William Shakespeare", "Drama", 222, true);
        if(!a.getAuthor().equals(myLibrary.getBook("Frankenstein").getAuthor())) {
            System.out.println("Trying to get Frankenstein returned a different value than expected");
            return false;
        }
        if(!b.getAuthor().equals(myLibrary.getBook("King Lear").getAuthor())) {
            System.out.println("Trying to get King Lear returned a different value than expected");
            return false;
        }
        // 2. Try to get a nonexistent Book
        try {
            if (myLibrary.getBook("someBook") != null) {
                System.out.println("Trying to get a nonexistent Book returned a non-null value");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Trying to get a nonexistent Book threw an unexpected exception");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * FOR BACK END DEVELOPERS: Tests the isBookAvailable and checkOut functionality
     * @return false if the test fails, true otherwise
     */
    public static boolean checkOutBookTest() {
        LibraryDB myLibrary = new LibraryDB();
        // 1. Make sure checking out a Book twice is not possible
        // Check inital status
        if(!myLibrary.isBookAvailable("Heart of Darkness")) {
            System.out.println("isBookAvailable returns false with an available Book");
            return false;
        }
        if(!myLibrary.checkOut("Heart of Darkness")) {
            System.out.println("checkOut return false when checking out an available Book");
            return false;
        }
        // Check status after checkOut
        if (myLibrary.isBookAvailable("Heart of Darkness")) {
            System.out.println("isBookAvailable says Book is still available after it has been checked out");
            return false;
        }
        // Check out for a second time
        try {
            if(myLibrary.checkOut("Heart of Darkness")) {
                System.out.println("Trying to check out Book for a second time returns true");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Checking out Book for the second time threw an unexpected exception");
            return false;
        }

        // 2. Make sure checking out a nonexistent Book is not possible
        try {
            if(myLibrary.checkOut("someBook")) {
                System.out.println("Checking out a nonexistent Book returned true");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Checking out a nonexistent book resulted in an unexpected exception");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * FOR BACK END DEVELOPERS: Tests the checkIn functionality. Depends on checkOut working correctly
     * @return false if the test fails, true otherwise
     */
    public static boolean checkInBookTest() {
        LibraryDB myLibrary = new LibraryDB();
        myLibrary.checkOut("To Kill a Mockingbird");
        // 1. Try to return a book twice
        if(!myLibrary.checkIn("To Kill a Mockingbird")) {
            System.out.println("checkIn return false when returning out a checked-out Book");
            return false;
        }
        // Return for a second time
        try {
            if(myLibrary.checkIn("To Kill a Mockingbird")) {
                System.out.println("Trying to return Book for a second time returns true");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Returning Book for the second time threw an unexpected exception");
            return false;
        }
        // 2. Try to return a nonexistent book
        try {
            if(myLibrary.checkIn("someBook")) {
                System.out.println("Returning a nonexistent Book returned true");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Returning a nonexistent book resulted in an unexpected exception");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
