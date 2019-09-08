import java.io.*;
import java.util.*;

public class madhav{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ve = br.readLine().trim().split(" ");
        int V = Integer.parseInt(ve[0]);
        int E = Integer.parseInt(ve[1]);
        int[][] adjmat = new int[V][V];
        Set<Integer> cont = new HashSet<>();
        for(int i=0;i<E;i++){
            String[] temp = br.readLine().trim().split(" ");
            int src = Integer.parseInt(temp[0])-1;
            int dest = Integer.parseInt(temp[1])-1;
            int wt = Integer.parseInt(temp[2]);
            if(src!=dest && adjmat[src][dest]==0 && adjmat[dest][src]==0){
                cont.add(src);
                cont.add(dest);
                adjmat[src][dest] = wt;
                adjmat[dest][src] = wt;
            }
            else if(src!=dest && adjmat[src][dest]!=0 && adjmat[dest][src]!=0){
                cont.add(src);
                cont.add(dest);
                if(wt<adjmat[src][dest]){
                    adjmat[src][dest]=wt;
                    adjmat[dest][src]=wt;
                }
            }
        }
        //for(int i=0;i<V;i++){
        //    for(int j=0;j<V;j++){
        //        System.out.print(adjmat[i][j]);
        //    }
        //    System.out.println();
        //}
        Graph g = new Graph();
        g.V = V;
        if(cont.contains(V-1)){
            long temp = g.dijkstra(adjmat, 0);
            if(temp!=Long.MAX_VALUE){
                System.out.println(temp);
            }
            else{
                System.out.println(-1);
            }
        } 
        else{
            System.out.println(-1);
        }
    }
}

class Graph{
    public static int V;
    public long dijkstra(int[][] graph, int src){
        long dist[] = new long[V];
        for(int i=0;i<V;i++){
            dist[i] = Long.MAX_VALUE;
        }
        dist[src] = 0;
        Set<Integer> vis = new HashSet<>();
        while(vis.size()<V){
            int u = minVert(dist, vis);
            if(u==-1){
                break;
            }
            //System.out.println(u+" yo");
            vis.add(u);
            for(int v=0;v<V;v++){
               // System.out.println(vis.contains(v)+" bool");
                if(vis.contains(v)==false && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE){
                    //System.out.println("jjj");
                    if(dist[v]>dist[u]+graph[u][v]){
                        dist[v] = dist[u]+graph[u][v];
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(dist));
        return dist[V-1];
    }
    public int minVert(long[] dist, Set<Integer> vis){
        long min = Long.MAX_VALUE;
        int index = -1;
        for(int i=0;i<V;i++){
            if(vis.contains(i)==false && dist[i]<min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}