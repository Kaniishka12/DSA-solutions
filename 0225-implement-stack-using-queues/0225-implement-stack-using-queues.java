import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    // Constructor to initialize the queues
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation (adds element to the active queue)
    public void push(int data) {
        if (!q1.isEmpty()) {
            q1.add(data);
        } else {
            q2.add(data);
        }
    }

    // Pop operation (removes and returns the last pushed element)
    public int pop() {
        if (empty()) {
            return -1; // Stack underflow case
        }

        int top = -1;
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                if (q1.isEmpty()) break;
                q2.add(top);
            }
        } else {
            while (!q2.isEmpty()) {
                top = q2.remove();
                if (q2.isEmpty()) break;
                q1.add(top);
            }
        }

        return top;
    }

    // Returns the top element without removing it
    public int top() {
        if (empty()) {
            return -1;
        }

        int top = -1;
        if (!q1.isEmpty()) {
            for (int i : q1) {
                top = i;
            }
        } else {
            for (int i : q2) {
                top = i;
            }
        }
        return top;
    }

    // Checks if the stack is empty
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
