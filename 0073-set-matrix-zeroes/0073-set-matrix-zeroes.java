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
   
        // xxxxxxxxxxxxxxxxxxxxxxx---Better Sol(1)---xxxxxxxxxxxxxxxxxxxxx
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
    boolean row[] = new boolean[matrix.length];
    boolean col[] = new boolean[matrix[0].length];

    for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[i][j] == 0){
                row[i] = true;
                col[j] = true;
            }
        }
    }
    // now traverse row and col and mark those row and col entirely '0' where true is present
    for(int i=0; i<row.length; i++){
       if(row[i]){
         for(int j=0; j<matrix[0].length; j++){
            matrix[i][j] = 0;
        }
       }
    }
           for(int i=0; i<col.length; i++){
       if(col[i]){
         for(int j=0; j<matrix.length; j++){
            matrix[j][i] = 0;
        }
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