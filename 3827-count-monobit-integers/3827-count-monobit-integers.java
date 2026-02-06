// class Solution {
//     public int countMonobit(int n) {
//         int count = 0;
//         for(int i=0; i<=n; i++){
//             String bin = Integer.toBinaryString(i);
//             // now figure out if 'bin' is monobit
//             boolean isMBit = true;
//             for(int j=0; j<bin.length()-1; j++){
//                 if(bin.charAt(j) != bin.charAt(j+1)){
//                     isMBit = false;
//                 }
//             }
//             if(isMBit == true){
//                 count++;
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int countMonobit(int n) {
        // Start with 1 to account for '0', which is always a Monobit
        int count = 1; 
        
        // We look for numbers of the form 1, 11, 111, 1111...
        // These are mathematically represented as (2^k) - 1
        long currentMonobit = 1; 
        while (currentMonobit <= n) {
            count++;
            // Shift left and add 1 to get the next 'all 1s' number
            // e.g., 1 (binary 1) -> 3 (binary 11) -> 7 (binary 111)
            currentMonobit = (currentMonobit << 1) | 1;
        }
        
        return count;
    }
}