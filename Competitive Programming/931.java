class 931{
    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.minFallingPathSum({{17, 82}, {1, -44}});
    }
}

class Solution {
    public static int ans = Integer.MAX_VALUE;
    public static int[][] cpyA;
    public static int[][] memo;
    public static boolean[][] vis;
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        if(n==1){
            return A[0][0];
        }
        else{
            cpyA = A;
            memo = new int[n][n];
            vis = new boolean[n][n];
            for(int i=0;i<n;i++){
                ans = Math.min(ans, recur(0, i, n, cpyA[0][i]));
            }
            return ans;
        }
    }
    
    public static int recur(int x, int y, int n, int sum){
        if(x == n-1){
            return sum;
        }
        else if(vis[x][y]!=false){
            return memo[x][y];
        }
        else{
            if(y<=n-1 && y>=0){
                ans = Math.min(ans, recur(x+1, y, n, sum+cpyA[x+1][y]));
            }
            else if(y<n-1){
                ans = Math.min(ans, recur(x+1, y+1, n, sum+cpyA[x+1][y+1]));
            }
            else if(y>0){
                ans = Math.min(ans, recur(x+1, y-1, n, sum+cpyA[x+1][y-1]));
            }
            memo[x][y] = ans;
            vis[x][y] = true;
            return ans;
        }
    }
}
