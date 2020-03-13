
package app.shapes;

//  ==========================
import app.shapes.triangles.*;
import app.CommonFunctions;
import java.util.Scanner;
//  ==========================

//  ===========================================
public class Triangle extends CommonFunctions {

//  ==================================================
    enum Choices {
        EQUILATERAL, RIGHT, ISOSCELES, SCALENE, GOBACK
    };
//  ==================================================

//  ===================================================================================    
    private Choices choices;
    private Scanner keyboard;
    private EquilateralTriangle equilateraltriangle;
    private ScaleneTriangle     scalenetriangle;
    private IsoscelesTriangle   isoscelestriangle;
    private RightTriangle       righttriangle;
//  ====================================================================================

//  ===================================
    public Triangle(Scanner keyboard) {

        this.keyboard = keyboard;
        equilateraltriangle = new EquilateralTriangle(keyboard);
        equilateraltriangle = new EquilateralTriangle(keyboard);
        scalenetriangle     = new ScaleneTriangle(keyboard);
        isoscelestriangle   = new IsoscelesTriangle(keyboard);
        righttriangle       = new RightTriangle(keyboard);

    }// Constructor
//  ===============

//  ====================
    public void Menu() {

        System.out.print("\u001b[31m===========================================\u001b[0m\n" +
                         "\u001b[34m1.\u001b[0m Equilateral Triangle \u001b[34m2.\u001b[0m Right Triangle  \n" +
                         "\u001b[34m3.\u001b[0m Isosceles Triangle   \u001b[34m4.\u001b[0m Scalene Triangle\n" +
                         "\u001b[34m5.\u001b[0m Go back                                 \n" +
                         "\u001b[31m===========================================\u001b[0m\n" );

    }// Menu Function
//  =================

//  ==========================================
    public void QueryUser() throws Exception {

        int answer = 0;

        answer = InputInt(keyboard, 1, 5);

        switch(answer) {
            case 1: choices = Choices.EQUILATERAL;
                break;
            case 2: choices = Choices.RIGHT;
                break;
            case 3: choices = Choices.ISOSCELES;
                break;
            case 4: choices = Choices.SCALENE;
                break;
            case 5: choices = Choices.GOBACK;
                break;
        } // switch

        System.out.print("\u001b[0m"); // this will change the color back to normal.

    }// QueryUser Function
//  ======================

//  ===============================================
    public void ProcessCommand() throws Exception {

        switch(choices) {
            case EQUILATERAL:

                EquilateralTriangle.NowaitClearScreen();

                do {
                    equilateraltriangle.MenuDisplay2d("Equilateral Triangle");
                    equilateraltriangle.QueryUser();
                    equilateraltriangle.ProcessCommand();
                    
                    if (equilateraltriangle.goback()) 
                        EquilateralTriangle.ClearScreen();
                    
                } while(equilateraltriangle.goback());

                break;

            case RIGHT:
            
                EquilateralTriangle.NowaitClearScreen();

                do {
                    righttriangle.MenuDisplay2d("Right Triangle");
                    righttriangle.QueryUser();
                    righttriangle.ProcessCommand();

                    if (righttriangle.goback())
                        RightTriangle.ClearScreen();

                } while(righttriangle.goback());

                break;

                
            case ISOSCELES:
                
                EquilateralTriangle.NowaitClearScreen();

                do {
                    isoscelestriangle.IsoscelesCreationMenu();
                    isoscelestriangle.QueryIsoscelesCreationMenuInput();
                    isoscelestriangle.ProcessIsoscelesCreationCommand();
                    
                    if (isoscelestriangle.goback())
                        break;  // exit outer do loop
                                        
                    do {
                        isoscelestriangle.DisplayIsoscelesInfoMenu();
                        isoscelestriangle.QueryDisplayIsoscelesInfoMenuiInput();
                        isoscelestriangle.DisplayRequestedIsoscelesInfo();
                    
                        if(isoscelestriangle.goback())
                           break;  // exit inner do loop
                      
                    } while(true);
                    
                } while(true);

                break;
                

            case SCALENE:

                EquilateralTriangle.NowaitClearScreen();

                do {
                    scalenetriangle.MenuDisplay2d("Scalene Triangle");
                    scalenetriangle.QueryUser();
                    scalenetriangle.ProcessCommand();

                    if (scalenetriangle.goback())
                        ScaleneTriangle.ClearScreen();

                } while(scalenetriangle.goback());

                break;


            case GOBACK:

                    System.out.println("\nGoing back please wait");

                break;
        }
        
    }// ProcessCommand Function
//  ===========================

//  =========================
    public boolean Goback() {

        if (choices != Choices.GOBACK) 
            return true;
        else
            return false;

    }// Goback Function
//  ===================

//  =====================
    public void close() {

        righttriangle       = null;
        scalenetriangle     = null;
        isoscelestriangle   = null;
        equilateraltriangle = null;

    }// Close Function
//  ==================


}// class Triangle
//  ==============
