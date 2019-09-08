import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.Arrays;


public class party{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> lk = new LinkedList<Integer>();
        int fin_ans = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];
        boolean allminus = true;
        int prev = -1;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]!=prev){
                allminus = false;
            }
        }
        if(allminus){
            fin_ans = 0;
        }
        else{
        Graph g = new Graph(n);
        for(int i=0;i<n;i++){
            if(arr[i]!=-1){
                g.addEdge(arr[i]-1, i);
            }
            else{
                lk.add(i);
            }
        }
        Iterator<Integer> abc = lk.iterator();
        while(abc.hasNext()){
            fin_ans = Math.max(fin_ans, g.BFS(abc.next(), visited, fin_ans));
        }}
        System.out.println(fin_ans+1);
    }
}



class Graph{
    //static int fin_ans = Integer.MIN_VALUE;
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

    public int BFS(int x, boolean[] visited, int fin_ans){
        Queue objq = new Queue();
        int[] dist = new int[vert];
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
                        fin_ans = Math.max(fin_ans, dist[travel.num]);
                        visited[travel.num] = true;
                        objq.enqueue(travel.num);
                    }
                    travel = travel.next;
                }
            }
            //System.out.println(Arrays.toString(dist));
        }
        return fin_ans;
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