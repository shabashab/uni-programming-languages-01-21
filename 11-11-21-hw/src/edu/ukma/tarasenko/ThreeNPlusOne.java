package edu.ukma.tarasenko;

import java.util.Scanner;

public class ThreeNPlusOne {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter n: ");
    int value = scanner.nextInt();

    if (value <= 0)
      throw new IllegalArgumentException("n should be greater than 0");

    int stepsCount = 0;
    while (value != 1) {
      int newValue;
      if (value % 2 == 0) {
        newValue = value / 2;
        System.out.printf("value = value / 2 = %d / 2 = %d\n", value, newValue);
      } else {
        newValue = (3 * value) + 1;
        System.out.printf("value = (value * 3) + 1 = (%d * 3) + 1 = %d\n", value, newValue);
      }
      value = newValue;
      stepsCount++;
    }

    System.out.printf("steps count: %d", stepsCount);
  }
}
