public class StackArray implements IntStack {
    private IntArray data = new IntArray();

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return data.get(data.size() - 1);
    }

    @Override
    public int pop() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return data.remove(data.size() - 1);
    }

    @Override
    public void push(int item) {
        data.add(item);
    }
}