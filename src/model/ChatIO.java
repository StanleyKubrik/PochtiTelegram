package model;

public class ChatIO implements IChatIO {
    @Override
    public void connect(String login) {
        System.out.println("ChatIO connect");
    }

    @Override
    public void send(String message) {
        // Отправляет сообщение на сервер
        System.out.println("ChatIO " + message);
    }

    @Override
    public void response() {
        System.out.println("ChatIO response");
    }

    @Override
    public void disconnect() {
        System.out.println("ChatIO disconnect");
    }
}
