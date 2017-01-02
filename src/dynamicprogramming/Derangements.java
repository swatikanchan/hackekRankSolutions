package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Swati on 11-10-2016.
 */
public class Derangements {
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
            int[] derangementArray = computeDerangements(intInput);
            System.out.println(derangementArray[intInput]);
        }
    }

    private static int[] computeDerangements(int intInput) {
        int[] derangementArray = new int[intInput+1];
        derangementArray[0]=1;
        derangementArray[1]=0;
        derangementArray[2]=1;
        for(int index=3;index<derangementArray.length;index++)
        {
            derangementArray[index]=(index-1)*(derangementArray[index-1]+derangementArray[index-2]);
        }
        return derangementArray;
    }
}
