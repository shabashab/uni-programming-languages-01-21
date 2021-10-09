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

  private GRect createRect(int x, int y) {
    int xPosition = x * RECT_SIZE;
    int yPosition = y * RECT_SIZE;

    GRect rect = new GRect(xPosition, yPosition, RECT_SIZE, RECT_SIZE);
    rect.setFillColor(getRectColor(x, y));
    rect.setFilled(true);

    return rect;
  }

  private void renderTable() {
    for(int x = 0; x < TABLE_WIDTH; x++) {
      for(int y = 0; y < TABLE_HEIGHT; y++) {
        GRect newRect = createRect(x, y);
        add(newRect);
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
