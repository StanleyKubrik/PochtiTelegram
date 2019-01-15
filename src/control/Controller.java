package control;

import model.ChatIO;
import model.IChatIO;
import view.Frame;
import view.IPanel;
import view.Route;
import view.chat.ChatPanel;
import view.login.LoginPanel;

public class Controller implements IController {
    private Route route;
    private IChatIO iChatIO;
    private IPanel iPanel;

    public Controller(){
        route = new Frame();
    }

    @Override
    public void login() {
        iPanel = new LoginPanel(this);
        route.viewLogin();
        route.addView(iPanel);
        route.setVisible(true);
    }

    @Override
    public void connect(String login) {
        iChatIO = new ChatIO();
        iChatIO.connect(login);
        chat();
    }

    @Override
    public void chat() {
        route.remove(iPanel);
        iPanel = new ChatPanel(this);
        route.viewChat();
        route.addView(iPanel);
        route.setVisible(true);
    }

    @Override
    public void send(String message) {
        iChatIO.send("ya tut");
        // TODO send
    }

    @Override
    public void response() {
        // TODO response
        iChatIO.response();
    }

    @Override
    public void disconnect() {
        if (iChatIO != null){
            iChatIO.disconnect();
            iChatIO = null;
        }
        route.dispose();
        route = null;
    }
}
