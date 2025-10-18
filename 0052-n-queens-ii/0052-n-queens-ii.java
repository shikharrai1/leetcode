class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int row = 0;
        boolean[][] board = new boolean[n][n];
        
        helper(row,n,board);
        return count;
    }
    public void helper(int row, int n, boolean[][] board){
        // base case
        if(row == n){
            count++;
            return;
        }
        // for a row traverse all the columns and see where it is safe to place queen
        for(int col = 0; col < n; col++){
            if(isSafe(board,row,col)){
                board[row][col] = true; // a 'Q' is placed at board[row][col]
                helper(row+1, n,board);
                // backtrack
                 board[row][col] = false; // remove 'Q' from board[row][col]
            }
        }
        

    }
     private static boolean isSafe(boolean[][] board, int row, int col) {
      //check vertical rows
      for(int r = 0; r<row; r++){
           if(board[r][col]){
            return false;
           }
      }
      //check right diagonal
      int maxRight = Math.min(board[0].length-col-1,row);
      for(int i=1; i <= maxRight; i++){
               if(board[row-i][col+i]){
                return false;
               }
      }
      //check left diagonal
      int maxLeft = Math.min(col,row);
      for(int i=1; i<=maxLeft; i++){
        if(board[row-i][col-i]){
            return false;
        }
      }
      return true;
    }
}