package edu.ukma.tarasenko;

import java.io.*;
import java.util.Scanner;

public class Backup {
  private static void copyFile(File inputFile, File outputFile) throws IOException {
    final int BUFFER_SIZE = 1024;

    InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));
    OutputStream outputFileStream = new BufferedOutputStream(new FileOutputStream(outputFile));

    byte[] buffer = new byte[BUFFER_SIZE];
    int readCount;

    while ((readCount = inputFileStream.read(buffer)) > 0) {
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
    File outputFile = new File(fileName + ".bak");

    try {
      copyFile(inputFile, outputFile);
    } catch (IOException exception) {
      System.out.printf("ERROR: %s\n", exception.getMessage());
      System.exit(1);
    }
  }
}
