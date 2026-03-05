class Solution {
    public String reverseWords(String s) {
    s = new StringBuilder(s).reverse().toString();
    String ans = "";
    int n = s.length();
    for(int i=0; i<n; i++){
        String word = "";
        while(i < n && s.charAt(i) != ' '){
            word += s.charAt(i);
            i++;
        }

        if(word.length() > 0){
            ans += " "+ new StringBuilder(word).reverse().toString();
        }
    }
    return ans.substring(1);
    }
}