package edu.ukma.tarasenko;

import java.io.*;
import java.util.Scanner;

public class Encoding {
  private static String encodeString(String input, int shift) {
    StringBuilder outputStringBuilder = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      outputStringBuilder.append((char) (input.charAt(i) + shift));
    }

    return outputStringBuilder.toString();
  }

  private static void writeFile(File file, String contents) throws IOException {
    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write(contents);
    fileWriter.close();
  }

  private static void encodeFile(File fileToEncode, int shift) throws IOException {
    Scanner fileScanner = new Scanner(fileToEncode);
    StringBuilder outputBuilder = new StringBuilder();

    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine();
      String encodedLine = encodeString(line, shift);
      outputBuilder.append(encodedLine).append("\n");
    }

    String output = outputBuilder.toString();
    writeFile(fileToEncode, output);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the name of the file you want to encode: ");
    String fileName = scanner.nextLine();

    System.out.print("Enter the shift: ");
    int shift = scanner.nextInt();

    File inputFile = new File(fileName);

    try {
      encodeFile(inputFile, shift);
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
      System.exit(1);
    }
  }
}
