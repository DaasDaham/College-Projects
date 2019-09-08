import java.util.*;

class alice_DS{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        int sum=0;
        int fin=n-1;
        int checker = 0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=k){
                sum+=i;
                fin = i;
                checker++;
            }
        }
        int start = 0;
        int end = 0;
        if(checker == 0){
            end = fin;
        }
        else{
            end = fin-1;
        }
        while(true){
            if(arr[end]+arr[start]>=k){
                sum+=(end-start);
                end--;
                start=0;
            }
            else if(end==start){
                break;
            }
            else{
            start++;}
        }
        System.out.println(sum);
    }
}

