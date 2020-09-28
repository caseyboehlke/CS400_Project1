// --== CS400 File Header Information ==--
// Name: Robert Leone Jr.
// Email: rdleone@wisc.edu
// Team: CB
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader:

/*
* This class serves as a database that holds Book objects. Books are provided by librarians
* to add or remove and by students to search for the book in the database.
*/
public class LibraryDB {
  
	private HashTableMap<String, Book> db;
	private Book[] firstBooks;
  
  /*
   * Constructor that creates a library database that functions as a HashTableMap of
   * initial capacity 20. This also adds 5 predefined books into the database.
   */
	public LibraryDB() {
		db = new HashTableMap<String, Book>(20);
		Book a = new Book("Frankenstein", "Mary Shelley", "Fiction", 111);
		Book b = new Book("King Lear", "William Shakespeare", "Drama", 222);
		Book c = new Book("The Scarlet Letter", "Nathaniel Hawthorne", "Historical Fiction", 333);
		Book d = new Book("Heart of Darkness", "Joseph Conrad", "Novel", 444);
		Book e = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 555);
		
		db.put(a.getTitle(),a);
    		db.put(b.getTitle(),b);
    		db.put(c.getTitle(),c);
    		db.put(d.getTitle(),d);
    		db.put(e.getTitle(),e);
	}
  
	/*
	 * Librarian function: Adds a new book to the database given specific details
	 * about the book
	 * 
	 * @param - title of book, author of book, book genre, book ISBN value
	 * 
	 * @return - true if book was added successfully, otherwise false
	 */
	public boolean addBook(String title, String author, String genre, int ISBN) {
		// use put method to add to the library DB
		Book book = new Book(title, author, genre, ISBN, true);
		return db.put(title, book);
	}
  
	/*
	 * Librarian function: Removes a book from the database given its title
	 * 
	 * @param - title of book to remove
	 * 
	 * @return - true if book was removed successfully, otherwise false
	 */
	public boolean removeBook(String title) {
		int checkSize = db.size();
		// use remove method
		db.remove(title);
		if ((checkSize - db.size()) == 1) {
			return true;
		}
		return false;
	}
  
	/*
	 * Search for a book from the database given its title
	 * 
	 * @param - title of book to find
	 * 
	 * @return - Book object corresponding to title
	 */
	public Book getBook(String title){
		return db.get(title);
	}
  
	/*
	 * Return the current size of the library database
	 * 
	 * @param - none
	 * 
	 * @return - integer size of database
	 */
	public int librarySize(){
		return db.size();
	}
  
	//boolean method to see if the book is checked out or  not
	/*
	 * Student function: Determines if a book is available to check-out
	 * given its title
	 * 
	 * @param - title of book to check
	 * 
	 * @return - true if the book is available, otherwise false
	 */
	public boolean isBookAvailable(String title){
		return db.get(title).getCheckedIn();
	}
  
	/*
	 * Student function: Check out the book from the database
	 * 
	 * @param - title of book to check-out
	 * 
	 * @return - true if the book was successfully checked-out, otherwise false
	 */
	public boolean checkOut(String title) {
		if(isBookAvailable(title)) {
			db.get(title).setCheckedIn();
			return true;
		}
		else return false;
	}

	/*
	 * Student function: Return a book to the database given its title
	 * 
	 * @param - title of book to return
	 * 
	 * @return - true if the book was successfully checked-in, otherwise false
	 */
	public boolean checkIn(String title) {
		if(!isBookAvailable(title)) {
			db.get(title).setCheckedIn();
			return true;
		}
		else return false;
	}
}
