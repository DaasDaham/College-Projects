import java.util.*;
import java.io.*;

class ezdijkst{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer ans = new StringBuffer();
        for(int times=0;times<t;times++){
            Set<Integer> abc =new HashSet<>();
            String[] v_k = br.readLine().trim().split(" ");
            int vertices = Integer.parseInt(v_k[0]);
            int edges = Integer.parseInt(v_k[1]);
            List<List<Node> > adj = new ArrayList<List<Node> >(); 
            for(int i=0;i<vertices;i++){ 
                List<Node> item = new ArrayList<Node>(); 
                adj.add(item); 
            }    
            for(int i=0;i<edges;i++){
                String[] a_b_c = br.readLine().trim().split(" ");
                int a = Integer.parseInt(a_b_c[0])-1;
                int b = Integer.parseInt(a_b_c[1])-1;
                int c = Integer.parseInt(a_b_c[2]);
                abc.add(a);
                abc.add(b);
                adj.get(a).add(new Node(b, c));
            }
            String[] A_B = br.readLine().trim().split(" ");
            int start = Integer.parseInt(A_B[0])-1;
            int end = Integer.parseInt(A_B[1])-1;
            Graph g = new Graph(vertices);
            g.sp_dijkstra(adj, start, abc.size());
            if(g.dist[end]<Integer.MAX_VALUE){
                ans.append(g.dist[end]+"\n");}
            else{
                ans.append("NO"+"\n");}
        }
        System.out.print(ans);
    }
}

class Graph{
    public int[] dist;
    public  List<List<Node>> adj;
    public Set<Integer> explored;
    public PriorityQueue<Node> pq;
    public int V;

    public Graph(int vert){
        V=vert;
        dist = new int[vert];
        explored = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(vert, new NodeComparator());
        for(int i=0;i<vert;i++){
            dist[i] = Integer.MAX_VALUE;
        }
    }

    public void sp_dijkstra(List<List<Node>> adj, int source, int max_size){
        this.adj = adj;
        dist[source] = 0;
        pq.add(new Node(source, 0));
        //System.out.println(pq.size());
        while(explored.size()!=max_size){
            Node to_explore = pq.remove();
            explored.add(to_explore.num);
            for(int i=0;i<adj.get(to_explore.num).size();i++){
                Node temp = adj.get(to_explore.num).get(i);
                if(!explored.contains(temp.num)){
                    if(dist[temp.num]>dist[to_explore.num]+temp.weight){
                        dist[temp.num] = dist[to_explore.num]+temp.weight;
                    }
                }
                pq.add(new Node(temp.num, dist[temp.num]));
            }
        }
    }

}

class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node num1, Node num2){ 
        if (num1.weight < num2.weight) 
            return -1; 
        if (num1.weight > num2.weight) 
            return 1; 
        return 0; 
    } 
}

class Node{ 
    public int num; 
    public int weight; 
    public Node(int num, int weight){ 
        this.num = num; 
        this.weight = weight; 
    } 
} 