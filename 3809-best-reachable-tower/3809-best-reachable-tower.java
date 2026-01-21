class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int[] result = {-1, -1};
        int maxQuality = -1;
        
        int cx = center[0];
        int cy = center[1];
        
        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int quality = tower[2];
            
            // Calculate Manhattan distance
            int distance = Math.abs(x - cx) + Math.abs(y - cy);
            
            // Check if tower is reachable
            if (distance <= radius) {
                // Update result if this tower is better
                if (quality > maxQuality || 
                    (quality == maxQuality && isLexicographicallySmaller(x, y, result[0], result[1]))) {
                    result[0] = x;
                    result[1] = y;
                    maxQuality = quality;
                }
            }
        }
        
        return result;
    }
    
    // Check if (x1, y1) is lexicographically smaller than (x2, y2)
    private boolean isLexicographicallySmaller(int x1, int y1, int x2, int y2) {
        // If current best is [-1, -1], any valid coordinate is smaller
        if (x2 == -1) {
            return true;
        }
        
        // x1 < x2, or x1 == x2 and y1 < y2
        return x1 < x2 || (x1 == x2 && y1 < y2);
    }
}