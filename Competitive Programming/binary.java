import java.util.Arrays;
import java.util.Scanner;

class binary{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int z = s.nextInt();
            String[] arr = new String[n];
            int[] org = new int[n];
            for(int k=0;k<n;k++){
                int temp = s.nextInt();
                arr[k] = Integer.toString(temp);
                org[k] = temp;
            }
            //System.out.println("n "+n);
            //System.out.println("z "+z);
            //System.out.println(Arrays.toString(arr));
            iter(arr, z, org);
            for(int k=0;k<n;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
    }

    public static void iter(String[] s, int z, int[] org){
        for(int i=0;i<z;i++){
            int j=0;
            while(j<s.length-1){
                if(s[j].equals("0")&&s[j+1].equals("1")){
                    String temp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = temp;
                    j+=2;
                }
                else{
                    j+=1;
                }
            }
        }
    }

    /*public static void iter(String[] s, int z, int[] org){
        int i=0;
        while(i<s.length-1){
        //for(int i=0;i<s.length-1;i++){
            if(s[i].equals("0") && s[i+1].equals("1")){
                //System.out.println("entered fir");
            //if(i+3<s.length && !"0".equals(s[i+2]) && !"1".equals(s[i+3])){
                int count=1;
                if(i+1 < s.length-1){
                  //  System.out.println("s[i+2 "+s[i+2]);
                for(int js=2;js<=s.length-1;js++){
                    //System.out.println("js "+js);
                    if(s[i+js].equals("1")){
                //        System.out.println("hello");
                        count++;
                    }
                    else{break;}
                }}
              //  System.out.println("count "+count);
                String temp = s[i];
                s[i] = s[i+count];
                s[i+count] = temp;
            }
            //System.out.println(Arrays.toString(org)+" org");
            if(i+3 < s.length && s[i+2].equals("0") && s[i+3].equals("1") && org[i]==0 && org[i+1]==1){
               // System.out.println("i "+i);
                int counter =2;
                if(i+4<s.length){
                    int j=i+4;
                  //  System.out.println("j "+j);
                    while(j<s.length-1){
                        if(s[j].equals("0") && s[j+1].equals("1")){
                            counter++;
                        }
                        else{break;}
                        j+=2;
                        //System.out.println("while");
                    }
                }
                System.out.println("counter "+counter);
                int start = i;
                int end = i+(2*counter)-1;
                if(start!=end){
                    int startnew = 0;
                    int endnew = 0;
                    if(z<=counter){
               //         System.out.println("start "+start);
                 //       System.out.println("end "+end);
                    for(int f=0;f<z;f++){
                        s[start+f] = "1";
                        s[end-f] = "0";
                        startnew = start+f+1;
                        endnew = end-f;
                        //System.out.println("firstfor");
                    }
                    int change = counter-z;
                    for(int f=0;f<change;f++){
                        s[startnew] = "0";
                        s[startnew+1] = "1";
                        startnew+=2;
                        //System.out.println("2ndfor");
                    }
                }
                else if(z>counter){
                    for(int f=0;f<counter;f++){
                        s[start+f] = "1";
                        s[end-f] = "0";
                        startnew = start+f+1;
                        endnew = end-f;
             //           System.out.println("thirdfor");
                    } 
                }                    
                }
             //   System.out.println("thirdfor");
                if(i-2>=0){i-=2;}
                else if(i-1>=0){i--;}
            }
            //System.out.println("fini "+i); 
           i++;
           //System.out.println(Arrays.toString(s));
        }
    }*/
}