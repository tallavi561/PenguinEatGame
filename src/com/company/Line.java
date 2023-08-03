package com.company;

public class Line {


    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
//
//    public boolean isIntersect(Ball other) {
//        int a;
//        int c;
//        int b;
//        int x1 = other.getX();
//        int y1 = other.getY();
//        int x2 = other.getX() + other.getMyVelocity().getX();
//        int y2 = other.getY() + other.getMyVelocity().getY();
//        if (this.p1.getX() == this.p2.getX()) {
//            a = 0;
//            b = 0;
//            c = this.p1.getY();
//            if () {
//
//            }
//        } else {
//
//        }
//
//        return false;
//    }

//    public Point isIntersect(Line other) {
//        int x;
//        int y;
//        long myM;
//        long otherM;
//        if (this.p1.getX() == this.p2.getX()) {
//            if (other.getP1().getX() == other.getP2().getX()) {
//
//                if (other.getP1().getX() != this.p1.getX()) {
//                    //
//                    return null;
//                } else {
//                    x = this.p1.getX();
//                    if ((this.p1.getY() >= other.getP1().getY() && this.p1.getY() <= other.getP2().getY())
//                            || (this.p1.getY() <= other.getP1().getY() && this.p1.getY() >= other.getP2().getY())
//                    ) {
//                        return this.p1;
//                    }
//
//                    if ((this.p2.getY() >= other.getP1().getY() && this.p2.getY() <= other.getP2().getY())
//                            || (this.p2.getY() <= other.getP1().getY() && this.p2.getY() >= other.getP2().getY())
//                    ) {
//                        return this.p2;
//                    }
//                    return null;
//                }
//
//            } else {
//                 // my p1.x == p2.x but the other not
//                otherM = (other.p1.getY() - other.p2.getY())/(other.p1.getX() - other.p2.getX());
//
//
//            }
//
//        } else {
//
//        }
//        return null;
//    }

}
