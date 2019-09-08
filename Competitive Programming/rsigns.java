import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class rsigns{
    static int m = 1000000007;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int times=0;times<t;times++){
            int k = s.nextInt();
            long ans=0;
            if(k>1){
                ans = power(2, k-1);
            }
            else{
                ans = 1;
            }
            ans = ans*10;
            System.out.println(ans%m);
            //BigInteger bg = BigDecimal.valueOf(kkk).toBigInteger();
            //bg = bg.multiply(new BigInteger("10"));
        }
    }

    public static long power(long a, long N){
        if(N==1){
            return a;
        }
        else if(N%2!=0){
            long jk = power(a, N/2);
            return ((a)*(jk%m)*(jk%m))%m;
        }
        else{
        long ans = power(a, N/2);
        return ((ans%m)*(ans%m))%m;}
    }
}