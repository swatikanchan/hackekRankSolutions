package dynamicprogramming;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Swati on 12-11-2016.
 */
public class PalindromeDetection {
    public static void main(String[] args) {
        PalindromeDetection pd = new PalindromeDetection();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a string");
        String inputString = scan.nextLine();
        System.out.println(pd.isPalindromeString(inputString)?"true":"false");

    }

    public boolean isPalindromeString(String inputStr)
    {
        String pattern = "[^a-zA-Z0-9]";
        String str = inputStr.replaceAll(pattern,"").toLowerCase();
        int start = 0, end = str.length()-1;
        boolean isPalindrome = true;
        while(start<end)
        {
            if(str.charAt(start++)!=str.charAt(end--)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
