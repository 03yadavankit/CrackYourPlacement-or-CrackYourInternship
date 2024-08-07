package Day07of45;

class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        long mul=1,cntZero=0;
        
        long ans[]=new long[n];
        
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                cntZero++;
                continue;
            }
            mul = mul*nums[i];
        }
        if(cntZero>1){
            for(int i=0;i<n;i++){
                ans[i]=0;
            }
        }
        else if(cntZero==1){
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    ans[i]=mul;
                }else{
                    ans[i]= 0;
                }
            }
        }
        else{
            for(int i=0;i<n;i++){
                    ans[i]= (mul/nums[i]);
            }
        }
        
        return ans;
	} 
} 
