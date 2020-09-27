
// --== CS400 File Header Information ==--
// Name: Timothy Eric Doughery
// Email: doughery@wisc.edu
// Team: CB
// Role: Back-End Developer
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <none>

public class LibraryTD {
	HashTableMap<String, Book> foo = null;
	
	public LibraryTD() {
		foo = new HashTableMap<String, Book>();
		Book a = new Book("Frankenstein", "Mary Shelley", "Fiction", 111, true);
		Book b = new Book("King Lear", "William Shakespeare", "Drama", 222, true);
		Book c = new Book("The Scarlet Letter", "Nathaniel Hawthorne", "Historical Fiction", 333, true);
		Book d = new Book("Heart of Darkness", "Joseph Conrad", "Novel", 444, true);
		Book e = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 555, true);
		Book[] bar = {a, b, c, d, e};
		for (Book i: bar) {
			foo.put(i.getTitle(), i);
		}
	}
	
	public boolean addBook(String title, String author, String genre, int isbn) {
		Book temp = new Book (title, author, genre, isbn, true);
		return foo.put(title, temp);
	}
	
	public Book getBook(String key) { 
		Book temp = null;
		try {
			temp = foo.get(key);
		} catch (Exception e) {
			
		}
		return temp;
	}
	
	public int librarySize() {
		return foo.size();
	}
	
	public boolean removeBook(String key) {
		if (foo.remove(key) != null) {
			return true;
		}
		return false;
	}

	public boolean checkOut(String key) {
		try {
			if (foo.get(key).getCheckedIn()) { //if the book is available
				foo.get(key).setCheckedIn(); //set it to unavailable
				return true; 
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	public boolean checkIn(String key) {
		try {
			if (!foo.get(key).getCheckedIn()) { //I guess if the book is unavailable
				foo.get(key).setCheckedIn(); //set it to available
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	public boolean isBookAvailable(String key) {
		return foo.get(key).getCheckedIn();
	}
}
