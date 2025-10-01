/* 
Finding sum of digits of a number until sum becomes single digit

comments
Given an integer n, we need to repeatedly find the sum of its digits until the result becomes a single-digit number.

Examples:
Input: n = 1234 
Output: 1 
Explanation:
Step 1: 1 + 2 + 3 + 4 = 10 
Step 2: 1 + 0 = 1

Input: n = 5674
Output: 4
Explanation: 
Step 1: 5 + 6 + 7 + 4 = 22 
Step 2: 2 + 2 = 4 */
package Array_Problem;

import java.util.Scanner;

public class DigitSum {
    
    public static int DigitSum(int n)
    {
        int sum=0;
        while(n>0||sum>9)
        {
            if(n==0)
            {
                n=sum;
                sum=0;
            }
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a Number : ");
        n=sc.nextInt();
        System.out.println("Sum of digits until single digit is : "+DigitSum(n));
        sc.close();
    }
}
