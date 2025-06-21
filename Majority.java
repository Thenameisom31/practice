package practice;
public class Majority {
    public static void main(String[] args)
    {
        int arr[] = {-1, 2, 3, 1, 1, 2, 2, 3, 3, 3, 3};
        int n = arr.length;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = -1;
        int candidate2 = -1;
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]==candidate1)
            {
                count1++;
            }
            else if(arr[i]==candidate2)
            {
                count2++;
            }
            else if(count1==0)
            {
                candidate1=arr[i];
                count1=1;
            }
            else if(count2==0)
            {
                candidate2=arr[i];
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        int count1Final = 0;
        int count2Final = 0;
        int arrResult[] = new int[2];
        for(int i=0;i<n;i++)
        {
            if(arr[i]==candidate1)
            {
                count1Final++;
            }
            if(arr[i]==candidate2)
            {
                count2Final++;
            }
        }
        if(count1Final > n/3)
        {
            arrResult[0] = candidate1;
        }
        if(count2Final > n/3)
        {
            arrResult[1] = candidate2;
        }
        if(arrResult[0]>arrResult[1])
        {
            int temp = arrResult[0];
            arrResult[0] = arrResult[1];
            arrResult[1] = temp;
        }
        System.out.println("Majority elements are: ");
        for(int i=0;i<2;i++)
        {
            if(arrResult[i] != 0)
            {
                System.out.print(arrResult[i] + " ");
            }
        }
        
    }
}
