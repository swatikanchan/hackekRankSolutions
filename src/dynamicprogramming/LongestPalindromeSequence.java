package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Swati on 13-11-2016.
 */
public class LongestPalindromeSequence {
    public static void main(String[] args) {
        LongestPalindromeSequence lps = new LongestPalindromeSequence();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the input string:");
        String inputString = scan.nextLine();
        System.out.println(lps.printLongestPalindromeSequence(inputString));
    }
    public String printLongestPalindromeSequence(String inputString)
    {
        int first=0,start=0,last=inputString.length()-1;
        int end = last;
        int count=0,maxSize=0;
        StringBuilder tempLongestPalindrome = new StringBuilder();
        StringBuilder longestPalindrome = new StringBuilder();
        while(longestPalindrome.length()<last-first)
        {
            if(start<end)
            {
                if(inputString.charAt(start++)==inputString.charAt(end--))
                {
                    count++;
                    tempLongestPalindrome.append(inputString.charAt(start-1));
                }
                else
                {
                   // first++;
                    start=first;
                    //end=last;
                    count=0;
                    tempLongestPalindrome.setLength(0);
                }
            }
            else
            {
                if(maxSize<count)
                {
                    maxSize=count;
                    longestPalindrome=tempLongestPalindrome;
                }
                count=0;
                tempLongestPalindrome.setLength(0);
                last--;
                end=last;
            }
        }
        return new String(longestPalindrome);
    }
}
