package view.chat;

import control.Controller;
import view.IPanel;

import javax.swing.*;

public class ChatPanel extends JPanel implements IPanel {

    private JButton ok;
    private JButton cancel;
    private JLabel lbl_login;
    private JTextArea txt_login;
    private Controller controller;

    public ChatPanel(Controller controller){
        this.controller = controller;
    }

    @Override
    public void response(String message) {

    }
}
