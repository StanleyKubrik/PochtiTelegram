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
        lbl_login.setBounds(10, 10, 50, 25);
        lbl_login.setBackground(Color.BLUE);

        txt_login = new JTextArea();
        txt_login.setBounds(70, 10, 75, 25);
        txt_login.setBackground(Color.pink);

        ok = new JButton("OK");
        ok.setBounds(10, 55, 50, 25);
        ok.setBackground(Color.WHITE);

        cancel = new JButton("Cancel");
        cancel.setBounds(70, 55, 50, 25);
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
