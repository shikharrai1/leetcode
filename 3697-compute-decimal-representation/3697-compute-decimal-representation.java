class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> ans = new ArrayList<>();
        int currPower = 1;
        while(n > 0){
            int lastDigit = n%10;
            if(lastDigit != 0){
                ans.add(lastDigit*currPower);
            }
        
            n = n/10;
            currPower *= 10;
          
        }
        int [] arr = new int[ans.size()];
        int j = 0;
        for(int i = ans.size()-1; i>=0; i--){
            arr[j] = ans.get(i);
            j++;
        }
        return arr;
    }
}