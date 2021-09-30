package edu.ukma.Tarasenko.h5;

import java.util.Scanner;

class SeasonsValues {
  static final int WINTER = 1;
  static final int SPRING = 2;
  static final int SUMMER = 3;
  static final int FALL = 4;
}

public class Seasons {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int seasonNumber = scanner.nextInt();
    String seasonName;
    switch (seasonNumber) {
      case SeasonsValues.WINTER -> seasonName = "Зима";
      case SeasonsValues.SPRING -> seasonName = "Весна";
      case SeasonsValues.SUMMER -> seasonName = "Літо";
      case SeasonsValues.FALL -> seasonName = "Осінь";
      default -> seasonName = "Помилка при вводі!";
    }
    System.out.println(seasonName);
  }
}
