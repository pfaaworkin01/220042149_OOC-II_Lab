public class Main {
    public static void main(String[] args) {

        MaxStack stack1 = new MaxStack();
        stack1.push(3);
        stack1.push(2);
        stack1.push(6);
        stack1.push(5);
        stack1.push(40);
        stack1.push(10);
        System.out.println("Max after pushing 3, 2, 5, 6: " + stack1.max());

        stack1.pop();
        System.out.println("Max after popping: " + stack1.max());

        MaxStack stack2 = new MaxStack();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(2);
        System.out.println("Max after pushing 1, 2, 3: " + stack2.max());
        stack2.pop();
        System.out.println("Max after popping: " + stack2.max());

    }
}

