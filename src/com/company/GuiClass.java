package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class GuiClass extends JComponent implements ActionListener, KeyListener {
    private Board myBoard;
    private Image backgroundImage; // Added for background
    private int time;


    public GuiClass(Board myBoard) {
        Timer timer = new Timer(10, this); // Set the timer for animation
        timer.start();
        time = 0;
        this.myBoard = myBoard;


        setFocusable(true); // Allow the component to receive key events
        addKeyListener(this); // Add the key listener to the component
        String imagePath = "C:/bg3.png";
//        String imagePath = "bg3.png";

        this.backgroundImage = new ImageIcon(imagePath).getImage();
        int t = backgroundImage.getHeight(this);


//        System.out.println("Image width: " + backgroundImage.getIconWidth());
//        System.out.println("Image height: " + backgroundImage.getIconHeight());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        this.myBoard.paintOnGui(g);
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(Color.BLUE);
//        g.fillOval(x, y, ballDiameter, ballDiameter);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (myBoard == null){
            int t = time;
        }
        this.myBoard.doStep();
        time++;


        // Repaint the component to update the ball's position
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.myBoard.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}