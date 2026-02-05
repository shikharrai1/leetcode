class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        // creating graph list of list adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
              graph.add(new ArrayList<>());
        }

        for(int [] arr : edges){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        int [] dx = bfs(n, graph, x);
        int [] dy = bfs(n, graph, y);
        int [] dz = bfs(n, graph, z);

        int cnt = 0;
        for(int i=0; i<n; i++){
            int a = dx[i];
            int b = dy[i];
            int c = dz[i];

            int nums[] = {a,b,c};
            Arrays.sort(nums);
            a = nums[0]*nums[0];
            b = nums[1]*nums[1];
            c = nums[2]*nums[2];

            if( (a+b) == c){
                cnt++;
            };
        }
        return cnt;
    }
    // bfs
    int[] bfs(int n, List<List<Integer>> graph, int curr){
        Queue<Integer> q = new LinkedList<>();
        int [] d = new int[n];
        Arrays.fill(d,-1);
        q.offer(curr);
        d[curr] = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : graph.get(u)){
                if(d[v] == -1){
                    d[v] = d[u] + 1;
                    q.offer(v);
                }
            }
        }
        return d;
    }
}