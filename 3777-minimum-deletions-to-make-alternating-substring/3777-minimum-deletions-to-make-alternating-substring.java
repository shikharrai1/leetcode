class Solution {

   
    static class SegTree {
        int n;
        int[] tree;

        SegTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void build(int idx, int l, int r, int[] arr) {
            if (l == r) {
                tree[idx] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(2 * idx, l, mid, arr);
            build(2 * idx + 1, mid + 1, r, arr);
            tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
        }

        void update(int idx, int l, int r, int pos, int val) {
            if (l == r) {
                tree[idx] = val;
                return;
            }
            int mid = (l + r) / 2;
            if (pos <= mid) update(2 * idx, l, mid, pos, val);
            else update(2 * idx + 1, mid + 1, r, pos, val);
            tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
        }

        int query(int idx, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return tree[idx];
            int mid = (l + r) / 2;
            return query(2 * idx, l, mid, ql, qr)
                 + query(2 * idx + 1, mid + 1, r, ql, qr);
        }
    }

    public int[] minDeletions(String s, int[][] queries) {
        int n = s.length();
        char[] arr = s.toCharArray();

       
        int[] bad = new int[Math.max(0, n - 1)];
        for (int i = 0; i + 1 < n; i++) {
            bad[i] = (arr[i] == arr[i + 1]) ? 1 : 0;
        }

        SegTree st = new SegTree(bad.length);
        if (bad.length > 0) {
            st.build(1, 0, bad.length - 1, bad);
        }

        int cntType2 = 0;
        for (int[] q : queries) if (q[0] == 2) cntType2++;

        int[] ans = new int[cntType2];
        int idxAns = 0;

        for (int[] q : queries) {
            if (q[0] == 1) {
                int j = q[1];

              
                arr[j] = (arr[j] == 'A') ? 'B' : 'A';

             
                if (j - 1 >= 0) {
                    int val = (arr[j - 1] == arr[j]) ? 1 : 0;
                    st.update(1, 0, bad.length - 1, j - 1, val);
                }
                if (j < n - 1) {
                    int val = (arr[j] == arr[j + 1]) ? 1 : 0;
                    st.update(1, 0, bad.length - 1, j, val);
                }
            } else {
                int l = q[1];
                int r = q[2];
                if (l == r) {
                    ans[idxAns++] = 0;
                } else {
                    ans[idxAns++] = st.query(1, 0, bad.length - 1, l, r - 1);
                }
            }
        }

        return ans;
    }
}
