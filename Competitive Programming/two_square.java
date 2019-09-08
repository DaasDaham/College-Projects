import java.io.*;
import java.util.*;


class two_square{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[Math.pow(10, 5)+2];
        double x=1;
        double y=1;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());
        Set<Node> st = new HashSet<Node>();
        double count = 0;
        pq.add(new Node(x, y));
        while(count<Math.pow(10, 5)+2){
            Node temp = pq.poll();
        }
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        double sq1 = n1.x*n1.x + n1.y*n1.y;
        double sq2 = n2.x*n2.x + n2.y*n2.y;
        if(sq1>sq2){
            return 1;
        }
        else if(sq1<sq2){
            return -1;
        }
        return 0;
    }
}

class Node{
    double x;
    double y;
    public Node(double x, double y){
        this.x = x;
        this.y = y;
    }
}