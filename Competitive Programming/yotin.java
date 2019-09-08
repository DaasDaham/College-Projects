import java.io.*;
import java.util.*;

public class yotin{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer ans = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        Graph g = new Graph(n);
        for(int i=0;i<q;i++){
            String[] qu = br.readLine().trim().split(" ");
            if(Integer.parseInt(qu[0])==1){
                g.addEdge(Integer.parseInt(qu[1])-1, Integer.parseInt(qu[2])-1);
                g.addEdge(Integer.parseInt(qu[2])-1, Integer.parseInt(qu[1])-1);
            }
            else if(Integer.parseInt(qu[0])==2){
                boolean yoyo = g.BFS(Integer.parseInt(qu[1])-1, Integer.parseInt(qu[2])-1);
                if(yoyo){
                    ans.append("YES"+"\n");
                }
                else{
                    ans.append("NO"+"\n");
                }
               // System.out.println("yoyoy");
            }
        }
        System.out.print(ans);
    }
}

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

    public boolean BFS(int x, int yjk){
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
            if(dist[yjk]!=Integer.MAX_VALUE){
                return true;
            }
            int to = objq.dequeue();
           // System.out.println("vis "+to);
            if(arr[to].start!=null){
                Node travel = arr[to].start;
              //  System.out.println("tteavel "+travel.num);
                while(travel!=null){
                    if(visited[travel.num]==false){
                        dist[travel.num] = dist[to]+1;
                        visited[travel.num] = true;
                        if(dist[yjk]!=Integer.MAX_VALUE){
                            return true;
                        }
                        objq.enqueue(travel.num);
                    }
                    travel = travel.next;
                }
            }
           // System.out.println(Arrays.toString(dist));
        }
        if(dist[yjk]!=Integer.MAX_VALUE){
            return true;
        }
        return false;
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