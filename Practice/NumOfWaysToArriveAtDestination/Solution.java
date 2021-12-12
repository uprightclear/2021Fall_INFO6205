package NumOfWaysToArriveAtDestination;

import java.util.*;

public class Solution {
    class Edge {
        int to;
        long len;
        Edge(int to, long len) {
            this.to = to;
            this.len = len;
        }
    }

    List<Edge>[] graph;
    final long INF = Long.MAX_VALUE;
    final int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        graph = new ArrayList[n];

        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] p : roads) {
            int u = p[0], v = p[1], w = p[2];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        return dijkstra(n);
    }

    public int dijkstra(int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.len, b.len));
        boolean[] vis = new boolean[n];
        long[] dist = new long[n];
        int[] cnt = new int[n];

        pq.offer(new Edge(0, 0));
        Arrays.fill(dist, INF);
        dist[0] = 0;
        cnt[0] = 1;

        while(!pq.isEmpty()) {
            int u = pq.poll().to;
            if(vis[u]) continue;
            vis[u] = true;
            for(Edge next : graph[u]) {
                int v = next.to;
                long w = next.len;
                if(dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    cnt[v] = cnt[u];
                    pq.offer(new Edge(v, dist[v]));
                } else if (dist[v] == dist[u] + w) {
                    cnt[v] = (cnt[v] + cnt[u]) % MOD;
                }
            }
        }

        return cnt[n - 1];
    }
}
