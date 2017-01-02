/**
 * Created by Swati on 05-10-2016.
 */
import java.util.Scanner;
public class CustomStackValidator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackImplementation stackImplementation = new StackImplementation();
        int numElements = scan.nextInt();
        for(int i=0;i<numElements;i++)
        {
            stackImplementation.push(scan.nextInt());
        }
        int index = stackImplementation.top;
        while(index>-1)
        {
            System.out.println(stackImplementation.peek(index--));
        }
        int deletedElement = stackImplementation.pop();
        System.out.println("Deleted element : "+deletedElement);
        index = stackImplementation.top;
        while(index>-1)
        {
            System.out.println(stackImplementation.peek(index--));
        }
        scan.close();

    }
}
