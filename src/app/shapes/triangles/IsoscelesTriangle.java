//=============================================================================
// IsoscelesTriangle.java
//
// Implemention of the IsoscelesTriangle class
// Geometry Project.
//
//          Original Author: Craig Jones
//                    Class: CS275
// Date of First Submission: 02/20/2020
//                  Project: GeometryProject (Winter 2020 Team Project)
//
// Revisions: 
//
//       Revisor          Date     Description
//  -----------------  ----------  --------------------------------------------
//
//=============================================================================
package app.shapes.triangles;

import app.CommonFunctions;
import app.shapes.Graph;
import app.shapes.Line;
import app.shapes.Point;
import java.util.Scanner;
import java.lang.Math;
import java.lang.StrictMath;
import java.util.ArrayList;

//  ===========================================================================
//  Class Definition of an IsoscelesTriangle class
//  ===========================================================================
public class IsoscelesTriangle extends CommonFunctions {

    // Allowed choices for the isosceles triangle sub-menu.
    enum Choices {
        // Define by the length of the 3 legs
        KNOW_3LEGS, 
        // Define by the length of a congruent side and the apex angle
        KNOW_CONGRUENTLEGS_APEXANGLE,
        // Define by the length of a congruent side and a base angle
        KNOW_CONGRUENTLEGS_BASEANGLES, 
        // Define by the length of the base leg and the apex angle
        KNOW_BASELEG_APEXANGLE,
        // Define by the length of the base leg and a base angle
        KNOW_BASELEG_BASEANGLES, 
        // Display the calculated perimeter
        PERIMETER, 
        // Display the calculated area
        AREA, 
        // Display a graph of the triangle
        DISPLAY, 
        // Go back to the general triangle menu
        GOBACK
    };

    private double  congruentLegs;
    private double  baseLeg;
    private double  apexAngle;   // degrees
    private double  baseAngles;  // degrees
    
    private Choices choice;
    private Scanner keyboard;


// ============================================================================
//  Constructor
// ============================================================================
    public IsoscelesTriangle(Scanner keyboard) {

        this.keyboard = keyboard;
        congruentLegs = baseLeg     = 0.0;
        apexAngle     = baseAngles  = 0.0;

    } // IsoscelesTriangle() constructor


// ============================================================================
//  Prompts for the way the user wants to describe an isosceles triangle
//  using known values.
// ============================================================================
    public void IsoscelesCreationMenu() {

        System.out.println("       \u001b[35mIsosceles Creation Options" + "\u001b[0m" + "       \n" + 
                           "\u001b[31m==================================\u001b[0m\n"                 +
                           "\u001b[34m1.\u001b[0m Enter the length of all legs\n"                        +
                           "\u001b[34m2.\u001b[0m Enter the length of the congruent legs and the apex angle\n"       +
                           "\u001b[34m3.\u001b[0m Enter the length of the congruent legs and the base angles\n"        +
                           "\u001b[34m4.\u001b[0m Enter the length of the base leg and the apex angle\n"          +
                           "\u001b[34m5.\u001b[0m Enter the length of the base leg and the base angles\n"           +
                           "\u001b[34m6.\u001b[0m Go back                          \n"               +
                           "\u001b[31m==================================\u001b[0m\n");

    } // IsoscelesCreationMenu()
   
   

// ============================================================================
//  Retrieves the user's response to the IsoscelesCreationMenu()
// ============================================================================
    public void QueryIsoscelesCreationMenuInput() {

        int answer;

        answer = InputInt(keyboard, 1, 6);

        switch(answer){
            case 1: choice  = Choices.KNOW_3LEGS;
                break;
            case 2: choice  = Choices.KNOW_CONGRUENTLEGS_APEXANGLE;
                break;
            case 3: choice  = Choices.KNOW_CONGRUENTLEGS_BASEANGLES;
                break;
            case 4: choice  = Choices.KNOW_BASELEG_APEXANGLE;
                break;
            case 5: choice  = Choices.KNOW_BASELEG_BASEANGLES;
                break;
            case 6: choice  = Choices.GOBACK;
                break;
            default: choice = Choices.GOBACK;
                break;
        }// switch

        System.out.print("\u001b[0m"); // change the color back to normal.

    } // QueryIsoscelesCreationMenuInput()

    
    
// ============================================================================
//  Prompts for the known values that the user chose to provide and saves the
//  user's input in the appropriate triangle component variables.
// ============================================================================
    public void ProcessIsoscelesCreationCommand() throws InterruptedException {

        switch(choice) {

            case KNOW_3LEGS:

                System.out.print("\nEnter a length for the two congruent legs: ");
                InvalidInputDouble(keyboard);
                setCongruentLegs(keyboard.nextDouble());
                    
                System.out.print("\nEnter a length for the base leg: ");
                InvalidInputDouble(keyboard);
                setBaseLeg(keyboard.nextDouble());
                    
                CalculateIsoscelesTriangle();
                break;

                
            case KNOW_CONGRUENTLEGS_APEXANGLE:

                System.out.print("\nEnter a length for the two congruent legs: ");
                InvalidInputDouble(keyboard);
                setCongruentLegs(keyboard.nextDouble());
                    
                System.out.print("\nEnter a value for the apex angle (degrees): ");
                InvalidInputDouble(keyboard);
                setApexAngle(keyboard.nextDouble());
                    
                CalculateIsoscelesTriangle();
                break;
               

            case KNOW_CONGRUENTLEGS_BASEANGLES:

                System.out.print("\nEnter a length for the two congruent legs: ");
                InvalidInputDouble(keyboard);
                setCongruentLegs(keyboard.nextDouble());
                    
                System.out.print("\nEnter a value for the base angles (degrees): ");
                InvalidInputDouble(keyboard);
                setBaseAngles(keyboard.nextDouble());
                    
                CalculateIsoscelesTriangle();
                break;

                
            case KNOW_BASELEG_APEXANGLE:

                System.out.print("\nEnter a length for the base leg: ");
                InvalidInputDouble(keyboard);
                setBaseLeg(keyboard.nextDouble());
                    
                System.out.print("\nEnter a value for the apex angle (degrees): ");
                InvalidInputDouble(keyboard);
                setApexAngle(keyboard.nextDouble());
                
                CalculateIsoscelesTriangle();
                break;
                

            case KNOW_BASELEG_BASEANGLES:

                System.out.print("\nEnter a length for the base leg: ");
                InvalidInputDouble(keyboard);
                setBaseLeg(keyboard.nextDouble());
                    
                System.out.print("\nEnter a value for the base angles (degrees): ");
                InvalidInputDouble(keyboard);
                setBaseAngles(keyboard.nextDouble());
                    
                CalculateIsoscelesTriangle();
                break;
                

            case GOBACK: 
                System.out.println("\nLeaving Isosceles Triangle");
                choice  = Choices.GOBACK;
                break;

                
            default:
                choice  = Choices.GOBACK;
                break;
                
        } // switch
        
    }  // ProcessIsoscelesCreationCommand()
        
     
    
//  =========================================================================== 
//  Prompts the user for what he wants to know about the isosceles triangle
//  he specified.
//  =========================================================================== 
    public void DisplayIsoscelesInfoMenu() {
       System.out.println("       \u001b[35mIsosceles Triangle Info" + "\u001b[0m" + "\n" + 
                          "\u001b[31m==================================\u001b[0m\n"       +
                          "\u001b[34m1.\u001b[0m Show Perimeter\n"                        +
                          "\u001b[34m2.\u001b[0m Show Area\n"                             +
                          "\u001b[34m3.\u001b[0m Display the triangle\n"                  +
                          "\u001b[34m4.\u001b[0m Go back                          \n"     +
                          "\u001b[31m==================================\u001b[0m\n");

    } // DisplayIsoscelesInfoMenu()



// ============================================================================
//  Retrieves the user's response to the DisplayIsoscelesInfoMenu()
// ============================================================================
    public void QueryDisplayIsoscelesInfoMenuiInput() {

        int answer;

        answer = InputInt(keyboard, 1, 4);

        switch(answer){
            
            case 1: choice  = Choices.PERIMETER;
                break;
            case 2: choice  = Choices.AREA;
                break;
            case 3: choice  = Choices.DISPLAY;
                break;
            case 4: choice  = Choices.GOBACK;
                break;
            default: 
                break;

        }// switch

        System.out.print("\u001b[0m"); // change the color back to normal.

    } // QueryDisplayIsoscelesInfoMenuiInput()



   
// ============================================================================
//  Display the info requested from DisplayIsoscelesInfoMenu(). 
// ============================================================================
    public void DisplayRequestedIsoscelesInfo() throws InterruptedException {
        
        switch(choice) {      

            case PERIMETER:

                if (congruentLegs != 0.0) {
                    System.out.printf("\n\nThe perimeter of %s %.2f units\n\n", 
                                       this, CalculateIsoscelesPerimeter());
                }// then
                else 
                    System.out.println("Error: Triangle is not initialized yet!");
                break;

                
            case AREA:

                if (congruentLegs != 0.0) {
                    System.out.printf("\n\nThe area of %s %.2f sq units\n\n", 
                                       this, CalculateIsoscelesArea());
                }// then
                else 
                    System.out.println("Error: Triangle is not initialized yet!");
                break;


            case DISPLAY:
                Point pt1, pt2;
                Line  line;
                ArrayList<Line> lineList;
                double bisector;
                double legA, legB;
                Graph graph;

                if(congruentLegs == 0.0) {
                   System.out.println("Error: No sides are set yet!");
                   break;
                }
               
                // Instantiate a graph object and initialize it
                graph = new Graph();
                graph.InitializeGraph("Isosceles Triangle", graph);
   
                // Create a new line list for the polygon
                lineList = Line.CreateLineList();
                             
                // create the first line -- the base leg.  The first point is
                // at the origin.
                pt1  = new Point(0.0, 0.0);
                pt2  = new Point(baseLeg, 0.0);
                line = new Line(pt1, pt2);
                lineList.add(line);
                
                // Create the line for the left congruent side. The 1st endpoint
                // is already set. The scond endpoint is half of the base leg 
                // length and the height is = the length of the perpendicular
                // bisector.
                legA     = getBaseLeg() / 2.0;
                legB     = getCongruentLegs();
                bisector = Math.sqrt(Math.abs((legA * legA) - (legB * legB))); 
                pt2.setPointX(baseLeg / 2.0);
                pt2.setPointY(bisector);
                line = new Line(pt1, pt2);
                lineList.add(line);
                
                // Now create the opposite congruent leg line. pt2 is already set.
                pt1.setPointX(baseLeg);
                pt1.setPointY(0.0);
                line = new Line(pt1, pt2);
                lineList.add(line);
                
                // Add the lineList to the shapeList    
                graph.shapeList.add(lineList);
                
                // Plot the polygon
                graph.PlotShapes();
                
                // For testing only
                Graph.PlotTriangleFromLineLengths(4.0, 5.0, 3.0);
      
                break;


            case GOBACK:

                break;
                

            default: 

                break;

        } // switch

    } // DisplayRequestedIsoscelesInfo()




// ============================================================================
//  Returns true if the user selected the "Go Back" option in any menu.
// ============================================================================
    public boolean goback() {
        if(choice == Choices.GOBACK)
            return true;
        else
            return false;
    } // goback()


// ============================================================================
//  Calculates the remaining values for an Isosceles triangle from the known
//  values entered by the user in ProcessIsoscelesCreationCommand().
// ============================================================================
    private void CalculateIsoscelesTriangle() {
      
        double legA;
        double legB;
        double bisector;
        double angle;
      
        // NOTE: congruentLegs act as the hypotonuse of the half triangle.
        //       The bisector acts as the height of the triangle.
        switch(choice) {
         
            case KNOW_3LEGS:
                legA     = getBaseLeg() / 2.0;
                legB     = getCongruentLegs();
                bisector = Math.sqrt(Math.abs((legA * legA) - (legB * legB)));

                // convert atan radian angle to degrees
                angle    = Math.toDegrees(Math.atan(bisector / legA));
                setBaseAngles(angle);

                setApexAngle(180.0 - (2 * angle));

                break;

            
            case KNOW_CONGRUENTLEGS_APEXANGLE:
                angle    = Math.toRadians(getApexAngle() / 2.0);
                legA     = getCongruentLegs() * StrictMath.sin(angle);

                setBaseLeg(legA * 2.0);
                setBaseAngles((180.0 - getApexAngle()) / 2.0);

                break;

            
           case KNOW_CONGRUENTLEGS_BASEANGLES:
                angle    = 180.0 - (2 * getBaseAngles());
                setApexAngle(angle);

                angle    = Math.toRadians(angle / 2.0);
                legA     = getCongruentLegs() * StrictMath.sin(angle);
                setBaseLeg(legA * 2.0);

                break;

            
           case KNOW_BASELEG_APEXANGLE:
                setBaseAngles((180.0 - getApexAngle()) / 2.0);

                angle    = Math.toRadians(getApexAngle() / 2.0);
                legA     = getBaseLeg() / 2.0;
                bisector = legA / Math.tan(angle);
                setCongruentLegs(Math.sqrt((bisector * bisector) + (legA * legA)));
                break;

            
           case KNOW_BASELEG_BASEANGLES:
                angle    =  180.0 - (2 * getBaseAngles());
                setApexAngle(angle);

                angle    = Math.toRadians(angle / 2.0);
                legA     = getBaseLeg() / 2.0;
                bisector = legA / Math.tan(angle);
                setCongruentLegs(Math.sqrt((bisector * bisector) + (legA * legA)));
                break;

            
           default:
                System.out.println("CalculateIsoscelesTriangle: bad choice\n");
                break;

        } // switch

    } // CalculateIsoscelesTriangle()
    
   
//  ===========================================================================
//  Override default toString() method with our own highly enlightened version
//  that prints out the values for the components of an Isosceles Triangle.
//  ===========================================================================
   @Override
    public String toString(){

    String result = String.format("an Isosceles triangle with sides:\n"
                                  + "   %.2f, %.2f, %.2f\n"
                                  + "and angles:\n"
                                  + "   %.2f, %.2f, %.2f"
                                  + " is: ",
                                  + congruentLegs, congruentLegs, baseLeg,
                                  + apexAngle, baseAngles, baseAngles);

       return result;

    } // toString()


// ============================================================================
// Returns the perimeter of an isosceles triangle
// ============================================================================
   private double CalculateIsoscelesPerimeter() {

       return ((2.0 * this.getCongruentLegs()) + this.getBaseLeg());

   } // CalculateIsoscelesPerimeter()


// ============================================================================
// Returns the area of an isosceles triangle
// ============================================================================
   private double CalculateIsoscelesArea() {

       double oneHalfBase;
       double hypotonuse;
       double height;
       double legASquared;
       double legBSquared;
       

       oneHalfBase = this.getBaseLeg() / 2.0;
       hypotonuse  = getCongruentLegs();

       legASquared = oneHalfBase * oneHalfBase;
       legBSquared = hypotonuse  * hypotonuse;
 
       height = Math.sqrt(Math.abs(legASquared - legBSquared));

       return (oneHalfBase * height);

   } // CalculateIsoscelesArea()


// ============================================================================
// Accessor method to retrieve the length of the congruent legs of an isosceles
// triangle.
// ============================================================================
   private double getCongruentLegs() {

       return this.congruentLegs;

   } // getCongruentLegs()


// ============================================================================
// Mutator method to set the length of the congruent legs of an isosceles
// triangle.
// ============================================================================
   private void setCongruentLegs(double legLength) {

       this.congruentLegs = legLength;

   } // setCongruentLegs()


// ============================================================================
// Accessor method to retrieve the length of the base leg of an isosceles
// triangle.
// ============================================================================
   private double getBaseLeg() {

       return this.baseLeg;

   } // getBaseLeg()


// ============================================================================
// Mutator method to set the length of the base leg of an isosceles triangle.
// ============================================================================
   private void setBaseLeg(double legLength) {

       this.baseLeg = legLength;

   } // setbaseLeg()


// ============================================================================
// Accessor method to retrieve the degrees of angle of the apex angle of an 
// isosceles triangle.
// ============================================================================
   private double getApexAngle() {

       return this.apexAngle;

   } // getApexAngle()


// ============================================================================
// Mutator method to set the degrees of angle of the apex angle of an 
// isosceles triangle.
// ============================================================================
   private void setApexAngle(double angleDegrees) {

       this.apexAngle = angleDegrees;

   } // setApexAngle()


// ============================================================================
// Accessor method to retrieve the degrees of angle of the base angles of an 
// isosceles triangle.
// ============================================================================
   private double getBaseAngles() {

       return this.baseAngles;

   } // getBaseAngles()


// ============================================================================
// Mutator method to set the degrees of angle of the base angles of an 
// isosceles triangle.
// ============================================================================
   private void setBaseAngles(double angleDegrees) {

       this.baseAngles = angleDegrees;

   } // setBaseAngles()


} // IsoscelesTriangle Class

