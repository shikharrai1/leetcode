class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //----------------------App1-----------------------------
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(matrix[i][j] == target) return true;
        //     }
        // }
        // return false;
     //------------------------App2(Better Solution)-------------------------
       for(int i = 0; i<matrix.length; i++){
        boolean ans =  BS(matrix[i], target);
        if(ans){
            return true;
        }
       }
       return false;
    }
    // BS()
    boolean BS(int arr[], int target){
        int si = 0;
        int ei = arr.length-1;
        while(si <= ei){
            int mid = (si+ei)/2;
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