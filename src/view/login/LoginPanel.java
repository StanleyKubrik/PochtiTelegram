package view.login;

import control.Controller;
import control.IController;
import view.IPanel;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel implements IPanel {
    private JButton ok, cancel;
    private JLabel lbl_login;
    private JTextArea txt_login;
    private IController controller;

    public LoginPanel(IController controller){
        this.controller = controller;
        setLayout(null);

        lbl_login = new JLabel("Create login");
        lbl_login.setBounds(10, 20, 75, 20);

        txt_login = new JTextArea();
        txt_login.setBounds(85, 20, 90, 20);
        txt_login.setBackground(Color.white);

        ok = new JButton("OK");
        ok.setBounds(10, 50, 75, 20);
        ok.setBackground(Color.WHITE);

        cancel = new JButton("Cancel");
        cancel.setBounds(100, 50, 75, 20);
        cancel.setBackground(Color.WHITE);

        add(lbl_login);
        add(txt_login);
        add(ok);
        add(cancel);

        listener();
    }

    private void listener() {
        ok.addActionListener(v -> controller.connect(txt_login.getText()));

        cancel.addActionListener(v -> controller.disconnect());
    }

    @Override
    public void response(String message) {

    }
}
