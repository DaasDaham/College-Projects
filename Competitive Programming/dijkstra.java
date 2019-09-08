import java.util.*;

class dijkstra{
    public static void main(String arg[]) 
    { 
        int V = 5; 
        int source = 0; 

        List<List<Node> > adj = new ArrayList<List<Node> >(); 
          for (int i = 0; i < V; i++) { 
            List<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
  
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
  
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
  
        Graph dpq = new Graph(V); 
        dpq.sp_dijkstra(adj, source); 

        System.out.println("The shorted path from num :"); 
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + dpq.dist[i]); 
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

    public void sp_dijkstra(List<List<Node>> adj, int source){
        this.adj = adj;
        dist[source] = 0;
        pq.add(new Node(source, 0));
        while(explored.size()!=V){
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