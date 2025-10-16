class Solution {
    public int longestBalanced(String s) {
        //----------------------------------- Brute Force--------------------------------------
        // if(s.length() <= 1) return s.length();
        // int longest = 0;
        // for(int i=0; i<s.length(); i++){
        //     for(int j=i+1; j<=s.length(); j++){
        //         if(j-i <= longest) continue;
        //         String str = s.substring(i,j);
        //         HashMap<Character,Integer> hm = new HashMap<>();
        //         for(int k=0; k<str.length(); k++){
        //             hm.put(str.charAt(k),hm.getOrDefault(str.charAt(k),0)+1);
        //         }
        //         // check if freq of all the characters is same
        //         boolean isSame = true;
        //         int freq = -1;
        //         for(int val : hm.values()){
        //             if(freq == -1){
        //                 freq = val;
        //             }else if(val != freq){
        //                 isSame = false;
        //                 break;
        //             }
        //         }
        //         if(isSame){
        //             longest = Math.max(longest,str.length());
        //         }
        //     } 
        // }
        // return longest; 
     int n = s.length();
        if (n <= 1) return n;

        int longest = 0;

        // Fix the starting index
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> hm = new HashMap<>();

            // Expand the end index
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);

                // Check if all frequencies are same
                if (areFrequenciesEqual(hm)) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }

    // Helper function to check if all values in HashMap are equal
    private boolean areFrequenciesEqual(HashMap<Character, Integer> hm) {
        int freq = -1;
        for (int val : hm.values()) {
            if (freq == -1) freq = val;
            else if (val != freq) return false;
        }
        return true;
    }
}