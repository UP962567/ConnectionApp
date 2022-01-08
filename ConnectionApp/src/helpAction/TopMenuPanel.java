package helpAction;

import Prog.Login;
import Prog.Contact;
import Prog.About;
import Prog.Main;
import Prog.Settings;
import Prog.Register;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopMenuPanel {
    Helper h;
    Login l;
    Main m;
    Contact c;
    About a;
    Register r;
    Settings s;
    JPanel TopPanel;

    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}


    public void TopMenuPanel() {
        TopPanel = new JPanel();
        TopPanel.setLayout(new GridLayout());
        TopPanel.setBounds(0, 0, 1000, 50);
        TopPanel.setOpaque(false);


        JButton logo = new JButton("MaDy");
        logo.setOpaque(false);
        logo.setFont(LogoFont(24));
        logo.setContentAreaFilled(false);
        logo.setBorderPainted(false);
        logo.setForeground(Color.white);
        logo.setFocusPainted(false);

        JButton contact = new JButton("Contact");
        contact.setOpaque(false);
        contact.setFont(MenuFont(20));
        contact.setContentAreaFilled(false);
        contact.setBorderPainted(true);
        contact.setForeground(Color.white);
        contact.setFocusPainted(false);
        contact.addActionListener(cp);

        JButton aboutUS = new JButton("About");
        aboutUS.setOpaque(false);
        aboutUS.setFont(MenuFont(20));
        aboutUS.setContentAreaFilled(false);
        aboutUS.setBorderPainted(true);
        aboutUS.setForeground(Color.white);
        aboutUS.setFocusPainted(false);
        aboutUS.addActionListener(ap);

        JButton Account = new JButton("Account");
        Account.setOpaque(false);
        Account.setFont(MenuFont(20));
        Account.setContentAreaFilled(false);
        Account.setBorderPainted(true);
        Account.setForeground(Color.white);
        Account.setFocusPainted(false);
        Account.addActionListener(cp);

        JButton Login  = new JButton("Login");
        Login.setOpaque(false);
        Login.setFont(MenuFont(20));
        Login.setContentAreaFilled(false);
        Login.setBorderPainted(true);
        Login.setForeground(Color.white);
        Login.setFocusPainted(false);
        Login.addActionListener(lp);

        JButton Register  = new JButton("Register");
        Register.setOpaque(false);
        Register.setFont(MenuFont(20));
        Register.setContentAreaFilled(false);
        Register.setBorderPainted(true);
        Register.setForeground(Color.white);
        Register.setFocusPainted(false);
        Register.addActionListener(rp);

        JButton Settings  = new JButton("Settings");
        Settings.setOpaque(false);
        Settings.setFont(MenuFont(20));
        Settings.setContentAreaFilled(false);
        Settings.setBorderPainted(true);
        Settings.setForeground(Color.white);
        Settings.setFocusPainted(false);
        Settings.addActionListener(sp);

        JButton Main  = new JButton("Main");
        Main.setOpaque(false);
        Main.setFont(MenuFont(20));
        Main.setContentAreaFilled(false);
        Main.setBorderPainted(true);
        Main.setForeground(Color.white);
        Main.setFocusPainted(false);
        Main.addActionListener(mp);

        JButton Exit  = new JButton("Exit");
        Exit.setOpaque(false);
        Exit.setFont(MenuFont(20));
        Exit.setContentAreaFilled(false);
        Exit.setBorderPainted(true);
        Exit.setForeground(Color.white);
        Exit.setFocusPainted(false);
        Exit.addActionListener(mp);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        if(Helper.getLocation() == 0){
            m.frameMain.add(TopPanel);
            TopPanel.add(logo);
            TopPanel.add(contact);
            TopPanel.add(aboutUS);
            TopPanel.add(Login);
            TopPanel.add(Register);
            TopPanel.add(Settings);
            TopPanel.add(Exit);
        }
        else if(Helper.getLocation() == 1){
            c.frameContact.add(TopPanel);
            TopPanel.add(logo);
            TopPanel.add(Main);
            TopPanel.add(aboutUS);
            TopPanel.add(Login);
            TopPanel.add(Register);
            TopPanel.add(Settings);
            TopPanel.add(Exit);
        }
        else if(Helper.getLocation() == 2){
            a.frameAbout.add(TopPanel);
            TopPanel.add(logo);
            TopPanel.add(Main);
            TopPanel.add(contact);
            TopPanel.add(Login);
            TopPanel.add(Register);
            TopPanel.add(Settings);
            TopPanel.add(Exit);
        }
        else if(Helper.getLocation() == 3){
            l.frameLogin.add(TopPanel);
            TopPanel.add(logo);
            TopPanel.add(Main);
            TopPanel.add(contact);
            TopPanel.add(aboutUS);
            TopPanel.add(Register);
            TopPanel.add(Settings);
            TopPanel.add(Exit);
        }
        else if(Helper.getLocation() == 4){
            r.frameRegister.add(TopPanel);
            TopPanel.add(logo);
            TopPanel.add(Main);
            TopPanel.add(contact);
            TopPanel.add(aboutUS);
            TopPanel.add(Login);
            TopPanel.add(Settings);
            TopPanel.add(Exit);
        }
        else if(Helper.getLocation() == 5){
            s.frameSettings.add(TopPanel);
            TopPanel.add(logo);
            TopPanel.add(Main);
            TopPanel.add(contact);
            TopPanel.add(aboutUS);
            TopPanel.add(Login);
            TopPanel.add(Register);
            TopPanel.add(Exit);
        }

        TopPanel.setVisible(true);
    }







    MainPage mp = new MainPage();
    ContactPage cp = new ContactPage();
    AboutPage ap = new AboutPage();
    LoginPage lp = new LoginPage();
    RegisterPage rp = new RegisterPage();
    SettingsPage sp = new SettingsPage();

    class MainPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                m.frameMain.setVisible(false);
                new Main();
            }
            else if(Helper.getLocation() == 1){
                c.frameContact.setVisible(false);
                new Main();
            }
            else if(Helper.getLocation() == 2){
                a.frameAbout.setVisible(false);
                new Main();
            }
            else if(Helper.getLocation() == 3){
                l.frameLogin.setVisible(false);
                new Main();
            }
            else if(Helper.getLocation() == 4){
                r.frameRegister.setVisible(false);
                new Main();
            }
            else if(Helper.getLocation() == 5){
                s.frameSettings.setVisible(false);
                new Main();
            }
        }
    }
    class ContactPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                m.frameMain.setVisible(false);
                new Contact();
            }
            else if(Helper.getLocation() == 1){
                c.frameContact.setVisible(false);
                new Contact();
            }
            else if(Helper.getLocation() == 2){
                a.frameAbout.setVisible(false);
                new Contact();
            }
            else if(Helper.getLocation() == 3){
                l.frameLogin.setVisible(false);
                new Contact();
            }
            else if(Helper.getLocation() == 4){
                r.frameRegister.setVisible(false);
                new Contact();
            }
            else if(Helper.getLocation() == 5){
                s.frameSettings.setVisible(false);
                new Contact();
            }
        }
    }
    class AboutPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                m.frameMain.setVisible(false);
                new About();
            }
            else if(Helper.getLocation() == 1){
                c.frameContact.setVisible(false);
                new About();
            }
            else if(Helper.getLocation() == 2){
                a.frameAbout.setVisible(false);
                new About();
            }
            else if(Helper.getLocation() == 3){
                l.frameLogin.setVisible(false);
                new About();
            }
            else if(Helper.getLocation() == 4){
                r.frameRegister.setVisible(false);
                new About();
            }
            else if(Helper.getLocation() == 5){
                s.frameSettings.setVisible(false);
                new About();
            }
        }
    }
    class LoginPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                m.frameMain.setVisible(false);
                new Login();
            }
            else if(Helper.getLocation() == 1){
                c.frameContact.setVisible(false);
                new Login();
            }
            else if(Helper.getLocation() == 2){
                a.frameAbout.setVisible(false);
                new Login();
            }
            else if(Helper.getLocation() == 3){
                l.frameLogin.setVisible(false);
                new Login();
            }
            else if(Helper.getLocation() == 4){
                r.frameRegister.setVisible(false);
                new Login();
            }
            else if(Helper.getLocation() == 5){
                s.frameSettings.setVisible(false);
                new Login();
            }
        }
    }
    class RegisterPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                m.frameMain.setVisible(false);
                new Register();
            }
            else if(Helper.getLocation() == 1){
                c.frameContact.setVisible(false);
                new Register();
            }
            else if(Helper.getLocation() == 2){
                a.frameAbout.setVisible(false);
                new Register();
            }
            else if(Helper.getLocation() == 3){
                l.frameLogin.setVisible(false);
                new Register();
            }
            else if(Helper.getLocation() == 4){
                r.frameRegister.setVisible(false);
                new Register();
            }
            else if(Helper.getLocation() == 5){
                s.frameSettings.setVisible(false);
                new Register();
            }
        }
    }
    class SettingsPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                m.frameMain.setVisible(false);
                new Settings();
            }
            else if(Helper.getLocation() == 1){
                c.frameContact.setVisible(false);
                new Settings();
            }
            else if(Helper.getLocation() == 2){
                a.frameAbout.setVisible(false);
                new Settings();
            }
            else if(Helper.getLocation() == 3){
                l.frameLogin.setVisible(false);
                new Settings();
            }
            else if(Helper.getLocation() == 4){
                r.frameRegister.setVisible(false);
                new Settings();
            }
            else if(Helper.getLocation() == 5){
                s.frameSettings.setVisible(false);
                new Settings();
            }
        }
    }

}
