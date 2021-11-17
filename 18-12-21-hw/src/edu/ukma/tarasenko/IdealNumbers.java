package edu.ukma.tarasenko;

public class IdealNumbers {
  static final int MIN_NUMBER = 1;
  static final int MAX_NUMBER = 10000;

  public static boolean checkNumber(int number) {
    int sum = 0;

    for (int i = 1; i < number; i++)
      if ((number % i) == 0) sum += i;

    return sum == number;
  }

  public static void main(String[] args) {
    for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++)
      if(checkNumber(i))
        System.out.printf("Число %d є досконалим\n", i);
  }
}
