package fpa.com.base;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileWork
{
    public boolean FValidation(List<String[]> file, boolean isSaved)
    {
        //Variables
        List<String[]> numbers = new ArrayList<>();
        Integer i, j;
        String line;
        String [] lineNum;

        try
        {
            System.out.println("---------------------------------------------------------------------------");
            for(i = 0; i < file.size(); i++)
            {
                lineNum = file.get(i);
                for(String str : lineNum)
                {
                    if(!isNumberValid(str))
                    {
                        System.out.println("Invalid number [" +str +"] at line: " +(Arrays.toString(file.get(i))));
                    }
                }
                numbers.add(lineNum);
            }
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The file's been processed. If there are any errors they are shown above.");
            if(isSaved)
            {
                isSaved = false;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return isSaved;
    }

    private boolean FValidation(List<String[]> list)
    {
        Integer i;
        boolean isGood = true;
        String[] lineNum;
        try
        {
            for(i=0; i<list.size(); i++)
            {
                lineNum = list.get(i);
                for(String str : lineNum)
                {
                    if(!isNumberValid(str))
                    {
                        isGood = false;
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return isGood;
    }

    public boolean lineSwitcher (List<String[]> list, boolean isSaved)
    {
        Scanner s = new Scanner(System.in);
        int[] input = new int[2];
        System.out.println("---------------------------------------------------------------------------");
        //Prints the array
        for (String[] arr : list)
        {
            System.out.println(Arrays.toString(arr));
        }
        try
        {
            do
            {
                //User input
                System.out.println("Enter a line you'd like to replace:");
                input[0] = s.nextInt();
                System.out.println("Enter a line you'd like to replace it with:");
                input[1] = s.nextInt();
                System.out.println("---------------------------------------------------------------------------");
            }while (input[0] < 0 || input[0] >= list.size() || input[1] < 0 || input[1] >= list.size());
        }
        catch (Exception e)
        {
            System.out.println(e);
            return isSaved;
        }


        //Line switching work
        String[] temp = list.get(input[0]);
        list.set(input[0], list.get(input[1]));
        list.set(input[1], temp);
        for(String[] arr : list)
        {
            System.out.println(Arrays.toString(arr));
        }
        if(isSaved)
        {
            isSaved = false;
        }
        return isSaved;
    }

    public boolean numberSwitcher(List<String[]> list, boolean isSaved)
    {
        Scanner s = new Scanner(System.in);
        int[] input = new int[4];
        System.out.println("---------------------------------------------------------------------------");
        //Prints the array
        for (String[] arr : list)
        {
            System.out.println(Arrays.toString(arr));
        }
        try
        {
            do
            {
                //User input
                System.out.print("Enter a line for the first number:");
                input[0] = s.nextInt();
                System.out.print("Enter the index of the number in " +input[0] +":");
                input[1] = s.nextInt();
                System.out.print("Enter a line for the second number:");
                input[2] = s.nextInt();
                System.out.print("Enter the index of the number in " +input[2] +":");
                input[3] = s.nextInt();
            }while (input[0] < 0 || input[0] >= list.size() || input[2] < 0 || input[2] >= list.size());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //input N   -   Line N
        //0         -   line 1
        //1         -   number 1
        //2         -   line 2
        //3         -   number 2

        String[] firstLine = list.get(input[0]);
        String[] secondLine = list.get(input[2]);
        String[] temp = firstLine.clone();

        firstLine[input[1]] = secondLine[input[3]];
        secondLine[input[3]] = temp[input[1]];

        try
        {
            list.set(input[0], firstLine);
            list.set(input[2], secondLine);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }

        for(String[] arr : list)
        {
            System.out.println(Arrays.toString(arr));
        }

        if(isSaved)
        {
            isSaved = false;
        }
        return isSaved;
    }

    private boolean isNumberValid(String s)
    {
        return s.matches("\\d+") && s.charAt(0) != '0';
    }

    public boolean saveToFile(String path, List<String[]> list)
    {
        try
        {
            if(FValidation(list))
            {
                FileWriter writer = new FileWriter(path);
                for (String[] line : list)
                {
                    String append = "";
                    for(String numb : line)
                    {
                        writer.write(append + numb);
                        append = " ";
                    }
                    writer.write("\n");
                }
                writer.flush();
                writer.close();
                System.out.println("File saved successfully");
            }
            else
            {
                System.out.println("You cannot save the file. Choose 1 to find out why.");
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
