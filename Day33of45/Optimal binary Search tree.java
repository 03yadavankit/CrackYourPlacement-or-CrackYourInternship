package Day33of45;

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        Integer dp[][][] = new Integer[n][n][n+1];
        return fun(keys,freq,0,n-1,1,dp);
    }
    static int fun(int arr[],int freq[], int i, int j,int level,Integer dp[][][])
    {
        if(i>j)return 0;
        if(i==j) return level*freq[i];
        if(dp[i][j][level]!=null)
        {
            return dp[i][j][level];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++)
        {
            int left = fun(arr,freq,i,k-1,level+1,dp);
            int right = fun(arr,freq,k+1,j,level+1,dp);
            int frequency = freq[k]*level;  
            int total= left+right+frequency;
	        min=Math.min(total,min);
	    }
	    return dp[i][j][level]=min;
    }
}
