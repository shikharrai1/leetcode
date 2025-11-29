class Solution {
    public int[] findPeakGrid(int[][] mat) {
//-------------------------App1(Brute Force)------------------------- 
        // int max[] = {-1,-1};
        // int maxEle = Integer.MIN_VALUE;
        // // find largest element in the entire matrix
        // for(int i=0; i<mat.length; i++){
        //     for(int j=0; j<mat[0].length; j++){
        //        if(mat[i][j] > maxEle){
        //         max[0] = i;
        //         max[1] = j;
        //         maxEle = mat[i][j];
        //        }
        //     }
        // }
        // return max;
//-------------------------App1(Optimal Solution)------------------------- 
int m = mat[0].length;
int low = 0;
int high = m-1;

while(low <= high){
    int mid = (low+high)/2;
    // Now find row in this col(mid) where maximum element is present
    int row = findRow(mat,mid);
    // Now we have index of maximum element in col = mid index is (row,mid)
    // Now we have to see if element at index(row, mid) is greater than elements in it's left or right if Yes then this element is peak otherwise whichever element either left or right is greater search in that half
    int left = (mid-1 >= 0) ? mat[row][mid-1] : -1;
    int right = (mid+1 < m) ? mat[row][mid+1] : -1;
    // Now we have to see if current element is greater than it's left and right. We don't need to compare current element with top and bottom element because it is already greatest in the column
    if(mat[row][mid] > left && mat[row][mid] > right){
        return new int[]{row, mid};
    }else if(left > mat[row][mid]){
        // If left element is greater than current element then we assume that peak may lie in left half so eliminate right half
        high = mid-1;
    }else{
            // If right element is greater than current element then we assume that peak may lie in right half so eliminate left half
            low = mid+1;
    }
}
return new int[]{-1,-1};
    }
    //findRow()
    int findRow(int[][] mat, int col){
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int i = 0;
        for(; i<mat.length; i++){
            if(mat[i][col] > max){
                maxIdx = i;
                max = mat[i][col];
            }
        }
        return maxIdx;
    }
}