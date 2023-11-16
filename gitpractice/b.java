import java.util.Arrays;

public class b {
    public static void mergeSort(int[] array) {
        if (array == null) {
            return;
        }

        int n = array.length;

        for (int currentSize = 1; currentSize < n; currentSize *= 2) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currentSize) {
                int mid = Math.min(leftStart + currentSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currentSize - 1, n - 1);

                int leftSize = mid - leftStart + 1;
                int rightSize = rightEnd - mid;

                int[] left = new int[leftSize];
                int[] right = new int[rightSize];

                for (int i = 0; i < leftSize; i++) {
                    left[i] = array[leftStart + i];
                }

                for (int j = 0; j < rightSize; j++) {
                    right[j] = array[mid + 1 + j];
                }

                int i = 0, j = 0, k = leftStart;

                while (i < leftSize && j < rightSize) {
                    if (left[i] <= right[j]) {
                        array[k] = left[i];
                        i++;
                    } else {
                        array[k] = right[j];
                        j++;
                    }
                    k++;
                }

                while (i < leftSize) {
                    array[k] = left[i];
                    i++;
                    k++;
                }

                while (j < rightSize) {
                    array[k] = right[j];
                    j++;
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int i = 0;
        System.out.println("Given array is");

        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        mergeSort(arr);

        System.out.println("\n");
        System.out.println("Sorted array is");

        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
