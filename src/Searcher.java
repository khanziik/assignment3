public class Searcher {
    //binary search: works only on sorted arrays
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid]==target) return mid; // found it
            if (arr[mid] < target) {
                left =mid + 1; //look in the right half
            } else {
                right = mid -1; // look in the left half
            }
        }
        return -1; //not found
    }
}