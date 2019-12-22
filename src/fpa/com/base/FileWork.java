package fpa.com.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWork
{
    public static String FValidation(File f)
    {
        //Variables
        List<String> numbers = new ArrayList<>();
        Integer i;
        String line = null;
        try
        {
            Scanner s = new Scanner(f);
            while(s.hasNext())
            {
                if(s.hasNext())
                {
                    numbers.add(s.next());
                }
                else
                {
                    //System.out.println("Invalid character: " +s.toString());
                    s.next();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println(numbers);
        for(i = 0; i < numbers.size(); i++)
        {
            line = numbers.get(i);
            if(line.startsWith("0"))
            {
                System.out.println();
                System.out.println("" +line +"(" +i +")" +" starts with a 0(zero)");
            }
        }
        return "No errors";
    }
}
