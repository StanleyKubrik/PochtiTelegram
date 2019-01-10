package model;

import io.reactivex.Observable;

public class ChatIO implements IChatIO {
    @Override
    public void connect(String login) {

    }

    @Override
    public void send(String message) {

    }

    @Override
    public Observable<String> response() {
        return null;
    }

    @Override
    public void disconnect() {

    }
}
