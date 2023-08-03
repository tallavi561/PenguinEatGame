package com.company;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        int w = 1000;
        int h = 800;

        double hananBenAri = 4.2;
        double omerAdam = 3.5;
        double imTheResult = hananBenAri / omerAdam;


        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);

        Board myBoard = new Board(w, h);

        frame.add(new GuiClass(myBoard));

        frame.setVisible(true);

    }

}
//    String a = "I ";
//    int len = a.length(); // len = 2
//    String b = "like ";
//    char mtChar = b.charAt(0); // נקבל את התו L
//
//    String c = "chocolate!";
//    String i_like_chocolate = a + b + c;