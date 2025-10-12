class Solution {
    public boolean scoreBalance(String s) {
        for(int i=1; i<s.length(); i++){
            String first = s.substring(0,i);
            String second =  s.substring(i);
        // now calculate scores of both first and second string and check if they are equal
        int firstScore = 0;
        int secondScore = 0;
        for(int j=0; j<first.length(); j++){
            firstScore += first.charAt(j)-'a'+1;
        }
         for(int k=0; k<second.length(); k++){
            secondScore += second.charAt(k)-'a'+1;
         }
         if(firstScore == secondScore) return true;
        }
        return false;
    }
}