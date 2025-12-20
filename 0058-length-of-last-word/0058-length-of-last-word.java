class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int len = 0;
        while(s.charAt(i) == ' '){
            i--;
        }
        // now pointer 'i' is pointing to the last character of the last word of the String
        while(i >= 0 && s.charAt(i) != ' '){
            len++;
            i--;
        }
        return len;
    }
}