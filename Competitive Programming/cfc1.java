import java.util.*;

public class cfc1{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        String[] initvalues = new String[m];
        int counter = 0;
        HashMap<String,Integer> team_ques = new HashMap<>();
        for(int i=0;i<m;i++){
            String team = s.next();
            initvalues[counter] = team;
            counter++;
            int pen = s.nextInt();
            if(team_ques.containsKey(team)){
                team_ques.put(team, team_ques.get(team)+1000-pen);
            }
            else{
                team_ques.put(team, 1000-pen);
            }
        }
        Map<String, Integer> shm = sortByValue(team_ques);
        int n_elements = 0;
        int rank = 0;
        int val_of_bm = team_ques.get("BhayanakMaut");
        for (Map.Entry<String, Integer> en : shm.entrySet()){
            n_elements = n_elements+1;
            if(en.getKey().equals("BhayanakMaut")){
                System.out.println("yoyo"+n_elements);
                rank = n_elements;
            } 
            //System.out.println("Key = " + en.getKey() +  
            //              ", Value = " + en.getValue()); 
        }
        Stack sk = new Stack();
        for(Map.entry<String, Integer> ab : shm.entrySet()){
            if(ab.getValue() == val_of_bm){
                if(sk.size != 0){
                    if(checker(initvalues, sk.top.team_name)){
                         
                    }
                }
            }
        } 
        //System.out.println("initrank"+rank);
        rank = n_elements+1-rank;
        System.out.println(rank);
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    }

    public static boolean checker(String[] arr, String to_find){
        int index_of_new_string = 0;
        int index_of_bm = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(to_find)){
                index_of_new_string = i;
            }
            if(arr[i].equals("BhayanakMaut")){
                index_of_bm = i;
            }
        }
        if(index_of_bm>index_of_new_string){
            return false;
        }
        else{
            return true;
        }
    }
    
}

class Node{
    Node next;
    String team_name;
    int num;
    Node(int num, String team_name){
        this.num = num;
        this.team_name = team_name;
        next = null;
    }
}

class Stack{
    Node top;
    int size;
    Stack(){
        top = null;
        size = 0;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public void push(int val, String tm){
        Node nptr = new Node(val, tm);
        nptr.next = top;
        top = nptr;
        size++;
    }

    public Node pop(){
        Node to_return = top;
        top = top.next;
        size--;
        return to_return;
    }

    public int peek(){
        int d = top.num;
        return d;
    }
}
