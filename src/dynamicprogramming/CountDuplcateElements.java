package dynamicprogramming;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Swati on 16-10-2016.
 */
public class CountDuplcateElements {
    public static void main(String[] args) {
        System.out.println(CountDuplcateElements.countDuplicates(new int[]{1, 1, 1, 1, 1, 1}));
    }

    static int countDuplicates(int[] numbers) {
        Map<Integer, Integer> num = new HashMap<>();
        int count = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (num.containsKey(numbers[index]))
                num.put(numbers[index], num.get(numbers[index]) + 1);
            else
                num.put(numbers[index], 1);

        }
        Collection<Integer> values = num.values();
        for (Integer entry : values)
            if (entry > 1)
                count++;
        return count;
    }
}
