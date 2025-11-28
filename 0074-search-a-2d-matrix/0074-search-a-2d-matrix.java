class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = 0;
        while(row < matrix.length){
            if(matrix[row][col] == target) return true;
            if(col == matrix[0].length-1){
                col = 0;
                row++;
            }else{
                col++;
            }
        }
        return false;
    }
}