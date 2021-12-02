package edu.ukma.tarasenko;

import java.io.*;
import java.util.Scanner;

public class ReplaceSubstring {

  private static void writeToFile(File file, String data) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    writer.write(data);
    writer.close();
  }

  private static void replaceSubstring(File file, String substring, String replacement) throws IOException {
    Scanner scanner = new Scanner(file);
    StringBuilder outputStringBuilder = new StringBuilder();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String formattedLine = line.replaceAll(substring, replacement);
      outputStringBuilder.append(formattedLine).append('\n');
    }

    String outputString = outputStringBuilder.toString();
    writeToFile(file, outputString);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter input file name: ");
    String inputFileName = scanner.nextLine();

    System.out.print("Enter the substring to replace: ");
    String substring = scanner.nextLine();

    System.out.print("Enter the string to replace substring with: ");
    String replacement = scanner.nextLine();

    File inputFile = new File(inputFileName);

    try {
      replaceSubstring(inputFile, substring, replacement);
    } catch (IOException e) {
      System.out.printf("ERROR: %s\n", e.getMessage());
      System.exit(1);
    }
  }
}
