
/**
 * Created by Swati on 05-10-2016.
 */
import java.util.ArrayList;
public class StackImplementation {
    ArrayList<Integer> stackArr;
    int top;
    boolean isEmpty;
    public StackImplementation() {
        top = -1;
        isEmpty=true;
        stackArr = new ArrayList<>();
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int getTop() {
        return top;
    }

    public void push(int element)
    {
        stackArr.add(++top,element);
        isEmpty = false;
    }
    public int pop()
    {
        int element = stackArr.remove(top);
        top--;
        if(top==-1) {
            isEmpty = true;
        }

        return element;
    }
    public int peek(int index)
    {
        return stackArr.get(index);
    }
}

