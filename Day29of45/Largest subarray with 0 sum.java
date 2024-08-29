package Day29of45;

class GfG
{
    int maxLen(int arr[], int n)
    {
        return sol.len(arr,n,0);
        // Your code here
    }
}
class sol{
    static int len(int ar[], int n, int tar){
        int sum = 0, len=0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            sum=sum+ar[i];
            if(sum==tar) len=i+1;
            else{
                if(mp.containsKey(sum-tar)){
                    len = Math.max(len,(i-mp.get(sum-tar)));
                } else mp.put(sum,i);
            }
        }
        return len;
    }
}