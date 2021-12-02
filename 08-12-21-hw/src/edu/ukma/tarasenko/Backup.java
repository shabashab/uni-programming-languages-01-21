package edu.ukma.tarasenko;

import javax.management.BadStringOperationException;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Backup {
  private static String replaceLast(String input, String toReplace, String replacement) {
    return input.replaceFirst("(" + toReplace + ")$", replacement);
  }

  private static String createOutputFilePath(String inputFileName) throws BadStringOperationException {
    String regex = "([^\\/\\\\\\.]*)(\\.([a-zA-Z]+))?$";
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(inputFileName);

    if(matcher.find()) {
      String extension = matcher.group(2);

      if(extension == null)
        extension = "";

      return replaceLast(inputFileName, extension, ".bak");
    }

    throw new BadStringOperationException("Invalid input string");
  }

  private static void copyFile(File inputFile, File outputFile) throws IOException {
    final int BUFFER_SIZE = 1024;

    InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));
    OutputStream outputFileStream = new BufferedOutputStream(new FileOutputStream(outputFile));

    byte[] buffer = new byte[BUFFER_SIZE];
    int readCount;

    while((readCount = inputFileStream.read(buffer)) > 0) {
      outputFileStream.write(buffer, 0, readCount);
    }

    inputFileStream.close();
    outputFileStream.close();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the file name to backup: ");
    String fileName = scanner.nextLine();

    File inputFile = new File(fileName);

    if(!inputFile.exists()) {
      System.out.println("ERROR: Input file does not exist");
      System.exit(1);
    }

    if(!inputFile.canRead()) {
      System.out.println("ERROR: Input file does not exist");
      System.exit(1);
    }

    if(!inputFile.exists()) {
      System.out.println("ERROR: Input file does not exist");
      System.exit(1);
    }

    String outputFilePath = "";
    try {
      outputFilePath = createOutputFilePath(fileName);
    } catch (BadStringOperationException exception) {
      System.out.println("ERROR: Input file format is incorrect");
      System.exit(1);
    }

    File outputFile = new File(outputFilePath);

    try {
      copyFile(inputFile, outputFile);
    } catch (IOException exception) {
      System.out.println("ERROR: error when trying to copy a file");
    }
  }
}
