class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
      int n = technique1.length;
    long sum = 0;

      Integer [] dif = new Integer[n];

      for(int i=0; i<n; i++){
        sum += technique2[i];
        dif[i] = technique1[i] - technique2[i];
      }

      Arrays.sort(dif, Collections.reverseOrder());
  
    // k tasks must be done using technique1
      for(int i=0; i<k; i++){
        sum += dif[i];
      }
    
    for(int i=k; i<n; i++){
        if(dif[i]>0){
            sum += dif[i];
        }else{
            break;
        }
    }
    return sum;
    }
}