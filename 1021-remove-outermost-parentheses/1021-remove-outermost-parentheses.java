class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int open = 0;
        int close = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }else{
                close++;
            }
            sb.append(s.charAt(i));
            if((open != 0 && close != 0) && open == close){
                //now sb is a primitive decomposition
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length()-1);
                // now assign this stringBuilder to String ans
                ans.append(sb);
                sb.setLength(0);
            }
        }
        return ans.toString();
    }
}