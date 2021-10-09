package edu.ukma.tarasenko.hw5;

import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;

public class ChessTableProgram extends GraphicsProgram {
  private final int RECT_SIZE = 50;
  private final int TABLE_WIDTH = 8;
  private final int TABLE_HEIGHT = 8;

  private Dimension getWindowSize() {
    int windowWidth = RECT_SIZE * TABLE_WIDTH + 100;
    int windowHeight = RECT_SIZE * TABLE_HEIGHT + 100;
    return new Dimension(windowWidth, windowHeight);
  }

  private Color getRectColor(int x, int y) {
    if(((TABLE_WIDTH * y) + x + y) % 2 == 0)
      return Color.WHITE;
    return Color.BLACK;
  }

  private void renderTable() {
    for(int xIterator = 0; xIterator < TABLE_WIDTH; xIterator++) {
      for(int yIterator = 0; yIterator < TABLE_HEIGHT; yIterator++) {
        int xPosition = xIterator * RECT_SIZE;
        int yPosition = yIterator * RECT_SIZE;

        GRect rect = new GRect(xPosition, yPosition, RECT_SIZE, RECT_SIZE);
        rect.setFilled(true);

        rect.setFillColor(getRectColor(xIterator, yIterator));
        add(rect);
      }
    }
  }

  public void run() {
    //Set window size according to the size of chess table
    setSize(getWindowSize());

    //Render chess table
    renderTable();
  }
}
