import java.util.*;
import java.io.*;

public class poortown{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer ans = new StringBuffer();
        String[] nk = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] a = br.readLine().trim().split(" ");
        PriorityQueue<Node> pq = new PriorityQueue<Node>(a.length, new NodeComparator());
        for(int i=1;i<=a.length;i++){           
            Node temp = new Node(i, Integer.parseInt(a[i-1]));
            pq.add(temp);
        }
        for(int i=0;i<k;i++){
            Node temp = pq.poll();
            temp.money++;
            pq.add(temp);
        }
        PriorityQueue<Node> pq2 = new PriorityQueue<Node>(n, new NodeIndexComparator());
        while(!pq.isEmpty()){
            Node yo = pq.poll();
            pq2.add(yo);
        }
        while(!pq2.isEmpty()){
            Node temp = pq2.poll();
            ans.append(temp.money+" ");
        }
        String fin_ans = ans.toString().trim();
        System.out.println(fin_ans);
    }
}

class NodeIndexComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        if(n1.index>n2.index){
            return 1;
        }
        else if(n1.index<n2.index){
            return -1;
        }
        return 0;
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        if(n1.money>n2.money){
            return 1;
        }
        else if(n1.money==n2.money && n1.index>n2.index){
            return 1;
        }
        else if(n1.money<n2.money){
            return -1;
        }
        else if(n1.money==n2.money && n1.index<n2.index){
            return -1;
        }
        return 0;
    }
}

class Node{
    int index;
    int money;
    public Node(int i, int m){
        index = i;
        money = m;
    }
}