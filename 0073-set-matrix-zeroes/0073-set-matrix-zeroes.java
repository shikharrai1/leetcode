class Solution {
    public void setZeroes(int[][] matrix) {
        //xxxxxxxxxxxxxxxxBrute Force Solxxxxxxxxxxxxxxxxxxxxxxxxx
       
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(matrix[i][j] == 0){
             
        //             markRow(i,matrix);
        //             markCol(j,matrix);
        //         }
        //     } 
        // }
        // // now traverse the entire matrix and convert -1 into 0
   
        //  for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(matrix[i][j] == -1){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
   
        // xxxxxxxxxxxxxxxxxxxxxxx---Better Sol(1 Me)---xxxxxxxxxxxxxxxxxxxxx
        // List<int[]> list = new ArrayList<>();
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(matrix[i][j]  == 0){
        //             list.add(new int[]{i,j});
        //         }
        //     }
        // }
        // for(int i = 0; i<list.size(); i++){
        //     int row = list.get(i)[0];
        //     for(int j = 0;  j<matrix[0].length; j++){
        //         matrix[row][j] = 0;
        //     }
        //     int col = list.get(i)[1];
        //     for(int j = 0; j<matrix.length; j++){
        //         matrix[j][col] = 0;
        //     }
        // }
            //******************************************Better Sol(2)************* */
    // boolean row[] = new boolean[matrix.length];
    // boolean col[] = new boolean[matrix[0].length];

    // for(int i=0; i<matrix.length; i++){
    //     for(int j=0; j<matrix[0].length; j++){
    //         if(matrix[i][j] == 0){
    //             row[i] = true;
    //             col[j] = true;
    //         }
    //     }
    // }
    // // now traverse the matrix again and mark those cell 0 for which either row is true or col is true
    // for(int i=0; i<matrix.length; i++){
    //       for(int j=0; j<matrix[0].length; j++){
    //         if(row[i] || col[j]){
    //             matrix[i][j] = 0;
    //         }
    //       }
    // }
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Optimal Sol&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    // int[] row[n] -> matrix[..][0]
    // int[] col[m] -> matrix[0][..]
    int col0 = 1;
    for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[i][j] == 0){
                // mark the i-th row
                matrix[i][0] = 0;
                // mark the j-th column
               if(j != 0){
                 matrix[0][j] = 0;
               }else{
                col0 = 0;
               }
            }
        }
    }

    // Now iterate the matrix from (1,1) to (n-1,m-1) ignoring 0th row and 0th col for every cell (i,j) check if matrix[i][0] is 0 or matrix[0][j] is 0 if yes then mark matrix[i][j] = 0;
    for(int i=1; i<matrix.length; i++){
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[i][0] == 0 || matrix[0][j] == 0){
                matrix[i][j] = 0;
            }
        }
    }
    // Now 0th row
    for(int i=matrix[0].length-1; i>=1; i--){
          if(matrix[0][0] == 0 || matrix[0][i] == 0){
            matrix[0][i] = 0;
          }
    }
    // Now 0th column
    for(int i=0; i<matrix.length; i++){
        if(matrix[i][0] == 0 || col0 == 0){
            matrix[i][0] = 0;
        }
    }
    }
    // markRow()
    // void markRow(int row, int[][] matrix){
    //     for(int i=0; i<matrix[0].length; i++){
    //         if(matrix[row][i] != 0){
    //             matrix[row][i] = -1;
    //         }
    //     }
    // }
    //  // markCol()
    // void markCol(int col, int[][] matrix){
    //     for(int i=0; i<matrix.length; i++){
    //         if(matrix[i][col] != 0){
    //             matrix[i][col] = -1;
    //         }
    //     }

}