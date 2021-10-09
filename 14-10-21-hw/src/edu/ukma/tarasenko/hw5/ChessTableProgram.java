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

  private void renderTable() {
    for(int xIterator = 0; xIterator < TABLE_WIDTH; xIterator++) {
      for(int yIterator = 0; yIterator < TABLE_HEIGHT; yIterator++) {
        int xPosition = xIterator * RECT_SIZE;
        int yPosition = yIterator * RECT_SIZE;

        GRect rect = new GRect(xPosition, yPosition, RECT_SIZE, RECT_SIZE);
        Color rectColor;

        rect.setFilled(true);

        if(((TABLE_WIDTH * yIterator) + xIterator + yIterator) % 2 == 0)
          rectColor = Color.WHITE;
        else
          rectColor = Color.BLACK;

        rect.setFillColor(rectColor);
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
