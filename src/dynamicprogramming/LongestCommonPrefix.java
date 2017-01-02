package dynamicprogramming;

/**
 * Created by Swati on 10-10-2016.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] inputStringArray = {"GeawsForGeeks", "Geeks", "Geeka", "Geet"};
        int initialIndex = 0, endIndex = inputStringArray.length-1;
        String result = divideArray(initialIndex, endIndex, inputStringArray);
        System.out.println(result);

    }

    private static String divideArray(int initialIndex, int endIndex, String[] inputStringArray) {
        if (endIndex - initialIndex < 1) {
            return inputStringArray[initialIndex];
        } else {
            int middleIndex = initialIndex + (endIndex - initialIndex) / 2;
            String firstString = divideArray(initialIndex, middleIndex, inputStringArray);
            String secondString = divideArray(middleIndex+1, endIndex, inputStringArray);
            return (calculateLongestCommonPrefix(firstString, secondString));
        }
    }

    private static String calculateLongestCommonPrefix(String s, String s1) {
        char[] charFirstArray = s.toCharArray();
        char[] charSecondArray = s1.toCharArray();
        String longestCommonPrefix = "";
        int n = charFirstArray.length >= charSecondArray.length ? charSecondArray.length : charFirstArray.length;
        for (int i = 0; i < n; i++) {
            if (charFirstArray[i] == charSecondArray[i])
                longestCommonPrefix = longestCommonPrefix + charFirstArray[i];
            else
                break;
        }
        return longestCommonPrefix;
    }


}
