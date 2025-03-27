import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStackTest {

    @Test
    public void testPush() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(3);
        maxStack.push(2);
        maxStack.push(5);
        maxStack.push(6);
        assertEquals(6, maxStack.max());
    }

    @Test
    public void testPop() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(3);
        maxStack.push(2);
        maxStack.push(5);
        maxStack.push(6);
        maxStack.pop();
        assertEquals(5, maxStack.max());
    }

    @Test
    public void testMax() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(3);
        maxStack.push(2);
        assertEquals(3, maxStack.max());
    }

}
