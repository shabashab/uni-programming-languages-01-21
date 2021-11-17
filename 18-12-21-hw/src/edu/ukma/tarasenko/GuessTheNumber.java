package edu.ukma.tarasenko;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumber {
  static final int MIN_NUMBER = 1;
  static final int MAX_NUMBER = 1000;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER);
    System.out.printf("Я вибрав число між %d та %d\n", MIN_NUMBER, MAX_NUMBER);

    for(;;) {
      System.out.print("Ваш варіант: ");
      int input = scanner.nextInt();

      if(input == number)
        break;

      if(input > number)
        System.out.println("Менше");
      else
        System.out.println("Більше");
    }

    System.out.println("Вірно!");
  }
}
