class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(goal);

        if(sb1.compareTo(sb2) == 0) return true;

        for(int i=1; i<sb1.length(); i++){
            char ch = sb1.charAt(0);
            sb1.deleteCharAt(0);
            sb1.append(ch);
            if(sb1.compareTo(sb2) == 0) return true;
        }
        return false;
    }
}