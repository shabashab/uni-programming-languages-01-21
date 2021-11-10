package edu.ukma.tarasenko;

import java.util.Scanner;

public class Pythagorean {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double a, b, c;

    System.out.println("Enter value to compute Pythagorean theorem.");

    System.out.print("a: ");
    a = scanner.nextInt();
    if(a <= 0)
      throw new IllegalArgumentException("Invalid input data. a should be more than 0");

    System.out.print("b: ");
    b = scanner.nextInt();
    if(b <= 0)
      throw new IllegalArgumentException("Invalid input data. b should be more than 0");

    c = Math.sqrt(a*a + b*b);
    System.out.println("c = " + c);
  }
 }
