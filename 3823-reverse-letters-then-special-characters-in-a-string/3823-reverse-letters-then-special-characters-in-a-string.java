class Solution {
    public String reverseByType(String s) {
        List<Integer> cntChar = new ArrayList<>();
        List<Integer> cntSChar = new ArrayList<>();
        StringBuilder sbChar = new StringBuilder();
        StringBuilder sbSChar = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                sbChar.append(ch);
                cntChar.add(i);
            }else{
                sbSChar.append(ch);
                cntSChar.add(i);
            }
        }
        // now reverse the stringbuilders
        sbChar.reverse();
        sbSChar.reverse();
     
        char[] result = new char[s.length()];
        for(int i=0; i<sbChar.length(); i++){
            result[cntChar.get(i)] = sbChar.charAt(i);
        }
          for(int i=0; i<sbSChar.length(); i++){
             result[cntSChar.get(i)] = sbSChar.charAt(i);
        }
        return new String(result);
    }
}