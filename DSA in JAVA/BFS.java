import java.util.Arrays;

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

    public void BFS(int x){
        Queue objq = new Queue();
        boolean[] visited = new boolean[vert];
        int[] dist = new int[vert];
        for(int i=0;i<vert;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;
        objq.enqueue(x);
        visited[x] = true;
        while(objq.size!=0){
            int to = objq.dequeue();
            System.out.println("vis "+to);
            if(arr[to].start!=null){
                Node travel = arr[to].start;
                System.out.println("tteavel "+travel.num);
                while(travel!=null){
                    if(visited[travel.num]==false){
                        dist[travel.num] = dist[to]+1;
                        visited[travel.num] = true;
                        objq.enqueue(travel.num);
                    }
                    travel = travel.next;
                }
            }
            System.out.println(Arrays.toString(dist));
        }
    }
}

class BFS{
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
        for(int i=0;i<8;i++){
            Node t = g.arr[i].start;
            while(t!=null){
                System.out.print(t.num+" ");
                t = t.next;
            }
            System.out.println();
        }
        g.BFS(0);
    }
}

class Node{
    Node next;
    int num;
    Node(int data){
        next = null;
        num = data;
    }
}

class LL{
    Node start;
    int size;
    LL(){
        start = null;
        size = 0;
    }

    public void insert(int x){
        Node nptr = start;
        Node ins = new Node(x);
        if(start == null){
            start = ins;
        }
        else{
            while(nptr.next != null){
                nptr = nptr.next;
            }
            nptr.next = ins;
        }
        size++;
    }
}

class Queue{
    Node front;
    Node rear;
    int size;
    Queue(){
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int x){
        Node nptr = new Node(x);
        if(rear == null){
            front = nptr;
        }
        else{
            rear.next = nptr;
        }
        rear = nptr;
        size++;
    }

    public int dequeue(){
        int d = front.num;
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
        return d;
    }

    public int peek(){
        int d = front.num;
        return d;
    }
}