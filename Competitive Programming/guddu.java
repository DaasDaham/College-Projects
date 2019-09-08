import java.math.BigInteger;
import java.util.Scanner;

class guddu{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int times=0;times<t;times++){
            BigInteger n = new BigInteger(s.next());
            String pre_ans = n.toString();
            String fin_ans = "";
            int sum=0;
            for(int i=0;i<pre_ans.length();i++){
                fin_ans+=pre_ans.charAt(i);
                sum+=Character.getNumericValue(pre_ans.charAt(i));
            }
            //System.out.println(sum);
            String last_bit = Integer.toString(sum);
            int last_bit_int = Character.getNumericValue(last_bit.charAt(last_bit.length()-1));
            //System.out.println(last_bit_int+" yiy");
            if(sum%10 != 0){
                last_bit_int = 10-last_bit_int;    
            }
            last_bit = Integer.toString(last_bit_int);
            //System.out.println(last_bit+" last_bit");
            fin_ans+=last_bit;
            System.out.println(fin_ans);
        }
    }

    public static BigInteger iter(BigInteger n, BigInteger start, BigInteger start_num){
        while(!start.equals(n)){
            start_num = start_num.add(new BigInteger("1"));
            String st = start_num.toString();
            int sum=0;
            int i=0;
            while(i<st.length()){
                sum+=Character.getNumericValue(st.charAt(i));
                i++;
            }
            if(sum%10==0){
                start = start.add(new BigInteger("1"));
            }
            //System.out.println("start, start_num"+start+" "+start_num);
        }
        return start_num;
    }
}

