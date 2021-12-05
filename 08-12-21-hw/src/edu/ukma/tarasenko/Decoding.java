package edu.ukma.tarasenko;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Decoding {

  private static void writeFile(File file, String contents) throws IOException {
    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write(contents);
    fileWriter.close();
  }

  private static String decodeString(String input, int shift) {
    StringBuilder outputBuilder = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      outputBuilder.append((char) (input.charAt(i) - shift));
    }

    return outputBuilder.toString();
  }

  private static void decodeFile(File file, int shift) throws IOException {
    Scanner fileScanner = new Scanner(file);
    StringBuilder outputBuilder = new StringBuilder();

    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine();
      String encodedLine = decodeString(line, shift);
      outputBuilder.append(encodedLine).append("\n");
    }

    String output = outputBuilder.toString();
    writeFile(file, output);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the name of the file you want to decode: ");
    String fileName = scanner.nextLine();

    System.out.print("Enter the shift: ");
    int shift = scanner.nextInt();

    File inputFile = new File(fileName);

    try {
      decodeFile(inputFile, shift);
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
      System.exit(1);
    }
  }
}
