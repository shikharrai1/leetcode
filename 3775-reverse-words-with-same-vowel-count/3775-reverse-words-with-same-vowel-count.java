class Solution {
    public String reverseWords(String s) {
         String[] words = s.split(" ");
         String firstWord = words[0];
         int vowelCnt = cntVowel(firstWord);
         for(int i=1; i<words.length; i++){
            String currStr = words[i];
            if(cntVowel(currStr) == vowelCnt){
                String reversed = new StringBuilder(currStr).reverse().toString();
                words[i] = reversed;
            }
         }
         String result = String.join(" ", words);
         return result;
    }
    //vowelCnt
    int cntVowel(String s){
                int vowelCnt = 0;
   for(int i=0; i<s.length(); i++){
    if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
            vowelCnt+=1;
    }
   }
   return vowelCnt;
    }
}