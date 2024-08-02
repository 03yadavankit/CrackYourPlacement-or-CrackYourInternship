class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int k=0;
        Queue<Integer>que = new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    que.add(k);
                }
                k++;
            }
        }

        while(!que.isEmpty()) {
           int t= que.poll();

            for(int i =0;i<r;i++){
                matrix[i][t%c]=0;
            }
            for(int i =0;i<c;i++){
                matrix[t/c][i]=0;
            }
        }

    }
}
