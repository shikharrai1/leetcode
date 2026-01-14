import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int maximumAND(int[] nums, int k, int m) {
        int ans = 0;
        
        // Iterate bits from 29 down to 0
        for (int b = 29; b >= 0; b--) {
            int candidate = ans | (1 << b);
            
            // Check if we can achieve 'candidate'
            // We need to find m numbers such that cost to make them match 'candidate' is minimized
            // and total cost <= k.
            
            // Optimization: If total cost exceeds k early, we can stop? No, we need smallest m.
            // Using a Max Heap of size m to store smallest costs found so far.
            // If heap size == m and new cost < heap.peek(), replace.
            
            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
            long currentSum = 0;
            
            // Optimization: If we can't find m numbers, impossible.
            // But we always can extend numbers to match mask (worst case cost is large).
            
            // Shift mask for current bit level logic
            int m_shifted = candidate >> b;
            
            for (int num : nums) {
                int v = num >> b;
                int diff = m_shifted & ~v;
                
                long cost;
                if (diff == 0) {
                    cost = 0; // Prefixes match required bits, lower bits 0 cost
                    // Wait, lower bits cost is ((num >> b) << b) - num?
                    // No, if prefix matches, we don't need to change anything to satisfy (y & cand) == cand
                    // because cand has 0s at < b.
                    // (num & cand) == cand is satisfied if prefix matches.
                    // So cost is 0?
                    // Example: num=5 (101), cand=4 (100). b=2.
                    // v=1, m=1. diff=0.
                    // num & cand = 101 & 100 = 100 == cand. Yes.
                    // Cost 0. Correct.
                    // Example: num=7 (111), cand=4.
                    // num & 4 = 4. Cost 0.
                } else {
                    int lb = Integer.lowestOneBit(diff); // Value of lowest bit, e.g. 1, 2, 4
                    // Logic: Y = (((v >> pos) + 1) << pos) | m
                    // Instead of pos, use arithmetic with lb
                    // v >> pos is v / lb? No.
                    // Clear bits below lb in v: (v & ~(lb - 1))
                    // Add lb: + lb
                    // So next_prefix = (v & ~(lb - 1)) + lb;
                    long next_prefix = (v & ~(lb - 1)) + lb;
                    long Y = next_prefix | m_shifted;
                    cost = (Y << b) - num;
                }
                
                if (pq.size() < m) {
                    pq.add(cost);
                    currentSum += cost;
                } else if (cost < pq.peek()) {
                    currentSum -= pq.poll();
                    currentSum += cost;
                    pq.add(cost);
                }
                
                // Early pruning? Not really possible with heap without full scan
            }
            
            if (currentSum <= k) {
                ans = candidate;
            }
        }
        
        return ans;
    }
}