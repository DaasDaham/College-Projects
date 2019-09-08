import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class rsigns{
    static BigInteger m = new BigInteger("1000000007");
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int times=0;times<t;times++){
            int k = s.nextInt();
            k = k-1;
            String k2 = Integer.toString(k);
            BigInteger ans= new BigInteger("0");
            if(k>1){
                ans = power(new BigInteger("2"), new BigInteger(k2));
            }
            else{
                ans = new BigInteger("1");
            }
            ans = ans.multiply(new BigInteger("10"));
            System.out.println(ans);
        }
    }

    public static BigInteger power(BigInteger a, BigInteger N){
        if(N.equals(new BigInteger("1"))){
            return a;
        }
        if(!(N.mod(new BigInteger("2")).equals(new BigInteger("0")))){
            return ((a.mod(m)).multiply((power(a, N.subtract(new BigInteger("1"))).mod(m))));
        }
        BigInteger ans = power(a, N.divide(new BigInteger("2")));
        return (ans.multiply(ans)).mod(m);
    }
}