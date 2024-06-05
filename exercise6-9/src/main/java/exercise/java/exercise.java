package exercise.java;

public class exercise {
    public static void main(String[] args) {

        String spaceNew = "          \n";
        String spaceContinue = "         ";

        System.out.print("Feet");
        System.out.print(spaceContinue);
      
        System.out.print("Meters");
        System.out.print(spaceContinue);

        System.out.print("Feet");
        System.out.print(spaceContinue);

        System.out.print("Meters");
        System.out.printf(spaceNew);

      printNumbers(10);
    }

    public static void printNumbers(int NUMBERS) {
      int count = 1;
      double number = 1;

      while (count <= NUMBERS) {

        String spaceNew = "          \n";
        String spaceContinue = "          ";

          System.out.print(number);
          System.out.printf(spaceContinue);
        
          System.out.print(number * 0.305);
          System.out.print(spaceContinue);

          System.out.print(number * 5 + 15);
          System.out.print(spaceContinue);

          System.out.print((number * 5 + 15) * 3.279);
          System.out.print(spaceNew);

        count++;
        number++;
      }
    }

}