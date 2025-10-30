class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        for(int num : nums){
            arr[i] = Math.abs(num);
             i++;
        }
        // now since arr contains elements which are non negative now we will sort them 
        Arrays.sort(arr);
    
        // now sortedarr contains element in decreasing order
        long evenSum = 0;
        long oddSum = 0;
        int n = arr.length;
        // now we will first figure out size of array if it is even then there will be equal number of even and odd indices but if it's odd there will be even index one more than odd index
        if(n%2 == 0){
            for(int k = n-1; k>=n/2; k--){
                evenSum += arr[k]*arr[k];
            }
            for(int l = n/2-1; l>=0; l--){
                oddSum += arr[l]*arr[l];
            }
            return evenSum - oddSum;
        }else{
                 for(int k = n-1; k>=n/2; k--){
                evenSum += arr[k]*arr[k];
            }
            for(int l = n/2-1; l>=0; l--){
                oddSum += arr[l]*arr[l];
            }
            return evenSum - oddSum;
        }
    }
}