import java.util.Arrays;
import java.util.Scanner;

class eattwice{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        for(int times=0;times<t;times++){
            int n = s.nextInt();
            int m = s.nextInt();
            Node[] arr = new Node[n];
            heapbuilder pq = new heapbuilder(arr, n);
            for(int i=0;i<n;i++){
                long d = s.nextInt();
                long taste = s.nextInt();
                pq.ins(new Node(taste, d));
            }
            long fin_sum = 0;
            pq.Max_heap();
            fin_sum+=arr[0].tastiness;
            long maxi = arr[0].day;
            for(int i=1;i<n;i++){
                if(arr[i].day != maxi){
                    fin_sum+=arr[i].tastiness;
                    //System.out.println(i+" i");
                    break;
                }
            }
            System.out.println(fin_sum); 
        }
    }
}

class Node{
    long day;
    long tastiness;
    Node(long tastiness, long day){
        this.day = day;
        this.tastiness = tastiness;
    }
}

class heapbuilder{
    public Node[] arr;
    public int size;
    public int maxsize;

    public heapbuilder(Node[] arr, int maxsize){
        this.maxsize = maxsize;
        this.arr = arr;
        size = 0;
    }

    public int parent(int pos){
        return pos/2;
    }

    public int leftCh(int pos){
        return (2*pos) + 1;
    }

    public int rightCh(int pos){
        return (2*pos) + 2;
    }

    public boolean leaf(int pos){
        if(pos >= (size/2) && pos <= size){
            return true;
        }
        return false;
    }

    public void swap(int n1, int n2){
        Node temp;
        temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public void Max_heap(){
        for(int i = size/2;i>=0;i--){
            maxHeapify(i);
        }
    }

    public void ins(Node num){
        arr[size] = num;
        int curr = size;
        while(arr[curr].tastiness>arr[parent(curr)].tastiness){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
        size++;
    }

    public Node extractMax(){ 
        Node popped = arr[0]; 
        arr[0] = arr[size-1];
        arr[size-1] = popped;
        size--; 
        maxHeapify(0); 
        return popped; 
    }

    public void maxHeapify(int i){
        int l = leftCh(i);
        int r = rightCh(i);
        int largest = 0;
        if(l<maxsize&& arr[l].tastiness>arr[i].tastiness){
            largest = l;
        }
        else{
            largest = i;
        }
        if(r<maxsize && arr[r].tastiness>arr[largest].tastiness){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void print(){
        for(int i=0;i<maxsize;i++){
            System.out.println("yooy");
            System.out.println(arr[i].day);
            System.out.println(arr[i].tastiness);
        }
    }
}