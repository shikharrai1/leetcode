class Solution {
    public int minLengthAfterRemovals(String s) {
        //-------------------------------App1-------------------------------------
        // int cntA = 0;
        // int cntB = 0;
        //     for(int i=0; i<s.length(); i++){
        //         if(s.charAt(i) == 'a') cntA++;
        //         else{
        //             cntB++;
        //         }
        //     }
        //     return Math.abs(cntA - cntB);

     //------------------------------------App2-------------------------------------
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(c == 'a' && !st.isEmpty() && st.peek() == 'b') st.pop();
            else if(c == 'b' && !st.isEmpty() &&  st.peek() == 'a'){
                st.pop();
            }
            else if(st.isEmpty()){
                st.push(c);
            }else{
                st.push(c);
            }
        }
        return st.size();
        } 
}