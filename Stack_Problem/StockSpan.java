/* Stock span problem
Difficulty: MediumAccuracy: 43.56%Submissions: 242K+Points: 4
The stock span problem is a financial problem where we have a series of daily price quotes for a stock 
and we need to calculate the span of stock price for all days.
You are given an array arr[] representing daily stock prices, 
the stock span for the i-th day is the number of consecutive days up to day i (including day i itself) for which the price of the stock is less than or equal to the price on day i. 
Return the span of stock prices for each day in the given sequence.

Examples:

Input: arr[] = [100, 80, 90, 120]
Output: [1, 1, 2, 4]
Explanation: Traversing the given input span 100 is greater than equal to 100 and there are no more days behind it 
so the span is 1, 80 is greater than equal to 80 and smaller than 100 so the span is 1, 
90 is greater than equal to 90 and 80 so the span is 2, 120 is greater than 90, 
80 and 100 so the span is 4. So the output will be [1, 1, 2, 4]. */
package Stack_Problem;
import java.util.Stack;
public class StockSpan {

    /* static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        
        return span;
    } */

    static int[] calculateSpan(int arr[])
    {
        int n=arr.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int span=1;
            for(int j=i-1;j>=0&&arr[j]<=arr[i];j--){
                span++;
            }
            res[i]=span;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] prices = {100, 80, 90, 120};
        int n = prices.length;
        //int[] spans = calculateSpan(prices, n);
        int[] spans = calculateSpan(prices);
        
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}