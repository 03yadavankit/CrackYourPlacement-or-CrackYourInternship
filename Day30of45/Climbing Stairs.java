class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return n;
        if(n==2)
            return n;
        int preSumI=1;
        int preSumII=2;
        int sum=0;
        for(int i=2;i<n;i++){
            sum = preSumI+preSumII;
            preSumI=preSumII;
            preSumII=sum;
        }

        return preSumII;
    }
}