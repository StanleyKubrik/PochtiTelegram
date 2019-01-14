package model;

import control.Controller;
import control.IController;

public class ChatIO implements IChatIO {
    @Override
    public void connect(String login) {
        // TODO ChatIO connect
    }

    @Override
    public void send(String message) {
        // TODO ChatIO send
        // Отправляет сообщение на сервер
    }

    @Override
    public void response() {
        // TODO ChatIO response
    }

    @Override
    public void disconnect() {
        // TODO ChatIO disconnect
    }
}
