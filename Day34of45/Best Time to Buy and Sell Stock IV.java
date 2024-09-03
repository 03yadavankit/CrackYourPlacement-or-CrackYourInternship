package Day34of45;
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        int [][]prev = new int[2][k+1];
        int [][]cur = new int[2][k+1];
        int profit=0;

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int transaction =1;transaction<=k;transaction++){

                    if(buy==0){
                        profit = Math.max(0+prev[0][transaction],-prices[i]+prev[1][transaction]);
                    }
                    if(buy == 1){
                        profit = Math.max(0+prev[1][transaction],prices[i]+prev[0][transaction-1]);
                    }
                    cur[buy][transaction]=profit;
                }
                prev = (int [][])(cur.clone());
            }
        }

        return prev[0][k];
    }
    
}