package app.shapes.triangles;

import app.CommonFunctions;
import java.util.Scanner;
import java.lang.Math;
import java.util.concurrent.TimeUnit;

//  ======================================================
public class EquilateralTriangle extends CommonFunctions {

//  ==============================================
    enum Choices {
        SETSIDES, PERIMETER, AREA, DISPLAY, GOBACK
    };
//  ==============================================

//  =================
    private int legA;
    private int legB;
    private int legC;
    private Choices choices;
    private Scanner keyboard;
//  =================

//  ==============================
    public EquilateralTriangle(Scanner keyboard) {

        this.keyboard = keyboard;
        legA = legB = legC = 0;

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
        int x;

        switch(choices) {
            case SETSIDES:
                    System.out.print("\nPlease enter the value for all 3 sides (all sides are the same): ");
                    InvalidInputInt(keyboard);
                    x = keyboard.nextInt();
                    legA = legB = legC = x;
                break;
            case PERIMETER:
                    if (legA != 0) {
                        System.out.println("Side 1 = Side 2 = Side 3 = " + legA + "\n" +
                                         legA + " + " + legB + " + " + legC + " = " + (legA + legB + legC) + " units");
                    }// then
                    else 
                        System.out.println("Error: No sides are set yet!");
                break;
            case AREA:
                    if (legA != 0 ) {
                        System.out.println("Side 1 = Side 2 = Side 3 = " + legA + "\n" + 
                        "\u221A3/4 * side^2 = \u221A3/4 * " + legA + "^2 = "  + (Math.sqrt(3)/4 * (legA * legA)) + " units^2");
                        TimeUnit.SECONDS.sleep(2);
                    } // then
                    else
                        System.out.println("Error: No sides are set yet!");
                break;
            case DISPLAY:
                    if (legA != 0) { // this display was hand coded. if the triangles 
                        String string = "  /  \\  ";
                        if (legA >= 10 ) 
                            string = string.substring(1, string.length()); // if the value is over 10 it will allow the display not to be messed up.
                        System.out.println("    /\\    \n" +
                                     legA + string + legB +"  \n" +
                                           "  /    \\  \n" + 
                                           " --------  \n" +
                                           "    " + legC); 
                    }// then
                    else
                        System.out.println("Error: No sides are set yet!");
                break;
            case GOBACK:
                    System.out.println("\nLeaveing Equilateral Triangle");
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
