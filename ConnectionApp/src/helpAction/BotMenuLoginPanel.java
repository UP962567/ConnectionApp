package helpAction;

import Prog.Board.MainL;
import Prog.Board.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotMenuLoginPanel {
    JPanel BotLoginPanel;
    MainL bm;
    Message bmm;


    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    public void BotMenuLoginPanel() {
        BotLoginPanel = new JPanel();
        BotLoginPanel.setLayout(new GridLayout());
        BotLoginPanel.setBounds(0, 750, 1000, 50);
        BotLoginPanel.setOpaque(false);

        JButton Bt1 = new JButton("Github");
        Bt1.setOpaque(false);
        Bt1.setFont(LogoFont(24));
        Bt1.setContentAreaFilled(false);
        Bt1.setBorderPainted(false);
        Bt1.setForeground(Color.white);
        Bt1.setFocusPainted(false);
        Bt1.addActionListener(GitButton);

        JButton Bt2 = new JButton("Website");
        Bt2.setOpaque(false);
        Bt2.setFont(MenuFont(20));
        Bt2.setContentAreaFilled(false);
        Bt2.setBorderPainted(false);
        Bt2.setForeground(Color.white);
        Bt2.setFocusPainted(false);
        Bt2.addActionListener(WebButton);

        JButton Bt3 = new JButton("Linkedin");
        Bt3.setOpaque(false);
        Bt3.setFont(MenuFont(20));
        Bt3.setContentAreaFilled(false);
        Bt3.setBorderPainted(false);
        Bt3.setForeground(Color.white);
        Bt3.setFocusPainted(false);
        Bt3.addActionListener(LinButton);

        

        if(Helper.getBoardLocation() == 1){
            bm.frameBoardMain.add(BotLoginPanel);
            BotLoginPanel.add(Bt1);
            BotLoginPanel.add(Bt2);
            BotLoginPanel.add(Bt3);
        }
        if(Helper.getBoardLocation() == 2){
            bmm.frameBoardMessage.add(BotLoginPanel);
            BotLoginPanel.add(Bt1);
            BotLoginPanel.add(Bt2);
            BotLoginPanel.add(Bt3);
        }


        BotLoginPanel.setVisible(true);
    }


    GithubButtonAction GitButton = new GithubButtonAction();
    WebsiteButtonAction WebButton = new WebsiteButtonAction();
    LinkInButtonAction LinButton = new LinkInButtonAction();

    class GithubButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://github.com/UP962567/";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    class WebsiteButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://www.ma-dy.com/";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    class LinkInButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://www.linkedin.com/in/maliqdyrma";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
