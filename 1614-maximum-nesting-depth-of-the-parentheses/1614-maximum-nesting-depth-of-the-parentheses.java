class Solution {
    public int maxDepth(String s) {
        int cnt = 0;
        int maxCnt = 0;
        for(int i=0;i< s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
                maxCnt = Math.max(cnt,maxCnt);
            }else if(s.charAt(i) == ')'){
                cnt--;
            }
            
        }
        return maxCnt;
    }
}