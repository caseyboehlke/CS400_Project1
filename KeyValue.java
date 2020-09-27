// --== CS400 File Header Information ==--
// Name: Connor William Dyjach
// Email:dyjach@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Gary Dahl
// Notes to Grader:
public class KeyValue<KeyType, ValueType> {

  private KeyType key;
  private ValueType value;


  public KeyValue(KeyType key, ValueType value) {

    this.key = key;
    this.value = value;

  }

  public KeyType getKey() {

    return this.key;

  }

  public ValueType getValue() {

    return this.value;

  }

}
