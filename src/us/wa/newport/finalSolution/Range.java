package us.wa.newport.finalSolution;
//Range Class for use in fields in Song
public class Range{
  private int min;
  private int max;
  //Constructs range object from String containing two ints
  public Range(String s){
      String[] parts = s.split("-");
      //Confirmation for both a min and max
      if (parts.length == 2){
          min = Integer.parseInt(parts[0]);
          max = Integer.parseInt(parts[1]);
      }
      else {
          System.out.println("Incorrect range format. Exiting...");
          System.exit(0);
      }
  }
  //Returns if int value is within range
  public boolean contains(int value){
      return value > this.min && value < this.max;
  }
  //Returns min of range
  public int getMin(){
      return this.min;
  }
  //Returns max of range
  public int getMax(){
      return this.max;
  }
}
