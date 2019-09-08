class min_climb_stairs{
    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(arr));
    }   

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans = 0;
        int f1= cost[1];
        int f0 = cost[0]; 
        for(int i=2;i<n;i++){
            int curr = cost[i]+Math.min(f0, f1);
            f0 = f1;
            f1 = curr;
        }
        return Math.min(f0, f1);
    }
}