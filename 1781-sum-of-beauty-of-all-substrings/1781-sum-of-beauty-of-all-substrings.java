class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                int cnt = cntBeauty(s.substring(i,j));
                if(cnt != -1){
                    ans += cnt;
                }
            }
        }
        return ans;
    }
    // function to count beauty of a string
    int cntBeauty(String str){
      int arr[] = new int[26];
      Arrays.fill(arr,0);
      for(int i=0; i<str.length(); i++){
        int index = str.charAt(i)-'a';
        arr[index]++;
      }
      // now get the max and min frequency
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      for(int i=0; i<arr.length; i++){
          if(arr[i] != 0){
        max = Math.max(max, arr[i]);
        min = Math.min(min, arr[i]);
          }
      }
      int diff = -1;
      // now check if there is valid max and min
      if((max != Integer.MAX_VALUE && min != Integer.MIN_VALUE) && (max != min)){
         diff = max-min;
      }
      return diff;
    }
}