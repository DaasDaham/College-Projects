import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer; 

class chfing{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        BigInteger modder = new BigInteger("1000000007");
        for(int times=0;times<t;times++){
            BigInteger n = new BigInteger(s.next());
            BigInteger k = new BigInteger(s.next());
            BigInteger lower_lim = k;
            BigInteger final_ans = new BigInteger("0");
            BigInteger upper_lim = (k.add(n)).subtract(new BigInteger("1"));
            if(n.equals(new BigInteger("2"))){
                final_ans = final_ans.add(k.subtract(new BigInteger("1")));
                BigInteger to_val = lower_lim.subtract((upper_lim.subtract(lower_lim)).add(new BigInteger("1")));
                BigInteger a1 = to_val;
                BigInteger a2 = to_val.add(new BigInteger("1"));
                BigInteger divi = new BigInteger("2");
                //System.out.println("card "+to_val+" a1 "+a1+" a2 "+a2+" fin "+final_ans);
                final_ans = final_ans.add((a1.multiply(a2)).divide(divi));
            }
            else{
                final_ans = final_ans.add(k.subtract(new BigInteger("1")));
                BigInteger to_v = upper_lim.subtract(lower_lim);
                BigInteger d = to_v;
                BigInteger a = k.subtract(n);
                //System.out.println("d: "+d+" a: "+a);
                BigInteger first_term = a.mod(d);
                BigInteger term = ((a.subtract(first_term)).divide(d)).add(new BigInteger("1"));
                BigInteger add1 = term.multiply(a.add(first_term));
                final_ans = final_ans.add(add1.divide(new BigInteger("2")));

            }
            final_ans = final_ans.mod(modder);
            System.out.println(final_ans);
        }
    }
}