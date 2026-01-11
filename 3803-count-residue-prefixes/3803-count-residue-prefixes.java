class Solution {
    public int residuePrefixes(String s) {
        Set<Character> st = new HashSet<>();
        int count = 0;
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            st.add(s.charAt(i));
            if(st.size() == sb.length()%3){
                count++;
            }
        }
        return count;
    }
}