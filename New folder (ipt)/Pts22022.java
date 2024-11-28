package pts22022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class Pts22022 extends JFrame {
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    JTextField txt1, txt2, txt3;
    JComboBox<String> cb1, cb2, cb3;
    JButton btn1, btn2, btn3;
    JTextArea ta1;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/enrollment";
    String uname = "root";
    String pass = "";

    Pts22022() {
        lbl1 = new JLabel("ENROLLMENT DATA");
        lbl1.setBounds(120, 20, 300, 100);
        lbl1.setFont(new Font("Arial", Font.BOLD, 24));
        lbl1.setForeground(Color.BLUE);
        add(lbl1);

        lbl2 = new JLabel("Name");
        lbl2.setBounds(50, 100, 150, 50);
        add(lbl2);

        txt1 = new JTextField();
        txt1.setBounds(150, 110, 300, 25);
        add(txt1);

        lbl2 = new JLabel("Student ID");
        lbl2.setBounds(50, 150, 150, 50);
        add(lbl2);

        txt2 = new JTextField();
        txt2.setBounds(150, 160, 300, 25);
        add(txt2);

        lbl3 = new JLabel("Email");
        lbl3.setBounds(50, 200, 150, 50);
        add(lbl3);

        txt3 = new JTextField();
        txt3.setBounds(150, 210, 300, 25);
        add(txt3);

        lbl4 = new JLabel("Program Level");
        lbl4.setBounds(50, 250, 150, 50);
        add(lbl4);

        String[] level = {"Please Choose", "Degree", "Diploma"};
        cb1 = new JComboBox<>(level);
        cb1.setBounds(150, 265, 150, 25);
        add(cb1);

        // Create the second JComboBox (cb2)
        cb2 = new JComboBox<>();
        cb2.setBounds(150, 315, 300, 25);
        add(cb2);

        // Create a JLabel
        lbl5 = new JLabel("Program Name");
        lbl5.setBounds(50, 300, 150, 50);
        add(lbl5);

        // Add ItemListener to cb1
        cb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) cb1.getSelectedItem();
                    cb2.removeAllItems(); // Clear previous items

                    switch (selected) {
                        case "Diploma":
                            cb2.addItem("Diploma in Business Administration");
                            cb2.addItem("Diploma in Information Technology");
                            cb2.addItem("Diploma in Mechanical Engineering");
                            cb2.addItem("Diploma in Electrical Engineering");
                            break;
                        case "Degree":
                            cb2.addItem("Degree in Business Administration");
                            cb2.addItem("Degree in Information Technology");
                            cb2.addItem("Degree in Mechanical Engineering");
                            cb2.addItem("Degree in Electrical Engineering");
                            break;
                        default:
                            cb2.addItem("Please select a program");
                            break;
                    }
                }
            }
        });

        lbl6 = new JLabel("Academy Session");
        lbl6.setBounds(50, 350, 150, 50);
        add(lbl6);

        String[] session = {"Please Choose", "Sesi 1 2023/2024", "Sesi 2 2023/2024"};
        cb3 = new JComboBox<>(session);
        cb3.setBounds(150, 365, 150, 25);
        add(cb3);

        btn1 = new JButton("Submit");
        btn1.setBounds(100, 420, 100, 35);
        add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String name = txt1.getText();
                String student_id = txt2.getText();
                String email = txt3.getText();
                String program_level = cb1.getSelectedItem().toString();
                String program_name = cb2.getSelectedItem().toString();
                String session = cb3.getSelectedItem().toString();

                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    Statement stt = con.createStatement();
                    String query = "INSERT INTO enrollment_data (name, student_id, email, program_level, program_name, session) VALUES ('" + name + "','" + student_id + "','" + email + "','" + program_level + "','" + program_name + "','" + session + "')";
                    stt.executeUpdate(query);
                    con.close();
                    JOptionPane.showMessageDialog(null, "Successfully inserted Data");
                } catch (Exception op) {
                    JOptionPane.showMessageDialog(rootPane, "Error at Button Insert: " + op);
                }
            }
        });

        btn2 = new JButton("View");
        btn2.setBounds(230, 420, 100, 35);
        add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    Statement stt = con.createStatement();
                    String query = "SELECT * FROM enrollment_data"; // Adjust the query as needed
                    ResultSet rs = stt.executeQuery(query);
                    ta1.setText(""); // Clear the text area before displaying new data

                    while (rs.next()) {
                        String name = rs.getString("name");
                        String student_id = rs.getString("student_id");
                        String email = rs.getString("email");
                        String program_level = rs.getString("program_level");
                        String program_name = rs.getString("program_name");
                        String session = rs.getString("session");

                        // Append the data to the JTextArea
                      ta1.append("Name: " + name + "\n" 
                                + "Student ID: " + student_id + "\n" 
                                + "Email: " + email + "\n" 
                                + "Program Level: " + program_level + "\n" 
                                + "Program Name: " + program_name + "\n" 
                                + "Session: " + session + "\n");                   }
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Error at Button View: " + ex);
                }
            }
        });

        btn3 = new JButton("Reset");
        btn3.setBounds(360, 420, 100, 35);
        add(btn3);

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");

                // Reset combo boxes to their default selections
                cb1.setSelectedIndex(0);
                cb2.removeAllItems(); // Clear items in cb2
                cb3.setSelectedIndex(0);

                // Clear the JTextArea
                ta1.setText("");
            }
        });

        ta1 = new JTextArea();
        JScrollPane scrollPane2 = new JScrollPane(ta1);
        scrollPane2.setBounds(100, 480, 320, 300); // Adjusted bounds for ta1
        add(scrollPane2);
        ta1.setEditable(false);

        setTitle("Practical Test");
        setSize(700, 700);
        setLayout(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Pts22022();
    }
}