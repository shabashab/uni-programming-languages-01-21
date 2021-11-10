package edu.ukma.tarasenko;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinMax {
  static final String stopKeyword = "0";

  public static int[] input() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> result = new ArrayList<>();

    while (true) {
      System.out.print("? ");
      String inputValue = scanner.nextLine();

      if(stopKeyword.equals(inputValue))
        break;

      int value = Integer.parseInt(inputValue);
      result.add(value);
    }

    return result.stream().flatMapToInt(IntStream::of).toArray();
  }

  public static int min(int[] value) {
    if (value.length == 0)
      throw new IllegalArgumentException();

    int minValue = value[0];
    for (int i = 1; i < value.length; i++)
      if (value[i] < minValue)
        minValue = value[i];

    return minValue;
  }

  public static int max(int[] value) {
    if(value.length == 0)
      throw new IllegalArgumentException();

    int maxValue = value[0];
    for(int i = 1; i < value.length; i++)
      if(value[i] > maxValue)
        maxValue = value[i];

    return maxValue;
  }

  public static void main(String[] args) {
    System.out.println("This program finds the largest and the smallest numbers");

    int[] input = input();

    if (input.length == 0) {
      System.out.println("No input data is provided");
      return;
    }

    int min = min(input);
    int max = max(input);
    System.out.printf("smallest: %d\n", min);
    System.out.printf("largest: %d\n", max);
  }
}
