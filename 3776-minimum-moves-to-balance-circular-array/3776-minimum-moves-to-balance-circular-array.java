class Solution {
    public long minMoves(int[] balance) {
        long moves = 0;
        int n = balance.length;
        int negIdx = -1;
        long sum = 0;
        for(int i=0; i<n; i++){
            sum += balance[i];
            if(balance[i] < 0) negIdx = i;
        }

                // base cases
        if(negIdx == -1) return 0;

        if(sum < 0) return -1;

        int disOfDonar = 1; //  distance b/w negIdx and it's left and right donars is 1 initially
        int leftDonarIdx = (negIdx-1+n)%n;
        int rightDonarIdx = (negIdx+1)%n;
        int val = -balance[negIdx]; // this is the exact amount needed to make balance[i] 0 which is smallest nonNegative
     
while(val > 0){
    // take from left
    if(balance[leftDonarIdx] > 0){
        int min = Math.min(balance[leftDonarIdx], val);
        val -= min;
        moves += min*disOfDonar;
        balance[leftDonarIdx] -= min;
    }
    if(val > 0 && balance[rightDonarIdx] > 0){
        int min = Math.min(balance[rightDonarIdx], val);
        val -= min;
        moves += min*disOfDonar;
        balance[rightDonarIdx] -= min;
    }
    leftDonarIdx = (leftDonarIdx-1+n)%n;
    rightDonarIdx = (rightDonarIdx+1)%n;
    disOfDonar+=1;
}
return moves;
    }
}