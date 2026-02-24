class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> st = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            char val = t.charAt(i);

            if(!map.containsKey(ch) && st.contains(val)){
                return false;
            }
            else if(!map.containsKey(ch) && !st.contains(val)){
                map.put(ch,val);
                st.add(val);
            }
            else if(map.containsKey(ch)){
                if(map.get(ch) != val){
                    return false;
                }
                continue;
            }
            else{
                return false; //map.containsKey(ch) && !st.contains(val)
            }
        }
        return true;
    }
}