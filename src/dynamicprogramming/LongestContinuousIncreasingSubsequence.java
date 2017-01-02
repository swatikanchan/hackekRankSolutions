package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swati on 10-10-2016.
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] intInputArray = {10,22,9,33,21,50,41,60,80};
        String output=intInputArray[0]+"";
        String tempOutput = output;
        List<Integer> outputList = computeLongestIncreasingSubsequence(intInputArray);

        for(int i=0;i<outputList.size();i++)
        {
            System.out.print(outputList.get(i)+" ");
        }
    }

    private static List<Integer> computeLongestIncreasingSubsequence(int[] intInputArray) {
        List<Integer> outputArray = new ArrayList<>();
        outputArray.add(intInputArray[0]);
        List<Integer> tempArray = new ArrayList<>();
        tempArray.add(intInputArray[0]);
        for(int i=1;i<intInputArray.length;i++)
        {
            if(intInputArray[i]>intInputArray[i-1])
            {
                tempArray.add(intInputArray[i]);
            }
            else
            {
                if(tempArray.size()>=outputArray.size())
                {
                    outputArray.clear();
                    outputArray.addAll(tempArray);
                }
                tempArray.clear();
                tempArray.add(intInputArray[i]);
            }
        }
        if(tempArray.size()>=outputArray.size())
        {
            outputArray.clear();
            outputArray.addAll(tempArray);
        }
        return outputArray;
    }
}
