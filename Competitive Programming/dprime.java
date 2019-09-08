import java.util.Scanner;

public class dprime{
    static int counter;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            counter=0;
            LL lk = new LL();
            factor(n, false, false, lk);
            if(counter==2){
                Node sf = lk.start;
                while(sf!=null){
                    System.out.print(sf.num+" ");
                    sf = sf.next;
                }
                System.out.println();
            }
            else{
                System.out.println(-1);
            }
        }
    }

    public static void factor(int n, boolean l1, boolean l2, LL lk){
        while (n%2==0){ 
            //System.out.print(2 + " "); 
            n /= 2;
            if(l1 == false){
                counter++;
                l1 = true;
                lk.insert(2);
            } 
        } 
        for (int i = 3; i <= Math.sqrt(n); i+= 2){ 
            while (n%i == 0){ 
                //System.out.print(i + " "); 
                n /= i; 
                if(l2 == false){
                    counter++;
                    l2 = true;
                    lk.insert(i);
                }
            }
            l2 = false; 
        } 
        if (n > 2){
            counter++; 
            lk.insert(n);
            //System.out.print(n);
        }
    }
}

class LL{
    Node start;
    int size;
    public LL(){
        start = null;
        size = 0;
    }
    public void insert(int data){
        Node nptr = new Node(data);
        nptr.next = null;
        if(start == null){
            start = nptr;
            start.next = null;
        }
        else{
            Node n = start;
            while(n.next!=null){
                n = n.next;
            }
            n.next = nptr;
        }
        size++;
    }
}

class Node{
    Node next;
    int num;
    Node(int data){
        num = data;
        next= null;
    }
}