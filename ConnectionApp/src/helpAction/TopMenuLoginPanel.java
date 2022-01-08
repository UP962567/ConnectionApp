package helpAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopMenuLoginPanel {
    JPanel TopPanelLogin;
    Prog.Board.MainL bm;
    Prog.Board.Message bmm;

    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    public void TopMenuLoginPanel() {
        TopPanelLogin = new JPanel();
        TopPanelLogin.setLayout(new GridLayout());
        TopPanelLogin.setBounds(0, 0, 1000, 50);
        TopPanelLogin.setOpaque(false);

        JLabel username = new JLabel("User: " + Users.getLoginUsername());
        username.setBounds(250,150,100,50);
        username.setFont(MainFont(20));
        username.setForeground(Color.white);
        username.setOpaque(false);



        JButton logo = new JButton("MaDy");
        logo.setOpaque(false);
        logo.setFont(LogoFont(24));
        logo.setContentAreaFilled(false);
        logo.setBorderPainted(false);
        logo.setForeground(Color.white);
        logo.setFocusPainted(false);

        JButton MainL  = new JButton("Main");
        MainL.setOpaque(false);
        MainL.setFont(MenuFont(20));
        MainL.setContentAreaFilled(false);
        MainL.setBorderPainted(true);
        MainL.setForeground(Color.white);
        MainL.setFocusPainted(false);
        MainL.addActionListener(mp);

        JButton game  = new JButton("Games");
        game.setOpaque(false);
        game.setFont(MenuFont(20));
        game.setContentAreaFilled(false);
        game.setBorderPainted(true);
        game.setForeground(Color.white);
        game.setFocusPainted(false);
        game.addActionListener(mp);

        JButton message  = new JButton("Message");
        message.setOpaque(false);
        message.setFont(MenuFont(20));
        message.setContentAreaFilled(false);
        message.setBorderPainted(true);
        message.setForeground(Color.white);
        message.setFocusPainted(false);
        message.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bm.frameBoardMain.setVisible(false);
                new Prog.Board.Message();}
        });

        JButton Exit  = new JButton("Logout");
        Exit.setOpaque(false);
        Exit.setFont(MenuFont(20));
        Exit.setContentAreaFilled(false);
        Exit.setBorderPainted(true);
        Exit.setForeground(Color.white);
        Exit.setFocusPainted(false);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bm.frameBoardMain.setVisible(false);
                new Prog.Main();}
        });


        if(Helper.getBoardLocation() == 1){
            TopPanelLogin.add(logo);
            TopPanelLogin.add(game);
            TopPanelLogin.add(message);
            TopPanelLogin.add(username);
            TopPanelLogin.add(Exit);
            bm.frameBoardMain.add(TopPanelLogin);
        }
        else if(Helper.getBoardLocation() == 2){
            TopPanelLogin.add(logo);
            TopPanelLogin.add(MainL);
            TopPanelLogin.add(game);
            TopPanelLogin.add(username);
            TopPanelLogin.add(Exit);
            bmm.frameBoardMessage.add(TopPanelLogin);
        }


    }

    MainLoginPage mp = new MainLoginPage();
    MessageLoginPage mlp = new MessageLoginPage();

    class MainLoginPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                bm.frameBoardMain.setVisible(false);
                new Prog.Board.MainL();
            }
            else if(Helper.getLocation() == 1){
                bm.frameBoardMain.setVisible(false);
                new Prog.Board.MainL();
            }
            else if(Helper.getLocation() == 2){
                bmm.frameBoardMessage.setVisible(false);
                new Prog.Board.MainL();
            }
        }
    }

    class MessageLoginPage implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Helper.getLocation() == 0){
                bm.frameBoardMain.setVisible(false);
                new Prog.Board.Message();
            }
            else if(Helper.getLocation() == 1){
                bm.frameBoardMain.setVisible(false);
                new Prog.Board.Message();
            }
            else if(Helper.getLocation() == 2){
                bmm.frameBoardMessage.setVisible(false);
                new Prog.Board.Message();
            }
        }
    }

}
