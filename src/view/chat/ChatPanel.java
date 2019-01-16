package view.chat;

import control.Controller;
import view.IPanel;

import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel implements IPanel {
    private JTextArea txt_message_out;
    private JTextArea txt_message_in;
    private JButton send;
    private JButton exit;
    private Controller controller;

    public ChatPanel(Controller controller){
        this.controller = controller;
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        txt_message_out = new JTextArea();
        txt_message_out.setBounds(10, 10, 765, 450);
        txt_message_out.setBackground(Color.WHITE);
        txt_message_out.setEditable(false);
        txt_message_out.setLineWrap(true);

        txt_message_in = new JTextArea();
        txt_message_in.setBounds(10, 475, 600, 25);
        txt_message_out.setBackground(Color.WHITE);

        send = new JButton("Send");
        send.setBounds(615, 475, 75, 25);

        exit = new JButton("Exit");
        exit.setBounds(700, 475, 75, 25);

        add(txt_message_out);
        add(txt_message_in);
        add(send);
        add(exit);
    }

    @Override
    public void response(String message) {

    }
}
