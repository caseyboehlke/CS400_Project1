// --== CS400 File Header Information ==--
// Name: Casey Boehlke
// Email: cboehlke@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Florian Heimerl
// Notes to Grader: none


/**
 * This is the Book class. It creates a book object and sets the values to whatever is input. It
 * also returns those values.
 * 
 * @author Casey Boehlke
 *
 */
public class Book {

  // Instance Variables
  private String title;
  private String author;
  private String genre;
  private int isbnNum;
  private boolean isCheckedIn;

  /**
   * This class creates a book object.
   * 
   * @param title       String value of the title of the book
   * @param author      String value of the name of the author
   * @param genre       String value of the genre of the book
   * @param isbnNum     Int value of the ISBN number of the book
   * @param isCheckedIn Boolean value representing whether or not the book is checked out
   */
  public Book(String title, String author, String genre, int isbnNum, boolean isCheckedIn) {

    this.title = title;
    this.author = author;
    this.genre = genre;
    this.isbnNum = isbnNum;
    this.isCheckedIn = isCheckedIn;

  }

  /**
   * Getter method for the title
   * 
   * @return the title of the book
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Getter method for the author
   * 
   * @return the author of the book
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Getter method for the genre
   * 
   * @return the genre of the book
   */
  public String getGenre() {
    return this.genre;
  }

  /**
   * Getter method for the ISBN number
   * 
   * @return the ISBN number of the book
   */
  public int getIsbnNum() {
    return this.isbnNum;
  }

  /**
   * Getter method for the checked in or out status of the book
   * 
   * @return true if the book is checked out, false otherwise
   */
  public boolean getIsCheckedIn() {
    return this.isCheckedIn;
  }

  /**
   * Setter method for the isCheckedIn value of the book. Simply changes it to the other value
   */
  public void setIsCheckedIn() {
    this.isCheckedIn = (!this.isCheckedIn);
  }

  /**
   * Returns a neatly organized String with all of the data about the book
   * 
   * @return all of the variables
   */
  public String getData() {

    String data = "";

    data = data + "Title: " + getTitle() + System.lineSeparator() + "Author: " + getAuthor()
        + System.lineSeparator() + "Genre: " + getGenre() + System.lineSeparator() + "ISBN: "
        + getIsbnNum() + System.lineSeparator() + "Checked In: " + getIsCheckedIn();

    return data;
  }

}
