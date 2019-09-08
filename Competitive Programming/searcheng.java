import java.io.*;
import java.util.Arrays;

class searcheng{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer ans =  new StringBuffer();
        String[] n_q = br.readLine().trim().split(" ");
        int n = Integer.parseInt(n_q[0]);
        int q = Integer.parseInt(n_q[1]);
        trie our_trie = new trie();
        for(int i=0;i<n;i++){
            String[] temp = br.readLine().trim().split(" ");
            our_trie.insert(temp[0], Integer.parseInt(temp[1]));
        }
        int prev = -1;
        String prevq="";
        for(int i=0;i<q;i++){
            String check = br.readLine().trim();
            int yoyo =-2;
            if(check.equals(prevq)){
                yoyo = prev;
            }
            else{yoyo = our_trie.query(check);}
            if(i==q-1){
                ans.append(yoyo);
            }
            else{
            ans.append(yoyo+"\n");}
            prevq= check;
            prev = yoyo;
        }
        System.out.println(ans);
    }
}

class Node{
    int count;
    Node[] children = new Node[26];
    boolean isEndofWord;
    public Node(){
        count=0;
        isEndofWord=false;
        for(int i=0;i<26;i++){
            children[i] = null;
        }
    }
}

class trie{
    static Node root = new Node();
    public static int max=Integer.MIN_VALUE;
    
    public void insert(String key, int weight){
        int index=-1;
        Node start = root;
        for(int i=0;i<key.length();i++){
            index = key.charAt(i)-'a';
            if(start.children[index]==null){
                start.children[index] = new Node();
            }
            start = start.children[index];
        }
        start.isEndofWord=true;
        start.count=weight;
    }
      
    public boolean search(String check){
        int index=-1;
        Node start = root;
        for(int i=0;i<check.length();i++){
            index = check.charAt(i)-'a';
            if(start.children[index]==null){
                return false;
            }
            start = start.children[index];
        }
        return(start!=null && start.isEndofWord!=false);
    }

    public int query(String check){
        max=0;
        int index=-1;
        Node start= root;
        for(int i=0;i<check.length();i++){
            index = check.charAt(i)-'a';
            if(start.children[index]==null){
                return -1;
            }
            start = start.children[index];
        }
        if(start==null){
            return -1;
        }
        else{
            //System.out.println("entered else of query "+Arrays.toString(start.children));
            inQuery(start);
            return max;
        }
    }

    public static void inQuery(Node start){
        if(start.isEndofWord){
            if(start.count>max){
                max = start.count;
                //System.out.println("max: "+max);
            }
            return;
        }
        for(int i=0;i<start.children.length;i++){
            if(start.children[i]!=null){
                inQuery(start.children[i]);
            }
        }
    }
}