package fpa.com.base;

import java.sql.Struct;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CRUDops
{
    public boolean addNumber(List<String[]> list, boolean isSaved)
    {
        //Variables
        Integer i;
        int[] input = new int[3];
        String[] line;
        String[] newLine;

        Scanner s = new Scanner(System.in);
        FileWork fileWork = new FileWork();

        fileWork.printList(list);
        //User input
        try
        {
            while (true)
            {
                System.out.print("Enter a line where you want to add a number to:");
                input[0] = s.nextInt();
                System.out.print("Enter the index of the number that you wish to add it to:");
                input[1] = s.nextInt();
                System.out.print("Enter the value of the number you want to add:");
                input[2] = s.nextInt();
                System.out.println("---------------------------------------------------------------------------");
                if(fileWork.isInRange(list, input[0], input[1], true))
                {
                    break;
                }
                else
                {
                    System.out.println("You've entered values that are out of the file's line size");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //List work
        line = list.get(input[0]);
        newLine = new String[line.length +1]; //Create new line (So to allocate new space for the new inserted number)

        for(i = 0; i < input[1]; i++) //Fill all the contents of line to newLine UP UNTIL input[1]
        {
            newLine[i] = line[i]; //Transfer line contents into newLine
        }

        newLine[input[1]] = Integer.toString(input[2]); //Change the number in the line

        for(i = input[1] +1; i <= line.length; i++) //Continue filling the rest of the line
        {
            newLine[i] = line[i -1];
        }

        list.set(input[0], newLine);
        fileWork.printList(list);
        fileWork.saveList(isSaved);

        return isSaved;
    }

    public boolean readNumber(List<String[]> list, boolean isSaved)
    {
        //Variables
        Integer i;
        int [] input = new int[2];
        String[] line;

        Scanner s = new Scanner(System.in);
        FileWork fileWork = new FileWork();

        fileWork.printList(list);

        //User input
        try
        {
            while (true)
            {
                System.out.print("Enter a line to read from:");
                input[0] = s.nextInt();
                System.out.print("Enter the index of the number in that line:");
                input[1] = s.nextInt();
                System.out.println("---------------------------------------------------------------------------");
                if(fileWork.isInRange(list, input[0], input[1], false))
                {
                    break;
                }
                else
                {
                    System.out.println("You've entered values that are out of the file's line size");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //List work
        try
        {
            line = list.get(input[0]);
            System.out.println("The number you wanted to read is:" +line[input[1]]);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return isSaved;
        }

        fileWork.printList(list);
        fileWork.saveList(isSaved);

        return isSaved;
    }

    public boolean modifyNumber(List<String[]> list, boolean isSaved)
    {
        //Variables
        int[] input = new int[3];
        String[] line;

        Scanner s = new Scanner(System.in);
        FileWork fileWork = new FileWork();


        fileWork.printList(list);
        //User input
        try
        {
            while (true)
            {
                System.out.print("Enter a line to modify a number from: ");
                input[0] = s.nextInt();
                System.out.print("Enter the index of the number in that line: ");
                input[1] = s.nextInt();
                System.out.print("Enter the new replacement for that number:");
                input[2] = s.nextInt();
                System.out.println("---------------------------------------------------------------------------");
                if(fileWork.isInRange(list, input[0], input[1], false))
                {
                    break;
                }
                else
                {
                    System.out.println("You've entered values that are out of the file's line size");
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //List work
        try
        {
            line = list.get(input[0]);
            line[input[1]] = Integer.toString(input[2]);
            list.set(input[0], line);
            for(String[] arr : list)
            {
                System.out.println(Arrays.toString(arr));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return isSaved;
        }

        fileWork.printList(list);
        fileWork.saveList(isSaved);
        return isSaved;
    }

    public boolean removeNumber(List<String[]> list, boolean isSaved)
    {
        //Variables
        Integer i;
        String[] line;
        String[] newLine;
        int[] input = new int[2];

        Scanner s = new Scanner(System.in);
        FileWork fileWork = new FileWork();

        fileWork.printList(list);
        //User input
        try
        {
            while (true)
            {
                System.out.print("Enter a line where you want to remove a number from:");
                input[0] = s.nextInt();
                System.out.print("Enter the index of the number that you wish to remove:");
                input[1] = s.nextInt();
                System.out.println("---------------------------------------------------------------------------");
                if(fileWork.isInRange(list, input[0], input[1], false))
                {
                    break;
                }
                else
                {
                    System.out.println("You've entered values that are out of the file's line size");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //List work
        line = list.get(input[0]);
        newLine = new String[line.length -1];

        for(i = 0; i < input[1]; i++)
        {
            newLine[i] = line[i];
        }

        for (i = input[1]; i< line.length -1; i++)
        {
            newLine[i] = line[i +1];
        }

        list.set(input[0], newLine);
        fileWork.printList(list);
        fileWork.saveList(isSaved);

        return isSaved;
    }
}
