class Solution {
    public int minAllOneMultiple(int k) {

        // If k has factor 2 or 5, answer is impossible
        if (k % 2 == 0 || k % 5 == 0) return -1;

        Set<Integer> seen = new HashSet<>();

        int rem = 1 % k;
        int length = 1;

        while (rem != 0) {
            if (seen.contains(rem)) {
                return -1; // cycle detected
            }
            seen.add(rem);

            rem = (rem * 10 + 1) % k;
            length++;
        }

        return length;
    }
}