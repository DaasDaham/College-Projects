import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class mmax{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int times=0;times<t;times++){
            String n_temp = br.readLine();
            String temp =  br.readLine();
            BigInteger n = new BigInteger(n_temp);
            BigInteger k = new BigInteger(temp);
            int[] arr = new int[Integer.parseInt(n_temp)];
            if(k.compareTo(n)==-1){
                int fin_ans = 0;
                int ni = Integer.parseInt(n_temp);
                int ki = Integer.parseInt(temp);
                if((ni-1)%2 == 0){
                    if(ki<=(ni/2)){
                        fin_ans = ki*2;
                    }
                    else{
                        fin_ans = (ni-ki)*2;
                    }
                }
                else{
                    if(ki*2==ni){
                        fin_ans = ki*2-1;
                    }
                    else if(ki<ni/2){
                        fin_ans = ki*2;
                    }
                    else if(ki>ni/2){fin_ans = (ni-ki)*2;}
                }
                System.out.println(fin_ans); 
            }
            else if(k.compareTo(n)==0){
                System.out.println(0);
            }
            else{
                int ans = 0;
                BigInteger modder = k.mod(n);
                int k2 = modder.intValue();
                int n2 = n.intValue();
                if((n2-1)%2 == 0){
                    if(k2<=(n2/2)){
                        ans = k2*2;
                    }
                    else{
                        ans = (n2-k2)*2;
                    }
                }
                else if(k2==0){ans=0;}
                else{
                    if(k2*2==n2){
                        ans = k2*2-1;
                    }
                    else if(k2<n2/2){
                        ans = k2*2;
                    }
                    else if(k2>n2/2){ans = (n2-k2)*2;}
                }
                System.out.println(ans);
            }
        }
    }
}


                    