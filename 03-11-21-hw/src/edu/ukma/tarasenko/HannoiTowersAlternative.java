package edu.ukma.tarasenko;

import java.util.Scanner;

public class HannoiTowersAlternative {
  private static long actionsCount = 0;

  private static void moveRings(Needle[] needles, int to, int count) {
    if(count == 0)
      return;

    if(count != 1)
      moveRings(needles, to, count - 1);

    while(needles[to].size() != count) {
      tryMoveRing(needles, count, to, count);
      HannoiTowers.printNeedles(needles);
      actionsCount++;
    }
  }

  private static void tryMoveRing(Needle[] needles, int neededCircle, int toNeedle, int ringsCount) {
    if (needles[0].size() != 0 && needles[0].peek() == ringsCount && needles[toNeedle].size() == 0) {
      needles[toNeedle].push(needles[0].pop());
      return;
    }

    for (int i = 0; i < 3; i++) {
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

    tryMoveRing(needles, neededCircle - 1, toNeedle, ringsCount);
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

    HannoiTowers.printNeedles(needles);
    moveRings(needles, neededNeedle - 1, count);
    HannoiTowers.printNeedles(needles);
    System.out.println(actionsCount);
  }
}
