import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.*;
import java.util.*;

class chfm{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int times=0;times<t;times++){
            int n = Integer.parseInt(br.readLine());
            String[] k = br.readLine().trim().split(" ");
            int fin_ans = 0;
            double sum = 0;
            for(int i=0;i<n;i++){
                sum = sum+Double.parseDouble(k[i]);
            }
            //System.out.println(sum+" sum");
            boolean ans_state = false;
            double init_avg = sum/n;
            //System.out.println(init_avg+" avg befor entering loop");
            for(int i=0;i<n;i++){
                double mid_sum = sum-Double.parseDouble(k[i]);
                //System.out.println("mdisum "+mid_sum);
                double anot_avg = mid_sum/(n-1);
                //System.out.println(k[i]+" "+anot_avg+" new avg");
                //System.out.println(init_avg+" old_avg");
                if(Double.compare(anot_avg, init_avg)==0){
                    fin_ans = i+1;
                    ans_state=true;
                    break;
                }
            }
            if(ans_state==false){
                System.out.println("Impossible");
            }
            else{
                System.out.println(fin_ans);
            }
        }
    }

}