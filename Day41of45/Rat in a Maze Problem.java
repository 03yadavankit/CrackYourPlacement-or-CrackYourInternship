package Day41of45;

class Solution {
    public void f(int i,int j, int[][]mat,String s,ArrayList<String> al,int[][]vis){
        if(i==mat.length-1&&j==mat.length-1) {
            al.add(s);
            return;
        }
        else vis[i][j]=1;
        //up
        if(i-1>=0&&vis[i-1][j]==0&&mat[i-1][j]==1){
            f(i-1,j,mat,s+"U",al,vis);
        }
        //down
        if(i+1<mat.length&&vis[i+1][j]==0&&mat[i+1][j]==1){
            f(i+1,j,mat,s+"D",al,vis);
        }
        //left
        if(j-1>=0&&vis[i][j-1]==0&&mat[i][j-1]==1){
            f(i,j-1,mat,s+"L",al,vis);
        }
        //right
        if(j+1<mat.length&&vis[i][j+1]==0&&mat[i][j+1]==1){
            f(i,j+1,mat,s+"R",al,vis);
        }
        vis[i][j]=0;
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int m=mat.length;
        int n =mat[0].length;
        String s = "";
        ArrayList<String> al=new ArrayList<>();
        //edge cases where start or end points are blocked
        if (mat == null || mat.length == 0 || mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
            al.add("-1");
            return al;
        }
        int[][]vis=new int[m][n];
        f(0,0,mat,s,al,vis);
        if(al.size()==0){
             al.add("-1");
        }
        return al;
    }
}
