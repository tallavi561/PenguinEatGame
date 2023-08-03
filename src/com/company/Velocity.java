package com.company;

public class Velocity {
    private int x;
    public Velocity(){
        this.x = 1;
        this.y = 1;
    }
    public Velocity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

}
