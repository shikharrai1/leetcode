class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();

        int[] xPos = new int[n];
        int[] yPos = new int[n];

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'U'){
                yPos[i] = i == 0 ? 1 : yPos[i-1] + 1; 
                xPos[i] = i == 0 ? 0 : xPos[i-1];
            }else if(ch == 'D'){
                yPos[i] = i == 0 ? -1 : yPos[i-1] - 1; 
                xPos[i] = i == 0 ? 0 : xPos[i-1];
            }else if(ch == 'R'){
                yPos[i] = i == 0 ? 0 : yPos[i-1]; 
                xPos[i] = i == 0 ? 1 : xPos[i-1]+1;
            }else{
                yPos[i] = i == 0 ? 0 : yPos[i-1]; 
                xPos[i] = i == 0 ? -1 : xPos[i-1]-1;
            }
        }
        HashSet<List<Integer>> set = new HashSet<>();
        // now calculate shifts in xPos and yPos
        int xShift = 0;
        int yShift = 0;
        for(int i=k-1; i<n; i++){
            if(i == k-1){
                 xShift = xPos[k-1];
                 yShift = yPos[k-1];
            }else{
                xShift = xPos[i] - xPos[i-k];
                yShift = yPos[i] - yPos[i-k];
            }
            int finalX = xPos[n-1] - xShift;
            int finalY = yPos[n-1] - yShift;
            set.add(Arrays.asList(finalX,finalY));
        }
        return set.size();
    }
}