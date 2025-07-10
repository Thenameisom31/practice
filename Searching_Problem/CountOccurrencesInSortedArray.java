package Searching_Problem;

public class CountOccurrencesInSortedArray {

    public static int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, res = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, res = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 3, 4, 5 };
        int x = 2;
        int first = firstOccurrence(arr, x);
        int last = lastOccurrence(arr, x);
        int count = (last - first);
        System.out.println("Count of " + x + " in the array is: " + count);
    }
}
