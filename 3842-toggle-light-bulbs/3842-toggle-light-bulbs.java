class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int freq[] = new int[101];
        for(int i=0; i<bulbs.size(); i++){
            freq[bulbs.get(i)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<freq.length; i++){
            if((freq[i] % 2) != 0){
                ans.add(i);
            }
        }
        // Collections.sort(ans);
        return ans;
    }
}