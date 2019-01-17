package control;

public interface IController {
    void login();
    void connect(String login);
    void send(String message);
    void response();
    void disconnect();
}
