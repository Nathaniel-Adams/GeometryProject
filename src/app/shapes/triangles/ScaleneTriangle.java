//=============================================================================
// ScaleneTriangle.java
//
// Implemention of the ScaleneTriangle class
// Geometry Project.
//
//          Original Author: Levi Kruse
//                    Class: CS275
// Date of First Submission: 02/20/2020
//                  Project: GeometryProject (Winter 2020 Team Project)
//
//=============================================================================
package app.shapes.triangles;

import app.CommonFunctions;
import java.util.Scanner;
import java.lang.Math;
import java.util.concurrent.TimeUnit;
import app.shapes.Graph;

//  ======================================================
public class ScaleneTriangle extends CommonFunctions {

//  ==============================================
    enum Choices {
        SETSIDES, PERIMETER, AREA, DISPLAY, GOBACK
    };
//  ==============================================

//  =================
    private double legA;
    private double legB;
    private double legC;
    private double base;
    private Choices choices;
    private Scanner keyboard;
//  =================

//  ==============================
    public ScaleneTriangle(Scanner keyboard) {

        this.keyboard = keyboard;
        legA = legB = legC = base = 0;

    }// EquilateralTriangle Function
//  ================================

//  =========================
    public void QueryUser() {

        int awnser = 0;

        awnser = InputInt(keyboard, 1, 5);

        switch(awnser){
            case 1: choices = Choices.SETSIDES;
                break;
            case 2: choices = Choices.PERIMETER;
                break;
            case 3: choices = Choices.AREA;
                break;
            case 4: choices = Choices.DISPLAY;
                break;
            case 5: choices = Choices.GOBACK;
                break;
        }// switch

        System.out.print("\u001b[0m"); // this will change the color back to normal.

    }// QueryUser Function
//  ======================

//  ==========================================================
    public void ProcessCommand() throws InterruptedException {
       

        switch(choices) {
            case SETSIDES:
                    System.out.print("\nPlease enter the value for side A: ");
                    InvalidInputInt(keyboard);
                    legA = keyboard.nextInt();
                    System.out.print("\nPlease enter the value for side B: ");
                    InvalidInputInt(keyboard);
                    legB = keyboard.nextInt();
                    System.out.print("\nPlease enter the value for side C: ");
                    InvalidInputInt(keyboard);
                    legC = keyboard.nextInt();
                    
                break;
            case PERIMETER:
                    if (legA != 0 && legB != 0 && legC != 0) {
                        double Perimeter = legA + legB + legC;
                        System.out.println("Side 1 + Side 2 + Side 3 = " + Perimeter + "\n" +
                                         legA + " + " + legB + " + " + legC + " = " + Perimeter + " units");
                    }// then
                    else 
                        System.out.println("Error: Side length can not equal zero!");
                break;
            case AREA:
                    if (legB != 0 && legA != 0 ) {

                        double s;
                        s = ((legA + legB + legC) / 2);
                        double area;
                        area = Math.sqrt(s * ( s - legA) * (s - legB) * (s - legC));

                        System.out.println(" Area = height * b / 2 = " + area + "\n");
                       // "\u221A3/4 * side^2 = \u221A3/4 * " + legA + "^2 = "  + (Math.sqrt(3)/4 * (legA * legA)) + " units^2");
                        TimeUnit.SECONDS.sleep(2);
                    } // then
                    else
                        System.out.println("Error: No sides are set yet!");
                break;
            case DISPLAY:
                    if (legA != 0) { // this display was hand coded. if the triangles 
                      Graph.PlotTriangleFromLineLengths(legA, legB, legC);
                    }// then
                    else
                        System.out.println("Error: No sides are set yet!");
                break;
            case GOBACK:
                    System.out.println("\nLeaveing Scalene Triangle");
                break;
        }

    }// ProcessCommand Function
//  ===========================

//  =========================
    public boolean goback() {
        if (choices != Choices.GOBACK)
            return true;
        else
            return false;
    }// goback function
//  ===================

}// EquilateralTriangle Class
//  =========================
