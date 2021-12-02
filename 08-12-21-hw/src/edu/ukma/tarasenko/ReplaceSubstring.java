package edu.ukma.tarasenko;

import java.io.*;
import java.util.Scanner;

class FileSubstringReplacer {
  private void writeToFile(File file, String data) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    writer.write(data);
    writer.close();
  }

  public void replaceSubstring(File file, String substring, String replacement) throws IOException {
    Scanner scanner = new Scanner(file);
    StringBuilder outputStringBuilder = new StringBuilder();

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();
      outputStringBuilder.append(line.replaceAll(substring, replacement)).append('\n');
    }

    String outputString = outputStringBuilder.toString();
    writeToFile(file, outputString);
  }
}

public class ReplaceSubstring {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter input file name: ");
    String inputFileName = scanner.nextLine();

    System.out.print("Enter the substring to replace: ");
    String substring = scanner.nextLine();

    System.out.print("Enter the string to replace substring with: ");
    String replacement = scanner.nextLine();

    File inputFile = new File(inputFileName);

    if(!inputFile.exists()) {
      System.out.println("ERROR: Input file does not exist!");
      System.exit(1);
    }

    if(!inputFile.canRead()) {
      System.out.println("ERROR: Input file is not readable!");
      System.exit(1);
    }

    if(!inputFile.canWrite()) {
      System.out.println("ERROR: Input file is not writable!");
      System.exit(1);
    }

    FileSubstringReplacer replacer = new FileSubstringReplacer();
    try {
      replacer.replaceSubstring(inputFile, substring, replacement);
    } catch (IOException e) {
      System.out.printf("ERROR: %s\n", e.getMessage());
      System.exit(1);
    }
  }
}
