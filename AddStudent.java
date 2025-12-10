package university.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import java.awt.*;

import com.toedter.calendar.JDateChooser;

import university.Conn;

public class AddStudent extends JFrame implements ActionListener{

    JTextField textName, textfather, textAddress, textPhone, textemail, textM10, textM12, textAdhar;
    
    JLabel empText;

    JDateChooser cdob;

    JComboBox courseBox, departmentBox;

    JButton submit, cancel;

    Random ran = new Random();

    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    public AddStudent(){
        getContentPane().setBackground(new Color(128,176,255));

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textfather = new JTextField();
        textfather.setBounds(600,150,150,30);
        add(textfather);

        JLabel empid = new JLabel("Roll Number");
        empid.setBounds(50,200,150,30);  // Positioned below 'Name'
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);

        empText = new JLabel("1409" + f4);
        empText.setBounds(200,200,150,30);  // Positioned next to 'Employee ID'
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);  // Positioned below 'Name'
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);  
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,200,30);  
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);  
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200,300,150,30);
        add(textemail);

        JLabel x = new JLabel("Class X (%)");
        x.setBounds(400,300,200,30);  
        x.setFont(new Font("serif",Font.BOLD,20));
        add(x);

        textM10 = new JTextField();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        JLabel xii = new JLabel("Class XII (%)");
        xii.setBounds(50,350,200,30);  
        xii.setFont(new Font("serif",Font.BOLD,20));
        add(xii);

        textM12 = new JTextField();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        JLabel adharNo = new JLabel("Adhar Number");
        adharNo.setBounds(400,350,200,30);  
        adharNo.setFont(new Font("serif",Font.BOLD,20));
        add(adharNo);

        textAdhar = new JTextField();
        textAdhar.setBounds(600,350,150,30);
        add(textAdhar);

        JLabel Qualification = new JLabel("Course");
        Qualification.setBounds(50,400,200,30);  
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        String course[] = {"B.Tech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        JLabel Department = new JLabel("Branch");
        Department.setBounds(400,400,200,30);  
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        String department[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT", "Artificial Intelligence and Data Science", "Robotics", "Industrial", "Aerospace", "Electrical"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(600,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == submit){
           String name = textName.getText();
           String fname = textfather.getText();
           String empid = empText.getText();
           String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
           String address = textAddress.getText();
           String phone = textPhone.getText();
           String email = textemail.getText();
           String x = textM10.getText();
           String xii = textM12.getText();
           String adharNo = textAdhar.getText();
           String course = (String) courseBox.getSelectedItem();
           String department = (String) departmentBox.getSelectedItem();
           try{
                String q = "insert into student values('"+name+"', '"+fname+"', '"+empid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+adharNo+"', '"+course+"', '"+department+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Inserted");
                setVisible(false);
           }catch (Exception E) {
            E.printStackTrace();
           }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }

}
