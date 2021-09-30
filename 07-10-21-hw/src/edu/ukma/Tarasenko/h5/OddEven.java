package edu.ukma.Tarasenko.h5;

import java.util.Scanner;

public class OddEven {
  public static void main(String[] args) {
    System.out.print("Enter a number: ");

    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    boolean isEven = (number % 2) == 0;
    String result = isEven ? "The number is even" : "The number is odd";

    System.out.println(result);
  }
}
