import java.io.*;
import java.util.*;

class angrybirfs{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
    }
}

class Graph{
    public int[][] adj_mat;
    public int V;

    public Graph(int V, int[][] adj_mat){
        this.V = V;
        this.adj_mat = adj_mat;
    }
    public void DFS(int i, boolean[] vis){
        if(!vis[i]){
            vis[i] = true;
        }
        for(int j=0;j<adj_mat[i].length;j++){
            if(adj_mat[i][j]!=0 && vis[j]==false){
                DFS(j, vis);
            }
        }
    }
}
