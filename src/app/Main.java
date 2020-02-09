/**
 * @author Nathaniel Adams, Levi Kruse, Jonathan Sandberg, Craig Jones
 * @email nacatcrazy@gmail
 * @create date 2020-02-07 14:24:51
 * @modify date 2020-02-08 14:06:12
 * @desc This project should not only work between mutliple class to allow the user
 *       to get the area of multiple functions and if the user would like they can make there own equation.
 */

package app;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Menu menu = new Menu();

        menu.Introduction();

        do {
            menu.Display();
            menu.QueryUser();
            menu.ProcessCommand();
            Menu.ClearScreen(); // opens clearscreen in a static function.
            
        }while(menu.Continue());
        
        menu.close();
        menu = null;


    }
}
