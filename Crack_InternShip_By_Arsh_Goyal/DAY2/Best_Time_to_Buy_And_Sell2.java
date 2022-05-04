public class Best_Time_to_Buy_And_Sell2 {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                profi+=prices[i]-prices[i-1];
            }
        }
        return profit;
        
    }
}
