package edu.ukma.tarasenko;

public class FriendlyNumbers {
  static final int MIN_NUMBER = 1;
  static final int MAX_NUMBER = 10000;

  public static int calculateSum(int num) {
    int sum = 0;
    for (int i = 1; i < num; i++)
      if ((num % i) == 0)
        sum += i;
    return sum;
  }

  public static boolean checkPair(int num1, int num2) {
    int sum1 = calculateSum(num1);
    int sum2 = calculateSum(num2);

    return sum1 == num2 && sum2 == num1;
  }

  public static void main(String[] args) {
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++)
      for (int j = MIN_NUMBER; j <= MAX_NUMBER; j++)
        if (checkPair(i, j))
          System.out.printf("Пара чисел %d і %d є дружними\n", i, j);
  }
}
