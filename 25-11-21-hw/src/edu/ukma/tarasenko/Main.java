package edu.ukma.tarasenko;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter student's first name: ");
    String firstName = scanner.nextLine();

    System.out.print("Enter student's second name: ");
    String secondName = scanner.nextLine();

    Student student = new Student(firstName, secondName);

    while(true) {
      System.out.println("""
              What function do you want to execute? (use q to exit the program)
              (1 - print student first and second name 10 times)
              (2 - print the table of squares of first 5 odd numbers)
              (3 - print the sum of first n natural numbers)
              (4 - print the sum of first n odd natural numbers)
              (5 - print the sum of first n multiplicative inverses)
              (6 - print the table of powers of 2 from 0 to 10)
              (7 - print the factorial of number n)
              (8 - print the values of quadratic function)
              (9 - print 10 random numbers and the average of them)
              (10 - check if the number n is prime)""");

      String input = scanner.nextLine();
      int n;

      switch (input) {
        case "1":
          student.printName10Times();
          break;
        case "2":
          student.printSquaresTable();
          break;
        case "3":
          System.out.print("Enter n: ");
          n = scanner.nextInt();
          System.out.printf("The result is %d\n", student.sumFirstN(n));
          break;
        case "4":
          System.out.print("Enter n: ");
          n = scanner.nextInt();
          System.out.printf("The result is %d\n", student.sumFirstNOdd(n));
          break;
        case "5":
          System.out.print("Enter n: ");
          n = scanner.nextInt();
          System.out.printf("The result is %f\n", student.sumFirstDividors(n));
          break;
        case "6":
          student.print10PowersOfTwo();
          break;
        case "7":
          System.out.print("Enter n: ");
          n = scanner.nextInt();
          System.out.printf("The result is %d\n", student.factorial(n));
          break;
        case "8":
          student.printSquareFunctionValues();
          break;
        case "9":
          student.printRandomNumbersAndAverage();
          break;
        case "10":
          System.out.print("Enter n: ");
          n = scanner.nextInt();
          System.out.println(student.checkPrimeNumber(n) ? "Number is prime" : "Number is not prime");
          break;
        case "q":
          return;
        default:
          System.out.println("Undefined command");
          break;
      }

      System.out.println();
    }
  }
}
