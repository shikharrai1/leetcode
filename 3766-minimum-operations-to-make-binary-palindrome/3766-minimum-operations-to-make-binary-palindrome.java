class Solution {
    public int[] minOperations(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(num < 0){
                int dis = Math.abs(num);
                ans[i] = dis;
                continue;
            }
            String bin = Integer.toBinaryString(num);
            if(isPalindrome(bin)){
                ans[i] = 0;
                continue;
            }
            // now increase num and check for palindrome
            num = num + 1;
            while(!isPalindrome(Integer.toBinaryString(num))){
                num = num + 1;
            }
            int rightDis = num - nums[i];
            // now decrease num and check for palindrome
            num = nums[i] - 1;
            while(num >= 0 && !isPalindrome(Integer.toBinaryString(num))){
                num = num - 1;
            }
            int leftDis = nums[i] - num;
            int minDis = Math.min(rightDis, leftDis);
            ans[i] = minDis;
        }
        return ans;
    }
    // isPalindrome()
    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}