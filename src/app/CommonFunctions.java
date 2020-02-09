/**
 * @author Nathaniel Adams, Levi Kruse, Jonathan Sandberg, Craig Jones
 * @email nacatcrazy@gmail
 * @create date 2020-02-08 22:22:42
 * @modify date 2020-02-08 22:22:42
 * @desc [description]
 */


package app;

//  =================================
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
//  =================================

//  ==========================
public class CommonFunctions {

    //  ====================================================================
    public static void ClearScreen() throws IOException, InterruptedException {

        /* ================SCRAPPED=====================================
        System.out.print("\033[H\033[2J");// This is an ANSI excape code
        // \033 stands for ESC(ANSI value 27)
        // Which starts the command as ESC[
        // then H moves the cursor to the top left corner of the screen
        // and \033[J clears the part of the screen from the cursor to the end of the screen
        // This functionally the ctrl + L
        // For more information on ANSI escape codes visit: https://en.wikipedia.org/wiki/ANSI_escape_code
        System.out.flush();
        // Flush must happen due to the use of a ANSI and not using println
        ==================================================================*/

        System.out.print("\nClearing screen ");
        for (int ii = 0; ii < 3; ii++ ) {
            System.out.print(". ");
            TimeUnit.SECONDS.sleep(1);// This is a delay function for 3 seconds.
        }// This is a delay function for 3 seconds.

        final String os = System.getProperty("os.name"); 
        // Since the value of string is not changed ever again it is better to make it final which means it can not be changed.
        // The System.getProperty will retrieve the exact string name of the system.
        if (os.contains("Windows")) // This will check the string if it contains Windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            // Will run the object to run the command of to open cmd then command then cls.
        else 
            Runtime.getRuntime().exec("clear");
            // Then if it's not windows it will excetute the command clear for all the rest of the ios.

    }// ClearScreen Function()
//  ==========================

//  ===============================================
    public void InvalidInputInt(Scanner keyboard) {

        if (!keyboard.hasNextInt()) {// In the scanner class it has a function to check if the next value is valid or not.
            System.out.println("Error: This is not a valid Int!");
            keyboard.next();// This will skip the input then go next.
            System.out.print("Please try again: ");
        } 

    }// InvalidInputInt Function()
//  ==============================

//  =========================================================
    public int InputInt(Scanner keyboard, int min, int max) {
    
        int answer = 0;

        System.out.println("\nPlease enter your Selection: \u001b[34m"); 
        InvalidInputInt(keyboard); // checks the input 
        answer = keyboard.nextInt();
        if (((answer > max)||(answer < min))&&(min != max)) // if min and max is the same it will act as just to grab the int only.
            System.out.println("Error: The integer that has been entered is out of range or invalid!"); 
        return answer; // returns int

    }// InputInt Function()
//  =======================

//  =========================================
    public void MenuDisplay2d (String file) {

        String space = "          "; // this is to try to make the object directly in the middle
        file = space.substring(0, space.length() - file.length()/2) + file;
        System.out.println("       \u001b[35m" + file + "\u001b[0m" + "       \n" + 
                           "\u001b[31m==================================\u001b[0m\n" +
                           "\u001b[34m1.\u001b[0m Set sides     \u001b[34m2.\u001b[0m Get Perimeter   \n" +
                           "\u001b[34m3.\u001b[0m Get Area      \u001b[34m4.\u001b[0m Display Shape\n" +
                           "\u001b[34m5.\u001b[0m Go back                          \n" +
                           "\u001b[31m==================================\u001b[0m\n" );

    }// MenuDisplay2d Function
//  ==========================

}// 
