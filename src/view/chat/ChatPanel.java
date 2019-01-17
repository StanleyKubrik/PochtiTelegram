package view.chat;

import control.IController;
import view.IPanel;
import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel implements IPanel {
    private JTextArea txt_message_out, txt_message_in;
    private JButton send;
    private JButton exit;
    private IController controller;

    public ChatPanel(IController controller){
        this.controller = controller;
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        listener();

        txt_message_in = new JTextArea();
        txt_message_in.setBounds(10, 10, 765, 450);
        txt_message_in.setBackground(Color.WHITE);

        txt_message_out = new JTextArea();
        txt_message_out.setBounds(10, 475, 600, 25);
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

    private void listener(){
        send.addActionListener(v -> {
            controller.send(txt_message_out.getText());
            txt_message_out.setText("");
        });

        exit.addActionListener(v -> {
            controller.disconnect();
        });
    }

    @Override
    public void response(String message) {
        txt_message_in.getText();
    }
}
