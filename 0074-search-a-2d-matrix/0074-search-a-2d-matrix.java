class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //--------------------App1------------------------
        // int row = 0;
        // int col = 0;
        // while(row < matrix.length){
        //     if(matrix[row][col] == target) return true;
        //     if(col == matrix[0].length-1){
        //         col = 0;
        //         row++;
        //     }else{
        //         col++;
        //     }
        // }
        // return false;

           //--------------------App2------------------------
           for(int i=0; i<matrix.length; i++){

            // now check if target lies in the row somewhere from 1st to last element
            if(matrix[i][0] <= target && matrix[i][matrix[0].length-1] >= target){
             
                return BS(matrix[i], target);
            }
           }
           return false;
    }
    // BS()
    boolean BS(int arr[], int target){
        int si = 0;
        int ei = arr.length-1;
        while(si <= ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return false;
    }
}