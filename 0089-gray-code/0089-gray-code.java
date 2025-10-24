class Solution {
    public List<Integer> grayCode(int n) {
                List<Integer> result = new ArrayList<>();
        result.add(0);  // base case: start with 0
        if (n == 0) return result;

        result.add(1);  // add 1 for n = 1

        // For each next bit size
        for (int i = 2; i <= n; i++) {
            int size = result.size();      // current size
            int addBit = 1 << (i - 1);     // bit to prefix (1 << (i-1))

            // reflect and add new codes
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) + addBit);
            }
        }

        return result;
    }
}