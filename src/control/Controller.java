package control;

import io.reactivex.disposables.CompositeDisposable;
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
    private CompositeDisposable compositeDisposable;

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
        compositeDisposable = new CompositeDisposable();
        iChatIO = new ChatIO();
        iChatIO.connect(login);
        chat();
    }

    private void chat() {
        route.remove(iPanel);
        iPanel = new ChatPanel(this);
        route.viewChat();
        route.addView(iPanel);
        route.setVisible(true);
    }

    @Override
    public void send(String message) {
        iChatIO.send(message);
    }

    @Override
    public void response() {
        compositeDisposable.add(
            iChatIO.response().subscribe(v -> iPanel.response(v), Throwable::printStackTrace)
        );
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
