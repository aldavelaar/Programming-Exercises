package exercise.java;
import java.util.Scanner;


public class MatchSymbols extends Exception {
  /** Main method */ 
  public static void main(String[] args) {
    try (// Create a Scanner
      Scanner input = new Scanner(System.in)) {
        System.out.println("Enter some code: ");
        String code = input.nextLine();
        boolean isCorrect = true;
        java.util.Deque<String> symbols = new java.util.ArrayDeque<>();
        for (int idx = 0; idx < code.length(); idx++) {
          char c = code.charAt(idx);
          if (c == '(' || c == '[' || c == '{') {
            symbols.offer(Character.toString(c));
          }
          if (c == ')' || c == ']' || c == '}') {
            if (
              ("(".equals(symbols.getLast()) && c == ')') ||
              ("[".equals(symbols.getLast()) && c == ']') ||
              ("{".equals(symbols.getLast()) && c == '}') ) {
              symbols.removeLast();
            } else {
              isCorrect = false;
            }
          }
        }
        if (isCorrect && symbols.isEmpty()) {
          System.out.println("The symbols in the code are correct.");
        } else {
          System.out.println("The symbols in the code are incorrect.");
        }
        System.out.println(symbols);
        System.out.println(isCorrect);
      }
  }
}