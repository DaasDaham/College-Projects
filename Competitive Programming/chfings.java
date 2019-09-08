import java.math.BigInteger;
import java.util.Scanner;

class chfings{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        BigInteger modder = new BigInteger("1000000007");
        for(int times=0;times<t;times++){
            String n_nonbig = s.next();
            String k_nonbig = s.next();
            BigInteger answer = new BigInteger("0");
            BigInteger n = new BigInteger(n_nonbig);
            BigInteger k = new BigInteger(k_nonbig);
            answer = answer.add(k.subtract(new BigInteger("1")));
            BigInteger lower_lim = k;
            //System.out.println("yoyo"+answer);
            BigInteger upper_lim = (n.add(k)).subtract(new BigInteger("1"));
            BigInteger stat_upper_lim = upper_lim;
            while(((upper_lim.subtract(lower_lim)).add(new BigInteger("1"))).compareTo(k)==-1){
                //System.out.println("yoyoloop"+answer+" "+lower_lim+" "+upper_lim);
                BigInteger toadd = k.subtract((upper_lim.subtract(lower_lim)).add(new BigInteger("1")));
                answer = answer.add(toadd);
                lower_lim = lower_lim.add(k);
                upper_lim = upper_lim.add(stat_upper_lim);
            } 
            BigInteger fin = answer.mod(modder);
            System.out.println(fin);
        }
    }
}