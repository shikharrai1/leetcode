class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int max[] = {-1,-1};
        int maxEle = Integer.MIN_VALUE;
        // find largest element in the entire matrix
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
               if(mat[i][j] > maxEle){
                max[0] = i;
                max[1] = j;
                maxEle = mat[i][j];
               }
            }
        }
        return max;
    }
}