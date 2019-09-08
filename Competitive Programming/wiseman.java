import java.io.*;
import java.util.*;

public class wiseman{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] ci = br.readLine().trim().split(" ");
        String[] ei = br.readLine().trim().split(" ");
        PriorityQueue<Node> g1 = new PriorityQueue<Node>(n, new NodeComparator());
        PriorityQueue<Node> g2 = new PriorityQueue<Node>(m, new NodeComparator());
        for(int i=0;i<n;i++){
            Node temp = new Node(Integer.parseInt(ci[i]), Integer.parseInt(ei[i]));
            g1.add(temp);
        }
        for(int i=n;i<m+n;i++){
            Node temp = new Node(Integer.parseInt(ci[i]), Integer.parseInt(ei[i]));
            g2.add(temp);
        }
        long vye=0;
        long tag=0;
        long day1 = 1;
        long day2 = 1;
        //System.out.println(g2.size()+" afafs");
        //System.out.println(g1.size()+" g1.size");
        while(!g1.isEmpty() || !g2.isEmpty()){
            if(!g1.isEmpty()){
                Node temp = g1.remove();
                //System.out.println(temp.c+" 1st loop "+temp.e);
                day1+=(temp.c-1);
                //System.out.println(day1+" abcd ");
                //System.out.println(day1-temp.e+" tasfasea");
                vye = Math.max(0, (day1-temp.e));
                day1++;
                //System.out.println(vye+" vye");
            }
            if(!g2.isEmpty()){
                Node temp2 = g2.remove();
                day2+=(temp2.c-1);
                //System.out.println(day2+" a ");
                //System.out.println(day2-temp2.e+" tea");
                tag = Math.max(0, (day2-temp2.e));
                day2++;
                //System.out.println(tag);
            }
        }
        if(vye>tag){
            System.out.println("Tagup");
        }
        else if(tag>vye){
            System.out.println("Vyebha");
        }
        else{
            System.out.println("Tie");
        }
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        if(n1.e>n2.e){
            return 1;
        }
        else if(n1.e<n2.e){
            return -1;
        }
        return 0;
    }
}

class Node{
    int c;
    int e;
    public Node(int c, int e){
        this.c = c;
        this.e = e;
    }
}