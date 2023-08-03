package com.company;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Board implements TimerListener, KeyListener {
    private List <TimerListener> myDoStepArray;
    private List <Drawable> myDrawableArray;
    private List <BallListener> myBallListeners;
    private Ball myCenterBall;
    private List <KeyListener> myKeyListenerArray;
    private int numOfGoldenBalls;


    private  int w;
    private  int h;

    public Board (int w, int h){

        this.w = w;
        this.h = h;

        myDoStepArray = new ArrayList<>();
        myDrawableArray = new ArrayList<>();
        myKeyListenerArray = new ArrayList<>();
        myBallListeners = new ArrayList<>();

        Random random = new Random();
        int numOfBombs = 5;
        int vel = 3;

        for (int i =0; i < numOfBombs; i ++){
            Point point = new Point(random.nextInt(w-40) + 20,random.nextInt(h-40) + 20 );
            int x = random.nextInt(vel) + 1;
            Velocity velocity = new Velocity(x, vel-x );
            Bomb bomb = new Bomb(point, velocity, 8, w, h, 40);
            myDoStepArray.add(bomb);
            myDrawableArray.add(bomb);
            myBallListeners.add(bomb);
        }
        this.numOfGoldenBalls = 20;
        for (int i =0; i < numOfGoldenBalls; i ++){
            Point point = new Point(random.nextInt(w-40) + 20,random.nextInt(h-40) + 20 );
            int x = random.nextInt(5) + 1;
            Velocity velocity = new Velocity(x, 6-x );
            GoldenBall goldenBall = new GoldenBall(point, velocity, 30, w, h, 40);
            myDoStepArray.add(goldenBall);
            myDrawableArray.add(goldenBall);
            myBallListeners.add(goldenBall);
        }




        Velocity v = new Velocity(4,4);
        int r = 10;
        Point p = new Point(w/2, h - 2*r);
        myCenterBall = new Ball(p,v,r,w,h,0,0,0, 30);

        myDoStepArray.add(myCenterBall);
        myDrawableArray.add(myCenterBall);
        myKeyListenerArray.add(myCenterBall);



    }


    @Override
    public void doStep() {

        int size = myDoStepArray.size();
        for (int i = 0; i < size; i++){
            myDoStepArray.get(i).doStep();
        }

        size = myBallListeners.size();
        int res;
        for (int i =0; i < size; i++){
            res = myBallListeners.get(i).isIntersected(myCenterBall);
            if (res == -1) {
                System.out.println("THE END");
                exit(1);

            } else if (res == 1){
                numOfGoldenBalls--;
                System.out.println("size before remove: " + size);

                myBallListeners.remove(i);
                myDoStepArray.remove(i);
                myDrawableArray.remove(i);
                System.out.println("YOU ARE GOOD!");
                size--;



                if (numOfGoldenBalls == 0){
                    System.out.println("YOU WON!");
                    exit(1);
                }
            }
        }




    }

    public void paintOnGui(Graphics graphics){
        int size = myDoStepArray.size();
        for (int i = 0; i < size; i++){
            myDrawableArray.get(i).drawMe(graphics);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int size = myKeyListenerArray.size();
        for (int i = 0; i < size; i++){
            myKeyListenerArray.get(i).keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
