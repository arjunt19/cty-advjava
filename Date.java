import java.io.Serializable;

public class Date implements Serializable //same thing as give code except implements serializable as it needs to be serialized when a song object is serialized
{
  private int month; //necessary attributes
  private int day;
  private int year;
  
  public Date() { month = 0; day = 0; year = 0; } //constructor
  
  public void setDate( int m, int d, int y ) //setter and getter
  {
    month = m; day = d; year = y;
  }
  
  public String getDateString()
  {
    return month + "/" + day + "/" + year;
  }
}