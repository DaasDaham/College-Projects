import java.io.*; 
import java.util.*; 
  
class mylab{  
    public static void main(String args[]) 
    { 
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int[] noise = new int[n];
            for(int j=0;j<n;j++){
                noise[j] = s.nextInt();
            }
            int m = s.nextInt();
            int[][] pairs = new int[m][2];
            for(int j=0;j<m;j++){
                pairs[j][0] = s.nextInt();
                pairs[j][1] = s.nextInt();
            }
            Graph grp = new Graph(n);
            for(int k=0;k<m;k++){
                //System.out.println("pairs[k][1]-1 "+pairs[k][1]+" pairs[k][0]-1 "+pairs[k][0]);
                grp.addEdge((pairs[k][1]-1), (pairs[k][0]-1));
            }
            int q = s.nextInt();
            int[] anslst = new int[q];
            for(int kk = 0;kk<q;kk++){
                int ansto = s.nextInt();
                anslst[kk] = ansto-1;
            }
            for(int fj=0;fj<q;fj++){
                grp.findNeighbours(anslst[fj], noise);
            }
        } 
    } 
} 

class Graph 
{ 
    public int vertex;   
    public LinkedList<Integer> adjlst[];
    
    public Graph(int vertex) 
    { 
        //System.out.println(Arrays.deepToString(arr));
        this.vertex = vertex; 
        adjlst = new LinkedList[vertex]; 
        for(int i=0;i<vertex;++i){
            adjlst[i] = new LinkedList(); 
        }
    } 
    public void addEdge(int n1,int n2){ 
        adjlst[n1].add(n2); 
    } 
    public void findNeighbours(int curr, int[] noise) 
    {   
        int notcheck = curr;       
        int ans = Integer.MAX_VALUE;
        boolean visited[] = new boolean[vertex]; 
        LinkedList<Integer> obj = new LinkedList<Integer>(); 
        visited[curr]=true; 
        obj.add(curr); 
        while (obj.size()!=0){ 
            curr = obj.poll(); 
            if((curr!=notcheck)&&(noise[curr]<ans)){
                ans = noise[curr];
            }
            //System.out.println("ans"+ans);
            //System.out.println("thsiiscurr"+curr+" "); 
            Iterator<Integer> i = adjlst[curr].listIterator(); 
            while (i.hasNext()){ 
                int n = i.next(); 
                if (!visited[n]){ 
                    visited[n] = true; 
                    obj.add(n); 
                } 
            }
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        } 
        else{
            System.out.println(ans);
        }
    } 
}
