import java.util.Arrays;
import java.util.Scanner;

class proxyc{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int k=0;k<t;k++){
        int d = s.nextInt();
        double d2 = Double.valueOf(d);
        String attend = s.next();
        double count = 0;
        int finans=0;
        boolean anstate = false;
        int[] arr = new int[d];
        for(int i=0;i<d;i++){
            if(attend.charAt(i) == 'P'){
                arr[i] = 1;
                count+=1;
            }
            else{
                arr[i] = 0;
            }
        }
        if(count/d2 >= 0.75){
            anstate = true;
        }
        //System.out.println(Arrays.toString(arr));
        //System.out.println(d2);
        double ans = 0;
        if(d>4 && anstate==false){
            for(int x=2;x<d-2;x++){
                if((arr[x-2]==1 || arr[x-1]==1)&&(arr[x]==0)&&(arr[x+1]==1 || arr[x+2]==1)){
                    count+=1;
                    finans+=1;
                    if((count/d2)>=0.75){
                        anstate=true;
                        break;
                    }
                }
            }
        }
        else{
            if((count/d2) >= 0.75){
                anstate=true;
            }
        }

        if(anstate==true){
            System.out.println(finans);
        }
        else{
            System.out.println(-1);
        }
    }
    }
}