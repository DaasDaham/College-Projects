import java.util.Arrays;
import java.util.Scanner;

class pt{
    public static void main(String[] args){
        int counter=0;
        for(int i=1;i<20000000;i++){
            int sum=0;
            String st = Integer.toString(i);
            for(int j=0;j<st.length();j++){
                sum += Character.getNumericValue(st.charAt(j));
            }
            if(sum%10==0){
                counter++;
                if(sum==20){
                    System.out.println("this is 20 "+i+" count20 "+counter);
                }
                else if(sum == 30){
                    System.out.println("this is 30 "+i+" count30 "+counter);
                }
                else if(sum==10){
                    System.out.println("this is 10 "+i+" count10 "+counter);
                }
            }
        }
        //System.out.println("yoyo "+counter);
    }
}
