public class IntArray {
    private int[] array;
    private int size;

    public IntArray() {
        array = new int[4];
        size = 0;
    }

    public IntArray(int[] items) {
        this();
        for (int item : items) add(item);
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            for (int i = 0; i < size; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void add(int item) {
        ensureCapacity();
        array[size++] = item;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public int set(int index, int item) {
        int old = get(index);
        array[index] = item;
        return old;
    }

    public int remove(int index) {
        int old = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return old;
    }

    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) return i;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(i == size - 1 ? "" : ", ");
        }
        return sb.append("]").toString();
    }
}
