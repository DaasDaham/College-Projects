import java.io.*;
import java.util.*;
public class clubs_mela{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer ans = new StringBuffer();
        String[] nq = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        Graph g = new Graph(n+1);
        for(int i=0;i<n;i++){
            String[] edges = br.readLine().trim().split(" ");
            //System.out.println(Arrays.toString(edges));;
            g.addEdge(Integer.parseInt(edges[0]), Integer.parseInt(edges[1]));
        }
        int[] check_ans = g.max_id;
        for(int i=0;i<q;i++){
            String[] temp = br.readLine().trim().split(" ");
            boolean[] vis = new boolean[n+1];
            int x = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            g.toXor = k;
            g.keepworking=true;
            int min = Integer.MAX_VALUE;
            g.max_id = new int[n+1];
            g.DFS(0, vis, min, x);
            ans.append(g.max_id[x]+"\n");
        }
        System.out.print(ans);
    }
}

class Graph 
{ 
    public int V; 
    public static LinkedList<Integer> adj[];
    public int[] max_id; 
    public static double fin_ans = 0;
    public static int toXor;
    public static boolean keepworking;

    Graph(int v){ 
        V = v; 
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    }

    public void addEdge(int v,int w){ 
        //System.out.println(v+" <-v,w-> "+w);
        adj[v].add(w); 
    }  

    public void DFS(int x, boolean[] visited, int max, int target){
        if(keepworking==true){
        visited[x] = true;
        if((x)>max){
            max = x;
        }
        max_id[x] = min;
        if(x==target){
            keepworking = false;
        }
        Iterator<Integer> iter = adj[x].iterator();
        while(iter.hasNext()){
            int n = iter.next();
            if(!visited[n]){
                //System.out.println(x+" yo "+max);
                DFS(n, visited, max, target);
            }
            //System.out.println(iter.next());
        }
    }
    }
}