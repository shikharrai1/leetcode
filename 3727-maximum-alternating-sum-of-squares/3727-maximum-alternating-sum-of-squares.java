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
        int sortedarr[] = new int[nums.length];
        int j = sortedarr.length-1;

        for(int el : arr){
               sortedarr[j] = el;
               j--;
        }
        // now sortedarr contains element in decreasing order
        long evenSum = 0;
        long oddSum = 0;
        // now we will first figure out size of array if it is even then there will be equal number of even and odd indices but if it's odd there will be even index one more than odd index
        if(sortedarr.length%2 == 0){
            for(int k = 0; k<sortedarr.length/2; k++){
                evenSum += sortedarr[k]*sortedarr[k];
            }
            for(int l = sortedarr.length/2; l<sortedarr.length; l++){
                oddSum += sortedarr[l]*sortedarr[l];
            }
            return evenSum - oddSum;
        }else{
                 for(int k = 0; k<sortedarr.length/2+1; k++){
                evenSum += sortedarr[k]*sortedarr[k];
            }
            for(int l = sortedarr.length/2+1; l<sortedarr.length; l++){
                oddSum += sortedarr[l]*sortedarr[l];
            }
            return evenSum - oddSum;
        }
    }
}