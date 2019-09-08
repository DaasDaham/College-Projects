import java.util.Arrays;




class heapbuilder{
    public int[] arr;
    public int size;
    public int maxsize;

    public heapbuilder(int[] arr, int maxsize){
        this.maxsize = maxsize;
        this.arr = arr;
        size = arr.length;
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
        int temp;
        temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public void Max_heap(){
        for(int i = size/2;i>=0;i--){
            maxHeapify(i);
        }
    }

    public void ins(int num){
        size++;
        arr[size] = num;
        int curr = size;
        while(arr[curr]>arr[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public int extractMax(){ 
        int popped = arr[0]; 
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
        if(l<size && arr[l]>arr[i]){
            largest = l;
        }
        else{
            largest = i;
        }
        if(r<size && arr[r]>arr[largest]){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void print(){
        int[] fff = new int[size];
        for(int i=0;i<size;i++){
            fff[i] = arr[i];
        }
        System.out.println(Arrays.toString(fff));
    }
}

class priority_queue{
    public int[] arr;
    public int size;
    public int maxsize;
    public int[] arr2;

    public heapbuilder(int[] arr, int maxsize, int[] arr2){
        this.maxsize = maxsize;
        this.arr = arr;
        this.arr2 = arr2;
        size = arr.length;
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

    public void maxHeapify(int i){
        int l = leftCh(i);
        int r =  rightCh(i);
        int largest = 0;
        if(l<size && arr[l]>arr[i]){
            largest = l;
        }
        else{
            largest = i;
        }
        if(r<size && arr[r]>arr[largest]){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void increase_key(int i){
        arr2[i]++;
    }

    public int heap_max(){
        return arr[0];
    }

    public int extract_max(){
        int max = arr[0];
        a[0] = a[size-1];
        size--;
        maxHeapify(0);
        return max;
    }

    public void Max_heap(){
        for(int i = size/2;i>=0;i--){
            maxHeapify(i);
        }
    }
}

public class heap{
    public static void main(String[] args) {
        int[] arr = {4,1,3,2,16,9,10,14,8,7};
        int maxsize = arr.length;
        heapbuilder h = new heapbuilder(arr, maxsize);
        h.Max_heap();
        h.print();
        h.extractMax();
        h.print();
    }
    
}

