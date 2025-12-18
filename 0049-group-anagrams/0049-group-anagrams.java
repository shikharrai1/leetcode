class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
           Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert string to char array
            char[] arr = s.toCharArray();
            // Sort characters
            Arrays.sort(arr);
            // Create key
            String key = new String(arr);

            // Add to map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}