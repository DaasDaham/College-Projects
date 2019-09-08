import java.util.Scanner;
import java.util.*;

public class vasya{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] arr = new String[n];
        String yo = s.next();
        for(int i=0;i<n;i++){
            arr[i] = Character.toString(yo.charAt(i));
        }
        //arr[0] = s.next();
        //System.out.println(Arrays.toString(arr));
        System.out.println(stone(arr));
    }
    public static int stone(String[] arr){
        int init = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("-")){
                if(init-1 >= 0){
                    init--;
                }
                else{
                    init+=1;
                    init--;
                }
            }
            else{
                init++;
            }
        }
        return init;
    }
}