public class IntList {
    private Node head;
    private int size;

    public IntList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item) {
        head = new Node(item, head);
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()) {
            addFirst(item);
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(item);
        size++;
    }

    public void add(int index, int item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
            return;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        prev.next = new Node(item, prev.next);
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    public int getFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.value;
    }

    public int getLast() {
        return get(size - 1);
    }

    public int set(int index, int item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        int oldVal = curr.value;
        curr.value = item;
        return oldVal;
    }

    public int indexOf(int item) {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.value == item) return i;
            curr = curr.next;
        }
        return -1;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public boolean removeItem(int item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public int removeFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        return sb.append("]").toString();
    }

    static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; this.next = null; }
        Node(int value, Node next) { this.value = value; this.next = next; }
    }

    public static void main(String[] args) {
        IntList list = new IntList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println("Before: " + list);
        list.reverse();
        System.out.println("After reverse: " + list);
    }
}