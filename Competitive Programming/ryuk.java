import java.util.Scanner;

public class ryuk{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = s.nextInt();
            }
            int result = iter(arr);
            System.out.println(result);
        }
    }
    public static int iter(int[] arr){
        MergeSort mg = new MergeSort();
        mg.sort(arr, 0, arr.length-1);
        int counter=1;
        if(arr.length > 2){
        int i = arr.length-2;
        int firstsum=100-arr[i+1];
        while(i>=0){
            int f = arr[i]+firstsum;
            if(f>=50){
                counter++;
            }
            else{
                break;
            }
            i--;
        }}
        else if(arr.length == 2){
            int fs = 100-arr[1];
            if(arr[0]+fs >= 50){
                counter++;
            }
        }
        return counter;
    }
}

class MergeSort 
{ 
    void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
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
    void sort(int arr[], int l, int r) 
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

   