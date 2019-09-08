import java.io.*;

public class alice_bob{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().trim().split(" ");
        long a = Long.parseLong(nm[0]);
        long b = Long.parseLong(nm[1]);
        long x = Long.parseLong(nm[2]);
        long y = Long.parseLong(nm[3]);
        long lcm = (a*b)/(gcd(a, b));
        long ans = (y/lcm)-((x-1)/(lcm));
        System.out.println(ans);
    }
    public static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}