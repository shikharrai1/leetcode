class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
//#########################App1(Gives TLE)######################
        // int n = damage.length;
        // int score = 0;
        // for(int i=0; i<n; i++){
        //     int currHp = hp;
        //     for(int j=i; j<n; j++){
        //         if(currHp-damage[j] >= requirement[j]){
        //             score += 1;
        //         }
        //         currHp = currHp-damage[j];
        //     }
        // }
        // return score;
//#########################App2############################
        int n = damage.length;
        long ans = 0;
        for(int i=1; i<n; i++){
            damage[i] = damage[i] + damage[i-1];
        }
        for(int i=1; i<n; i++){
            int boundary = find(damage,i,hp,requirement);
            ans += (i-boundary);
        }
        if(hp-damage[0] >= requirement[0]) ans++;
        return ans;
    }
    // find()
    int find(int damage[], int idx, int hp, int requirement[]){
        int low = 0;
        int high = idx;
        int ans = idx;
        while(low <= high){
            int mid = low + (high-low)/2;
            long dmg = damage[idx] - (mid > 0 ? damage[mid-1] : 0);
            if(hp - dmg >= requirement[idx]){
                ans = mid-1;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}