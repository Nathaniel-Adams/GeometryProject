/**
 * @author Nathaniel Adams, Levi Kruse, Jonathan Sandberg, Craig Jones
 * @email nacatcrazy@gmail
 * @create date 2020-02-08 14:06:36
 * @modify date 2020-02-08 14:06:36
 * @desc This class file will be the one that controlls the other shapes and will close them all 
 *       all shapes when the class file is closed one step above it.
 * 
 */

package app;
import app.shapes.*;
import java.util.Scanner;

public class Shapes extends CommonFunctions {

//  ===========================================
    private Triangle triangle;
    private Rectangle rectangle;
    private Prism prism;
    private Cube cube;
//  ===========================================

//  =================================
    public Shapes(Scanner keyboard) {

        triangle = new Triangle(keyboard);
        rectangle = new Rectangle(keyboard);
        prism = new Prism(keyboard);
        cube = new Cube(keyboard);

    }// Constructor
//  ===============

    public void Cube() throws Exception {

        Cube.NowaitClearScreen();

        do {
            cube.MenuDisplay2d("Cube");
            cube.QueryUser();
            Cube.ClearScreen();
        } while(false);
    }

//  ==========================================
    public void Rectangle() throws Exception {

        Rectangle.NowaitClearScreen();

        do {
            rectangle.MenuDisplay2d("Rectangle");
            rectangle.QueryUser();
            rectangle.ProcessCommand();

            if(rectangle.Goback()) 
                Rectangle.ClearScreen();

        } while(rectangle.Goback());

    }// Rectangle Function
//  ======================

//  =========================================
    public void Triangle() throws Exception {

        Triangle.NowaitClearScreen();

        do {
            triangle.Menu();
            triangle.QueryUser();
            triangle.ProcessCommand();

            if (triangle.Goback())
                Triangle.NowaitClearScreen();

        } while(triangle.Goback());

    }// Triangle Function
//  =====================

//  ======================================
    public void Prism() throws Exception {
        Prism.NowaitClearScreen();

        do {

            prism.Menu();
            prism.QueryUser();
            prism.ProcessCommand();

            if (prism.Goback()) 
                Prism.ClearScreen();

        } while (prism.Goback());

    }// Function Prism
//  ==================

//  =====================
    public void close() {

        triangle.close();
        triangle = null;
        rectangle = null;

    }// Function Close
//  ==================


}
