class Solution {
    public int maximumSum(int[] nums) {
                List<Integer> r0 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        // Split numbers by remainder
        for (int num : nums) {
            int r = num % 3;
            if (r == 0) r0.add(num);
            else if (r == 1) r1.add(num);
            else r2.add(num);
        }

        // Sort descending
        Collections.sort(r0, Collections.reverseOrder());
        Collections.sort(r1, Collections.reverseOrder());
        Collections.sort(r2, Collections.reverseOrder());

        int ans = 0;

        // 0 + 0 + 0
        if (r0.size() >= 3) {
            ans = Math.max(ans, r0.get(0) + r0.get(1) + r0.get(2));
        }

        // 1 + 1 + 1
        if (r1.size() >= 3) {
            ans = Math.max(ans, r1.get(0) + r1.get(1) + r1.get(2));
        }

        // 2 + 2 + 2
        if (r2.size() >= 3) {
            ans = Math.max(ans, r2.get(0) + r2.get(1) + r2.get(2));
        }

        // 0 + 1 + 2
        if (r0.size() >= 1 && r1.size() >= 1 && r2.size() >= 1) {
            ans = Math.max(ans, r0.get(0) + r1.get(0) + r2.get(0));
        }

        return ans;
    }
}