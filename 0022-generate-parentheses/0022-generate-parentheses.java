class Solution {
    // isValid
    public boolean isValid(String s){
     int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                count++;
            }else{ // if we are getting a closing parentheses ')' and we do not have any '(' then it is false 
                if(count == 0) return false;
                count--;
            }
    }
    return count == 0;
     }
    // Solve
    public void Solve(String curr, int n, List<String>result,int open,int close){
        //
        // base case
        if(curr.length() == 2*n){
            if(isValid(curr)){
                result.add(curr);
            }
            return;
        }
        if(open < n){
           
            Solve(curr+"(",n,result,open+1,close);
        }
        if(close < open){
           
            Solve(curr+")",n,result,open,close+1);
        }
     
           
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Solve("",n,result,0,0);
        return result;
    }
}