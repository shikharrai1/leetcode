class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // first add positives in the list
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                list.add(nums[i]);
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < 0){
                list.add(nums[i]);
            }
        }
        int ans[] = new int[nums.length];
        int i =  0; // to iterate on +ve elements
        int j = list.size()/2; // to iterate on -ve elements
        int k = 0; // to iteraye over ans array
        while(k < ans.length){
            ans[k] = list.get(i);
            k++;
            ans[k] = list.get(j);
            k++;
            i++;
            j++;
        }
        return ans;
    }
}