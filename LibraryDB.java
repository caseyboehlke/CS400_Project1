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
public class LibraryDB implements HashTableMap() {
	
	private HashTableMap<String, Book> db;
	private Book[] firstBooks;
	
	public LibraryDB() {
		db = new HashTableMap<String, Book>(20);
		
	}
	
	public boolean addBook(String title, String author, String genre, int ISBN){
	// use put method to add to the library DB
		Book book = new Book(title, author, genre, ISBN, true);
		db.put(title, book);
	}
	
	public boolean removeBook(String title){
    // use remove method
		db.remove(title);
	}
	
	public String getBook(String title){
    // 
		db.get(title);
	}
	
// return the concatenated string of all book variables
	public int librarySize(){
		return db.size;
	}
	
//boolean method to see if the book is checked out or  not
	public boolean isBookAvailable(String title){
		return db.get(title).getCheckedIn();
		
	}
	
	public boolean checkOut(String title) {
		if(db.isBookAvailable(title)) {
			db.get(title).setCheckedIn(false);
			return true
		}
		else return false;
	}
	
// change the book check out status
