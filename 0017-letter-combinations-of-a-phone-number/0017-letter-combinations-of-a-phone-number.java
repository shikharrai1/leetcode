class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
      return  helper("",digits);
      
    }
    // helper
    public List<String> helper(String p, String up){
            // base case
            if(up.isEmpty()){
                List<String> ans = new ArrayList<>();
                ans.add(p);
                return ans;
            }
        List<String> finalAns = new ArrayList<>();
        int digit = up.charAt(0)-'0';
        
        if(digit < 2 || digit > 9) return finalAns;
        // get the range corresponding to every digit
        int start;
        int count;

       if(digit <= 6){
            start = (digit-2)*3;
            count = 3;
       }else if(digit == 7){
        start = (digit-2)*3;
        count = 4;
       }else if(digit == 8){
        start = (digit-2)*3+1;
        count = 3;
       }else{
         start = (digit-2)*3+1;
         count = 4;
       }

       for(int i=start; i < start+count; i++){
            char ch = (char)('a'+i);
        finalAns.addAll(helper(p+ch,up.substring(1)));
       }
       return finalAns;
    }
}