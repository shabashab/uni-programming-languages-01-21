package edu.ukma.tarasenko;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface RunnableTestFunction {
  void run(PrintStream stream);
}

public class StudentTestSuite {

  private String getFunctionPrintStringOutput(RunnableTestFunction function) throws UnsupportedEncodingException {
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    final String utf8 = StandardCharsets.UTF_8.name();
    try (PrintStream ps = new PrintStream(baos, true, utf8)) {
      function.run(ps);
    }
    return baos.toString(utf8);
  }

  private boolean testPrintFunction(String expectedOutput, RunnableTestFunction function) {
    try {
      String output = this.getFunctionPrintStringOutput(function);
      return expectedOutput.equals(output);
    } catch (Exception e) {
      return false;
    }
  }

  private Student createStudent() {
    return new Student("Artem", "Tarasenko");
  }

  public boolean testPrintName10Times() {
    Student student = createStudent();
    String expectedOutput = """
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            Artem Tarasenko
            """;

    return testPrintFunction(expectedOutput, student::printName10Times);
  }

  public boolean testPrintSquaresTable() {
    Student student = createStudent();
    String expectedOutput = """
            1^2 = 1
            3^2 = 9
            5^2 = 25
            7^2 = 49
            9^2 = 81
            """;

    return testPrintFunction(expectedOutput, student::printSquaresTable);
  }

  public boolean testSumFirstN() {
    Student student = createStudent();
    int[] expectedResults = new int[]{0, 1, 3, 6, 10, 15, 21};

    for(int i = 0; i < expectedResults.length; i++)
      if(student.sumFirstN(i) != expectedResults[i])
        return false;

    return true;
  }

  public boolean testSumFirstNOdd() {
    Student student = createStudent();
    int[] expectedResults = new int[]{0, 1, 4, 9, 16, 25, 36};

    for(int i = 0; i < expectedResults.length; i++)
      if(student.sumFirstNOdd(i) != expectedResults[i])
        return false;

    return true;
  }

  public boolean testSumFirstDividors() {
    Student student = createStudent();
    float[] expectedResults = new float[]{0f, 1.5f, 1.8333333f};

    for(int i = 0; i < expectedResults.length; i++)
      if(student.sumFirstDividors(i) != expectedResults[i])
        return false;

    return true;
  }

  public boolean testPrint10PowersOfTwo() {
    Student student = createStudent();
    String expectedOutput = """
            2^0 = 1
            2^1 = 2
            2^2 = 4
            2^3 = 8
            2^4 = 16
            2^5 = 32
            2^6 = 64
            2^7 = 128
            2^8 = 256
            2^9 = 512
            2^10 = 1024
            """;

    return testPrintFunction(expectedOutput, student::print10PowersOfTwo);
  }

  public boolean testFactorial() {
    Student student = createStudent();
    int[] expectedResults = new int[]{1, 1, 2, 6, 24, 120};

    for(int i = 0; i < expectedResults.length; i++)
      if(student.factorial(i) != expectedResults[i])
        return false;

    return true;
  }

  public boolean testPrintSquareFunctionValues() {
    Student student = createStudent();
    String expectedOutput = """
            f(-2.000000) = -2.600000
            f(-1.750000) = -1.600000
            f(-1.500000) = -0.900000
            f(-1.250000) = -0.500000
            f(-1.000000) = -0.400000
            f(-0.750000) = -0.600000
            f(-0.500000) = -1.100000
            f(-0.250000) = -1.900000
            f(0.000000) = -3.000000
            f(0.250000) = -4.400000
            f(0.500000) = -6.100000
            f(0.750000) = -8.100000
            f(1.000000) = -10.400000
            f(1.250000) = -13.000000
            f(1.500000) = -15.900000
            f(1.750000) = -19.100000
            f(2.000000) = -22.600000
            """;

    return testPrintFunction(expectedOutput, student::printSquareFunctionValues);
  }

  private int parseNumberLine(String line) {
    String regexPatternString = "Number ([0-9]+): ([0-9]+)";
    Pattern regexPattern = Pattern.compile(regexPatternString);

    Matcher regexMatcher = regexPattern.matcher(line);

    if(regexMatcher.find()) {
      int numValue;

      try {
        numValue = Integer.parseInt(regexMatcher.group(1));
      } catch (Exception e) {
        throw new IllegalArgumentException("Invalid input string");
      }

      return numValue;
    } else throw new IllegalArgumentException("Invalid input string");
  }

  private float parseAverageLine(String line) {
    String regexPatternString = "Average: ([0-9.]+)";
    Pattern regexPattern = Pattern.compile(regexPatternString);

    Matcher regexMatcher = regexPattern.matcher(line);

    if(regexMatcher.find()) {
      try {
        return Float.parseFloat(regexMatcher.group(0));
      } catch (Exception e) {
        throw new IllegalArgumentException("Invalid input string. Can't parse a number");
      }
    } else throw new IllegalArgumentException("Invalid input string. The string is in invalid format");
  }

  public boolean testPrintRandomNumbersAndAverage() {
    Student student = createStudent();

    try {
      String output = this.getFunctionPrintStringOutput(student::printRandomNumbersAndAverage);
      String[] outputLines = output.lines().toArray(String[]::new);

      if(outputLines.length != 11)
        return false;

      int[] numbers = new int[10];

      for(int i = 0; i < 10; i++) {
        int num = parseNumberLine(outputLines[i]);

        if(num < 1 || num > 10)
          return false;

        numbers[i] = num;
      }

      int numbersSum = Arrays.stream(numbers).sum();
      float expectedAverage = numbersSum / 10f;
      float actualAverage = parseAverageLine(outputLines[10]);

      return expectedAverage == actualAverage;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean testCheckPrimeNumber() {
    Student student = createStudent();
    HashMap<Integer, Boolean> resultsMap = new HashMap<>();

    resultsMap.put(13, true);
    resultsMap.put(2, false);
    resultsMap.put(27, false);
    resultsMap.put(113, true);

    for(int key: resultsMap.keySet()) {
      if(student.checkPrimeNumber(key) != resultsMap.get(key))
        return false;
    }

    return true;
  }
}
