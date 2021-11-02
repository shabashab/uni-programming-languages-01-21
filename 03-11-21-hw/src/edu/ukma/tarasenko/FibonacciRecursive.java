package edu.ukma.tarasenko;

import java.util.Scanner;

public class FibonacciRecursive {

  private static void fibonacci(int max, int previousValue, int currentValue, int currentIndex) {
    System.out.printf("%d - %d\n", currentIndex, currentValue);

    int newValue = previousValue + currentValue;
    if(newValue > max)
      return;

    fibonacci(max, currentValue, newValue, currentIndex + 1);
  }

  private static void fibonacci(int max) {
    fibonacci(max, 1, 0, 0);
  }

  public static void main(String[] args) {
    System.out.print("Enter max value: ");

    Scanner scanner = new Scanner(System.in);
    int max = scanner.nextInt();

    fibonacci(max);
  }
}
