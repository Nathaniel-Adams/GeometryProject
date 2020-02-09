package app;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;


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

        if (!keyboard.hasNextInt()) {
            System.out.println("Error: This is not a valid Int!");
            keyboard.next();
            System.out.print("Please try again: ");
        }

    }// InvalidInputInt Function()
//  ==============================

}
