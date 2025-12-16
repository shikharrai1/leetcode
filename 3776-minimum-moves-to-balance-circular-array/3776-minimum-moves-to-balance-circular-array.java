class Solution {
       static class Source {
        int dist;
        long units;
        Source(int d, long u) {
            dist = d;
            units = u;
        }
    }
    public long minMoves(int[] balance) {
        int n = balance.length;

        long total = 0;
        int negIdx = -1;

        for (int i = 0; i < n; i++) {
            total += balance[i];
            if (balance[i] < 0) negIdx = i;
        }

        // Impossible case
        if (total < 0) return -1;

        // Already balanced
        if (negIdx == -1) return 0;

        long need = -balance[negIdx];

        List<Source> sources = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == negIdx || balance[i] <= 0) continue;

            int d = Math.abs(i - negIdx);
            int dist = Math.min(d, n - d); // circular distance
            sources.add(new Source(dist, balance[i]));
        }

        // Sort by distance (nearest first)
        Collections.sort(sources, (a, b) -> Integer.compare(a.dist, b.dist));

        long moves = 0;

        for (Source s : sources) {
            if (need == 0) break;

            long take = Math.min(need, s.units);
            moves += take * s.dist;
            need -= take;
        }

        return need == 0 ? moves : -1;
    }
}