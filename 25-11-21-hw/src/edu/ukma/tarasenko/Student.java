package edu.ukma.tarasenko;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;

interface FunctionRunnable {
  float calculate(float input);
}

public class Student {
  private final String _firstName;
  private final String _secondName;

  Student(String firstName, String secondName) {
    this._firstName = firstName;
    this._secondName = secondName;
  }

  void printName10Times() {
    this.printName10Times(System.out);
  }

  void printName10Times(PrintStream outputStream) {
    for (int i = 0; i < 10; i++)
      outputStream.printf("%s %s\n", this._firstName, this._secondName);
  }

  void printSquaresTable() {
    this.printSquaresTable(System.out);
  }

  void printSquaresTable(PrintStream outputStream) {
    for (int i = 1; i <= 5; i++) {
      int number = (i * 2) - 1;
      int square = number * number;

      outputStream.printf("%d^2 = %d\n", number, square);
    }
  }

  int sumFirstN(int n) {
    int sum = 0;
    while((--n) != 0) {
      sum += (n + 1);
    }
    return sum;
  }

  int sumFirstNOdd(int n) {
    int sum = 0;
    while((--n) != 0) {
      sum += ((n + 1) * 2) - 1;
    }
    return sum;
  }

  float sumFirstDividors(int n) {
    float sum = 0f;
    while((n--) != 0) {
      sum += 1f / (n + 1);
    }
    return sum;
  }

  void print10PowersOfTwo() {
    this.print10PowersOfTwo(System.out);
  }

  void print10PowersOfTwo(PrintStream outputStream) {
    for(int i = 0; i <= 10; i++) {
      outputStream.printf("2^%d = %d", i, (int)Math.pow(2, i));
    }
  }

  int factorial(int n) {
    return n == 1 || n == 0 ? 1 : n * factorial(n - 1);
  }

  private void printFunctionValues(float min, float max, float step, FunctionRunnable runnable, PrintStream outputStream) {
    for(float i = min; i <= max; i += step)  {
      outputStream.printf("f(%f) = %f\n", i, runnable.calculate(i));
    }
  }

  void printSquareFunctionValues() {
    this.printSquareFunctionValues(System.out);
  }

  void printSquareFunctionValues(PrintStream outputStream) {
    printFunctionValues(-2f, 2f, 0.25f, (float input) -> ((-2.4f) * input * input) + ((-5f) * input) - 3, outputStream);
  }

  void printRandomNumbersAndAverage() {
    this.printRandomNumbersAndAverage(System.out);
  }

  void printRandomNumbersAndAverage(PrintStream outputStream) {
    int[] numbers = new int[10];

    for(int i = 0; i < 10; i++) {
      numbers[i] = ThreadLocalRandom.current().nextInt(1, 10);
      outputStream.printf("Number %d: %d\n", i + 1, numbers[i]);
    }

    OptionalDouble average = Arrays.stream(numbers).average();
    if(average.isPresent())
      outputStream.printf("Average: %f", average.getAsDouble());
  }

  boolean checkPrimeNumber(int value) {
    if(value % 2 == 0) return false;

    for(int i = 3; i < value; i += 2)
      if(value % i == 0) return false;

    return true;
  }
}
