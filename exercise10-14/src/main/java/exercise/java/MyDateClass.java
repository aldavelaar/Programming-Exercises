package exercise.java;
import java.util.Calendar;

public class MyDateClass {
    /** Main method */ 
    public static void main(String[] args) {
// print those dates
      MyDate date1 = new MyDate();
      System.out.println("The year is " + date1.getYear()
      + ", the month is "+ date1.getMonth()
      + ", and the day is "+ date1.getDay()
      + ".");
      
      Calendar date2 = Calendar.getInstance();
      date2.setTimeInMillis(34355555133101l);
      System.out.println("Elapsed time after Jan 01 12:00:00 EDT 1970 is " + date2.getTime()
      + ".");

    
    }
  }
// the date object
  class MyDate {
    int year;
    int month;
    int day;

// no args constructor
    public MyDate() {
      this.year = Calendar.YEAR;
      this.month = Calendar.MONTH;
      this.day = Calendar.DAY_OF_MONTH;
    }

    public MyDate(int year, int month, int day) {
      this.year = year;
      this.month = month;
      this.day = day;
    }

    int getYear() {
      return this.year;
    }

    int getMonth() {
      return this.month;
    }

    int getDay() {
      return this.day;
    }

    public void setDate(int year, int month, int day) {
      this.year = year;
      this.month = month;
      this.day = day;
    }

  }