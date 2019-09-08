import java.util.LinkedList;

class tries{
    public static void main(String[] args) {
        
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
    
    public static void insert(String key){
        int index=-1;
        Node start = root;
        for(int i=0;i<key.length();i++){
            index = key.charAt(i)-'a';
            if(start.children[index]==null){
                root.children[index] = new Node();
            }
            start = start.children[index];
        }
        start.isEndofWord=true;
        start.count++;
    }
      
    public static boolean search(String check){
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
}