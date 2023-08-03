package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball implements TimerListener, Drawable, KeyListener {
    //    private int x;
//    private int y;
    private Point point;
    private int time;
    private int r;
    private int wOfBoard;
    private int hOfBoard;
    private int timeToGrow;

    private int[] xTriArray;
    private int[] yTriArray;
    private int [] xOfEyes;
    private int [] yOfEyes;

    private int [] xOfInnerEyes;
    private int [] yOfInnerEyes;

    private int radiusOfEyes;
    private int radiusOfInnerEyes;





    private Color c;
    private Velocity myVelocity;

    public Ball(int x, int y, int r, Velocity myVelocity) {
//        this.x = x;
//        this.y = y;
        this.r = r;
        this.myVelocity = myVelocity;

    }

    public Ball(Ball b) {
        this.c = new Color(0, 0, 0);

        this.r = b.r;
        this.myVelocity = new Velocity(b.myVelocity.getX(), b.myVelocity.getY());
    }


    public Ball(Point p, Velocity v, int r, int wOfBoard, int hOfBoard, int red, int green, int blue, int timeToGrow) {
        this.hOfBoard = hOfBoard;
        this.wOfBoard = wOfBoard;
        this.timeToGrow = timeToGrow;

//        Random random = new Random();
//
//        // Generate a random integer between 0 (inclusive) and 100 (exclusive)
//        int red = random.nextInt(255);
//        int green = random.nextInt(255);
//        int blue = random.nextInt(255);


        this.c = new Color(red, green, blue);

        this.point = new Point(p.getX(), p.getY());
        this.myVelocity = new Velocity(v.getX(), v.getY());
        this.r = r;

        this.xTriArray = new int[3];
        this.yTriArray = new int[3];
        this.xOfEyes = new int[2];
        this.yOfEyes = new int[2];

        this.xOfInnerEyes = new int[2];
        this.yOfInnerEyes = new int[2];

        this.radiusOfEyes = r /3 ;
        radiusOfInnerEyes = radiusOfEyes /3;

        updateTriangularAndEyes();
    }


    public int getX() {
        return this.point.getX();
    }

    public void setX(int x) {

    }

    public void setXY(int x, int y) {
        this.point.setX(x);
        this.point.setY(y);

    }

    public void updateTriangularAndEyes() {

        double s_2 = Math.sqrt(2);
        this.radiusOfEyes = r/4;
        radiusOfInnerEyes = radiusOfEyes /3 +2;

        int len_of_tr = (int) (r * 1.5);
        if (this.myVelocity.getX() * this.myVelocity.getY() > 0) {
            xTriArray[0] = this.point.getX() + (int) (this.r / s_2);
            xTriArray[1] = this.point.getX() - (int) (this.r / s_2);
            yTriArray[0] = this.point.getY() - (int) (this.r / s_2);
            yTriArray[1] = this.point.getY() + (int) (this.r / s_2);

            if (this.myVelocity.getX() > 0) {
                xTriArray[2] = (xTriArray[0] + xTriArray[1]) / 2 + len_of_tr;
                yTriArray[2] = (yTriArray[0] + yTriArray[1]) / 2 + len_of_tr;

                for (int i = 0; i < 2 ; i++){
                    this.xOfEyes[i] = (xTriArray[i]  + 2 *this.point.getX()) /3 + radiusOfEyes;
                    this.yOfEyes[i] = (yTriArray[i]  + 2* this.point.getY()) /3 + radiusOfEyes;

                    this.xOfInnerEyes[i] = xOfEyes[i] + radiusOfInnerEyes;
                    this.yOfInnerEyes[i] = yOfEyes[i]+ radiusOfInnerEyes;
                }

            } else {
                xTriArray[2] = (xTriArray[0] + xTriArray[1]) / 2 - len_of_tr;
                yTriArray[2] = (yTriArray[0] + yTriArray[1]) / 2 - len_of_tr;

                for (int i = 0; i < 2 ; i++){
                    this.xOfEyes[i] = (xTriArray[i]  + 2 *this.point.getX()) /3 - radiusOfEyes;
                    this.yOfEyes[i] = (yTriArray[i]  + 2* this.point.getY()) /3 - radiusOfEyes;

                    this.xOfInnerEyes[i] = xOfEyes[i]  - radiusOfInnerEyes;
                    this.yOfInnerEyes[i] = yOfEyes[i]  - radiusOfInnerEyes;
                }

            }
        } else {
            xTriArray[0] = this.point.getX() - (int) (this.r / s_2);
            xTriArray[1] = this.point.getX() + (int) (this.r / s_2);
            yTriArray[0] = this.point.getY() - (int) (this.r / s_2);
            yTriArray[1] = this.point.getY() + (int) (this.r / s_2);

            if (this.myVelocity.getX() > 0) {
                xTriArray[2] = (xTriArray[0] + xTriArray[1]) / 2 + len_of_tr;
                yTriArray[2] = (yTriArray[0] + yTriArray[1]) / 2 - len_of_tr;

                for (int i = 0; i < 2 ; i++){
                    this.xOfEyes[i] = (xTriArray[i]  + 2 *this.point.getX()) /3 + radiusOfEyes;
                    this.yOfEyes[i] = (yTriArray[i]  + 2* this.point.getY()) /3 - radiusOfEyes;

                    this.xOfInnerEyes[i] = xOfEyes[i] + radiusOfInnerEyes;
                    this.yOfInnerEyes[i] = yOfEyes[i] - radiusOfInnerEyes;
                }

            } else {
                xTriArray[2] = (xTriArray[0] + xTriArray[1]) / 2 - len_of_tr;
                yTriArray[2] = (yTriArray[0] + yTriArray[1]) / 2 + len_of_tr;

                for (int i = 0; i < 2 ; i++){
                    this.xOfEyes[i] = (xTriArray[i]  + 2 *this.point.getX()) /3 - radiusOfEyes;
                    this.yOfEyes[i] = (yTriArray[i]  + 2* this.point.getY()) /3 + radiusOfEyes;

                    this.xOfInnerEyes[i] = xOfEyes[i] - radiusOfInnerEyes;
                    this.yOfInnerEyes[i] = yOfEyes[i] + radiusOfInnerEyes;
                }
            }
        }





    }

    public int getY() {
        return this.point.getY();
    }

    public void setY(int y) {
        this.point.setY(y);

    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Velocity getMyVelocity() {
        return myVelocity;
    }

    public void setMyVelocity(Velocity myVelocity) {
        this.myVelocity = myVelocity;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    @Override
    public void doStep() {

        if (this.point.getX() + myVelocity.getX() + this.r > wOfBoard || this.point.getX() + myVelocity.getX() < 0) {
            this.myVelocity.setX(this.myVelocity.getX() * -1);
        }
        if (this.point.getY() + myVelocity.getY() + this.r > hOfBoard || this.point.getY() + myVelocity.getY() < 0) {
            this.myVelocity.setY(this.myVelocity.getY() * -1);
        }

        setXY(this.point.getX() + myVelocity.getX(), this.point.getY() + myVelocity.getY());
        this.time++;
        if (time == timeToGrow) {
            this.r++;
            this.time = 0;
        }
        updateTriangularAndEyes();

    }

    @Override
    public void drawMe(Graphics graphics) {
        graphics.setColor(new Color(255, 165, 0)); // Set the color
        graphics.fillPolygon(xTriArray, yTriArray, 3); // Fill the polygon

        int x;
        int y;


        x = this.getX() - r;
        y = this.getY() - r;
        graphics.setColor(this.getC());
        graphics.fillOval(x, y, this.getR() * 2, this.getR() * 2);
        graphics.setColor(Color.white);

        for (int i = 0; i < 2; i++){
            x = this.xOfEyes[i] - radiusOfEyes;
            y = this.yOfEyes[i] - radiusOfEyes;
            graphics.fillOval(x, y, radiusOfEyes * 2, radiusOfEyes * 2);
        }

        graphics.setColor(new Color(50, 50, 200, 100));
        for (int i = 0; i < 2; i++){
            x = this.xOfInnerEyes[i] - radiusOfInnerEyes;
            y = this.yOfInnerEyes[i] - radiusOfInnerEyes;
            graphics.fillOval(x, y, radiusOfInnerEyes * 2, radiusOfInnerEyes * 2);
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            this.myVelocity.setX(-1 * Math.abs(this.myVelocity.getX()));
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            this.myVelocity.setX(Math.abs(this.myVelocity.getX()));
        } else if (keyCode == KeyEvent.VK_UP) {
            this.myVelocity.setY(-1 * Math.abs(this.myVelocity.getY()));
        } else if (keyCode == KeyEvent.VK_DOWN) {
            this.myVelocity.setY(Math.abs(this.myVelocity.getY()));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
