package view;

import model.Constant;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements Route {

    public Frame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public <T extends IPanel> void addView(T panel) {
        add((JPanel) panel);
    }

    @Override
    public <T extends IPanel> void remove(T panel) {
        remove((JPanel)panel);
    }

    @Override
    public void setVisible(boolean flag) {
        super.setVisible(flag);
    }

    @Override
    public void viewLogin(){
        setTitle(Constant.TITLE_LOGIN);
        setBounds(250, 250, 400, 300);
    }

    @Override
    public void viewChat(){
        setTitle(Constant.TITLE_CHAT);
        setBounds(250, 250, 800, 600);
    }

    @Override
    public void dispose(){
        super.dispose();
    }
}
