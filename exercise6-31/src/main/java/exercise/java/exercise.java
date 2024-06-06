package exercise.java;
import java.util.Scanner;

public class exercise {

    /** Main method */
    public static void main(String[] args) {
      try (// Create a Scanner
      Scanner input = new Scanner(System.in)) {
      
        // Prompt the user to enter a string
        System.out.print("Enter a credit card number: ");
        long number = input.nextLong();
        //variables for testing
        //long number = 4388576018402626l;
        //long number = 4388576018410707l;
        //long number = 5196081888500645l;

        if (isValid(number))
          System.out.println(number + " is a valid card number!");
        else
          System.out.println(number + " is not a valid card number");
      }
    }

    // Return true if the card number is valid */
    public static boolean isValid(long number) {
      int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
      return total % 10 == 0;
    }

    // Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2) 
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        //System.out.println(sum);
        return sum;
    }

    // Return this number if it is a single digit, otherwise, return the sum of the two digits */
    public static int getDigit(int number) {
      if (number < 9)
        return number;
      return number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2) 
            sum += Integer.parseInt(num.charAt(i) + "");
        //System.out.println(sum);
        return sum;
    }

   // Return the number of digits in a number */
    public static int getSize(long number) {
      return (int) Math.floor(Math.log10(number) + 1);
    }

}