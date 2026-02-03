// class Solution {
//     public long nthSmallest(long n, int k) {
//         long arr[][] = new long[50][50];
//         for(int i=0; i<50; i++){
//             arr[i][0] = 1;
//             for(int j=1; j<=i; j++){
//                 arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
//             }
//         }
//         long ans = 0;
//         for(int i=49; i>=0; i--){
//             long cnt = 0;
//             if(k <= i){
//                 cnt += arr[i][k];
//             }
//             if(n > cnt){
//                 ans = ans/(1L << i);
//                 n = n-cnt;
//                 k--;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public long nthSmallest(long n, int k) {
        // DP table to store Binomial Coefficients C(m, r)
        // arr[i][j] stores "i choose j"
        long[][] arr = new long[50][50];
        
        // Fill DP table (Pascal's Triangle)
        for (int i = 0; i < 50; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        long ans = 0;
        // Iterate from the Most Significant Bit (49) down to 0
        for (int i = 49; i >= 0; i--) {
            long count0 = 0;
            
            // Calculate how many numbers can be formed if the bit at 'i' is 0.
            // This equals the ways to place 'k' ones in the remaining 'i' positions.
            if (k <= i) {
                count0 = arr[i][k];
            }

            // If n > count0, it means the target number cannot start with 0 at this position.
            // Therefore, the bit at 'i' must be 1.
            if (n > count0) {
                ans |= (1L << i); // FIXED: Set the bit using OR, do not divide.
                n -= count0;      // Skip the count of numbers that started with 0
                k--;              // We used one '1', so we need one less
            }
        }
        return ans;
    }
}