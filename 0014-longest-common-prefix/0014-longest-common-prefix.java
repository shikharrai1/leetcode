class Solution {
    public String longestCommonPrefix(String[] strs) {
        String smallestStr = strs[0];
        int smallestLen = strs[0].length();
        for(int i=1; i<strs.length; i++){
             if(strs[i].length() < smallestLen){
                   smallestLen = strs[i].length();
                   smallestStr = strs[i];
             }
        }
        for(int i=0; i<smallestStr.length(); i++){
            char ch = smallestStr.charAt(i);
            // now check whether all the strings contain this 'ch' at index 'i'
            boolean doesContains = true;
            for(int j=0; j<strs.length; j++){
                if(strs[j].charAt(i) != ch){
                    doesContains = false;
                }
            }
            if(!doesContains){
                return smallestStr.substring(0,i);
            }
        }
        return smallestStr;
    }
}