public class QueueStack implements IntQueue {
    private StackArray in = new StackArray();
    private StackArray out = new StackArray();

    @Override
    public boolean empty() {
        return in.empty() && out.empty();
    }

    @Override
    public void add(int item) {
        in.push(item);
    }

    private void moveItems() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }

    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Queue is empty");
        moveItems();
        return out.peek();
    }

    @Override
    public int remove() {
        if (empty()) throw new RuntimeException("Queue is empty");
        moveItems();
        return out.pop();
    }
}