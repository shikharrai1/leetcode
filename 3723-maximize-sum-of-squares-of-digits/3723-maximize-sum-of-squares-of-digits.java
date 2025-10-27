class Solution {
    public String maxSumOfSquares(int num, int sum) {
     if (sum > 9 * num) return ""; // Impossible to reach that digit sum

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum); // put the largest possible digit
            sb.append(digit);
            sum -= digit;
        }
        
        if (sum > 0) return ""; // still some sum left, not possible
        return sb.toString();
    }
}