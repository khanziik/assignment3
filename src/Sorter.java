import java.util.Random;
public class Sorter {

    //selection Sort: find the minimum and swap it to the front
    public void basicSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // assume the first element is the smallest
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // found a smaller one
                }

            }
            //swap the found minimum element with the first elment
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //quick Sort:uses a pivot to split the array
    public void advancedSort(int[] arr) {
        quickSort(arr,0, arr.length -1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low <high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); //sort left
            quickSort(arr, pivotIndex+ 1, high); //sort right
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // chose the last element as pivot
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j]< pivot) {
                i++;
                //swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }
        //swap pivot into the right place
        int temp = arr[i + 1];
        arr[i +1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    //helper to generate an array with random numbers
    public int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i<size; i++) {
            arr[i] = rand.nextInt(1000); // numbers from 0 to 999
        }
        return arr;
    }
    //helper to print array
    public void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + "  ");
        }
        System.out.println();
    }
}