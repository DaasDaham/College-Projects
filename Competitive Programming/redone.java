import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 

class redone{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in)); 
  
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int t = Integer.parseInt(st.nextToken());  
        int[] arr = new int[1000000];
        while (t-- > 0) 
        { 
            int n = Integer.parseInt(br.readLine());
            int co=n-1;
            while(co >0){
                if(arr[co]!=0){
                    break;
                }
                co--;
            } 
            int start = co;
            int init = co;
            if(start==0){
                start++;
            }
            //System.out.println("yoyo"+arr[start]);
            //System.out.println("ddd"+start);
            double k = Math.pow(10,9)+7;
            double dopp = n;
            double sum=0;
            if(init>0){
            sum = (arr[start]+dopp+(arr[start]*dopp))%k;
            start+=2;
            init++;
            dopp = sum;}
            int fj = n-init-1;
            //System.out.println("fj"+fj);
            for(int j=0;j<fj;j++){
                sum = (start+dopp+(start*dopp))%k;
                dopp = sum; 
                start++;
            }
            //System.out.println("fin "+dopp);
            arr[n-1] = (int)(dopp);
            //double l = (dopp);//%(Math.pow(10,9)+7)));
            System.out.println(Math.round(dopp));
            
        }
    }
}