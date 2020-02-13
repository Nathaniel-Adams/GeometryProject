/**
 * @author Nathaniel Adams, Levi Kruse, Jonathan Sandberg, Craig Jones
 * @email nacatcrazy@gmail
 * @create date 2020-02-08 14:06:36
 * @modify date 2020-02-08 14:06:36
 * @desc [description]
 */

package app;
import app.shapes.*;
import java.util.Scanner;

public class Shapes extends CommonFunctions {

//  ===========================================
    private Triangle triangle;
    private Rectangle rectangle;
//  ===========================================

//  =================================
    public Shapes(Scanner keyboard) {

        triangle = new Triangle(keyboard);
        rectangle = new Rectangle(keyboard);
    }// Constructor
//  ===============

//  ==========================================
    public void Rectangle() throws Exception {

        Rectangle.ClearScreen();

        do {
            rectangle.MenuDisplay2d("Rectangle");

            Triangle.ClearScreen();

        } while(false);

    }// Rectangle Function
//  ======================

//  =========================================
    public void Triangle() throws Exception {

        Triangle.ClearScreen();

        do {
            triangle.Menu();
            triangle.QueryUser();
            triangle.ProcessCommand();

            if (triangle.Goback())
                Triangle.ClearScreen();

        } while(triangle.Goback());

    }// Triangle Function
//  =====================

//  =====================
    public void close() {

        triangle.close();
        triangle = null;
        rectangle = null;

    }// Function Close
//  ==================


}
