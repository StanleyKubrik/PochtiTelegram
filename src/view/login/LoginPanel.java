package view.login;

import control.Controller;
import view.IPanel;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel implements IPanel {
    private JButton ok;
    private JButton cancel;
    private JLabel lbl_login;
    private JTextArea txt_login;
    private Controller controller;

    public LoginPanel(Controller controller){
        this.controller = controller;

        lbl_login = new JLabel("Login");
        lbl_login.setBounds(50, 50, 75, 25);

        txt_login = new JTextArea();
        txt_login.setBounds(145, 50, 100, 25);

        ok = new JButton("OK");
        ok.setBounds(50, 200, 50, 25);
        ok.setBackground(Color.WHITE);

        cancel = new JButton("Cancel");
        cancel.setBounds(150, 200, 50, 25);
        cancel.setBackground(Color.WHITE);

        add(lbl_login);
        add(txt_login);
        add(ok);
        add(cancel);

        ok.addActionListener(v -> controller.connect(txt_login.getText()));

        cancel.addActionListener(v -> controller.disconnect());
    }

    @Override
    public void response(String message) {

    }
}
