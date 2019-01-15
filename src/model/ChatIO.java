package model;

public class ChatIO implements IChatIO {
    @Override
    public void connect(String login) {
        // TODO ChatIO connect
        System.out.println("ChatIO connect");
    }

    @Override
    public void send(String message) {
        // TODO ChatIO send
        // Отправляет сообщение на сервер
        System.out.println("ChatIO " + message);
    }

    @Override
    public void response() {
        // TODO ChatIO response
        System.out.println("ChatIO response");
    }

    @Override
    public void disconnect() {
        // TODO ChatIO disconnect
        System.out.println("ChatIO disconnect");
    }
}
