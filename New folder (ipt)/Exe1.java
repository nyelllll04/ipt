package exe1;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Exe1 extends JFrame {
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5;
    JTextField txt1, txt2, txt3, txt4;
    JTextArea txa1, txa2;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    JDialog jd1;
    JRadioButton rb1, rb2;
    ButtonGroup bg;
    
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/politeknik";
    String uname = "root";
    String pass = "";
    
    Exe1() {
        lbl1 = new JLabel("Java SQL Database - Danial");
        lbl1.setBounds(30, 40, 300, 25);
        lbl1.setForeground(Color.GREEN);
        add(lbl1);

        lbl2 = new JLabel("Name:");
        lbl2.setBounds(30, 100, 150, 25);
        lbl2.setForeground(Color.GREEN);
        add(lbl2);

        txt1 = new JTextField("");
        txt1.setBounds(120, 100, 150, 25);
        add(txt1);

        lbl3 = new JLabel("ID Number:");
        lbl3.setBounds(30, 140, 150, 25);
        lbl3.setForeground(Color.GREEN);
        add(lbl3);

        txt2 = new JTextField("");
        txt2.setBounds(120, 140, 150, 25);
        add(txt2);

        lbl4 = new JLabel("Email:");
        lbl4.setBounds(30, 180, 150, 25);
        lbl4.setForeground(Color.GREEN);
        add(lbl4);

        txt3 = new JTextField("");
        txt3.setBounds(120, 180, 150, 25);
        add(txt3);

        lbl5 = new JLabel("Address:");
        lbl5.setBounds(30, 220, 150, 25);
        lbl5.setForeground(Color.GREEN);
        add(lbl5);

        txa1 = new JTextArea();
        JScrollPane scrollPane1 = new JScrollPane(txa1);
        scrollPane1.setBounds(120, 220, 320, 180);
        add(scrollPane1);

        txa2 = new JTextArea();
        JScrollPane scrollPane2 = new JScrollPane(txa2);
        scrollPane2.setBounds(500, 100, 320, 300); // Adjusted bounds for txa2
        add(scrollPane2);
         
        btn1 = new JButton("Search");
        btn1.setBounds(30, 470, 100, 35);
        add(btn1);
        
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent s) {
                String SerId = JOptionPane.showInputDialog("Insert student id");
                try{
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    Statement stt = con.createStatement();
                    String sql = "select * from student where id=" + SerId;
                    ResultSet rs = stt.executeQuery(sql);
                    
                    txa2.setText("");
                    
                    while (rs.next()){
                        int pk_num = rs.getInt("pk_num");
                        String getName = rs.getString("name");
                        String getid = rs.getString("id");
                        String getemail = rs.getString("email");
                        String getaddress = rs.getString("address");
                        
                        txa2.append("Data Student:\n"
                                 + "\n*****************************"
                                 + "\n Primary Number: " + pk_num
                                 + "\n Name: " + getName 
                                 + "\n ID: " + getid 
                                 + "\n Email: " + getemail
                                 + "\n Address: " + getaddress 
                                 + "\n\n"
                        );
                    }
                    con.close();
                }
                catch (Exception we) {
                    JOptionPane.showMessageDialog(rootPane , "Error at Button Search :" + we);
                }
            }
        });

        btn2 = new JButton("Delete");
        btn2.setBounds(140, 470, 100, 35);
        add(btn2);
        
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent b) {
                String num = JOptionPane.showInputDialog("Insert ID Number : ");
                try{
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    Statement stt = con.createStatement();
                    String query = "delete from student WHERE id =" + num;
                    stt.executeUpdate(query);
                    con.close();
                    JOptionPane.showMessageDialog (null,"Successfully Delete Data");
                }
                catch(Exception op){
                    JOptionPane.showMessageDialog(rootPane , "Error at Button Delete :" + op);
                }
            }
        });

        btn3 = new JButton("Update");
        btn3.setBounds(250, 470, 100, 35);  
        add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent o) {
                try {
                    Class.forName(driver);
                    Connection conn = DriverManager.getConnection(url, uname, pass);
                    String id = txt2.getText(); 
                    String name = txt1.getText(); 
                    String email = txt3.getText(); 
                    String address = txa1.getText();
                    
                    String query = "UPDATE student SET name = '" + name + "', email = '" + email + "', address = '" + address + "' WHERE id = '" + id + "'";
                    Statement gwen = conn.createStatement();
                    int rowsAffected = gwen.executeUpdate(query);
                    conn.close();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Data updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No record found with the given ID");
                    }
                } catch (Exception op) {
                    JOptionPane.showMessageDialog(rootPane, "Error at Button Update: " + op);
                }
            }
        });

        btn4 = new JButton("Insert");
        btn4.setBounds(360, 470, 100, 35);
        add(btn4);
        
        btn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent a) {
                String name = txt1.getText();
                String id = txt2.getText();
                String email = txt3.getText();
                String address = txa1.getText();
                
                try{
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    Statement stt = con.createStatement();
                    String query = "Insert into student (name,id,email,address) values ('"+name+"','"+id+"','"+email+"','"+address+"')";
                    stt.executeUpdate(query);
                    con.close();
                    JOptionPane.showMessageDialog (null,"Successfully insert Data");
                }
                catch(Exception op){
                    JOptionPane.showMessageDialog(rootPane , "Error at Button Insert :" + op);
                }
            }
        });

        btn5 = new JButton("Test");
        btn5.setBounds(470, 470, 100, 35);
        add(btn5);

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    
                    if (!con.isClosed()) {
                        JOptionPane.showMessageDialog(rootPane , "Successfully Connected");
                    } else {
                        JOptionPane.showMessageDialog(rootPane , "Failed to Connect");
                    }
                    
                    con.close();
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(Exe1.this, "Error at button test: " + err);
                }
            }
        });
        
        jd1 = new JDialog();
        jd1.setSize(350,150);
        jd1.setLayout(null);
        jd1.setLocationRelativeTo(null);
        jd1.setTitle ("Selection Search");
      
        bg = new ButtonGroup();
        rb1 = new JRadioButton ("Search All");
        rb1.setBounds (20,15,200,28);
        jd1.add(rb1);
        bg.add(rb1);
        rb1.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent tr){
                if(rb1.isSelected()){
                    txt4.setVisible(false);
                }
                else{
                    txt4.setVisible(true);
                }
            }
        });
        
        rb2 = new JRadioButton ("Search by ID");
        rb2.setBounds (20,50,200,28);
        jd1.add(rb2);
        bg.add(rb2);
        rb2.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent tr){
                if(rb2.isSelected()){
                    txt4.setVisible(true);
                }
                else{
                    txt4.setVisible(false);
                }
            }
        });
       
        txt4 = new JTextField ();
        txt4.setBounds(20,80,190,28);
        txt4.setVisible(false);
        jd1.add(txt4);
        
        btn7 = new JButton ("Search");
        btn7.setBounds(245,80,80,28);
        jd1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                String getSerID = txt4.getText();
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    Statement smt = con.createStatement();
                   
                    if(rb1.isSelected()){
                        String sql = "select * from student";
                        ResultSet rs = smt.executeQuery(sql);
                        txa2.setText("");
                        while (rs.next()){
                            int pk_num = rs.getInt("pk_num");
                            String getName = rs.getString("name");
                            String getid = rs.getString("id");
                            String getemail = rs.getString("email");
                            String getaddress = rs.getString("address");
                            
                            txa2.append("Data Student:\n"
                                     + "\n*****************************"
                                     + "\n Primary Number: " + pk_num
                                     + "\n Name: " + getName 
                                     + "\n ID: " + getid 
                                     + "\n Email: " + getemail
                                     + "\n Address: " + getaddress 
                                     + "\n\n"
                            );
                        }
                    } else if(rb2.isSelected()){
                        String sql = "select * from student where id=" + getSerID;
                        ResultSet rs = smt.executeQuery(sql);
                        txa2.setText("");
                        while (rs.next()){
                            int pk_num = rs.getInt("pk_num");
                            String getName = rs.getString("name");
                            String getid = rs.getString("id");
                            String getemail = rs.getString("email");
                            String getaddress = rs.getString("address");
                            
                            txa2.append("Data Student:\n"
                                     + "\n*****************************"
                                     + "\n Primary Number: " + pk_num
                                     + "\n Name: " + getName 
                                     + "\n ID: " + getid 
                                     + "\n Email: " + getemail
                                     + "\n Address: " + getaddress 
                                     + "\n\n"
                            );
                        }
                    }
                    con.close();
                } catch (Exception za) {
                    JOptionPane.showMessageDialog(null, "Error at button Search by: " + za);
                }
            }
        });    

        btn6 = new JButton ("Search by");
        btn6.setBounds (580,470,100,35);
        add(btn6);
        
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent q) {
                jd1.setVisible(true);
                try {
                    // No additional code needed here
                } catch (Exception za) {
                    JOptionPane.showMessageDialog(Exe1.this, "Error at button Search by: " + za);
                }
            }
        });    
       
        getContentPane().setBackground(Color.BLACK);
        
        setSize(1200, 1200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Exe1();
    }
}