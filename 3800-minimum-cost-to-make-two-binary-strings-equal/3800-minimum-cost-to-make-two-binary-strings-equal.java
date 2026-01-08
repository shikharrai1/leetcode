class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        // first count 0-1 as type1 and 1-0 as type2
        int type1 = 0;
        int type2 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            if(s.charAt(i) == '0') type1++;
            else type2++;
        }
        long cost = 0;
        // count 'min' out of type1 and type2 because we can only swap 'min' pairs initially
        int pair = Math.min(type1, type2);
        // now compare cost of 2 flip with one swap
        long minCost1 = Math.min(2*flipCost, swapCost);
        
        cost += pair*minCost1;
        // remaining characters which are not arranged properly
        int rem = Math.abs(type1-type2);

        // Now remaining will be of same type
        // Now two possible operatins 
        //1. cross+swap it will solve 2 characters of same type
        //2. 2*flip 
        long minCost2 = Math.min((long)crossCost+swapCost, 2*flipCost);
        cost += (rem/2)*minCost2;

        if(rem%2 == 1){
            cost += flipCost;
        }
        return cost;
    }
}