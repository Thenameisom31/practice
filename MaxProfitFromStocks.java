
/* Stock Buy and Sell - Multiple Transaction Allowed
Given an array prices[] of size n denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.

Examples:

Input: prices[] = {100, 180, 260, 310, 40, 535, 695}
Output: 865
Explanation: Buy the stock on day 0 and sell it on day 3 => 310 - 100 = 210
                       Buy the stock on day 4 and sell it on day 6 => 695 - 40 = 655
                       Maximum Profit  = 210 + 655 = 865 */


public class MaxProfitFromStocks {
    public static void main(String[] args)
    {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int n = prices.length;
        int min=0;
        int max=0;
        int profit=0;
        int i=1;
        while(i<n)
        {
            if(prices[i]>prices[i-1])
            {
                min = prices[i-1];
                max = prices[i];
                profit += max - min;
                i++;
            }
            else
            {
                i++;
            }
        }
        System.out.println("Maximum Profit: " + profit);
        

    }
        
}
