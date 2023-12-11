public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int middle = (array.length + 1) / 2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[array.length - middle];

        for (int i = 0; i < middle; i++) {
            leftHalf[i] = array[i];
        }
        for (int i = middle; i < array.length; i++) {
            rightHalf[i - middle] = array[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                array[mergedIndex++] = leftHalf[leftIndex++];
            } else {
                array[mergedIndex++] = rightHalf[rightIndex++];
            }
        }
        while (leftIndex < leftHalf.length) {
            array[mergedIndex++] = leftHalf[leftIndex++];
        }

        while (rightIndex < rightHalf.length) {
            array[mergedIndex++] = rightHalf[rightIndex++];
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 0, 2};
        mergeSort(array);
    }
}
