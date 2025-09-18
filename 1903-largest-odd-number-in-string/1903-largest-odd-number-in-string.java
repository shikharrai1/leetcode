class Solution {
    public String largestOddNumber(String num) {
        // traverse the string from right to left and stop when an odd number is encountered
        int rightMostOddIdx = -1;
        for(int i=num.length()-1; i>=0; i--){
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0){
                   rightMostOddIdx = i+1;
                   break;
            }
        }
        if(rightMostOddIdx != -1){
            return num.substring(0,rightMostOddIdx);
        }
        return "";
    }
}