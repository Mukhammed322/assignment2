public class MinHeap implements IntQueue {
    private IntArray data;

    public MinHeap() {
        data = new IntArray();
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public void add(int item) {
        data.add(item);
        bubbleUp(data.size() - 1);
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (data.get(index) >= data.get(parentIndex)) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    @Override
    public int remove() {
        if (empty()) throw new RuntimeException("Heap is empty");
        int root = data.get(0);
        int lastItem = data.removeLast();

        if (!empty()) {
            data.set(0, lastItem);
            bubbleDown(0);
        }
        return root;
    }

    private void bubbleDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < data.size() && data.get(left) < data.get(smallest)) {
                smallest = left;
            }
            if (right < data.size() && data.get(right) < data.get(smallest)) {
                smallest = right;
            }
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Heap is empty");
        return data.get(0);
    }

    /// Сортировка любого массива по убыванию с помощью MinHeap
    public static void sortDescending(int[] arr) {
        MinHeap heap = new MinHeap();
        for (int x : arr) heap.add(x);

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.remove();
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 3, 8, 1, 20};
        sortDescending(arr);

        System.out.print("Sorted descending: ");
        for (int x : arr) System.out.print(x + " ");
    }
}