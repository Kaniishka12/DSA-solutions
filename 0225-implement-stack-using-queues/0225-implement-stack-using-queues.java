import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public boolean empty() {  // Renamed from isEmpty() to empty()
        return q1.isEmpty();
    }

    // Push operation (O(1) time complexity)
    public void push(int data) {
        q1.add(data);
    }

    // Pop operation (O(n) time complexity)
    public int pop() {
        if (empty()) {
            System.out.println("empty stack");
            return -1;
        }

        // Move all elements except the last to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // The last element is the top of the stack
        int top = q1.remove();

        // Swap q1 and q2 so q1 remains the main queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Top operation (O(n) time complexity)
    public int top() {
        if (empty()) {
            System.out.println("empty stack");
            return -1;
        }

        // Move all elements except the last to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // The last element is the top of the stack
        int top = q1.peek();
        q2.add(q1.remove());

        // Swap q1 and q2 so q1 remains the main queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }
}
