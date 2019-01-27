package model;

import io.reactivex.Observable;

import java.io.IOException;

public interface IChatIO {
    void connect(String login);
    void send(String message) throws IOException;
    Observable<String> response();
    void disconnect(); //throws IOException;
}