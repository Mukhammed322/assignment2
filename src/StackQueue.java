public class StackQueue implements IntStack {
    private QueueList q1 = new QueueList();
    private QueueList q2 = new QueueList();

    @Override
    public boolean empty() {
        return q1.empty();
    }

    @Override
    public void push(int item) {
        q2.add(item);
        while (!q1.empty()) {
            q2.add(q1.remove());
        }
        QueueList temp = q1;
        q1 = q2;
        q2 = temp;
    }

    @Override
    public int pop() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return q1.remove();
    }

    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return q1.peek();
    }
}