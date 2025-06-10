public class Move_Zero_ToEnd {
    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 5, 0, 3, 0, 4};
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 0) {
                arr[count] = arr[i];
                count++;    
            }
        }
        while (count < arr.length) {
            arr[count] = 0;
            count++;
            
        }
        System.out.println("Array after moving zeros to the end:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }


}