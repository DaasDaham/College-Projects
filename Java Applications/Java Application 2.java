import java.io.*;
import java.util.*;

class Lab1{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queries q = new Queries();
        q.num_unplaced = n;
        Student[] arr = new Student[n];
        for(int i=0;i<n;i++){
            String[] k = br.readLine().trim().split(" ");
            arr[i] = new Student(Double.parseDouble(k[0]), k[1], i+1);
        }
        q.all_students = arr;
        while(q.num_unplaced!=0){
            String[] query = br.readLine().trim().split(" ");
            if(Integer.parseInt(query[0])==1){
                q.add_company();
            }
            else if(Integer.parseInt(query[0])==2){
                q.remove_account_placed_students();
            }
            else if(Integer.parseInt(query[0])==3){
                q.remove_account_closed_companies();
            }
            else if(Integer.parseInt(query[0])==4){
                q.disp_unplaced_students();
            }
            else if(Integer.parseInt(query[0])==5){
                q.disp_open_companies();
            }
            else if(Integer.parseInt(query[0])==6){
                q.select_students(query[1]);
            }
            else if(Integer.parseInt(query[0])==7){
                q.display_comp_details(query[1]);
            }
            else if(Integer.parseInt(query[0])==8){
                q.disp_student_details(Integer.parseInt(query[1]));
            }
            else if(Integer.parseInt(query[0])==9){
                q.name_companies_by_student(Integer.parseInt(query[1]));
            }
        }
    }
}

class Student{
    public double cgpa;
    public String branch;
    public int roll;
    public boolean placed;
    public int score;
    public HashMap<String, Integer> comp_score_map = new HashMap<>();
    public Student(double cgpa, String branch, int roll){
        this.branch = branch;
        this.cgpa = cgpa;
        this.roll = roll;
    } 
}

class Company{
    public String name;
    public HashSet<String> course_crit;
    public int req_students;
    public String status;
    public ArrayList<Student> tech_scores = new ArrayList<Student>();
    public Company(String name, HashSet<String> course_crit, int req_students){
        this.name = name;
        this.course_crit = course_crit;
        this.req_students = req_students;
        status = "OPEN";
    }
}

class Queries{
    public static ArrayList<Company> companies = new ArrayList<Company>();
    public static Student[] all_students;
    public static int num_unplaced;
    public static int num_open = 0;

    public static void add_company(){
        Scanner s = new Scanner(System.in);
        String name = s.next();
        System.out.print("Number of Eligible Courses = ");
        int no_elg_courses = s.nextInt();
        HashSet<String> course_crit = new HashSet<String>();
        for(int i=0;i<no_elg_courses;i++){
            course_crit.add(s.next());
        }
        System.out.print("Number of Required Students = ");
        int req_students = s.nextInt();
        Company company = new Company(name, course_crit, req_students);
        System.out.println(company.name);
        System.out.println("Course Criteria");
        Iterator<String> iter = company.course_crit.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("Number of Required Students = "+company.req_students);
        System.out.println("Application Status = "+company.status);
        System.out.println("Enter scores for the technical round");
        for(int i=0;i<all_students.length;i+=1){
            if(company.course_crit.contains(all_students[i].branch)){
                System.out.println("Enter score for Roll no. "+all_students[i].roll);
                int students_score = s.nextInt();
                all_students[i].comp_score_map.put(company.name, students_score);
                company.tech_scores.add(all_students[i]);
            }
        }
        companies.add(company);
        num_open++;
    }

    public static void remove_account_placed_students(){
        System.out.println("Accounts removed for");
        for(int i=0;i<all_students.length;i++){
            if(all_students[i].placed){
                System.out.println(all_students[i].roll);
            }
        }
    }

    public static void remove_account_closed_companies(){
        System.out.println("Accounts removed for");
        Iterator<Company> iter = companies.iterator();
        while(iter.hasNext()){
            Company temp = iter.next();
            if(temp.status.equals("CLOSED")){
                System.out.println(temp.name);
            }
        }
    }

    public static void disp_unplaced_students(){
        System.out.println(num_unplaced+" students left.");
    }

    public static void disp_open_companies(){
        Iterator<Company> iter = companies.iterator();
        while(iter.hasNext()){
            Company temp = iter.next();
            if(temp.status.equals("OPEN")){
                System.out.println(temp.name);
            }
        }
    }

    public static void select_students(String compName){
        ArrayList<Integer> selectedRoll = new ArrayList<>();
        Iterator<Company> iter = companies.iterator();
        while(iter.hasNext()){
            Company pickStudents = iter.next();
            if(pickStudents.name.equals(compName)){
                if(pickStudents.status.equals("OPEN")){
                    PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());
                    Iterator<Student> shortIter = pickStudents.tech_scores.iterator();
                    while(shortIter.hasNext()){
                        Student temp = shortIter.next();
                        if(!all_students[temp.roll-1].placed){
                            Integer temper = temp.comp_score_map.get(pickStudents.name);
                            Node students_data = new Node(temp.cgpa, temper, temp.roll);
                            pq.add(students_data);                        
                        }
                    }
                    int numSelected=0;
                    while(!pq.isEmpty() && numSelected<pickStudents.req_students){
                        Node selected = pq.poll();
                        all_students[selected.roll-1].placed = true;
                        selectedRoll.add(selected.roll);
                        num_unplaced--;
                        numSelected++;
                    }
                    pickStudents.status = "CLOSED";
                    num_open--;
                    break;
                }
                else{
                    System.out.println("No such company exists.");
                    break;
                }
            }
        }
        Iterator rollIter = selectedRoll.iterator();
        System.out.println("Roll Number of Selected Students");
        while(rollIter.hasNext()){
            System.out.println(rollIter.next());
        }
    }

    public static void display_comp_details(String compName){
        Iterator<Company> iter = companies.iterator();
        while(iter.hasNext()){
            Company temp = iter.next();
            if(temp.name.equals(compName)){ 
                System.out.println(temp.name);
                System.out.println("Course Criteria");
                Iterator<String> courseIter = temp.course_crit.iterator();
                while(courseIter.hasNext()){
                    System.out.println(courseIter.next());
                }
                System.out.println("Number of Required Students = "+temp.req_students);
                System.out.println("Application Status = "+temp.status);
                break;
            }
        }
    }

    public static void disp_student_details(int rollNumber){
        Student toShow = all_students[rollNumber-1];
        System.out.println(toShow.roll);
        System.out.println(toShow.cgpa);
        System.out.println(toShow.branch);
        if(toShow.placed){
            System.out.println("Placement Status: Placed");
        }
        else{
            System.out.println("Placement Status: Not placed");
        }
    }

    public static void name_companies_by_student(int rollNumber){
        if(!all_students[rollNumber-1].placed){
            for(Map.Entry std_comp : all_students[rollNumber-1].comp_score_map.entrySet()){
                String name = (String)std_comp.getKey();
                int score = (int)std_comp.getValue();
                System.out.println(name+" "+score);
            }
        }
        else{
            System.out.println("No student with the given roll number has an account.");
        }
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node s1, Node s2){
        if(s1.score<s2.score){
            return 1;
        }
        else if(s1.score==s2.score && s1.cgpa<s2.cgpa){
            return 1;
        }
        else if(s1.score>s2.score){
            return -1;
        }
        else if(s1.score==s2.score && s1.cgpa>s2.cgpa){
            return -1;
        }
        return 0;
    }
}

class Node{
    double cgpa;
    int score;
    int roll;
    public Node(double cgpa, int score, int roll){
        this.roll = roll;
        this.cgpa = cgpa;
        this.score = score;
    }
}
