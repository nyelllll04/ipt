package practicalexercise1f1066;
import javax.swing.*;
import java.awt.*;


public class PracticalExercise1F1066 extends JFrame {
    
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8;
    JTextField txt1,txt2,txt3,txt4,txt5;
    JComboBox cb1,cb2;
    JRadioButton rb1,rb2;
    JPanel p1;
    JButton btn1,btn2,btn3,btn4,btn5;
    JTextArea ta1;
    
   
    PracticalExercise1F1066(){
        
        lbl1 = new JLabel("Sistem Sewaan Kenderaan (e-Vehicle)");
        lbl1.setBounds(30,30,350,25);
        lbl1.setFont(new Font("Arial", Font.BOLD, 18)); // Set font to Arial, bold, and size 18
        lbl1.setForeground(Color.BLUE); // Set text color to blue
        add(lbl1);
        
//        nama
        lbl2 = new JLabel ("Nama :");
        lbl2.setBounds(20,80,150,25);
        add(lbl2);
        
        txt1 = new JTextField ();
        txt1.setBounds(100,85,200,25);
        add(txt1);
        
//        id

        lbl3= new JLabel ("ID  :");
        lbl3.setBounds(20,120,150,25);
        add(lbl3);
        
        txt2 = new JTextField ();
        txt2.setBounds(100,125,200,25);
        add(txt2);
        
//        no tel

         lbl4= new JLabel ("No Tel :");
        lbl4.setBounds(20,160,150,25);
        add(lbl4);
        
        txt3 = new JTextField ();
        txt3.setBounds(100,165,200,25);
        add(txt3);
        
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(20, 200, 350, 250);
        p1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        add(p1);

//        pengguna
        lbl5= new JLabel ("Pengguna :");
        lbl5.setBounds(20,10,150,25);
        p1.add(lbl5);
        
        rb1 = new JRadioButton ("Staff");
        rb1.setBounds(100,10,70,25);
        p1.add(rb1);
        
        rb2 = new JRadioButton ("Pelajar");
        rb2.setBounds(180,10,80,25);
        p1.add(rb2);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        
//        jenis
        lbl6 = new JLabel("Jenis e-Vehicle :");
        lbl6.setBounds(20,50,150,25);
        p1.add(lbl6);
        
        String [] jenis = {"-Select-", "Skuter Lipat", "Skuter Off-Road", "Skuter Klasik" , "Skuter 3 Roda (3 Seater)" , "Skuter 3 Roda (4 Seater)" , "E-Buggy (6 Seater)"};
        cb1 = new JComboBox (jenis);
        cb1.setBounds(120,55,150,25);
        p1.add(cb1);
        
//        bilangan
        
        lbl7 = new JLabel("Bilangan :");
        lbl7.setBounds(20,90,150,25);
        p1.add(lbl7);
        
        String [] bilangan = {"-Select-", "1", "2", "3"};
        cb2 = new JComboBox(bilangan);
        cb2.setBounds(120,95,150,25);
        p1.add(cb2);
        
//        masa
        lbl8= new JLabel ("Masa/Jam :");
        lbl8.setBounds(20,130,150,25);
        p1.add(lbl8);
        
        txt4 = new JTextField ();
        txt4.setBounds(120,135,150,25);
        p1.add(txt4);


        btn1= new JButton("Calculate");
        btn1.setBounds(50,170,100,30);
        p1.add(btn1);
        
        txt5 = new JTextField();
        txt5.setBounds(180, 170, 70, 25);
        txt5.setEnabled(false);
        p1.add(txt5);
        
        btn2 = new JButton ("Clear");
        btn2.setBounds(70,480,100,30);
        add(btn2);
        
        btn3 = new JButton("Book");
        btn3.setBounds(180,480,100,30);
        add(btn3);
        
        ta1 = new JTextArea ();
        ta1.setBounds (390,85,350,360);
        add(ta1);
        
        btn4 = new JButton ("<<Delete");
        btn4.setBounds(390,480,100,30);
        add(btn4);
        
        btn5 = new JButton (">>Search");
        btn5.setBounds(640,480,100,30);
        add(btn5);
        
        
    

    setTitle("Swing Practical 1");
       setSize (800,750);
       setLayout (null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public static void main(String[] args) {
       new PracticalExercise1F1066();
    }
    
}