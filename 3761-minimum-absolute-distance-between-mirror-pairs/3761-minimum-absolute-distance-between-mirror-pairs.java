class Solution {
    public int minMirrorPairDistance(int[] nums) {
        //-----------App1(Gives TLE)-----------------------
        // int ans = Integer.MAX_VALUE;

        // for(int i=0; i<nums.length; i++){
        //     // Reverse nums[i]
        //     String reversedStr = new StringBuilder(String.valueOf(nums[i])).reverse().toString();
        //     int reversedNum = Integer.parseInt(reversedStr);

        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j] == reversedNum){
        //             int dist = j-i;
        //             ans = Math.min(ans, dist);
        //         }
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? -1 : ans;
//--------------------------------------App2--------------------------
int min = Integer.MAX_VALUE;
HashMap<Integer,Integer> hm = new HashMap<>();
for(int i=0; i<nums.length; i++){
    if(hm.containsKey(nums[i])){
        int j = hm.get(nums[i]);
        int dis = i-j;
           min = Math.min(min,dis);
    }
    String reversedStr = new StringBuilder(String.valueOf(nums[i])).reverse().toString();
    int reversedNum = reversedStr == "" ? 0 : Integer.parseInt(reversedStr);
    hm.put(reversedNum, i);
}
return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}