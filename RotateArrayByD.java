package practice;
import java.util.Scanner;

public class RotateArrayByD {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arr[] = { 1, 2, 3, 4, 5, 6 };

        System.out.println("Enter a element to rotate by : ");
        int d = scanner.nextInt();
        int n = arr.length;
        d = d % n; // In case d is greater than n
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

        System.out.println("Rotated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }
    
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
