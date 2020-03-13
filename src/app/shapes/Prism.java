package app.shapes;

import app.CommonFunctions;
import java.util.Scanner;

public class Prism extends CommonFunctions {

//  ==============================================
    enum Choices {
        SETDIM, DISPLAY, VOLUME, SURFACEAREA, GOBACK
    };
//  ==============================================

//  =========================
    Choices choices;
    private Scanner keyboard;
    private int length;
    private int width;
    private int height;
//  =========================

//  ================================
    public Prism(Scanner keyboard) {

        this.keyboard = keyboard;
        length = width = height = 0;

    }// Prism constructor
//  =====================

//  ====================
    public void Menu() {

        System.out.println(
            "                 \u001b[35mPrism\u001b[0m               \n" + 
            "\u001b[31m======================================\u001b[0m\n" +
            "\u001b[34m1.\u001b[0m Set Dimensions  \u001b[34m2.\u001b[0m Display Prism   \n" +
            "\u001b[34m3.\u001b[0m Get Volume      \u001b[34m4.\u001b[0m Get Surface Area\n" +
            "\u001b[34m5.\u001b[0m Go Back                            \n" +
            "\u001b[31m======================================\u001b[0m\n"
        );

    }// Menu Function
//  =================

//  =========================
    public void QueryUser() {

        int awnser = 0;

        awnser = InputInt(keyboard, 1, 5);

        switch(awnser){
            case 1: choices = Choices.SETDIM;
                break;
            case 2: choices = Choices.DISPLAY;
                break;
            case 3: choices = Choices.VOLUME;
                break;
            case 4: choices = Choices.SURFACEAREA;
                break;
            case 5: choices = Choices.GOBACK;
                break;
        }// switch

        System.out.print("\u001b[0m"); // this will change the color back to normal.

    }// QueryUser Function
//  ======================

//  ==========================================================
public void ProcessCommand() throws InterruptedException {
       
    char newside;

    switch(choices) {
        case SETDIM:
            if (length == 0 && width == 0 && height == 0) {
                System.out.print("\nPlease enter the value for the width: ");
                InvalidInputInt(keyboard);
                width = keyboard.nextInt();
                System.out.print("\nPlease enter the value for the Length: ");
                InvalidInputInt(keyboard);
                length = keyboard.nextInt();
                System.out.print("\nPlease enter the value for the height: ");
                InvalidInputInt(keyboard);
                height = keyboard.nextInt();
                return;
            }
            else if (length != 0 || width != 0 || height != 0) {
                System.out.print("Which side would you like to set? (w/l/h): ");
                newside = keyboard.next().charAt(0);
                if (newside == 'w' || newside == 'W') {
                    System.out.print("\nPlease enter the value for the width: ");
                    InvalidInputInt(keyboard);
                    width = keyboard.nextInt();
                }
                else if (newside == 'l' || newside == 'L') {
                    System.out.print("\nPlease enter the value for the Length: ");
                    InvalidInputInt(keyboard);
                    length = keyboard.nextInt();
                }
                else if (newside == 'h' || newside == 'H') {
                    System.out.print("\nPlease enter the value for the height: ");
                    InvalidInputInt(keyboard);
                    height = keyboard.nextInt();
                }
                else
                    System.out.print("Error: not a valid answer!");
            }
            break;
        case DISPLAY:

                if (width != 0 && height != 0 && length != 0) {
                    System.out.println(
                        "                           \n" + 
                        "          ________________ \n" +
                        "        /|               /|\n" +
                        "       / |              / |\n" +
                        "       -----------------  |\n" +
                        "      |  |             |  | " + height + "\n" +
                        "      |  |             |  |\n" + 
                        "      |  --------------|---\n" +
                        "      | /              | / \n" +
                        "      |/               |/ " + width + "\n" +
                        "      ------------------   \n" +
                        "            " + length + " \n" 
                    );
                }
                else
                    System.out.println("one or more values are 0! You can not display an object that does not exist!");

            break;
        case VOLUME:
                if (width != 0 && height != 0 && length != 0) {
                    System.out.println("l * w * h = Volume");
                    System.out.println(length + " * " + width + " * " + height + " = " + width*height*length + " units^3");
                }
                else
                    System.out.println("The prism does not exist!");

            break;
        case SURFACEAREA:
                if (width != 0 && height != 0 && length != 0) {
                    System.out.println("2(l * w) + 2(l * h) + 2(w * h) = Surface Area");
                    System.out.println("2(" + length + " * " + width + ") + 2(" + length + " * " + height + ") + 2(" +
                                        width + " * "  + height + ") = " + (2*(length*width) + 2*(length*height) + 2* (width*height)) + " units^2");
                }
                else
                    System.out.println("The prism does not exist!");

            break;
        case GOBACK:

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
    }// goback function
//  ===================



}
