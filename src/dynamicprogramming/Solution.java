package dynamicprogramming;

/**
 * Created by Swati on 16-10-2016.
 */
import java.util.*;

/**
 * Created by Deepankit on 10/16/2016.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAllSubStringsInSortedOrderOneWay("abc");
    }


    private void findAllSubStringsInSortedOrderOneWay(String input) {
//        for (int i = 0; i < input.length(); i++) {
//            for (int j = i + 1; j <= input.length(); j++) {
//                System.out.println(input.substring(i, j));
//            }
//        }
        StringBuilder cur = new StringBuilder();
        for (int length = 1; length <= input.length(); length++)
            for (int pos = 0; pos + length <= input.length(); pos++)
                next(pos, length, cur, input);
        System.out.println(cur);
    }
    private void next(int pos, int reminder, StringBuilder cur, String input) {
        cur.append(input.charAt(pos));

        if (reminder == 1) {
            System.out.println(cur);
        } else {
            for (int i = pos + 1; i + reminder - 1 <= input.length(); i++)
                next(i, reminder - 1, cur, input);
        }
        cur.deleteCharAt(cur.length() - 1);
    }

}
