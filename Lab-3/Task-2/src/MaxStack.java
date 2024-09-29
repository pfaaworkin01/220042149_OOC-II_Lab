import java.util.Stack;

public class MaxStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int value) {
        mainStack.push(value);

        if(maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }
    }

    public int pop() {
        int value = mainStack.pop();

        if(value == maxStack.peek()) {
            maxStack.pop();
        }

        return value;
    }

    public int max() {
        return maxStack.peek();
    }

}
