
import java.util.Arrays;
class Next_permutation {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4 , 5, 6};
        int pivot = -1;
        
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            System.out.println("Next permutation is: ");    
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            return;
        }
        for (int i = arr.length - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }
        int n = arr.length;
        int start = pivot + 1;
        int end = n - 1;    
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("Next permutation is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}
