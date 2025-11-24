class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long maxSum = (long)(n)*(n+1)/2;
        long req = (maxSum - target);
        if(req < 0 || req%2 != 0){
             return new int[]{};
        }
        long negativeSum = req/2;
        boolean isNegative[] = new boolean[n+1];
        int ans[] = new int[n];
        for(int i = n; i>=1; i--){
            if(negativeSum >= i){
                isNegative[i] = true;
                negativeSum  = negativeSum  - i;
            }
        }
        if(negativeSum != 0) return new int[]{};
        // Now form ans array
        int j = 0;
        for(int i = n; i>=1; i--){
            if(isNegative[i] == true){
                ans[j] = -i;
                j++;
            }
        }
        for(int i = 1; i<=n; i++){
            if(isNegative[i] == false){
                ans[j] = i;
                j++;
            }
        }
        return ans;
    }
}