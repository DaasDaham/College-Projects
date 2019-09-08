import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;

class slush{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
        for(int times=0;times<t;times++){
            StringBuffer ans =  new StringBuffer();
            String[] k = br.readLine().trim().split(" ");
            int n = Integer.parseInt(k[0]);
            int m = Integer.parseInt(k[1]);
            k = br.readLine().trim().split(" ");
            int[] ci = new int[m];
            //boolean[] missed = new boolean[n];
            for(int i=0;i<m;i++){
                ci[i] = Integer.parseInt(k[i]);                
            }
            int[][] cust = new int[n][3];
            int[] answers = new int[n];
            LinkedList<Integer> lk = new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                k = br.readLine().trim().split(" ");
                cust[i][0] = Integer.parseInt(k[0]);
                cust[i][1] = Integer.parseInt(k[1]);
                cust[i][2] = Integer.parseInt(k[2]);
            }
            long fin_ans = 0;
            for(int i=0;i<n;i++){
                if(ci[cust[i][0]-1]>0){
                    ci[cust[i][0]-1]--;
                    fin_ans= fin_ans+cust[i][1];
                    answers[i] = cust[i][0];
                }
                else{
                    fin_ans+=cust[i][2];
                    answers[i]=-1;
                    lk.add(i);
                }
            }
            Iterator<Integer> abc = lk.iterator();
            for(int i=0;i<m;i++){
                while(ci[i]!=0){
                    if(abc.hasNext()){
                    answers[abc.next()] = i+1;
                    ci[i]--;}
                    else{
                        break;
                    }
                }
                if(abc.hasNext()==false){
                    break;
                }
            }
            ans.append(fin_ans+"\n");
            for(int i:answers){
                ans.append(i+" ");
            }
            ans.append("\n");
            System.out.println(ans);
        }
    }
}