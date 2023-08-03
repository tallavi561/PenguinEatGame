package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Bomb implements TimerListener, Drawable , BallListener{
    //    private int x;
//    private int y;
    private Point point;
    private int time;
    private int r;
    private int wOfBoard;
    private int hOfBoard;
    private int timeToGrow;


    private Color c;
    private Velocity myVelocity;

    public Bomb(int x, int y, int r, Velocity myVelocity) {
//        this.x = x;
//        this.y = y;
        this.r = r;
        this.myVelocity = myVelocity;
    }



    public Bomb(Point p, Velocity v, int r, int wOfBoard, int hOfBoard, int timeToGrow) {
        this.hOfBoard = hOfBoard;
        this.wOfBoard = wOfBoard;
        this.timeToGrow = timeToGrow;
        Random random = new Random();

        // Generate a random integer between 0 (inclusive) and 100 (exclusive)
//        int red = random.nextInt(255);
//        int green = random.nextInt(255);
//        int blue = random.nextInt(255);
        int red = 240;
        int green = 5;
        int blue = 10;


        this.c = new Color(red, green, blue);

        this.point = new Point(p.getX(), p.getY());
        this.myVelocity = new Velocity(v.getX(), v.getY());
        this.r = r;
    }


    public int getX() {
        return this.point.getX();
    }


    public void setX(int x) {
        this.point.setX(x);
    }

    public int getY() {
        return this.point.getY();
    }

    public void setY(int y) {
        this.point.setX(y);

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
        if (time < timeToGrow/2){
            setC(new Color(200, 100, 5));
        } else {
            setC(new Color(250, 10, 5));
        }
        if (this.point.getX() + myVelocity.getX() + r > wOfBoard || this.point.getX() + myVelocity.getX() < 0) {
            this.myVelocity.setX(this.myVelocity.getX() * -1);
        }
        if (this.point.getY() + myVelocity.getY() + r > hOfBoard || this.point.getY() + myVelocity.getY() < 0) {
            this.myVelocity.setY(this.myVelocity.getY() * -1);
        }
        this.point.setX(this.point.getX() + myVelocity.getX());
        this.point.setY(this.point.getY() + myVelocity.getY());
        this.time++;
        if (time == timeToGrow) {
            this.r++;
            this.time = 0;
        }
    }

    @Override
    public void drawMe(Graphics graphics) {
        int x = this.getX()- r;
        int y = this.getY() - r;
        graphics.setColor(this.getC());
        graphics.fillOval(x,y , this.getR() * 2, this.getR() * 2);
    }

    @Override
    public int isIntersected(Ball ball) {
        double sumOfR = this.getR() + ball.getR() ;
//        sumOfR = sumOfR /1.5 ;
        double dx = Math.pow((ball.getX()  - this.getX()),2);
        double dy = Math.pow((ball.getY()  - this.getY()),2);

        if (Math.sqrt(dx +dy) < sumOfR){
            System.out.println("sumOfR is: " + sumOfR + " the real: " + Math.sqrt(dx +dy));
            System.out.println("the bomb x: " + this.getX() + " y: " + this.getY() + " my r is: " + this.getR());
            System.out.println("the ball x: " + ball.getX() + " y: " + ball.getY() + " its r is: " + ball.getR());
            return -1;
        }
        return 0;
    }
}