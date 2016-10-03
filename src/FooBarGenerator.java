/**
 * Created by Swati on 02-10-2016.
 */

import java.util.Scanner;

public class FooBarGenerator {

    private static final String SPACE = "";
    private static final String FOO = "foo";
    private static final String BAR = "bar";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String temp;
        String outValue=SPACE;
        for (int index = 1; index <= input; index++) {
            temp = SPACE + index;
            if (index % 3 == 0) {
                temp = FOO;
            }
            if (index % 5 == 0) {
                try{
                    Integer.parseInt(temp);
                    temp = BAR;
                }
                catch(Exception e)
                {
                    temp = temp + BAR;
                }
            }
            outValue = outValue + " " + temp;

        }
        System.out.println(outValue);
    }
}
