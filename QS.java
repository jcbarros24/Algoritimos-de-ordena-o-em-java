public class QS {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int middle = start + ((end - start) / 2);
        swap(array, middle, end);

        int pivot = array[end];
        int smallerIndex = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                smallerIndex++;
                swap(array, smallerIndex, j);
            }
        }

        swap(array, smallerIndex + 1, end);
        return smallerIndex + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 0, 2};
        quickSort(array);
    }
}
