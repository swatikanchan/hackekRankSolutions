package dynamicprogramming;

/**
 * Created by Swati on 16-10-2016.
 */
public class RearrangeWordToNextLargerWord {
    public static void main(String[] args) {
        System.out.println(arrangeWrd("gg"));
    }

    static String rearrangeWord(String word) {
        char[] charArr = word.toCharArray();
        boolean flag = false;
        char temp;
        for (int i = charArr.length - 1; i > 0; i--) {
            if (charArr[i] > charArr[i - 1]) {
                temp = charArr[i];
                charArr[i] = charArr[i - 1];
                charArr[i - 1] = temp;
                flag = true;
                break;
            }
        }
        if (!flag) {
            return "no answer";
        } else {
            return new String(charArr);
        }

    }

    static String arrangeWrd(String word) {
        int inputLength = word.length() - 1;
        while (inputLength > 0 && word.charAt(inputLength - 1) >= word.charAt(inputLength)) {
            inputLength--;
        }

        if (inputLength <= 0)

        {
            return "no answer";
        }

        int rearrangedWordLength = word.length() - 1;

        while (word.charAt(rearrangedWordLength) <= word.charAt(inputLength - 1))

        {
            rearrangedWordLength--;
        }
        char[] outputCharArray = word.toCharArray();
        char temp = outputCharArray[inputLength - 1];
        outputCharArray[inputLength - 1] = outputCharArray[rearrangedWordLength];
        outputCharArray[rearrangedWordLength] = temp;

        rearrangedWordLength = outputCharArray.length - 1;

        formOutput(inputLength, rearrangedWordLength, outputCharArray);

        return String.valueOf(outputCharArray);

    }

    private static void formOutput(int inputLength, int rearrangedWordLength, char[] outputCharArray) {
        char temp;
        while (inputLength < rearrangedWordLength)

        {
            temp = outputCharArray[inputLength];
            outputCharArray[inputLength] = outputCharArray[rearrangedWordLength];
            outputCharArray[rearrangedWordLength] = temp;
            inputLength++;
            rearrangedWordLength--;
        }
    }
}