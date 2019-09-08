import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class protick{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] k = br.readLine().trim().split(" ");
        int n = Integer.parseInt(k[0]);
        int m = Integer.parseInt(k[1]);
        int A = Integer.parseInt(k[2])-1;
        int B = Integer.parseInt(k[3])-1;
        Graph g = new Graph(n);
        for(int i=0;i<m;i++){
            k = br.readLine().trim().split(" ");
            int v1 = Integer.parseInt(k[0])-1;
            int w1 = Integer.parseInt(k[1])-1;
            g.addEdge(v1, w1);
            g.addEdge(w1, v1);
        }
        int[] depth_from_A = new int[n];
        int[] depth_from_B = new int[n];
        for(int i=0;i<n;i++){
            depth_from_A[i] = Integer.MAX_VALUE;
            depth_from_B[i] = Integer.MAX_VALUE;
        }
        depth_from_A[A] = 0;
        depth_from_B[B] = 0;
        g.BFS(A, depth_from_A);
        g.BFS(B, depth_from_B);
        //System.out.println(Arrays.toString(depth_from_A));
        //System.out.println(Arrays.toString(depth_from_B));
        int fin_ans = 0;
        for(int i=0;i<n;i++){
            if(depth_from_A[i]!=Integer.MAX_VALUE || depth_from_B[i]!=Integer.MAX_VALUE){
                if(depth_from_A[i] == depth_from_B[i]){
                    fin_ans++;
                }
            }
        }
        System.out.println(fin_ans);
    }
}

class Graph 
{ 
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

    public void BFS(int x, int[] dist){
        Queue objq = new Queue();
        boolean[] visited = new boolean[vert];
        //int[] dist = new int[vert];
        for(int i=0;i<vert;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;
        objq.enqueue(x);
        visited[x] = true;
        while(objq.size!=0){
            int to = objq.dequeue();
            //System.out.println("vis "+to);
            if(arr[to].start!=null){
                Node travel = arr[to].start;
                //System.out.println("tteavel "+travel.num);
                while(travel!=null){
                    if(visited[travel.num]==false){
                        dist[travel.num] = dist[to]+1;
                        visited[travel.num] = true;
                        objq.enqueue(travel.num);
                    }
                    travel = travel.next;
                }
            }
            //System.out.println(Arrays.toString(dist));
        }
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