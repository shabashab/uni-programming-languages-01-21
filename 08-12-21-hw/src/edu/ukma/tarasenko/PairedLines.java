package edu.ukma.tarasenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PairedLines {

  private static final String ODD_LINES_FILE_NAME = "oddLines.txt";
  private static final String EVEN_LINES_FILE_NAME = "evenLines.txt";

  private static void fatalError(String message) {
    System.out.printf("ERROR: %s\n", message);
    System.exit(1);
  }

  public static void createFiles(File inputFile, File evenLinesFile, File oddLinesFile) throws IOException {
    Scanner inputFileScanner = new Scanner(inputFile);

    FileWriter evenLinesFileWriter = new FileWriter(evenLinesFile);
    FileWriter oddLinesFileWriter = new FileWriter(evenLinesFile);

    for(long i = 0; inputFileScanner.hasNextLine(); i++) {
      String line = inputFileScanner.nextLine();

      if(i % 2 == 0)
        evenLinesFileWriter.write(line);
      else oddLinesFileWriter.write(line);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a name of the file you want to use: ");
    String inputFileName = scanner.nextLine();

    File inputFile = new File(inputFileName);
    File oddLinesFile = new File(ODD_LINES_FILE_NAME);
    File evenLinesFile = new File(EVEN_LINES_FILE_NAME);

    try {
      createFiles(inputFile, evenLinesFile, oddLinesFile);
    } catch (IOException e) {
      fatalError(e.getMessage());
    }
  }
}
