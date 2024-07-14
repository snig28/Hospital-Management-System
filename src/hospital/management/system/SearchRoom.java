package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;
    SearchRoom(){

        JPanel panel = new JPanel() ;
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel forRoom = new JLabel("Search for Room");
        forRoom.setBounds(250,11,186,31);
        forRoom.setForeground(Color.white);
        forRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(forRoom);

        JLabel status= new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.white);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice= new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel RoomNo= new JLabel("Room Number");
        RoomNo.setBounds(20,162,150,20);
        RoomNo.setForeground(Color.white);
        RoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(RoomNo);

        JLabel available= new JLabel("Availability");
        available.setBounds(175,162,80,20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price= new JLabel("Price");
        price.setBounds(350,162,150,20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel Bed= new JLabel("Bed Type");
        Bed.setBounds(530,162,150,20);
        Bed.setForeground(Color.white);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Bed);

        JButton search = new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380,420,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
