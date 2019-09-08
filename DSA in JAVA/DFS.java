class Graph{
    LL[] arr;
    int vert;
    Graph(int vert){
        this.vert = vert;
        arr = new LL[vert];
        for(int i=0;i<vert;i++){
            arr[i] = new LL();
        }
    }

    public void addEdge(int x, int y){
        arr[x].insert(y);
    }

    public void DFS(int x, boolean[] visited){
        visited[x] = true;
        System.out.println("vert "+x);
        Node travel = arr[x].start;
        while(travel!=null){
            if(visited[travel.num] == false){
                DFS(travel.num, visited);
            }
            travel = travel.next;
        }
    }
}

class DFS{
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(5, 4);
        g.addEdge(0, 5);
        g.addEdge(3, 1);
        g.addEdge(1, 2);
        g.addEdge(5, 3);
        g.addEdge(3, 2);
        g.addEdge(1, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 3);
        boolean[] visited = new boolean[8];
        g.DFS(0, visited);
    }
}

class Node{
    Node next;
    int num;
    Node(int num){
        this.num = num;
        next=null;
    }
}

class Stack{
    Node top;
    int size;
    Stack(){
        top = null;
        size = 0;
    }
    public void push(int data){
        Node nptr = new Node(data);
        nptr.next = top;
        top = nptr;
        size++;
    }
    public int pop(){
        int d = top.num;
        top = top.next;
        return d;
    }
}