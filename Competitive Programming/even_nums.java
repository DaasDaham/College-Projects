import java.io.*;
public class even_nums{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        long[] arr = new long[n];
        for(int i=0;i<q;i++){
            String[] qu = br.readLine().trim().split(" ");
            if(qu[0].equals("a")){
                int index = Integer.parseInt(qu[1])-1;
                long to_add = Long.parseLong(qu[2]);
                arr[index]+=to_add;
            }
            else{
                int L = Integer.parseInt(qu[1])-1;
                int R = Integer.parseInt(qu[2])-1;
                long count = 0;
                for(int j=L;j<=R;j++){
                    if(arr[j]%2==0){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}