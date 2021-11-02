package edu.ukma.tarasenko;

import java.util.Scanner;
import java.util.Stack;

class Needle extends Stack<Integer> {
  public boolean canPush(Integer value) {
    return this.size() == 0 || this.peek() > value;
  }
}

public class HannoiTowers {
  private static String previousOutput = "";

  private static void printNeedles(Needle[] needles) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < needles.length; i++) {
      Needle needle = needles[i];
      builder.append(i + 1).append(": ");
      needle.forEach((value) -> builder.append(value).append(" "));
      builder.append("\n");
    }
    String output = builder.toString();
    if(output.equals(previousOutput))
      return;

    previousOutput = output;
    System.out.println(output);
  }

  private static void tow(Needle[] needles, int neededNeedle, int ringsCount) {
    while(true) {
      if (needles[neededNeedle - 1].size() == ringsCount)
        return;

      tryMoveRing(needles, ringsCount, neededNeedle, ringsCount);
    }
  }

  private static void tryMoveRing(Needle[] needles, int neededCircle, int neededNeedle, int ringsCount) {
    if (needles[0].size() != 0 && needles[0].peek() == ringsCount && needles[neededNeedle - 1].size() == 0) {
      needles[neededNeedle - 1].push(needles[0].pop());
      return;
    }

    for (int i = 0; i < 3; i++) {
      printNeedles(needles);

      if (needles[i].size() == 0 || needles[i].peek() != neededCircle)
        continue;

      int value = needles[i].peek();
      int indexOffset = value % 2 == 0 ? 2 : 1;
      int targetIndex = (indexOffset + i) % 3;

      if(needles[targetIndex].canPush(needles[i].peek())) {
        needles[targetIndex].push(needles[i].pop());
      }
      else continue;

      return;
    }

    tryMoveRing(needles, neededCircle - 1, neededNeedle, ringsCount);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the count of disks: ");
    int count = scanner.nextInt();

    System.out.print("Enter the needed needle number (2 or 3): ");
    int neededNeedle = scanner.nextInt();

    Needle[] needles = new Needle[3];
    needles[0] = new Needle();
    needles[1] = new Needle();
    needles[2] = new Needle();

    for (int i = 0; i < count; i++) {
      needles[0].push(count - i);
    }

    tow(needles, neededNeedle, count);
    printNeedles(needles);
  }
}
