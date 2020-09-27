// --== CS400 File Header Information ==--
// Name: Connor William Dyjach
// Email:dyjach@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Gary Dahl
// Notes to Grader:


/*
 * This class represents a book with and stores its title, ISBN number, author, checked in/out
 * status, genre, and a brief description
 * 
 * @author Connor Dyjach
 */
public class Book {

  private String title;
  private int isbn;
  private String author;
  private boolean checkedIn;
  private String genre;
  private String description;


  /*
   * creates a book object.
   * 
   * @param title String value representing the title
   * 
   * @param isbn int value representing the isbn number
   * 
   * @param author String value representing the author
   * 
   * @param checkedIn boolean value representing if a booked is checked in.
   * 
   * @param genre String value representing the genre
   * 
   * @param description String value representing a short description of the book
   * 
   */
  public Book(String title, String author, String genre, int isbn, boolean checkedIn) {

    this.title = title;
    this.isbn = isbn;
    this.author = author;
    this.checkedIn = checkedIn;
    this.genre = genre;
    
    
   


  }


  public String getTitle() {

    return this.title;

  }

  public int getIsbn() {

    return this.isbn;

  }


  public String getAuthor() {

    return this.author;

  }

  public boolean getChekedIn() {

    return this.checkedIn;

  }
  
  /*
   * changes whether the book is checked in or not
   */
  public void setChekedIn() {

     if (this.checkedIn == true) {
       this.checkedIn = false;
     }
     else {
       this.checkedIn = true;
     }

  }


  public String getGenre() {

    return this.genre;
  }



}
