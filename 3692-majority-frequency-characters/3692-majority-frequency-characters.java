class Solution {
    public String majorityFrequencyGroup(String s) {
        int fre[] = new int[26];
        for(int i=0; i<s.length(); i++){
            fre[s.charAt(i)-'a']++;
        }
      int maxOccurence = 0;
      int maxOccurenceFre = -1;

      for(int f=1; f<=s.length(); f++){
            int currFreCount = 0;
            for(int i=0; i<fre.length; i++){
                
                if(fre[i] == f){
                    currFreCount++;
                }
            }
         if(currFreCount >= maxOccurence){
            maxOccurence = currFreCount;
            maxOccurenceFre = f;
         }
      }
      String ans = "";
        for(int i=0; i<fre.length; i++){
            if(fre[i] == maxOccurenceFre){
                 ans += (char)('a'+i); 
            }
        }
        return ans;
        }
    }
