package fpa.com.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileWork
{
    public List<String[]> FValidation(File f)
    {
        //Variables
        List<String[]> numbers = new ArrayList<>();
        Integer i, j;
        String line;
        String [] lineNum;

        try
        {
            Scanner s = new Scanner(f);
            System.out.println("---------------------------------------------------------------------------");
            while(s.hasNext())
            {
                if(s.hasNext())
                {
                   line = s.nextLine();
                   lineNum = line.split("\\s+");
                   for(String str : lineNum)
                   {
                       if(!isNumberValid(str))
                       {
                           System.out.println("Invalid number [" +str +"] at line: " +line);
                       }
                   }
                   numbers.add(lineNum);
                }
                else
                {
                    s.next();
                }
            }
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The file's been processed. If there are any errors they are shown above.");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return numbers;
    }

    public List<String[]> lineSwitcher (List<String[]> list)
    {
        Scanner s = new Scanner(System.in);
        int[] input = new int[2];
        for (String[] arr : list)
        {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("Enter a line you'd like to replace:");
        input[0] = s.nextInt();
        System.out.println("Enter a line you'd like to replace it with:");
        input[1] = s.nextInt();

        String[] temp = list.get(input[0]);
        list.set(input[0], list.get(input[1]));
        list.set(input[1], temp);
        for(String[] arr : list)
        {
            System.out.println(Arrays.toString(arr));
        }
        return list;
    }

    private boolean isNumberValid(String s)
    {
        return s.matches("\\d+") && s.charAt(0) != '0';
    }


}
