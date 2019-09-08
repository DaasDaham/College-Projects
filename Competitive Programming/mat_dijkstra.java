import java.util.HashSet;
import java.util.Set;

class Graph{
    public static int V;
    public int dijkstra(int[][] graph, int src){
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        Set<Integer> vis = new HashSet<>();
        while(vis.size()<V){
            int u = minVert(dist, vis);
            vis.add(u);
            for(int v=0;v<V;v++){
                if(vis.contains(v)==false && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE){
                    if(dist[v]>dist[u]+graph[u][v]){
                        dist[v] = d[u]+graph[u][v];
                    }
                }
            }
        }
        return dist[V-1];
    }
    public int minVert(int[] dist, Set<Integer> vis){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<V;i++){
            if(vis.contains(i)==false && dist[i]!=min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}