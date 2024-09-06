package Day37of45;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        char balloon[] = colors.toCharArray();
        int minTime = 0,j=0;
        for(int i=1;i<balloon.length;i++){
            if(balloon[j]==balloon[i]){
                if(neededTime[i]<neededTime[j]){
                    minTime+=neededTime[i];
                }else{
                    minTime+=neededTime[j];
                    j=i;
                }
            }else{
                j=i;
            }
        }
        return minTime;
    }
}