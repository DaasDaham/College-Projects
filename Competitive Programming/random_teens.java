import java.io.*;
import java.util.Arrays;
public class random_teens{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long max=0;
        if(n-m+1>=2){max = binomialCoeff(n-m+1, 2);}
        int min_1 = n/m;
        //int[] arr = new int[m];
        int num_of_min_1 = m;
        int count = m;
        int left = n-(count*min_1);
        int tol = 0;
        while(tol<left){
            num_of_min_1--;
            tol++;
        }
        long nim = 0;
        if(min_1!=1){
            long min_1_bin = binomialCoeff(min_1, 2);
            nim+=(num_of_min_1*min_1_bin);
        }
        long min_1_plus_bin = binomialCoeff(min_1+1, 2);
        nim+=(m-num_of_min_1)*min_1_plus_bin;
        //System.out.println(min_1+" ag "+min_1_bin+" "+min_1_plus_bin);
        //System.out.println(Arrays.toString(arr));
        
        System.out.println(nim+" "+max);
    }
    static long binomialCoeff(int n, int k) 
    { 
        long res = 1; 
        if ( k > n - k ){k = n - k;}       
        for (int i = 0; i < k; ++i){ 
        res *= (n - i); 
        res /= (i + 1); 
        } 
        return res; 
    } 
      
}