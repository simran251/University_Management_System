package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import university.Conn;

public class ExaminationDetails extends JFrame implements ActionListener{

    JTextField search;

    JButton result, back;

    JTable table;

    public ExaminationDetails(){

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(350,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);

        search = new JTextField();
        search.setBounds(150,90,120,30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);

        result = new JButton("Result");
        result.setBounds(300,90,120,30);
        result.setBackground(Color.black);
        result.setForeground(Color.white);
        result.addActionListener(this);
        add(result);

        back = new JButton("Back");
        back.setBounds(440,90,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,130,1000,310);
        add(scrollPane);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        setSize(1000,475);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == result){
        setVisible(false);
        new Marks(search.getText());
    }else{
        setVisible(false);
    }
}

public static void main(String[] args) {
    new ExaminationDetails();
}
}
