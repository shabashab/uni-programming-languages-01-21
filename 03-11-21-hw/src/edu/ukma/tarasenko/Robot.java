package edu.ukma.tarasenko;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Robot extends GraphicsProgram {
  final int HEAD_WIDTH = 300;
  final int HEAD_HEIGHT = 400;
  final int EYE_RADIUS = 30;
  final int MOUTH_WIDTH = 200;
  final int MOUTH_HEIGHT = 30;

  private void initializeWindowSize() {
    int windowWidth = (int)(HEAD_WIDTH * 1.3);
    int windowHeight = (int)(HEAD_HEIGHT * 1.3);

    setSize(windowWidth, windowHeight);
  }

  private GRect createHeadRect() {
    Dimension windowSize = getSize();

    int xPosition = (windowSize.width / 2) - (HEAD_WIDTH / 2);
    int yPosition = (windowSize.height / 2) - (HEAD_HEIGHT / 2);

    GRect headRect = new GRect(xPosition, yPosition, HEAD_WIDTH, HEAD_HEIGHT);

    headRect.setFilled(true);
    headRect.setFillColor(Color.GRAY);

    return headRect;
  }

  private GRect createMouthRect(GRect head) {
    int headX = (int)head.getX();
    int headY = (int)head.getY();

    int headWidth = (int)head.getWidth();
    int headHeight = (int)head.getHeight();

    int mouthX = (headWidth / 2) - (MOUTH_WIDTH / 2) + headX;
    int mouthY = ((headHeight / 3) * 2) + headY;

    GRect mouth = new GRect(mouthX, mouthY, MOUTH_WIDTH, MOUTH_HEIGHT);

    mouth.setFilled(true);
    mouth.setFillColor(Color.white);

    return mouth;
  }

  private GOval createLeftEye(GRect head) {
    int eyeXPosition = (int)((head.getWidth() / 7) * 2 + head.getX() - EYE_RADIUS);
    int eyeYPosition = (int)((head.getHeight() / 4) + head.getY());

    int eyeDiameter = EYE_RADIUS * 2;

    GOval leftEye = new GOval(eyeXPosition, eyeYPosition, eyeDiameter, eyeDiameter);

    leftEye.setFilled(true);
    leftEye.setFillColor(Color.YELLOW);

    return leftEye;
  }

  private GOval createRightEye(GRect head) {
    int eyeXPosition = (int)((head.getWidth() / 7) * 5 + head.getX() - EYE_RADIUS);
    int eyeYPosition = (int)((head.getHeight() / 4) + head.getY());

    int eyeDiameter = EYE_RADIUS * 2;

    GOval leftEye = new GOval(eyeXPosition, eyeYPosition, eyeDiameter, eyeDiameter);

    leftEye.setFilled(true);
    leftEye.setFillColor(Color.YELLOW);

    return leftEye;
  }

  @Override
  public void run() {
    initializeWindowSize();

    GRect head = createHeadRect();
    add(head);

    GRect mouth = createMouthRect(head);
    add(mouth);

    GOval rightEye = createRightEye(head);
    GOval leftEye = createLeftEye(head);

    add(leftEye);
    add(rightEye);
  }
}
