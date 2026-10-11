import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTasks {

    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;
        
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        int maxVal = 10000;
        int[] count = new int[maxVal + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= maxVal; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void bucketSort(double[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        List<List<Double>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double val : arr) {
            int index = (int) (val * n);
            if (index == n) index = n - 1; 
            buckets.get(index).add(val);
        }

        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        int idx = 0;
        for (List<Double> bucket : buckets) {
            for (double val : bucket) {
                arr[idx++] = val;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Задача 1");
        int[] orders1 = {314159, 271828, 123456};
        radixSort(orders1);
        System.out.println("Тест 1: " + Arrays.toString(orders1)); 

        int[] orders2 = {90, 9, 900};
        radixSort(orders2);
        System.out.println("Тест 2: " + Arrays.toString(orders2)); 

        System.out.println("\nЗадача 2");
        int[] goods1 = {10000, 0, 25, 25};
        countingSort(goods1);
        System.out.println("Тест 1: " + Arrays.toString(goods1)); 

        int[] goods2 = {7, 2, 7, 4};
        countingSort(goods2);
        System.out.println("Тест 2: " + Arrays.toString(goods2)); 

        System.out.println("\nЗадача 3");
        double[] dist1 = {0.42, 0.11, 0.87, 0.35};
        bucketSort(dist1);
        System.out.println("Тест 1: " + Arrays.toString(dist1)); 

        double[] dist2 = {0.01, 0.99, 0.50};
        bucketSort(dist2);
        System.out.println("Тест 2: " + Arrays.toString(dist2)); 
    }
}
// Output:

// Задача 1
// Тест 1: [123456, 271828, 314159]
// Тест 2: [9, 90, 900]

// Задача 2
// Тест 1: [0, 25, 25, 10000]
// Тест 2: [2, 4, 7, 7]

// Задача 3
// Тест 1: [0.11, 0.35, 0.42, 0.87]
// Тест 2: [0.01, 0.5, 0.99]