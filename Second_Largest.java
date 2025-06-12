import java.util.*;

class Second_Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of array:");
        int size = sc.nextInt();

        if (size < 2) {
            System.out.println("Array should have at least two elements");
            return;
        }

        System.out.println("Enter Array elements:");
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        secondLargest(arr);
        sc.close();
    }

    public static void secondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array should have at least two elements");
            return;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("No second largest element found");
        } else {
            System.out.println("The second largest element is: " + second);
        }
    }
    
}