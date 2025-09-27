import java.util.*;

class Query implements Comparable<Query> {
    int xi, mi, qNo;

    public Query(int xi, int mi, int qNo) {
        this.xi = xi;
        this.mi = mi;
        this.qNo = qNo;
    }

    @Override
    public int compareTo(Query q2) {
        return this.mi - q2.mi;
    }
}

class Node {
    Node[] children = new Node[2];
}

class Solution {

    void insert(Node root, int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null)
                curr.children[bit] = new Node();
            curr = curr.children[bit];
        }
    }

    int findMaxXOR(Node root, int xi) {
        Node curr = root;
        if (curr.children[0] == null && curr.children[1] == null) return -1;

        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (xi >> i) & 1;
            int opp = 1 - bit;
            if (curr.children[opp] != null) {
                xor = (xor << 1) | 1;
                curr = curr.children[opp];
            } else {
                xor = xor << 1;
                curr = curr.children[bit];
            }
        }
        return xor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        Query[] offlineQueries = new Query[queries.length];

        for (int i = 0; i < queries.length; i++) {
            offlineQueries[i] = new Query(queries[i][0], queries[i][1], i);
        }

        Arrays.sort(offlineQueries); // sort by mi

        int[] result = new int[queries.length];
        Node root = new Node();
        int idx = 0;

        for (Query q : offlineQueries) {
            // Insert nums[i] ≤ q.mi into the Trie
            while (idx < nums.length && nums[idx] <= q.mi) {
                insert(root, nums[idx]);
                idx++;
            }

            // Query the maximum XOR for xi
            int maxXor = findMaxXOR(root, q.xi);
            result[q.qNo] = maxXor;
        }

        return result;
    }
}
