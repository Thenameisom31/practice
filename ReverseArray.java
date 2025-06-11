class ReverseArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        //int Start = 0;
        //int End = n - 1;
        // Reverse the array using two pointers
        // Approach 1: Using two pointers
       /*  for (int i = 0; i < n; i++) {
            if (Start < End) {
                int temp = arr[Start];
                arr[Start] = arr[End];
                arr[End] = temp;
                Start++;
                End--;
            }
        } */



        // Approach 2: Using a while loop
      /*   while (Start < End) {
            int temp = arr[Start];
            arr[Start] = arr[End];
            arr[End] = temp;
            Start++;
            End--;
        } */


        // Approach 3: Using a for loop
        for (int i = 0; i < n / 2; i++) {
            // Swap the elements at Start and End indices
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }


        // Print the reversed array
        System.out.println("Reversed Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}