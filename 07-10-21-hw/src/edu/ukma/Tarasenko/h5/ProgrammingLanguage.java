package edu.ukma.Tarasenko.h5;

import java.util.Scanner;

public class ProgrammingLanguage {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String languageName = scanner.nextLine();
    if(languageName.equals("Java")  || languageName.equals("C++") || languageName.equals("C#")) {
      System.out.println("This is programming language " + languageName);
    } else {
      System.out.println("Incorrect name!");
    }
  }
}
