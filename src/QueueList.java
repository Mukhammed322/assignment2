public class QueueList implements IntQueue {
    private IntList data = new IntList();

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public void add(int item) {
        data.addLast(item);
    }

    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Queue is empty");
        return data.getFirst();
    }

    @Override
    public int remove() {
        if (empty()) throw new RuntimeException("Queue is empty");
        return data.removeFirst();
    }
}