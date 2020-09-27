// --== CS400 File Header Information ==--
// Name: Robert Leone Jr.
// Email: rdleone@wisc.edu
// Team: CB
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader:

/*
* This class serves as a database that holds Book objects. Books are provided by librarians
* to add or remove and by readers to search for the book in the database.
*/
public class LibraryDB implements HashTableMap() {
	
	private boolean bookStatus();		//true = available, false = checked out
	
	public LibraryDB() {
		HashTableMap db = new HashTableMap();
	}
	
	public boolean addBook(Book bookToAdd){
	// use put method to add to the library DB
		db.put(bookToAdd.getTitle(), bookToAdd.getIsbn(), bookToAdd.getAuthor(), bookStatus,
			bookToAdd.getGenre(), bookToAdd.getDescription());
	}
	
	public boolean removeBook(Book bookToRemove){
    // use remove method
		db.remove(bookToRemove.getTitle());
		
	}
	
	public String getBook(int key){
    // 
		db.get(key);
	}
	
// return the concatenated string of all book variables
	public int librarySize(){
		return size;
	}
	
//boolean method to see if the book is checked out or  not
	public boolean isBookCheckedOut(Book bookToCheck){
		return bookStatus;
	}
	
	public boolean checkOut(Book bookToCheck){
		if(!isBookCheckedOut(bookToCheck)) {
			bookStatus = false;
			return true
		}
		else return false;
	}
	
// change the book check out status