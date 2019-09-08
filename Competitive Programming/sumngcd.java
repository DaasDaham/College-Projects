import java.util.HashSet;
import java.util.*;
import java.util.Scanner;

class sumngcd{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int times=0;times<t;times++){
            int n = s.nextInt(); 
            long[] arr = new long[n];
            long fin_ans =0;
            long maxi = -1;
            long second_max = -1;
            long s_max_pos = -1;
            long this_is =0;
            Set<Long> card = new HashSet<Long>();
            for(int for_arr=0;for_arr<n;for_arr++){
                arr[for_arr] = s.nextInt();
                //String temp_str = Integer.toString(arr[for_arr]);
                if(card.size()<=4){
                    card.add(arr[for_arr]);
                }
                if(arr[for_arr]>maxi){
                    maxi = arr[for_arr];
                    this_is = for_arr;
                }
            }
            for(int i=0;i<n;i++){
                if(arr[i]!=maxi){
                    if(arr[i]>second_max){
                        second_max = arr[i];
                        s_max_pos = i;
                    }
                }
            }
            Iterator<Long> value = card.iterator();
            if(card.size() == 1){
                //System.out.println("car1");
                fin_ans = arr[0]*2;
            }
            else if(card.size()==2){
               // System.out.println("car2");
                fin_ans+=(value.next()).longValue();
                fin_ans+=(value.next()).longValue();
            }
            else{
            int fin_iter=0;
            int anon_iter=0;
            int counter = 0;
            for(int blah=0;blah<n;blah++){
                if(arr[blah]!=maxi && arr[blah]!=second_max){
                    counter++;
                }
            }
            int new_n = counter+2;
            long[] final_arr = new long[new_n];
            while(fin_iter<new_n && anon_iter<arr.length){
                //System.out.println(Arrays.toString(final_arr)+" yoyo");
                if(arr[anon_iter]!=maxi && arr[anon_iter]!=second_max){
                    final_arr[fin_iter] = arr[anon_iter];
                    fin_iter++;
                }
                anon_iter++;
            }
            final_arr[new_n-1] = maxi;
            final_arr[new_n-2] = second_max; 
            //System.out.println(Arrays.toString(final_arr));
                //System.out.println("f_max: "+final_arr[n-1]+" s_max: "+final_arr[n-2]);
                long gcd_of_lowers = n_gcd(final_arr, new_n-2);
                long gcd_first_max = gcd(gcd_of_lowers, final_arr[new_n-1]);
                long gcd_second_max = gcd(gcd_of_lowers, final_arr[new_n-2]);
                long a1 = maxi+gcd_second_max;
                long a2 = second_max+gcd_first_max;
                //System.out.println("gcn2 "+gcd_of_lowers+" gcd_fm "+gcd_first_max+" gcd_sm "+gcd_second_max);
                //System.out.println("a1 "+a1+" a2 "+a2);
                if(a1>a2){
                    fin_ans = a1;
                }
                else{
                    fin_ans=a2;
                }
            }
            System.out.println(fin_ans);
        }
    }

    public static long n_gcd(long[] arr, long n){
        long res = arr[0];
        for(int i=1;i<n;i++){
            res = gcd(arr[i], res);
        }
        return res;
    }

    public static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}