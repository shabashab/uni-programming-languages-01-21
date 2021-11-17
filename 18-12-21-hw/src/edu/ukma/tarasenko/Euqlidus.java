package edu.ukma.tarasenko;

import java.util.Scanner;

public class Euqlidus {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int a, b;

    System.out.print("Введіть число a: ");
    a = scanner.nextInt();

    System.out.print("Введіть число b: ");
    b = scanner.nextInt();

    while (a != b) {
      if (a > b) a = a - b;
      else b = b - a;
    }

    System.out.printf("НСД: %d\n", a);
  }
}
