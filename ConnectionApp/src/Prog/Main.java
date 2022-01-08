package Prog;

import helpAction.BotMenuPanel;
import helpAction.Helper;
import helpAction.Users;
import helpAction.TopMenuPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    private Container contact;
    public static JFrame frameMain;
    public String EMAIL;
    public String ABOUT;
    public String CONEST;

    public String USERNAME;
    public String MESSAGE;
    public String TIME;



    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    BotMenuPanel bmp = new BotMenuPanel();
    TopMenuPanel tmp = new TopMenuPanel();
    Helper h = new Helper();
    Users u;

    public Main() {


        frameMain = new JFrame("Main Page");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setLayout(null);
        frameMain.setSize(1000, 800);
        frameMain.setResizable(false);
        frameMain.setLocationRelativeTo(null);
        frameMain.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameMain.setUndecorated(true);
        contact = frameMain.getContentPane();

        h.setLocation(0);
        tmp.TopMenuPanel();
        bmp.BotMenuPanel();
        BodyPanel();
        show_user();
        frameMain.pack();
        frameMain.setVisible(true);
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
        frameMain.add(panel);
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
