public class ArrayIntersection {
    public static IntArray intersect(IntArray A, IntArray B) {
        IntArray result = new IntArray();
        for (int i = 0; i < A.size(); i++) {
            int currentVal = A.get(i);
            if (B.indexOf(currentVal) != -1 && result.indexOf(currentVal) == -1) {
                result.add(currentVal);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntArray A = new IntArray(new int[]{1, 2, 2, 3, 4});
        IntArray B = new IntArray(new int[]{2, 2, 4, 5});

        IntArray result = intersect(A, B);
        System.out.println("Intersection: " + result);
    }
}