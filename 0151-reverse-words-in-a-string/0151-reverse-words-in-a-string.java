class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String ans = "";
        s = new StringBuilder(s).reverse().toString();
        for(int i=0; i<n; i++){
            String word = "";

            while( i < n && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }
      word = new StringBuilder(word).reverse().toString();
      if(word.length() > 0){
        ans+=" "+word;
      }
        }
        return ans.substring(1);
    }
}