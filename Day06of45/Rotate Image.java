package Day06of45;

class Solution {
    public void rotate(int[][] m) {
        int n=m.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==j) continue;
                int a=m[i][j];
                m[i][j]=m[j][i];
                m[j][i]=a;
            }
        }
        
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int a=m[j][i];
                m[j][i]=m[j][n-1-i];
                m[j][n-1-i]=a;
            }
        }
    }
}