package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Swati on 11-10-2016.
 */
public class DerangementUsingRecursion {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a number:");
        int intInput = scan.nextInt();
        scan.close();
        if(intInput==0)
        {
            System.out.println("Number must be > 0");
        }
        else if(intInput==1)
        {
            System.out.println("0");
        }
        else if(intInput==2)
        {
            System.out.println("1");
        }
        else {
            int countDerangements = computeDerangements(intInput);
            System.out.println(countDerangements);
        }
    }

    private static int computeDerangements(int intInput) {
        if(intInput==0)
            return 0;
        else if(intInput==1)
            return 0;
        else if(intInput==2)
            return 1;
        return (intInput - 1) * (computeDerangements(intInput - 1) + computeDerangements(intInput - 2));
    }
}
