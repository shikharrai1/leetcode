class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
         long type1 = 0; // count of 0 in s, 1 in t
        long type2 = 0; // count of 1 in s, 0 in t
        
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == t.charAt(i)) continue;
            if (s.charAt(i) == '0') type1++;
            else type2++;
        }
        
        long cost = 0;
        
        // Cost to resolve one Type 1 and one Type 2
        // 1. Swap the mismatched characters in s (or t) -> swapCost
        // 2. Flip both characters -> 2 * flipCost
        long costDiff = Math.min(swapCost, 2L * flipCost);
        
        // Cost to resolve two Type 1s (or two Type 2s)
        // 1. Cross swap one pair + Swap -> crossCost + swapCost
        // 2. Flip both -> 2 * flipCost
        long costSame = Math.min((long)crossCost + swapCost, 2L * flipCost);
        
        // 1. Pair up Type 1 and Type 2 as much as possible
        long pairs = Math.min(type1, type2);
        cost += pairs * costDiff;
        
        // 2. Handle remaining of same type
        long rem = Math.abs(type1 - type2);
        cost += (rem / 2) * costSame;
        
        // 3. If one left, flip it
        if (rem % 2 == 1) {
            cost += flipCost;
        }
        
        return cost;
    }
}