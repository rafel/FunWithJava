/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Ritare
 */

package view;


import java.awt.event.MouseAdapter;         //Mushändelser(click press etc)
import java.awt.event.MouseEvent;           //Mushändelser(click press +  postion cursor)
import java.awt.event.MouseMotionListener;  //Musrörelse

import javax.swing.*;
import java.awt.*;


public class Gui extends JPanel implements MouseMotionListener {
    private static final int SquareWidth = 10;      //Storleken på boxen
    private static final int Max = 10;      //Max antal boxar
    private Rectangle[] squares = new Rectangle[Max];
    private int squareCount = 0;        //räknare
    private int currentSquareIndex = -1;

      public Gui() {
        addMouseListener(new MouseAdapter() {
            //Musen intryckt
            public void mousePressed(MouseEvent evt) {
            int x = evt.getX();
            int y = evt.getY();
            currentSquareIndex = getSquare(x, y);
            if (currentSquareIndex < 0) // Inte tryck på boxen
                add(x, y);
            }
            
            //Mus click
            public void mouseClicked(MouseEvent evt) {
                int x = evt.getX();
                int y = evt.getY();

                if (evt.getClickCount() >= 2) {     //Dubbelklick raderar boxen
                    remove(currentSquareIndex);
                }
            }
    });
    addMouseMotionListener(this);
  }

    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < squareCount; i++)
      ((Graphics2D)g).draw(squares[i]);
  }
  //Nu varande index
  public int getSquare(int x, int y) {
    for (int i = 0; i < squareCount; i++)
      if(squares[i].contains(x,y))
        return i;
    return -1;
  }

  //Lägger till en box
  public void add(int x, int y) {
    if (squareCount < Max) {
      squares[squareCount] = new Rectangle(x, y,SquareWidth,SquareWidth);
      currentSquareIndex = squareCount;
      squareCount++;
      repaint();
    }
  }

  //Raderar en box
  public void remove(int n) {
    if (n < 0 || n >= squareCount)
      return;
    squareCount--;
    squares[n] = squares[squareCount];
    if (currentSquareIndex == n)
      currentSquareIndex = -1;
    repaint();
  }

    //Musdragning flytta boxen
    public void mouseDragged(MouseEvent evt) {
    int x = evt.getX();
    int y = evt.getY();

    if (currentSquareIndex >= 0) {
      Graphics g = getGraphics();
      g.setXORMode(getBackground());
      ((Graphics2D)g).draw(squares[currentSquareIndex]);
      squares[currentSquareIndex].x = x;
      squares[currentSquareIndex].y = y;
      ((Graphics2D)g).draw(squares[currentSquareIndex]);
      g.dispose();
    }
  }

    //Om musen är över boxen så bytes pekaren till crosshair.
    public void mouseMoved(MouseEvent evt) {
        int x = evt.getX();
        int y = evt.getY();

        if (getSquare(x, y) >= 0)
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        else
            setCursor(Cursor.getDefaultCursor());
    }
 }
