public enum JacketSize {
   small(36), medium(40), large(42), extra_large(46), extra_extra_large(48);

  // Constructor
  JacketSize(int chestSize) {
    this.chestSize = chestSize;
  }
  // Method to return the chest size for the current jacket size
  public int chestSize() {
    return chestSize;
  }

  private int chestSize;                                               // Field to record chest size
 }
