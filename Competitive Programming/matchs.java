import java.util.Arrays;
import java.util.Scanner;

class matchs{
    static double[][] dp = new double[10000][10000];
    static double[][] dp4 = new double[10000][10000];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            String no = s.next();
            String mo = s.next();
            double n = Double.parseDouble(no);
            double m = Double.parseDouble(mo);
            double result = grundy(n, m);
            if(result == 0){
                System.out.println("Rich");
            }
            else{
                System.out.println("Ari");
            }
        }
    }

    public static double grundy(double a, double b){
        if(a<10000 && b<10000 && dp[(int)a][(int)b]!=0){
            //System.out.println("yyo");
            return dp[(int)a][(int)b];
        }
        else if(a<10000 && b<10000 && dp[(int)b][(int)a]!=0){
            //System.out.println("2nd one");
            return dp[(int)b][(int)a];
        }
        else{
            if(a==0||b==0){
                //System.out.println("0 wali cond");
                return 0;
            }
            else if(a<b){
                LL l = new LL();
                for(int k=1;k<=b;k++){
                    if(a*k <= b){
                        //System.out.println("k "+k);
                        l.insert(grundy(a, b-(a*k)));
                    }
                    else{
                        break;
                    }
                }
                /*int[] gr = new int[l.size];
                for(int k=0;k<l.size;k++){
                    gr[k] = l.start.num;
                    System.out.println("elem "+gr[k]);
                    l.start = l.start.next;
                }*/
                //System.out.println("mex "+mex(l));
                double finale = mex(l);
                if(a<10000 && b<10000){
                dp[(int)a][(int)b] = finale;
                dp[(int)b][(int)a] = finale;
                dp4[(int)b][(int)a] = finale;
                }
                return finale;
            }
            else if(a==b){
                //System.out.println("== wali cond");
                LL l = new LL();
                if(a<10000 && b<10000){
                dp[(int)a][(int)b] = 1;
                dp[(int)b][(int)a] = 1;
                dp4[(int)b][(int)a] = 1;}
                return 1;
            }
            else{
                LL l = new LL();
                for(int k=1;k<=a;k++){
                    if(b*k <= a){
                        l.insert(grundy(a-(b*k), b));
                    }
                    else{
                        break;
                    }
                }
                double fin = mex(l);
                if(a<10000 && b<10000){
                dp[(int)a][(int)b] = fin;
                dp[(int)b][(int)a] = fin;
                dp4[(int)b][(int)a] = fin;}
                return fin;
            }
        }
    }

    public static double mex(LL l){
        double[] arr = new double[l.size];
        int i=0;
        while(l.start!=null){
            //System.out.println("yoyo "+l.start.num);
            arr[i] = l.start.num;
            i++;
            l.start = l.start.next;
        }
        MergeSort m = new MergeSort();
        m.sort(arr, 0, arr.length-1);
        double miss=0;
        //System.out.println(Arrays.toString(arr));
        for(int j=0;j<arr.length;j++){
            if(arr[j] == miss){
                miss++;
            }
            else if(arr[j]>miss){
                break;
            }
        }
        return miss;
    }
}

class Node{
    Node next;
    double num;
    Node(double data){
        num = data;
        next = null;
    }
}

class LL{
    Node start;
    int size;
    public LL(){
        start = null;
        size = 0;
    }
    public void insert(double data){
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

class MergeSort 
{ 
    void merge(double arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        double L[] = new double [n1]; 
        double R[] = new double [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }  
    void sort(double arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
  
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
}

/*import java.util.Scanner;

class test{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int k=0;k<t;k++){
            String ns = s.next();
            String ms = s.next();
            double n = Double.parseDouble(ns);
            double m = Double.parseDouble(ms);
            int res = (int)play(n, m);
            if(res%2==0 || res==0){
                System.out.println("Ari");
            }
            else{
                System.out.println("Rich");
            }
        }
    }

    public static double play(double m, double n){
        if(m>n){
            int counter=0;
            for(int i=2;i<=m;i++){
                if(n*i > m){
                    break;
                }
                else{
                    counter++;
                }
            }
            if(counter > 0){
                return 0;
            }
            else{
                return 1+play(m-n, n);
            }
        }
        else if(n>m){
            int counter2=0;
            for(int j=2;j<=n;j++){
                if(m*j > n){
                    break;
                }
                else{
                    counter2++;
                }
            }
            if(counter2 > 0){
                return 0;
            }
            else{
                return 1+play(m, n-m);
            }
        }
        else{
            return 0;
        }
    }
}*/