package fpa.com.base;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.exit;


public class Menu
{
    public static void printFMsg()
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Hello and welcome to Sibuscus's file processing application.");
        System.out.println("Read the README.md file for more information.");
        System.out.println("Press Enter to continue...");
        System.out.println("-----------------------------------------------------------");
        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        System.out.flush();
        FilePath();
    }
    //TESTING PURPOSES
    //My path:      D:\Development\GitHub\FileProcessingApplication\file-processing-application\numbers.txt
    //UNIX code:    "D:" +File.separator +"Development" +File.separator +"GitHub" +File.separator +"FileProcessingApplication" +File.separator +"file-processing-application" +File.separator +"numbers.txt";

    private static void FilePath()
    {
        //Variables
        Integer choice;
        String path;
        Scanner s = new Scanner(System.in);
        //User input
        System.out.print("Specify the file's path:");
        path = s.nextLine();
        //Check for correct file path/directory
        if (!isPathValid(path))
        {
            System.out.println("You've specified an invalid file path");
            exit(0);
        }
        File f = new File(path);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Working with file: " + f.getName());
        System.out.println("1. Validate file contents.");
        System.out.println("2. Switch lines.");
        System.out.println("3. Switch indexes.");
        System.out.println("4. CRUD operations.");
        System.out.println("5. Save file");
        System.out.println("NOTE: The file will not be saved unless you choose to save the file");
        System.out.println("-----------------------------------------------------------");
        System.out.print("Choice:");
        choice = s.nextInt();
    }

    public static boolean isPathValid(String Path)
    {
        try
        {
            File f = new File(Path);
            if (!f.isDirectory())
            {
                f = f.getParentFile();
            }

            if (f.exists())
            {
                System.out.println("That file exists, you may proceed.");
            }
            //Paths.get(Path); //Always returns true...
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
