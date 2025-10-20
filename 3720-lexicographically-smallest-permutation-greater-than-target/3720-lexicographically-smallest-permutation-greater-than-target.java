class Solution {
   public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder prefix = new StringBuilder();

        // Try to build prefix matching target as far as possible
        int i = 0;
        for (; i < n; i++) {
            int ch = target.charAt(i) - 'a';

            // If we can place target[i], prefer to place it (keep equality so far)
            if (freq[ch] > 0) {
                freq[ch]--;
                prefix.append((char) (ch + 'a'));
                continue;
            }

            // Otherwise try to place the next greater char at position i
            boolean placedGreater = false;
            for (int next = ch + 1; next < 26; next++) {
                if (freq[next] > 0) {
                    // place this greater character and fill the rest with smallest available
                    freq[next]--;
                    prefix.append((char) (next + 'a'));

                    StringBuilder rest = new StringBuilder();
                    for (int c = 0; c < 26; c++) {
                        while (freq[c]-- > 0) rest.append((char) (c + 'a'));
                    }
                    return prefix.toString() + rest.toString();
                }
            }

            // Can't place target[i] (not available) nor any greater char at i.
            // Need to backtrack to earlier positions.
            int back = i - 1;
            while (back >= 0) {
                // Restore the char we had placed at 'back'
                int restored = prefix.charAt(back) - 'a';
                freq[restored]++;

                // try to increase that position
                for (int next = restored + 1; next < 26; next++) {
                    if (freq[next] > 0) {
                        // build answer: keep prefix up to back-1, place 'next', then smallest suffix
                        StringBuilder ans = new StringBuilder();
                        ans.append(prefix.substring(0, back));
                        freq[next]--;
                        ans.append((char) (next + 'a'));

                        StringBuilder rest = new StringBuilder();
                        for (int c = 0; c < 26; c++) {
                            while (freq[c]-- > 0) rest.append((char) (c + 'a'));
                        }
                        return ans.toString() + rest.toString();
                    }
                }

                // move back further
                back--;
            }

            // If backtracking fails, no permutation > target
            return "";
        }

        // If we matched entire target (i == n), we still need to attempt backtracking
        // to increase an earlier position (example: s="ab", target="ab" -> "ba")
        int back = n - 1;
        while (back >= 0) {
            int restored = prefix.charAt(back) - 'a';
            freq[restored]++;

            for (int next = restored + 1; next < 26; next++) {
                if (freq[next] > 0) {
                    StringBuilder ans = new StringBuilder();
                    ans.append(prefix.substring(0, back));
                    freq[next]--;
                    ans.append((char) (next + 'a'));

                    StringBuilder rest = new StringBuilder();
                    for (int c = 0; c < 26; c++) {
                        while (freq[c]-- > 0) rest.append((char) (c + 'a'));
                    }
                    return ans.toString() + rest.toString();
                }
            }
            back--;
        }

        // Nothing found
        return "";
    }
}