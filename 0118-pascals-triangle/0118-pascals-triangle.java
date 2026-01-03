class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            List<Integer> eachRow = new ArrayList<>();
            // there will be i elements in ith row 
            for(int el = 1; el <= i; el++){
                // NCR(row-1, col-1)
                int res = NCR(i-1,el-1);
                 eachRow.add(res);
            }
            ans.add(eachRow);
        }
        return ans;
    }
    // NCR()
    int NCR(int row, int col){
        int res = 1;
        for(int i=0; i<col; i++){
            res = res*(row-i);
            res = res/(i+1);
        }
        return res;
    }
}