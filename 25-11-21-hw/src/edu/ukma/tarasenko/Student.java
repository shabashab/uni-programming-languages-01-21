package edu.ukma.tarasenko;

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
    for (int i = 0; i < 10; i++)
      System.out.printf("%s %s\n", this._firstName, this._secondName);
  }

  void printSquaresTable() {
    for (int i = 1; i <= 5; i++) {
      int number = (i * 2) - 1;
      int square = number * number;

      System.out.printf("%d^2 = %d\n", number, square);
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
    for(int i = 0; i <= 10; i++) {
      System.out.printf("2^%d = %d", i, (int)Math.pow(2, i));
    }
  }

  int factorial(int n) {
    return n == 1 ? 1 : n * factorial(n - 1);
  }

  private void printFunctionValues(float min, float max, float step, FunctionRunnable runnable) {
    for(float i = min; i <= max; i += step)  {
      System.out.printf("f(%f) = %f\n", i, runnable.calculate(i));
    }
  }

  void printSquareFunctionValues() {
    printFunctionValues(-2f, 2f, 0.25f, (float input) -> ((-2.4f) * input * input) + ((-5f) * input) - 3);
  }

  void randomNumbers() {
    int[] numbers = new int[10];

    for(int i = 0; i < 10; i++) {
      numbers[i] = ThreadLocalRandom.current().nextInt(1, 10);
      System.out.printf("Number %d: %d\n", i + 1, numbers[i]);
    }

    OptionalDouble average = Arrays.stream(numbers).average();
    if(average.isPresent())
      System.out.printf("Average: %f", average.getAsDouble());
  }

  boolean checkPrimeNumber(int value) {
    if(value % 2 == 0) return false;

    for(int i = 3; i < value; i += 2)
      if(value % i == 0) return false;

    return true;
  }
}
