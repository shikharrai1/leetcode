class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
            // now create an array of type List<Character> and at an index 'i' of this array we will keep the characters that has frequency 'i'
        List<Character>[] arr = new List[s.length()+1];
        // now traverse the keys of map and get the frequencies corresponding to each key
        for(char key : map.keySet()){
           int freq = map.get(key);
           if(arr[freq] == null){
               arr[freq] = new ArrayList<>();
           }
           arr[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        // now traverse the 'arr' from end since the characters with higher frequencies will be at the end as we have kept characters with frequency 'i' at an index 'i'
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] != null){
                for(char c : arr[i]){
                    for(int j=0; j<i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}