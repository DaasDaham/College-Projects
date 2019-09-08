import java.io.BufferedReader;
import java.io.InputStreamReader;

class max_subarray{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println(maxSubArray(nums));
    }

    public static long maxSubArray(int[] nums){
        long ans=Integer.MIN_VALUE;
        long[] dp = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                dp[i] = nums[i];
            }
            else{
                dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}