class Solution {
    public String largestEven(String s) {
        if(s.length() == 0){
            return "";
        }
        // keep removing last character until it is '2' at the end
        StringBuilder sb = new StringBuilder(s);
        while(sb.charAt(sb.length()-1) != '2'){
            sb = sb.deleteCharAt(sb.length()-1);
            if(sb.length() == 0){
                return "";
            }
        }
        return sb.toString();
    }
}