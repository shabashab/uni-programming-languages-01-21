package edu.ukma.tarasenko;

import java.util.Scanner;

public class Pythagorean {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double a, b, c;

    System.out.println("Enter value to compute Pythagorean theorem.");
    System.out.print("a: ");
    a = scanner.nextInt();
    System.out.print("b: ");
    b = scanner.nextInt();

    c = Math.sqrt(a*a + b*b);
    System.out.println("c = " + c);
  }
 }
