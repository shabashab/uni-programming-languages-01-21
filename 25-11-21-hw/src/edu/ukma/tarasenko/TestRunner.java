package edu.ukma.tarasenko;

interface TestFunction {
  boolean executeTest();
}

class Test {
  public String functionName;
  public TestFunction function;

  Test(String functionName, TestFunction function) {
    this.function = function;
    this.functionName = functionName;
  }
}

public class TestRunner {
  public boolean executeTests(Test[] tests) {
    boolean result = true;

    for (Test test : tests) {
      System.out.printf("Running test for function \"%s\"... ", test.functionName);

      boolean isPassed = test.function.executeTest();
      System.out.println(isPassed ? "PASSED!" : "FAILED!");

      if (!isPassed)
        result = false;
    }

    return result;
  }

  public static void main(String[] args) {
    TestRunner runner = new TestRunner();
    StudentTestSuite testSuite = new StudentTestSuite();

    Test[] tests = new Test[]{
            new Test("printName10Times", testSuite::testPrintName10Times),
            new Test("printSquaresTable", testSuite::testPrintSquaresTable),
            new Test("sumFirstN", testSuite::testSumFirstN),
            new Test("sumFirstNOdd", testSuite::testSumFirstNOdd),
            new Test("sumFirstDividors", testSuite::testSumFirstDividors),
            new Test("print10PowersOfTwo", testSuite::testPrint10PowersOfTwo),
            new Test("factorial", testSuite::testFactorial),
            new Test("printSquareFunctionValues", testSuite::testPrintSquareFunctionValues),
            new Test("printRandomNumbersAndAverage", testSuite::testPrintRandomNumbersAndAverage),
            new Test("testPrintName10Times", testSuite::testCheckPrimeNumber),
    };

    boolean result = runner.executeTests(tests);
    System.out.println(result ? "All tests passed! Congratulations!" : "One or more tests failed. ;(");
  }
}
