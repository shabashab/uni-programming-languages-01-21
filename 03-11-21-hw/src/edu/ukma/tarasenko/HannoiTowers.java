package edu.ukma.tarasenko;

import java.util.Scanner;
import java.util.Stack;

class Needle extends Stack<Integer> {
  public boolean canPush(Integer value) {
    return this.isEmpty() || this.peek() > value;
  }
}

public class HannoiTowers {
  public static void printNeedles(Needle[] needles) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < needles.length; i++) {
      Needle needle = needles[i];
      builder.append(i + 1).append(": ");
      needle.forEach((value) -> builder.append(value).append(" "));
      builder.append("\n");
    }

    String output = builder.toString();
    System.out.println(output);
  }

  private static void tow(Needle[] needles, int toNeedle, int ringsCount) {
    while(true) {
      if (needles[toNeedle].size() == ringsCount)
        return;

      tryMoveRing(needles, ringsCount, toNeedle, ringsCount);
      printNeedles(needles);
    }
  }

  private static void tryMoveRing(Needle[] needles, int neededRing, int neededNeedle, int ringsCount) {
    if (!needles[0].isEmpty() && needles[0].peek() == ringsCount && needles[neededNeedle].size() == 0) {
      needles[neededNeedle].push(needles[0].pop());
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (needles[i].isEmpty() || needles[i].peek() != neededRing)
        continue;

      int value = needles[i].peek();
      int indexOffset = value % 2 == 0 ? 2 : 1;
      int targetIndex = (indexOffset + i) % 3;

      if(needles[targetIndex].canPush(needles[i].peek()))
        needles[targetIndex].push(needles[i].pop());
      else continue;

      return;
    }

    tryMoveRing(needles, neededRing - 1, neededNeedle, ringsCount);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the count of disks: ");
    int count = scanner.nextInt();

    System.out.print("Enter the needed needle number (2 or 3): ");
    int neededNeedle = scanner.nextInt();

    if(neededNeedle > 3 || neededNeedle < 2) {
      System.out.println("Invalid input!");
      return;
    }

    Needle[] needles = new Needle[] {
      new Needle(),
      new Needle(),
      new Needle()
    };

    for (int i = 0; i < count; i++) {
      needles[0].push(count - i);
    }

    printNeedles(needles);
    tow(needles, neededNeedle - 1, count);
    printNeedles(needles);
  }
}
