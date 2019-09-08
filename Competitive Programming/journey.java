import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.Arrays;

public class journey{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Graph g = new Graph(n);
        for(int i=0;i<n-1;i++){
            String[] k = br.readLine().trim().split(" ");
            int tme1 = Integer.parseInt(k[0])-1;
            int tme2 = Integer.parseInt(k[1])-1; 
            g.addEdge(tme1, tme2);
            g.addEdge(tme2, tme1);
        }
        boolean[] vis = new boolean[n];
        g.find_neighbors(0, vis);
        //System.out.println(Arrays.toString(g.neighbors));
        boolean[] visited = new boolean[n];
        //System.out.println(Arrays.toString(neighbors));
        g.DFS(0, 1, 0, visited);
        System.out.println(g.fin_ans);

    }
}

class Graph 
{ 
    public int V; 
    public LinkedList<Integer> adj[]; 
    public static double fin_ans = 0;
    public static int[] neighbors;

    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v];
        neighbors = new int[v];
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    }
    
    void find_neighbors(int parent, boolean[] vis){
        vis[parent] = true;
        Iterator<Integer> abc = adj[parent].iterator();
        while(abc.hasNext()){
            int child = abc.next();
            if(!vis[child]){
                neighbors[parent]++;
                find_neighbors(child, vis);
            }
        }
    }
  
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    }  

    void DFS(int x, double prob, int depth, boolean[] visited){
        visited[x] = true;
        Iterator<Integer> iter = adj[x].iterator();
        while(iter.hasNext()){
            int n = iter.next();
            if(!visited[n]){
                //System.out.println(x+" yo");
                DFS(n, prob/((double)neighbors[x]), depth+1, visited);
            }
        }
        if(neighbors[x]==0){
            //System.out.println(prob);
            fin_ans = fin_ans + prob*((double)depth);
        }
    }
    
}