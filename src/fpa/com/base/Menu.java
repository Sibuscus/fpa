package fpa.com.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu
{
    //Intro
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
        Integer choice, i;
        String path;
        String line;
        String[] lineNum;
        boolean isSaved = false;

        Scanner s = new Scanner(System.in);
        FileWork fw = new FileWork();
        List<String[]> currentList = new ArrayList<>();

        //User input
        System.out.print("Specify the file's path:");
        path = s.nextLine();

        //Check for correct file path/directory
        while (!isPathValid(path))
        {
            System.out.println("Specify a correct file path:");
            path = s.nextLine();
        }

        File f = new File(path);

        //Read the file beforehand and put it in the ArrayList[] currentList
        try
        {
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext())
            {
                if(scanner.hasNext())
                {
                    line = scanner.nextLine();
                    lineNum = line.split("\\s+");
                    currentList.add(lineNum);
                }
                else
                {
                    scanner.hasNext();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //---------------------------------------MAIN MENU----------------------------------------
        do
        {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Working with file: " + f.getName());
            System.out.println("1. Validate file contents.");
            System.out.println("2. Switch lines.");
            System.out.println("3. Switch indexes.");
            System.out.println("4. CRUD operations.");
            System.out.println("5. Save file");
            System.out.println("6. Exit (Saved: " +isSaved +")" );
            System.out.println("NOTE: The file will not be saved unless you choose to save the file");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Choice:");
            choice = s.nextInt();

            switch (choice)
            {
                case 1:
                    isSaved = fw.FValidation(currentList, isSaved);
                    break;
                case 2:
                    isSaved = fw.lineSwitcher(currentList, isSaved);
                    break;
                case 3:
                    isSaved = fw.numberSwitcher(currentList, isSaved);
                    break;
                case 4:
                    break;
                case 5:
                    isSaved = fw.saveToFile(path, currentList);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        while (choice != 6);
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
        catch (SecurityException | NullPointerException e)
        {
            System.out.println("You've specified an invalid file path or do not have access to it");
            return false;
        }
        return true;
    }
}
