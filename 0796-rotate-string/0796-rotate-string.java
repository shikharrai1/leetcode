class Solution {
    public boolean rotateString(String s, String goal) {
//--------------------Brute Force---------------------------
        // Strings must be same length to be rotations of each other
        if (s.length() != goal.length()) {
            return false;
        }
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


//--------------------Brute Force---------------------------
                // Strings must be same length to be rotations of each other
        // if (s.length() != goal.length()) {
        //     return false;
        // }

        // Try all possible rotations of s
        // for (int i = 0; i < s.length(); i++) {
        //     String rotated = s.substring(i) + s.substring(0, i);
        //     if (rotated.equals(goal)) {
        //         // Return true if a match is found
        //         return true;  
        //     }
        // }

        // return false;
    }
}