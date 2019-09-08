import java.util.Arrays;

class what_is_and{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(7)));
    }
    public static int[] countBits(int num) {
        int[] onesCount = new int[num+1];
        
        // Loop from 0 to num, for each i
        // Find i & (i-1), increment +1 to the count of ones for its result
        for (int i = 1 ; i <= num ; i++) {
            int andResult = i & (i-1);
            System.out.println(andResult+" yoyo");
            onesCount[i] = onesCount[andResult] + 1;
        }
        
        return onesCount;
    }
}