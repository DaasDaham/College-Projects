class bell_ford{
    public static void main(String[] args) {
        
    }
}

class Graph{
    static int V;
    static Edge[] edges;
    static int E;
    public Graph(int v, int e){
        V = v;
        E = e;
        edges = new Edge[e];
        for(int i=0;i<e;i+=1){
            edges[i] = new Edge();
        }
    }

    public void bellman_ford(int src){
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int i=0;i<V;i++){
            for(int j=0;j<E;j++){
                int strt = edges[j].source;
                int end = edges[j].dest;
                int wt = edges[j].weight;
                if(dist[strt]!=Integer.MAX_VALUE){
                    if(dist[strt]+wt<dist[end]){
                        dist[end] = wt+dist[strt];
                    }
                }
            }
        }
    }

    public boolean detect_neg_cycle(int src){
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int i=0;i<V;i++){
            for(int j=0;j<E;j++){
                int strt = edges[j].source;
                int end = edges[j].dest;
                int wt = edges[j].weight;
                if(dist[strt]!=Integer.MAX_VALUE){
                    if(dist[strt]+wt<dist[end]){
                        dist[end] = wt+dist[strt];
                    }
                }
            }
        }
        for(int j=0;j<E;j+=1){
            int strt = edges[j].source;
            int end = edges[j].dest;
            int wt = edges[j].weight;
            if(dist[strt]!=Integer.MAX_VALUE){
                if(dist[strt]+wt<dist[end]){
                    return true;
                }
            }
        }
        return false;
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
    public Edge(){
        source = dest = weight=0;
    }
}