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
	}
	
	public boolean addBook(String title, String author, String genre, int isbn) {
		Book temp = new Book (title, author, genre, isbn, true);
		return foo.put(title, temp);
	}
	
	public String getBook(String key) { 
		return ("Title: " + foo.get(key).getTitle() + "\nISBN: " + foo.get(key).getIsbn()
		+ "\nAuthor: " + foo.get(key).getAuthor() + "\nGenre: " + foo.get(key).getGenre());
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

	public boolean checkoutBook(String key) {
		if (foo.get(key).getCheckedIn()) { //if the book is available
			foo.get(key).setCheckedIn(); //set it to unavailable
			return true; 
		}
		return false;
	}
	public boolean dropOffBook(String key) {
		if (!foo.get(key).getCheckedIn()) { //I guess if the book is unavailable
			foo.get(key).setCheckedIn(); //set it to available
			return true;
		}
		return false;
	}
}
