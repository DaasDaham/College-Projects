import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class kruskals{
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);
        g.MST();
    }
}

class Edge{
    int source;
    int dest;
    int weight;
    public Edge(int source, int dest, int weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }
}

class Graph{
    public static int vertices;
    public static ArrayList<Edge> allEddges = new ArrayList<>();

    public Graph(int vert){
        vertices = vert;
    }

    public void addEdge(int a, int b, int c){
        Edge edge = new Edge(a, b, c);
        allEddges.add(edge);
    }

    public void MST(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        for(int i=0;i<allEddges.size();i++){
            pq.add(allEddges.get(i));
        }
        ArrayList<Edge> mst = new ArrayList<>();
        int[] parent = new int[vertices];
        makeSet(parent);
        int index = 0;
        while(index<vertices-1){
            Edge temp = pq.remove();
            int x = find(parent, temp.source);
            int y = find(parent, temp.dest);
            if(x!=y){
                mst.add(temp);
                index++;
                union(parent, x, y);
            }
        }
        printG(mst);
    }
    public static void makeSet(int[] parent){
        for(int i=0;i<vertices;i++){
            parent[i] = i;
        }
    }
    public static int find(int[] parent, int x){
        if(parent[x]==x){
            return x;
        }
        else{
            return find(parent, parent[x]);
        }
    }
    public static void union(int[] parent, int x, int y){
        int par_x = find(parent, x);
        int par_y = find(parent, y);
        if(par_x==par_y){
            return;
        }
        else{
            parent[par_x] = par_y;
        }
    }
    public static void printG(ArrayList<Edge> lst){
        for(int i=0;i<lst.size();i+=1){
            Edge edge = lst.get(i);
            System.out.println("i "+i+" source: "+edge.source+" dest "+edge.dest+" weifght "+edge.weight);
        }
    }
}