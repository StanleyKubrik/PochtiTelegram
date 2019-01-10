package model;

import io.reactivex.Observable;

public interface IChatIO {
    void connect(String login);
    void send(String message);
    Observable<String> response();
    void disconnect();
}