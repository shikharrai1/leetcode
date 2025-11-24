class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num1 < 100 && num2 < 100) return 0;
        int cnt = 0;
        for(int i = num1; i<=num2; i++){
            String s = String.valueOf(i);
            for(int j = 1; j<s.length()-1; j++){
                if((s.charAt(j)-'0' > s.charAt(j-1)-'0' && 
                 s.charAt(j)-'0' > s.charAt(j+1)-'0') || (s.charAt(j)-'0' < s.charAt(j-1)-'0' && s.charAt(j)-'0' < s.charAt(j+1)-'0')){
                    cnt++;
                  }
            }
        }
        return cnt;
    }
}