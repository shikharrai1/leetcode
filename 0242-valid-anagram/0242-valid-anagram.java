class Solution {
    public boolean isAnagram(String s, String t) {
//----------------Brute Force-------------------------------------------
        // char[] chars1 = s.toCharArray();
        // Arrays.sort(chars1);
        // String ss = new String(chars1);

        // char[] chars2 = t.toCharArray();
        // Arrays.sort(chars2);
        // String st = new String(chars2);

        // return ss.equals(st);

//---------------------------------------------------------------
        if(s.length() != t.length()) return false;
        int n = s.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
         HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<n; i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0; i<n; i++){
             map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
        // now select one String out of 's' and 't' and then iterate over that string and mathch the frequency from both map1 and map2

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
      
            if(!map1.get(ch).equals(map2.getOrDefault(ch, 0))){
                 return false;
            } 
        }
        return true;
    }
}