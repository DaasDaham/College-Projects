class Stack{
    Node top;
    int size;
    Stack(){
        top = null;
        size = 0;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public void push(int val){
        Node nptr = new Node(val);
        nptr.next = top;
        top = nptr;
        size++;
    }

    public void pop(){
        int d = top.num;
        top = top.next;
        size--;
    }

    public int peek(){
        int d = top.num;
        return d;
    }
}

class Queue{
    Node front;
    Node rear;
    int size;
    
    public Queue(){
        rear = null;
        front = null;
        size = 0;
    }

    public void enqueue(int val){
        Node nptr = new Node(val);
        if(rear == null){
            front = nptr;
        }
        else{
            rear.next = nptr;
        }
        rear = nptr;
        size++;
    }

    public void dequeue(){
        //int d = front.num;
        if(front == null){
            rear = null;
        }
        front = front.next;
        size--;
    }

    public int peek(){
        int d = front.num;
        return d;
    }
}

class Graph 
{ 
    private int V; 
    private LinkedList<Integer> adj[]; 
    public int[] colored; 
    public int counter;
    public int min = Integer.MIN_VALUE;
  
    Graph(int v, int count) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
        //in_degree = new int[v];
        counter = count;
    } 
  
    void addEdge(int v,int w) 
    { 

        adj[v].add(w); 
        //in_degree[w]++;
    } 

    void DFSUtil(int v,boolean visited[]) 
    { 
        visited[v] = true; 
        //System.out.println("vert "+v+" count= "+counter); 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()){ 
            int n = i.next(); 
            //if(n == v){
            //    counter++;
            //}
            counter++;
            if (!visited[n]){ 
                DFSUtil(n, visited); 
                //System.out.println("this sat");
        }   }
    } 
  
    void DFS() 
    { 
        boolean visited[] = new boolean[V]; 
        for (int i=0; i<V; ++i){ 
            if (visited[i] == false){ 
                DFSUtil(i, visited);
                //System.out.println("count2 "+counter/2);
                if((counter/2)>min){
                    min = counter/2;
                } 
                counter = 0;
            }
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

class HeapSort 
{ 
    public void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
        for (int i=n-1; i>=0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, i, 0); 
        } 
    } 
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; 
        int l = 2*i + 1;  
        int r = 2*i + 2; 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            heapify(arr, n, largest); 
        } 
    } 
}

class BT{
    Node root;
    BT(int key){
        root = new Node(key);
    }
    BT(){
        root = null;
    }

    public void printpre(Node nptr){
        if(nptr == null){
            return;
        }
        System.out.println(nptr.num);
        printpre(nptr.left);
        printpre(nptr.right);
    }

    public int countnode(Node n){
        if(n==null){
            return 0;
        }
        return 1 + countnode(n.right) + countnode(n.left);
    }

    public int height(Node n){
        if(n == null){
            return 0;
        }
        else{
            return 1+Math.max(height(n.left), height(n.right));
        }
    }

    public boolean search(Node n, int s){
        if(n == null){
            return false;
        }
        else if(n.num == s){
            return true;
        }
        else if(s>n.num){
            return search(n.right, s);
        }
        else if(s<n.num){
            return search(n.left, s);
        }
        else{
            return false;
        }
    }

    public Node searchfordel(Node n, int s){
        if(n.left.num == s || n.right.num == s){
            return n;
        }
        else{
            if(n.num > s){
                return searchfordel(n.left, s);
            }
            else{
                return searchfordel(n.right, s);
            }
        }
    }

    public Node insert(Node bt, Node ins, BT obj){
        if(obj.root == null){
            obj.root = ins;
        }
        else if(bt == null){
            bt = ins;
        }
        else if(ins.num<bt.num){
            bt.left=insert(bt.left, ins, obj);
        }
        else if(ins.num>bt.num){
            bt.right = insert(bt.right, ins, obj);
        }
        return bt;
    }
}

class MinimumPriorityQueue {
    public static int heapSize = 0;
    public static int treeArraySize = 20;
    public static int INF = 100000;
  
    //function to get right child of a node of a tree
    public static int getRightChild(int A[], int index) {
        if((((2*index)+1) < A.length && (index >= 1)))
            return (2*index)+1;
        return -1;
    }
  
    //function to get left child of a node of a tree
    public static int getLeftChild(int A[], int index) {
        if(((2*index) < A.length && (index >= 1)))
            return 2*index;
        return -1;
    }
  
    //function to get the parent of a node of a tree
    public static int getParent(int A[], int index) {
        if ((index > 1) && (index < A.length)) {
            return index/2;
        }
        return -1;
    }
  
    public static void minHeapify(int A[], int index) {
      int leftChildIndex = getLeftChild(A, index);
      int rightChildIndex = getRightChild(A, index);
  
      // finding smallest among index, left child and right child
      int smallest = index;
  
      if ((leftChildIndex <= heapSize) && (leftChildIndex>0)) {
        if (A[leftChildIndex] < A[smallest]) {
          smallest = leftChildIndex;
        }
      }
  
      if ((rightChildIndex <= heapSize && (rightChildIndex>0))) {
        if (A[rightChildIndex] < A[smallest]) {
          smallest = rightChildIndex;
        }
      }
  
      // smallest is not the node, node is not a heap
      if (smallest != index) {
        int temp;
        //swapping
        temp = A[smallest];
        A[smallest] = A[index];
        A[index] = temp;
        minHeapify(A, smallest);
      }
    }
  
    public static void buildMinHeap(int A[]) {
      for(int i=heapSize/2; i>=1; i--) {
        minHeapify(A, i);
      }
    }
  
    public static int minimum(int A[]) {
      return A[1];
    }
  
    public static int extractMin(int A[]) {
      int minm = A[1];
      A[1] = A[heapSize];
      heapSize--;
      minHeapify(A, 1);
      return minm;
    }
  
    public static void decreaseKey(int A[], int index, int key) {
      A[index] = key;
      while((index>1) && (A[getParent(A, index)] > A[index])) {
        int temp;
        temp = A[getParent(A, index)];
        A[getParent(A, index)] = A[index];
        A[index] = temp;
        index = getParent(A, index);
      }
    }
  
    public static void increaseKey(int A[], int index, int key) {
      A[index] = key;
      minHeapify(A, index);
    }
  
    public static void insert(int A[], int key) {
      heapSize++;
      A[heapSize] = INF;
      decreaseKey(A, heapSize, key);
    }
  
    public static void printHeap(int A[]) {
      for(int i=1; i<=heapSize; i++) {
        System.out.println(A[i]);
      }
      System.out.println("");
    }
  
    public static void main(String[] args) {
      int A[] = new int[treeArraySize];
      buildMinHeap(A);
  
      insert(A, 20);
      insert(A, 15);
      insert(A, 8);
      insert(A, 10);
      insert(A, 5);
      insert(A, 7);
      insert(A, 6);
      insert(A, 2);
      insert(A, 9);
      insert(A, 1);
  
      printHeap(A);
  
      increaseKey(A, 5, 22);
      printHeap(A);
  
      System.out.println(minimum(A));
      System.out.println("");
      System.out.println(extractMin(A));
      System.out.println("");
  
      printHeap(A);
  
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
      System.out.println(extractMin(A));
    }
  }
      
