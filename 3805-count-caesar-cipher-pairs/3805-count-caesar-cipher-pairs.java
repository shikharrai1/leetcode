import java.util.*;

class Solution {
    public long countPairs(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        long count = 0;

        for (String word : words) {

            StringBuilder key = new StringBuilder();

            char base = word.charAt(0);

            for (int i = 0; i < word.length(); i++) {
                int diff = (word.charAt(i) - base + 26) % 26;
                key.append(diff).append(",");
            }

            String signature = key.toString();

            // If this signature already exists, add its count
            count += map.getOrDefault(signature, 0);

            // Increment count for this signature
            map.put(signature, map.getOrDefault(signature, 0) + 1);
        }

        return count;
    }
}
