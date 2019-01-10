package control;

import io.reactivex.Observable;

public interface IController {
    void login();
    void chat();
    void send(String message);
    Observable<String> response();
    void disconnect();
}
