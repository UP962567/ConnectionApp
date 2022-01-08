package Prog;

import helpAction.BotMenuPanel;
import helpAction.Helper;
import helpAction.TopMenuPanel;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Contact {
    private Container contact;
    public static JFrame frameContact;

    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    BotMenuPanel bmp = new BotMenuPanel();
    TopMenuPanel tmp = new TopMenuPanel();
    Helper h = new Helper();


    public Contact() {
        frameContact = new JFrame("Contact Page");
        frameContact.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameContact.setLayout(null);
        frameContact.setSize(1000, 800);
        frameContact.setResizable(false);
        frameContact.setLocationRelativeTo(null);
        frameContact.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameContact.setUndecorated(true);
        contact = frameContact.getContentPane();

        h.setLocation(1);
        tmp.TopMenuPanel();
        bmp.BotMenuPanel();
        BodyPanel();

        frameContact.pack();
        frameContact.setVisible(true);
    }



    public void BodyPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 200, 800, 500);
        panel.setOpaque(false);
        frameContact.add(panel);

        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(38,45,43));
        UI.put("Panel.background",new ColorUIResource(38,45,43));
        UI.put("OptionPane.messageForeground", Color.white);



        JLabel email = new JLabel("Email: ");
        email.setBounds(100,50,150,50);
        email.setFont(MainFont(20));
        email.setForeground(Color.white);
        email.setOpaque(false);
        JTextField emailarea = new JTextField();
        emailarea.setBounds(250,50,400,50);
        emailarea.setFont(MainFont(20));
        emailarea.setForeground(Color.white);
        emailarea.setOpaque(false);

        JLabel about = new JLabel("About: ");
        about.setFont(MainFont(20));
        about.setBounds(100,100,150,50);
        about.setForeground(Color.white);
        about.setOpaque(false);
        JTextField aboutarea = new JTextField();
        aboutarea.setBounds(250,100,400,50);
        aboutarea.setFont(MainFont(20));
        aboutarea.setForeground(Color.white);
        aboutarea.setOpaque(false);

        JLabel contest = new JLabel("Contest: ");
        contest.setFont(MainFont(20));
        contest.setBounds(100,150,150,50);
        contest.setForeground(Color.white);
        contest.setOpaque(false);
        JTextArea contestarea = new JTextArea();
        contestarea.setBounds(250,150,400,150);
        contestarea.setFont(MainFont(20));
        contestarea.setForeground(Color.white);
        contestarea.setLineWrap(true);
        contestarea.setWrapStyleWord(true);
        contestarea.setEditable(true);
        contestarea.setBackground(Color.decode("#262A2B"));
        contestarea.setOpaque(true);

        JButton Register = new JButton("Send");
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
                        String email1 = emailarea.getText();
                        String contest1 = contestarea.getText();
                        String about1 = aboutarea.getText();
                        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","m1a2l3i4Q5i6");
                        PreparedStatement Statement=connection.prepareStatement("insert into contact_main values(id,?,?,?)");
                        Statement.setString(1,email1);
                        Statement.setString(2,about1);
                        Statement.setString(3,contest1);
                        if(email1.isEmpty() || contest1.isEmpty() || about1.isEmpty()) {
                            JOptionPane.showMessageDialog(null,"Please fill of the fields! ");
                        }
                        else
                        {
                            Statement.executeUpdate();
                            JOptionPane.showMessageDialog(null,"We received your complain! \n Thank your for your time!");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();}}
            }}
        );







        panel.add(Register);
        panel.add(about);
        panel.add(aboutarea);
        panel.add(contest);
        panel.add(contestarea);
        panel.add(email);
        panel.add(emailarea);


    }



}





