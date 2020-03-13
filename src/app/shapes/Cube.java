
package app.shapes;
import java.util.Scanner;

public class Cube extends Rectangle {
//
    enum Choices {
        DIMENSIONS, DISPLAY, VOLUME, SURFACEAREA,GOBACK
    };

    private Choices choices;
    private Scanner keyboard;
    private int side;

//  ===============================
    public Cube(Scanner keyboard) {
        super(keyboard); // this is the super class which means the super must be added
        this.keyboard = keyboard;
        side = 0;
    }

//  =========================================================
    @Override // has to override the queryUser from rectangle
    public void QueryUser() {

        int awnser = 0;

        awnser = InputInt(keyboard, 1, 5);

        switch(awnser){
            case 1: choices = Choices.DIMENSIONS;
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

        System.out.print("\u001b[0m"); 


    }// QueryUser()
//  ===============

    @Override
    public void ProcessCommand() {

        switch(choices) {
            case DIMENSIONS: 
                System.out.print("\nPlease enter the value for the sides(width/length/height are all the same): ");
                InvalidInputInt(keyboard);
                side = keyboard.nextInt();
            break;
            case DISPLAY:
                if (side != 0) {
                    System.out.println(
                    "                           \n" + 
                    "          ________________ \n" +
                    "        /|               /|\n" +
                    "       / |              / |\n" +
                    "       -----------------  |\n" +
                    "      |  |             |  | " + side + "\n" +
                    "      |  |             |  |\n" + 
                    "      |  --------------|---\n" +
                    "      | /              | / \n" +
                    "      |/               |/ " + side + "\n" +
                    "      ------------------   \n" +
                    "            " + side + " \n" 
                    );
                }
                else
                    System.out.println("one or more values are 0! You can not display an object that does not exist!");
                break;
            case VOLUME:
                System.out.println("side^3 = area");
                System.out.println(side + "^3 = " + (Area(side, side) * side) + " units^2" );
            break;
            case SURFACEAREA:
                System.out.println("side^2 * 6 = SurfaceArea");
                System.out.println(side + "^2 * 6 = " + (Area(side, side) * 6 ) + " units^2");
            break;
            case GOBACK:

            break;

        }

    }

    //  ====================
    public void Menu() {

        System.out.println(
            "                 \u001b[35mCube\u001b[0m               \n" + 
            "\u001b[31m======================================\u001b[0m\n" +
            "\u001b[34m1.\u001b[0m Set Dimensions  \u001b[34m2.\u001b[0m Display Cube    \n" +
            "\u001b[34m3.\u001b[0m Get Volume      \u001b[34m4.\u001b[0m Get Surface Area\n" +
            "\u001b[34m5.\u001b[0m Go Back                            \n" +
            "\u001b[31m======================================\u001b[0m\n"
        );

    }// Menu Function
//  =================

//  =========================
    @Override
    public boolean Goback() {

        if (choices != Choices.GOBACK) 
            return true;
        else
            return false;

    }// Goback Function
//  ===================

}
