package Prog.Board;

import Prog.User;
import helpAction.BotMenuLoginPanel;
import helpAction.Helper;
import helpAction.TopMenuLoginPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import static helpAction.Users.getLoginUsername;

public class Message {
    private Container contact;
    public static JFrame frameBoardMessage;
    public static JButton Register, Refresh;

    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    BotMenuLoginPanel bmp = new BotMenuLoginPanel();
    TopMenuLoginPanel tmp = new TopMenuLoginPanel();
    Helper h = new Helper();

    public String USERNAME;
    public String MESSAGE;
    public String TIME;

    public Message() {
        frameBoardMessage = new JFrame("Message Page");
        frameBoardMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBoardMessage.setLayout(null);
        frameBoardMessage.setSize(1000, 800);
        frameBoardMessage.setResizable(false);
        frameBoardMessage.setLocationRelativeTo(null);
        frameBoardMessage.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameBoardMessage.setUndecorated(true);
        contact = frameBoardMessage.getContentPane();

        h.setBoardLocation(2);
        tmp.TopMenuLoginPanel();
        bmp.BotMenuLoginPanel();
        BodyPanel();
        show_user();

        frameBoardMessage.pack();
        frameBoardMessage.setVisible(true);
    }



    public void BodyPanel() {
        h.setTable(new JTable());
        Object[][] data = {};
        h.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"TIME", "USERNAME", "MESSAGE"}
        ));
        JScrollPane panel = new JScrollPane(h.getTable());
        panel.setBounds(100, 50, 800, 500);
        panel.setBackground(Color.orange);
        panel.setOpaque(false);

        JPanel newPanel = new JPanel();
        newPanel.setBounds(100, 600, 800, 50);
        newPanel.setBackground(Color.orange);
        newPanel.setLayout(new GridLayout(1,2));
        newPanel.setOpaque(false);

        JPanel newPanel2 = new JPanel();
        newPanel2.setBounds(100, 650, 800, 50);
        newPanel2.setBackground(Color.orange);
        newPanel2.setLayout(new GridLayout(1,1));
        newPanel2.setOpaque(false);


        JLabel eneterMessage = new JLabel("Message:");
        eneterMessage.setFont(MainFont(20));
        eneterMessage.setForeground(Color.white);
        eneterMessage.setOpaque(false);
        JTextField messageEnter = new JTextField();
        messageEnter.setFont(MainFont(20));
        messageEnter.setForeground(Color.white);
        messageEnter.setOpaque(false);


        Register = new JButton("Send");
        Register.setBounds(320,380,200,50);
        Register.setOpaque(false);
        Register.setFont(MenuFont(20));
        Register.setContentAreaFilled(false);
        Register.setBorderPainted(true);
        Register.setForeground(Color.white);
        Register.setFocusPainted(false);
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Register) {
                    try {
                        String user = getLoginUsername();
                        String mess = messageEnter.getText();
                        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","m1a2l3i4Q5i6");
                        PreparedStatement Pstatement=connection.prepareStatement("insert into global_message values(id,?,?,time)");
                        Pstatement.setString(1,user);
                        Pstatement.setString(2,mess);
                        if(user.isEmpty() || mess.isEmpty()) {
                            JOptionPane.showMessageDialog(null,"Please Enter Your Message ");
                        }
                        else
                        {
                            Pstatement.executeUpdate();
                            frameBoardMessage.setVisible(false);
                            new Prog.Board.Message();
                            //JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();}}
            }}
        );

        Refresh = new JButton("Refresh");
        Refresh.setBounds(320,380,200,50);
        Refresh.setOpaque(false);
        Refresh.setFont(MenuFont(20));
        Refresh.setContentAreaFilled(false);
        Refresh.setBorderPainted(true);
        Refresh.setForeground(Color.white);
        Refresh.setFocusPainted(false);
        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameBoardMessage.setVisible(false);
                new Prog.Board.Message();
            }}
        );
        newPanel.add(eneterMessage);
        newPanel.add(messageEnter);
        newPanel2.add(Register);
        newPanel2.add(Refresh);
        frameBoardMessage.add(newPanel);
        frameBoardMessage.add(newPanel2);
        frameBoardMessage.add(panel);
    }
    public ArrayList<User> userList(){
        ArrayList<User> usersList = new ArrayList<>();
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","m1a2l3i4Q5i6");
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM global_message");
            ResultSet rs = statement.executeQuery();
            User user;
            while(rs.next()){
                user = new User(TIME = rs.getString("time"),USERNAME = rs.getString("username"),MESSAGE = rs.getString("message"));
                usersList.add(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel) h.getTable().getModel();
        Object[] row = new Object[3];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getTime();
            row[1] = list.get(i).getUsername();
            row[2] = list.get(i).getMessage();
            model.addRow(row);}
        System.out.println(TIME + "\n" + USERNAME + "\n"  + MESSAGE);
    }
}
