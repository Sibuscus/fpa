package fpa.com.base;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CRUDops
{
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
            do
            {
                System.out.print("Enter a line to read from:");
                input[0] = s.nextInt();
                System.out.print("Enter the index of the number in that line:");
                input[1] = s.nextInt();
            }while (input[0] < 0 || input[0] > list.size() || input[1] < 0);
                System.out.println("---------------------------------------------------------------------------");
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

        //User input
        fileWork.printList(list);

        try
        {
            do
            {
                System.out.print("Enter a line to modify a number from: ");
                input[0] = s.nextInt();
                System.out.print("Enter the index of the number in that line: ");
                input[1] = s.nextInt();
                System.out.print("Enter the new replacement for that number:");
                input[2] = s.nextInt();
                System.out.println("---------------------------------------------------------------------------");
            }while (input[0] < 0 || input[0] >= list.size() || input[1] < 0);
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
        }

        fileWork.printList(list);
        fileWork.saveList(isSaved);
        return isSaved;
    }
}
