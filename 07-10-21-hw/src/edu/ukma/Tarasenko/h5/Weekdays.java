package edu.ukma.Tarasenko.h5;

import java.util.Scanner;

class WeekdayValues {
  static final int SUNDAY = 0;
  static final int MONDAY = 1;
  static final int TUESDAY = 2;
  static final int WEDNESDAY = 3;
  static final int THURSDAY = 4;
  static final int FRIDAY = 5;
  static final int SATURDAY = 6;
}

public class Weekdays {

  public static void main(String[] args) {
    System.out.print("Введіть номер дня неділі: ");
    Scanner scanner = new Scanner(System.in);
    int dayNumber = scanner.nextInt();
    String result;
    switch (dayNumber) {
      case WeekdayValues.SUNDAY -> result = "Неділя";
      case WeekdayValues.MONDAY -> result = "Понеділок";
      case WeekdayValues.TUESDAY -> result = "Вівторок";
      case WeekdayValues.WEDNESDAY -> result = "Середа";
      case WeekdayValues.THURSDAY -> result = "Четвер";
      case WeekdayValues.FRIDAY -> result = "П'ятниця";
      case WeekdayValues.SATURDAY -> result = "Субота";
      default -> result = "Неправильний номер дня";
    }
    System.out.println(result);
  }
}
