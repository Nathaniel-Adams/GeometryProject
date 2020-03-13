/**
 * @author Nathaniel Adams, Levi Kruse, Jonathan Sandberg, Craig Jones
 * @email nacatcrazy@gmail
 * @create date 2020-02-07 14:30:29
 * @modify date 2020-02-08 14:06:26
 * @desc This file is going to be the main foundation that will communcate to the lower classes such as the Geometry class
 *       Make your own equation class and if we have time to simfly your output. In this file I will be using ANSI escape 
 *       codes to add color to the console window for more information on ANSI escape codes make sure to read https://en.wikipedia.org/wiki/ANSI_escape_code.
 *       
 */


package app;

import java.util.Scanner;

//  ======================================
public class Menu extends CommonFunctions {

//  ===============================================================================
    enum Choices {
        RECTANGLE, CIRCLE, TRIANGLE, TRAPIZOID, SPHERE, PRISM, CUBE, CREATEOWN, QUIT 
    };
//  ===============================================================================
    
//  ==================================================
    private Scanner keyboard = new Scanner(System.in);
    private Shapes shapes = new Shapes(keyboard);
    private Choices choices;
//  ==================================================

//  ===============
    public Menu() {

        System.out.println("Menu Constructor Invoked.");
        
    }// Constructor 
//  ===============

//  ============================
    public void Introduction() {

        System.out.print("\u001b[31m=============================\u001b[0m\n" + // \u001b[31m is the ANSI code for red \u001b[0m resets.
                         "This program will be able to \n" +
                         "calculate many shape areas of\n" +
                         "3d objects and 2d objects    \n" +
                         "\u001b[31m=============================\u001b[0m\n" );

    }// Intruduction Function

/** 
*   @notes In this display function you will see that there is a ton of ANSI codes in the strings.
*           But when I first designed the entire menu without the ANSI codes then I added in the codes
*           to just be blue on the numbers and red on the top and bottom bar.
*/
//  =======================
    public void Display() {

        System.out.println();
        System.out.print("\u001b[31m===================================\u001b[0m\n" + // \u001b[31m is the ANSI code for red \u001b[0m resets.
                         "\u001b[34m1.\u001b[0m Rectangle       \u001b[34m2.\u001b[0m Circle       \n" + // \u001b[34m1 is the ANSI code for blue.
                         "\u001b[34m3.\u001b[0m Triangle        \u001b[34m4.\u001b[0m Trapizoid    \n" + 
                         "\u001b[34m5.\u001b[0m Sphere          \u001b[34m6.\u001b[0m Prism        \n" +
                         "\u001b[34m7.\u001b[0m Cube            \u001b[34m8.\u001b[0m Create my own\n" +
                         "\u001b[34m9.\u001b[0m Quit                            \n" +
                         "\u001b[31m===================================\u001b[0m\n");
                    
    }// Display Function
//  ====================

//  =========================
    public void QueryUser() {

        int answer = 0;

        answer = InputInt(keyboard, 1, 9);


        switch(answer) {
            case 1: choices = Choices.RECTANGLE;
                break;
            case 2: choices = Choices.CIRCLE;
                break;
            case 3: choices = Choices.TRIANGLE;
                break;
            case 4: choices = Choices.TRAPIZOID;
                break;
            case 5: choices = Choices.SPHERE;
                break;
            case 6: choices = Choices.PRISM;
                break;
            case 7: choices = Choices.CUBE;
                break;
            case 8: choices = Choices.CREATEOWN;
                break;
            case 9: choices = Choices.QUIT;
                break;
        }
        System.out.print("\u001b[0m"); // this will change the color back to normal.

    }// QueryUser Function
//  ======================

//  ===========================
    public boolean Continue() {
        if (choices == Choices.QUIT) 
            return false;
        else
            return true;
    }// Continue Function Returning Boolean
//  ========================================

//  ==============================
    public void ProcessCommand() throws Exception {

        switch(choices) {
            case RECTANGLE: 
                    shapes.Rectangle();
                break; 
            case CIRCLE:

                break;
            case TRIANGLE:
                    shapes.Triangle();
                break;
            case TRAPIZOID:

                break;
            case SPHERE:

                break;
            case PRISM:
                    shapes.Prism();
                break;
            case CUBE:
                    shapes.Cube();
                break;
            case CREATEOWN:

                break;
            case QUIT:
                    System.out.println("Closing Program, have a wonderful day!");
                break;
            default: System.out.println("Error: Menu.ProcessCommand() an error has occured.");
        }


    }// ProcessCommand Function
//  ===========================

//  =====================
    public void close() throws Exception {

        keyboard.close();
        shapes.close();
        shapes = null;

    }// Close Function
//  ==================


}// Class Menu
//  ==========
