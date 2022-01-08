package Prog;

import Prog.Board.MainL;
import helpAction.BotMenuPanel;
import helpAction.Helper;
import helpAction.TopMenuPanel;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static helpAction.Users.*;

public class Login {
    private Container main;
    public static JFrame frameLogin;

    private static Font MenuFont(int size){
        return  new Font("Time New Roman", Font.PLAIN,size);
    }
    private static Font LogoFont(int size){
        return  new Font("Time New Roman", Font.BOLD,size);
    }
    private static Font MainFont(int size){
        return  new Font("Time New Roman", Font.PLAIN,size);
    }

    BotMenuPanel bmp = new BotMenuPanel();
    TopMenuPanel tmp = new TopMenuPanel();
    Helper h = new Helper();



    public Login() {
        frameLogin = new JFrame("Login Page");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setLayout(null);
        frameLogin.setSize(1000, 800);
        frameLogin.setResizable(false);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameLogin.setUndecorated(true);
        main = frameLogin.getContentPane();

        h.setLocation(3);
        tmp.TopMenuPanel();
        bmp.BotMenuPanel();
        BodyPanel();

        frameLogin.pack();
        frameLogin.setVisible(true);
    }



    public void BodyPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 200, 800, 500);
        panel.setOpaque(false);
        frameLogin.add(panel);

        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(38,45,43));
        UI.put("Panel.background",new ColorUIResource(38,45,43));
        UI.put("OptionPane.messageForeground", Color.white);


        JLabel username = new JLabel("Username:");
        username.setBounds(250,150,100,50);
        username.setFont(MainFont(20));
        username.setForeground(Color.white);
        username.setOpaque(false);
        JTextField usernamearea = new JTextField();
        usernamearea.setBounds(350,150,200,50);
        usernamearea.setFont(MainFont(20));
        usernamearea.setForeground(Color.white);
        usernamearea.setOpaque(false);



        JLabel password = new JLabel("Password:");
        password.setFont(MainFont(20));
        password.setBounds(250,200,100,50);
        password.setForeground(Color.white);
        password.setOpaque(false);
        JTextField passwordarea = new JTextField();
        passwordarea.setBounds(350,200,200,50);
        passwordarea.setFont(MainFont(20));
        passwordarea.setForeground(Color.white);
        passwordarea.setOpaque(false);

        JButton Login = new JButton("Login");
        Login.setBounds(350,380,200,50);
        Login.setOpaque(false);
        Login.setFont(MenuFont(20));
        Login.setContentAreaFilled(false);
        Login.setBorderPainted(true);
        Login.setForeground(Color.white);
        Login.setFocusPainted(false);



        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement ps;
                ResultSet rs;
                String user = usernamearea.getText();
                String pass = passwordarea.getText();

                String quary = "SELECT * FROM users WHERE username = ? and password = ?";
                try {
                    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","m1a2l3i4Q5i6");
                    ps = (connection).prepareStatement(quary);
                    ps.setString(1, user);
                    ps.setString(2, pass);

                    setLoginUsername(user);
                    setLoginPassword(pass);

                    rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null,"Yes");

                        System.out.println(getLoginUsername());
                        System.out.println(getLoginPassword());
                        frameLogin.setVisible(false);
                        new MainL();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"No");
                    }
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }}
        );


        panel.add(Login);
        panel.add(username);
        panel.add(password);
        panel.add(usernamearea);
        panel.add(passwordarea);
    }

    private static void test(){
        System.out.println("Welcome!");
    }


}
