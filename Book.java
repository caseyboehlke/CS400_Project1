// --== CS400 File Header Information ==--
// Name: Connor William Dyjach
// Email:dyjach@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Gary Dahl
// Notes to Grader:


/*
 * This class represents a book with and stores its title, and details in strings
 * 
 * @author Connor Dyjach
 */
public class Book<KeyType, ValueType> {

  private String title;
  private String details; 

  /*
   * creates a book object.
   * 
   * @param title String value representing the title
   * 
   * @param details String Value representing the details of the book
   * 
   */
  public Book(KeyType key, ValueType value) {

    this.title = (String) key;
    this.details = (String) value;
   


  }

/*
 * @return title a string value representing a books title
 */
  public String getKey() {

    return this.title;

  }

  /*
   * @return details a string value representing a books details
   */
  public String getValue() {

    return this.details;

  }
  
  

 


}
