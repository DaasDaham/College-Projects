import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.Stack;

class toposort{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] k = br.readLine().trim().split(" ");
        int n = Integer.parseInt(k[0]);
        int m = Integer.parseInt(k[1]);
        StringBuffer ans =  new StringBuffer();
        Graph g = new Graph(n);
        for(int i=0;i<m;i++){
            String[] temp = br.readLine().trim().split(" ");
            g.addEdge(Integer.parseInt(temp[0])-1, Integer.parseInt(temp[1])-1);
        }
        g.in_deg();
        g.comp();
        if(g.all_good){
            Queue<Integer> copy = g.lk;
            while(!copy.isEmpty()){
                int to_add = copy.remove()+1;
                ans.append(to_add+" ");
            }
        }
        else{
            ans.append("Sandro fails.");
        }
        //ans.append("\n");
        System.out.println(ans);
    }
}

class Graph{
    public LinkedList<Integer> adj[];
    public static int V;
    public static int[] indegree;
    public static int vis_nodes=0;
    public static Queue<Integer> lk = new LinkedList();
    boolean all_good = true;

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        indegree = new int[v];
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void in_deg(){
        for(int i=0;i<V;i++){
            Iterator<Integer> abc = adj[i].iterator();
            while(abc.hasNext()){
                indegree[abc.next()]++;
            }
        }
    }

    void comp(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                pq.add(i);
            }
        }
        while(pq.size()!=0){
            vis_nodes+=1;
            int rem = pq.poll();
            lk.add(rem);
            Iterator<Integer> abc = adj[rem].iterator();
            while(abc.hasNext()){
                int nn = abc.next();
                if(indegree[nn]==0){
                    pq.add(nn);
                }
                else{
                    indegree[nn]--;
                    if(indegree[nn]==0){
                        pq.add(nn);
                    }
                }
            }
        }
        if(vis_nodes!=V){
            all_good = false;
        }
    }
}