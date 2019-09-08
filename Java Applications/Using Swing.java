import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Runner{
    String name;
    int time;
    int category;
    Runner next;
    public Runner(String name, int time, int category){
        this.name = name;
        this.time = time;
        this.category = category;
        next = null;
    }
}

class LL{
    public static Runner max1_g = new Runner("None",Integer.MAX_VALUE,Integer.MAX_VALUE);
    public static Runner max2_g = new Runner("None",Integer.MAX_VALUE,Integer.MAX_VALUE);
    public static Runner max1_o = new Runner("None",Integer.MAX_VALUE,Integer.MAX_VALUE);
    public static Runner max2_o = new Runner("None",Integer.MAX_VALUE,Integer.MAX_VALUE);
    public static Runner max1_h = new Runner("None",Integer.MAX_VALUE,Integer.MAX_VALUE);
    public static Runner max2_h = new Runner("None",Integer.MAX_VALUE,Integer.MAX_VALUE);
    Runner start;
    int size;
    public LL(){
        start = null;
        size = 0;
    }
    public void insert(String name, int time, int category){
        Runner nptr = new Runner(name, time, category);
        nptr.next = null;
        if(start == null){
            start = nptr;
            start.next = null;
        }
        else{
            Runner n = start;
            while(n.next!=null){
                n = n.next;
            }
            n.next = nptr;
        }
        size++;
    }
    public void all_max(){
        Runner t = start;
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        int max3 = Integer.MAX_VALUE;
        int max4 = Integer.MAX_VALUE;
        int max5 = Integer.MAX_VALUE;
        int max6 = Integer.MAX_VALUE;
        if(t==null){
            return;
        }
        else{
            while(t!=null){
                if(t.category==1){
                    if(t.time<max1){
                        max1 = t.time;
                        max1_g = t;
                    }
                }
                else if(t.category==2){
                    if(t.time<max3){
                        max3 = t.time;
                        max1_o = t;
                    }
                }
                else if(t.category==3){
                    if(t.time<max5){
                        max5 = t.time;
                        max1_h = t;
                    }
                }
                t = t.next;
            }
            t = start;
            while(t!=null){
                if(t.category==1){
                    if(t.time<max2 && !t.equals(max1_g)){
                        max2 = t.time;
                        max2_g = t;
                    }
                }
                else if(t.category==2){
                    if(t.time<max4 && !t.equals(max1_o)){
                        max4 = t.time;
                        max2_o = t;
                    }
                }
                else if(t.category==3){
                    if(t.time<max6 && !t.equals(max1_h)){
                        max6 = t.time;
                        max2_h = t;
                    }
                }
                t = t.next;
            }
        }
    }
}

public class a1 {

    public static JPanel p_name, p_ans;
    public static JLabel l_name;
    public static JTextField tf_name;
    public static LL sortedlk = new LL();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Select Runner");
        JPanel p_main = new JPanel();
        p_main.setLayout(new BoxLayout(p_main,BoxLayout.Y_AXIS));
        p_name = new JPanel();
        p_name.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_main.add(p_name);

        l_name = new JLabel("Name");
        tf_name = new JTextField();
        tf_name.setPreferredSize(new Dimension(150,50));
        p_name.add(l_name);
        p_name.add(tf_name);

        JPanel p_time = new JPanel();
        JLabel l_time = new JLabel("Time");
        JTextField tf_time = new JTextField();
        tf_time.setPreferredSize(new Dimension(150,50));
        p_time.add(l_time);
        p_time.add(tf_time);
        p_main.add(p_time);

        JLabel l_race = new JLabel("Marathon : ");
        JPanel p_race=  new JPanel();
        p_race.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_race.add(l_race);

        ButtonGroup bg_race = new ButtonGroup();

        JRadioButton rb_gdr = new JRadioButton("Great Delhi Run: ");
        JRadioButton rb_o10r = new JRadioButton("Open 10K Run: ");
        JRadioButton rb_hm = new JRadioButton("Half Marathon: ");

        bg_race.add(rb_gdr);
        bg_race.add(rb_o10r);
        bg_race.add(rb_hm);

        p_race.add(rb_gdr);
        p_race.add(rb_o10r);
        p_race.add(rb_hm);

        rb_hm.setSelected(true);
        p_main.add(p_race);

        JPanel p_buttons = new JPanel();
        p_buttons.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton b_next = new JButton("Next");
        JButton b_print = new JButton("Print");
        JButton b_exit = new JButton("Exit");

        b_exit.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        b_next.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_name = tf_name.getText();
                String user_tim_temp = tf_time.getText();
                if(user_name.equals("") || user_tim_temp.equals("")){
                    JFrame frame3 = new JFrame("Error");
                    JPanel temporary = new JPanel();
                    temporary.setLayout(new BoxLayout(temporary,BoxLayout.Y_AXIS));
                    JLabel errorMessage = new JLabel("Error !!");
                    temporary.add(errorMessage);
                    frame3.add(temporary);
                    frame3.setSize(600,600);
                    frame3.setVisible(true);
                    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                }
                int user_time = Integer.MAX_VALUE;
                if(!user_tim_temp.equals("")){user_time = Integer.parseInt(user_tim_temp);}
                else{
                    user_time = Integer.MAX_VALUE;
                }
                int user_category = 0;
                if(rb_gdr.isSelected()){
                    user_category = 1;
                    //Runner user_g = new Runner(user_name, user_time, user_category);
                    sortedlk.insert(user_name, user_time, user_category);
                }
                else if(rb_o10r.isSelected()){
                    user_category = 2;
                    //Runner user_o = new Runner(user_name, user_time, user_category);
                    sortedlk.insert(user_name, user_time, user_category);
                }
                else{
                    user_category = 3;
                    //Runner user_h = new Runner(user_name, user_time, user_category);
                    sortedlk.insert(user_name, user_time, user_category);
                }
                tf_name.setText("");
                tf_time.setText("");
                rb_hm.setSelected(true);
            }
        });

        b_print.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                sortedlk.all_max();;
                JFrame frame2 = new JFrame("Winners");
                p_ans = new JPanel();
                p_ans.setLayout(new BoxLayout(p_ans,BoxLayout.Y_AXIS));
                JPanel p_g = new JPanel();
                p_g.setLayout(new FlowLayout(FlowLayout.CENTER));
                JLabel l_heading = new JLabel("Great Delhi Marathon");
                JLabel l_g1 = new JLabel("First Winner ");
                JLabel l_g2 = new JLabel("Second Winner ");
                JTextField tf_g1 = new JTextField();
                JTextField tf_p1 = new JTextField();
                JTextField tf_g2 = new JTextField();
                JTextField tf_p2 = new JTextField();
                tf_g1.setText(sortedlk.max1_g.name);
                tf_g2.setText(sortedlk.max2_g.name);
                tf_p1.setText("Rs 1,35,000");
                tf_p2.setText("Rs 1,15,000");
                l_heading.setPreferredSize(new Dimension(150,50));
                tf_g1.setPreferredSize(new Dimension(150,50));
                tf_g2.setPreferredSize(new Dimension(150,50));
                tf_p1.setPreferredSize(new Dimension(150,50));
                tf_p2.setPreferredSize(new Dimension(150,50));
                p_g.add(l_heading);
                p_g.add(l_g1);
                p_g.add(tf_g1);
                p_g.add(tf_p1);
                p_g.add(l_g2);
                p_g.add(tf_g2);
                p_g.add(tf_p2);
                p_ans.add(p_g);
                JPanel p_o = new JPanel();
                p_o.setLayout(new FlowLayout(FlowLayout.CENTER));
                JLabel l_heading2 = new JLabel("Open 10K Marathon");
                JLabel l_o1 = new JLabel("First Winner ");
                JLabel l_o2 = new JLabel("Second Winner ");
                JTextField tf_o1 = new JTextField();
                JTextField tf_po1 = new JTextField();
                JTextField tf_o2 = new JTextField();
                JTextField tf_po2 = new JTextField();
                tf_o1.setText(sortedlk.max1_o.name);
                tf_o2.setText(sortedlk.max2_o.name);
                tf_po1.setText("Rs 1,90,000");
                tf_po2.setText("Rs 1,50,000");
                l_heading2.setPreferredSize(new Dimension(150,50));
                tf_o1.setPreferredSize(new Dimension(150,50));
                tf_o2.setPreferredSize(new Dimension(150,50));
                tf_po1.setPreferredSize(new Dimension(150,50));
                tf_po2.setPreferredSize(new Dimension(150,50));
                p_o.add(l_heading2);
                p_o.add(l_o1);
                p_o.add(tf_o1);
                p_o.add(tf_po1);
                p_o.add(l_o2);
                p_o.add(tf_o2);
                p_o.add(tf_po2);
                p_ans.add(p_o);
                JPanel p_h = new JPanel();
                p_h.setLayout(new FlowLayout(FlowLayout.CENTER));
                JLabel l_heading3 = new JLabel("Half Marathon");
                l_heading3.setPreferredSize(new Dimension(150,50));
                JLabel l_h1 = new JLabel("First Winner ");
                JLabel l_h2 = new JLabel("Second Winner ");
                JTextField tf_h1 = new JTextField();
                JTextField tf_ph1 = new JTextField();
                JTextField tf_h2 = new JTextField();
                JTextField tf_ph2 = new JTextField();
                tf_h1.setText(sortedlk.max1_h.name);
                tf_h2.setText(sortedlk.max2_h.name);
                tf_ph1.setText("Rs 2,80,000");
                tf_ph2.setText("Rs 2,10,000");              
                tf_h1.setPreferredSize(new Dimension(150,50));
                tf_h2.setPreferredSize(new Dimension(150,50));
                tf_ph1.setPreferredSize(new Dimension(150,50));
                tf_ph2.setPreferredSize(new Dimension(150,50));
                p_h.add(l_heading3);
                p_h.add(l_h1);
                p_h.add(tf_h1);
                p_h.add(tf_ph1);
                p_h.add(l_h2);
                p_h.add(tf_h2);
                p_h.add(tf_ph2);
                p_ans.add(p_h);
                frame2.add(p_ans);
                frame2.setSize(600,600);
                frame2.setVisible(true);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                
            }
        });

        p_buttons.add(b_next);
        p_buttons.add(b_print);
        p_buttons.add(b_exit);

        p_main.add(p_buttons);

        frame.add(p_main);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


