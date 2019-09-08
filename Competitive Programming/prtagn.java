import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class prtagn{
    public static int[] dp = new int[10000000];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer ans =  new StringBuffer();
        for(int times=0;times<t;times++){
            int q = Integer.parseInt(br.readLine());
            Set<Integer> val = new HashSet<>();
            int E=0;
            int O=0;
            for(int i=0;i<q;i++){
                int to_add = Integer.parseInt(br.readLine());
                if(val.isEmpty()){
                    val.add(to_add);
                    if(Integer.bitCount(to_add)%2==0){
                        E++;
                    }
                    else{
                        O++;
                    }
                }
                else if(!val.contains(to_add)){
                    Set<Integer> val2 = new HashSet<>();
                    Iterator<Integer> abc = val.iterator();
                    while(abc.hasNext()){
                        int temp = abc.next();
                        if(temp!=to_add){
                            int xor = temp^to_add;
                            if(!val.contains(xor)){
                                val2.add(xor);
                                if(Integer.bitCount(xor)%2==0){
                                    E++;
                                }       
                                else{
                                    O++;
                                }                         
                            }
                        }
                    }
                    val.addAll(val2);
                    if(!val.contains(to_add)){
                        val.add(to_add);
                        if(Integer.bitCount(to_add)%2==0){
                            E++;
                        }
                        else{
                            O++;
                        }
                        val.add(to_add);
                    } 
                }
                if(times==t-1 && i==q-1){
                    ans.append(E+" "+O);
                }
                else{ans.append(E+" "+O+"\n");}
            }
        }
        System.out.println(ans);
    }
}