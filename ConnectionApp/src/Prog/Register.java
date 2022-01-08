package Prog;

import helpAction.BotMenuPanel;
import helpAction.Helper;
import helpAction.TopMenuPanel;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Register extends Component {
    private Container main;
    public static JFrame frameRegister;
    public static JButton Register;

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
    String gender[] = {"Male", "Female", "Others"};


    public Register() {
        frameRegister = new JFrame("Login Page");
        frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegister.setLayout(null);
        frameRegister.setSize(1000, 800);
        frameRegister.setResizable(false);
        frameRegister.setLocationRelativeTo(null);
        frameRegister.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameRegister.setUndecorated(true);
        main = frameRegister.getContentPane();

        h.setLocation(4);
        tmp.TopMenuPanel();
        bmp.BotMenuPanel();
        BodyPanel();

        frameRegister.pack();
        frameRegister.setVisible(true);
    }



    public void BodyPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 200, 800, 500);
        panel.setOpaque(false);
        frameRegister.add(panel);

        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(38,45,43));
        UI.put("Panel.background",new ColorUIResource(38,45,43));
        UI.put("OptionPane.messageForeground", Color.white);


        JLabel username = new JLabel("Username:");
        username.setBounds(0,50,150,50);
        username.setFont(MainFont(20));
        username.setForeground(Color.white);
        username.setOpaque(false);
        JTextField usernamearea = new JTextField();
        usernamearea.setBounds(150,50,200,50);
        usernamearea.setFont(MainFont(20));
        usernamearea.setForeground(Color.white);
        usernamearea.setOpaque(false);

        JLabel password = new JLabel("Password:");
        password.setFont(MainFont(20));
        password.setBounds(0,100,150,50);
        password.setForeground(Color.white);
        password.setOpaque(false);
        JTextField passwordarea = new JTextField();
        passwordarea.setBounds(150,100,200,50);
        passwordarea.setFont(MainFont(20));
        passwordarea.setForeground(Color.white);
        passwordarea.setOpaque(false);

        JLabel repassword = new JLabel("RePassword:");
        repassword.setFont(MainFont(20));
        repassword.setBounds(0,150,150,50);
        repassword.setForeground(Color.white);
        repassword.setOpaque(false);
        JTextField repasswordarea = new JTextField();
        repasswordarea.setBounds(150,150,200,50);
        repasswordarea.setFont(MainFont(20));
        repasswordarea.setForeground(Color.white);
        repasswordarea.setOpaque(false);

        JLabel Gender = new JLabel("Gender:");
        Gender.setFont(MainFont(20));
        Gender.setBounds(0,200,150,50);
        Gender.setForeground(Color.white);
        Gender.setOpaque(false);

        Choice choice = new Choice();
        choice.setFont(MainFont(28));
        choice.setBounds(150,200,200,50);
        choice.setForeground(Color.white);
        choice.setBackground(Color.decode("#262A2B"));
        choice.add("Male");
        choice.add("Female");
        choice.add("Others");

        JLabel Email = new JLabel("Email:");
        Email.setFont(MainFont(20));
        Email.setBounds(0,250,150,50);
        Email.setForeground(Color.white);
        Email.setOpaque(false);
        JTextField Emailarea = new JTextField();
        Emailarea.setBounds(150,250,400,50);
        Emailarea.setFont(MainFont(20));
        Emailarea.setForeground(Color.white);
        Emailarea.setOpaque(false);

        JLabel ReEmail = new JLabel("Email:");
        ReEmail.setFont(MainFont(20));
        ReEmail.setBounds(0,300,150,50);
        ReEmail.setForeground(Color.white);
        ReEmail.setOpaque(false);
        JTextField ReEmailarea = new JTextField();
        ReEmailarea.setBounds(150,300,400,50);
        ReEmailarea.setFont(MainFont(20));
        ReEmailarea.setForeground(Color.white);
        ReEmailarea.setOpaque(false);


        JLabel address = new JLabel("Address:");
        address.setBounds(450,50,150,50);
        address.setFont(MainFont(20));
        address.setForeground(Color.white);
        address.setOpaque(false);
        JTextField addressarea = new JTextField();
        addressarea.setBounds(600,50,200,50);
        addressarea.setFont(MainFont(20));
        addressarea.setForeground(Color.white);
        addressarea.setOpaque(false);

        JLabel country = new JLabel("Country:");
        country.setFont(MainFont(20));
        country.setBounds(450,100,150,50);
        country.setForeground(Color.white);
        country.setOpaque(false);
        JTextField countryarea = new JTextField();
        countryarea.setBounds(600,100,200,50);
        countryarea.setFont(MainFont(20));
        countryarea.setForeground(Color.white);
        countryarea.setOpaque(false);

        JLabel age = new JLabel("Your Age:");
        age.setFont(MainFont(20));
        age.setBounds(450,150,150,50);
        age.setForeground(Color.white);
        age.setOpaque(false);
        JTextField agearea = new JTextField();
        agearea.setBounds(600,150,200,50);
        agearea.setFont(MainFont(20));
        agearea.setForeground(Color.white);
        agearea.setOpaque(false);

        JLabel Language = new JLabel("Language:");
        Language.setFont(MainFont(20));
        Language.setBounds(450,200,150,50);
        Language.setForeground(Color.white);
        Language.setOpaque(false);
        Choice choice1 = new Choice();
        choice1.setFont(MainFont(28));
        choice1.setBounds(600,200,200,50);
        choice1.setForeground(Color.white);
        choice1.setBackground(Color.decode("#262A2B"));
        choice1.add("English");
        choice1.add("German");
        choice1.add("Others");




        Register = new JButton("Register");
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
                        String user = usernamearea.getText();
                        String pass = passwordarea.getText();
                        String add = addressarea.getText();
                        String country = countryarea.getText();
                        String age = agearea.getText();
                        String email = Emailarea.getText();
                        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","m1a2l3i4Q5i6");
                        PreparedStatement Pstatement=connection.prepareStatement("insert into users values(?,?,?,?,?,?)");
                        Pstatement.setString(1,user);
                        Pstatement.setString(2,pass);
                        Pstatement.setString(3,add);
                        Pstatement.setString(4,country);
                        Pstatement.setString(5,age);
                        Pstatement.setString(6,email);
                        if(user.isEmpty() || passwordarea.getText().isEmpty() || add.isEmpty() || country.isEmpty() || age.isEmpty() || email.isEmpty()) {
                            JOptionPane.showMessageDialog(null,"Please fill of the fields! ");
                        }
                        else if(!Emailarea.getText().equalsIgnoreCase(ReEmailarea.getText())) {
                            JOptionPane.showMessageDialog(null,"Confirm you email! ");
                        }
                        else if(passwordarea.getText().equalsIgnoreCase(repasswordarea.getText()))
                        {
                            Pstatement.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Password did not match");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();}}
            }}
        );





















        panel.add(username);
        panel.add(password);
        panel.add(repassword);
        panel.add(usernamearea);
        panel.add(passwordarea);
        panel.add(repasswordarea);
        panel.add(Gender);
        panel.add(choice);
        panel.add(address);
        panel.add(addressarea);
        panel.add(country);
        panel.add(countryarea);
        panel.add(age);
        panel.add(agearea);
        panel.add(Language);
        panel.add(choice1);
        panel.add(Email);
        panel.add(Emailarea);
        panel.add(ReEmail);
        panel.add(Register);
        panel.add(ReEmailarea);

    }



}
