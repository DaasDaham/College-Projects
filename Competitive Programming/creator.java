import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.io.*;
import java.util.*;

public class creator{
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] times = br.readLine().trim().split(" ");
        int[] h_time = new int[n];
        Comparator<Num> n_Comparator = new Comparator<Num>() {
            public int compare(Num num1, Num num2){
                if(num1.num_times == Math.max(num1.num_times, num2.num_times)){
                    return -1;
                }
                else if(num2.num_times == Math.max(num1.num_times, num2.num_times)){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        };
        LinkedList<Num> lk = new LinkedList<>();
        boolean[] added = new boolean[100005];
        for(int i=0;i<n;i++){
            h_time[i] = Integer.parseInt(times[i]);
        }
        PriorityQueue<Num> pq = new PriorityQueue<>(n_Comparator);
        
        int[] freq = new int[100005];
        for(int i=0;i<n;i++){
            freq[h_time[i]]++;
        }
        for(int i=0;i<n;i++){
            if(!added[h_time[i]]){pq.add(new Num(freq[h_time[i]], h_time[i]));}
            added[h_time[i]] = true;
        }
        //while(!pq.isEmpty()){
        //    System.out.println(pq.peek().data+" "+pq.peek().num_times);
        //    pq.poll();
        //}
        Num prev = new Num(0, 0);
        while(!pq.isEmpty()){
            Num temp = pq.poll();
            lk.add(temp);
            if(prev.num_times>0){pq.add(prev);}
            prev=temp;
            prev.num_times-=1;
        }
        //Iterator<Integer> abc = lk.iterator();
        //while(abc.hasNext()){
        //    System.out.println(abc.next());
        //}
        if(lk.size()!=n){System.out.println("No");}
        else{System.out.println("Yes");}
    }
}

class Num{
    int num_times;
    int data;
    Num(int num_times, int data){
        this.data = data;
        this.num_times = num_times;
    }
}