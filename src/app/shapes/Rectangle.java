package app.shapes;

import app.CommonFunctions;
import java.util.Scanner;

public class Rectangle extends CommonFunctions {

    //  ==============================================
    enum Choices {
        SETSIDES, DISPLAY, AREA, PERIMETER, GOBACK
    };
//  ==============================================

//  =========================
    private Choices choices;
    private Scanner keyboard;
    private int length;
    private int width;
//  ========================

//  ====================================
    public Rectangle(Scanner keyboard) {

        this.keyboard = keyboard;
        length = width = 0;

    }// Constructor
//  ===============

//  ========================================
    private int Area(int length, int width) {

        return length * width;

    }// Function Area
//  =================

//  ==============================================
    private int Perimeter(int length, int width) {

        return ((2 * length) + (2*width));

    }// Function Perimeter
//  ======================

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
                if (length == 0 && width == 0) {
                    System.out.print("\nPlease enter the value for width: ");
                    InvalidInputInt(keyboard);
                    width = keyboard.nextInt();
                    System.out.print("\nPlease enter the value for length: ");
                    InvalidInputDouble(keyboard);
                    length = keyboard.nextInt();
                }
                else {
                    char choice = 0;

                    System.out.print("Which side would you like to change?(w/l) ");
                    choice = keyboard.next().charAt(0);
                    if (choice == 'w') {
                        System.out.print("\nPlease enter the value for width: ");
                        InvalidInputInt(keyboard);
                        width = keyboard.nextInt();
                    }
                    else if (choice == 'l') {
                        System.out.print("\nPlease enter the value for length: ");
                        InvalidInputInt(keyboard);
                        length = keyboard.nextInt();
                    }
                    else 
                        System.out.println("Error: Incorrect input");
                }
            
            break;
        case PERIMETER:
               if (length != 0 && width != 0) {
                   System.out.println("\nPerimeter = (2 * l) + (2 * w)");
                   System.out.println("\n= (2 * " + length + ") + (2 * " + width + ") = " + Perimeter(length, width));
               } 
               else 
                    System.out.println("\nError: Can not get the perimeter when there is no shape!");
            break;
        case AREA:
            if (length != 0 && width != 0) {
                System.out.println("\nArea = l * w");
                System.out.println("\n= " + length + " * " + width + " = " + Area(length, width));
            } 
            else 
                System.out.println("\nError: Can not get the Area when there is no shape!");
            break;
        case DISPLAY:
            if (length != 0 && width != 0) {
                System.out.print(
                    "-----------------------\n" +
                    "|                     |\n" +
                    "|                     |\n" + 
                    "|                     |" + width + "\n" +
                    "|                     |" +
                    "-----------------------" +
                    "         " + length
                );
            } 
            else 
                System.out.println("\nError: Can not display a shape when there is no shape!");
                
            break;
        case GOBACK:
                System.out.println("\nLeaveing Scalene Triangle");
            break;
    }

    }// ProcessCommand Function
//      ===========================

//  =========================
    public boolean Goback() {

        if (choices != Choices.GOBACK) 
            return true;
        else
            return false;

    }// Goback Function
//  ===================


}
