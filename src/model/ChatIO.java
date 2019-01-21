package model;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import static javax.swing.JOptionPane.showMessageDialog;

public class ChatIO extends BaseChatIO implements IChatIO {

    public ChatIO() throws IOException {
        try {
            cs = new Socket(Constant.ADDRESS, Constant.PORT);
            in = new DataInputStream(cs.getInputStream());
            out = new DataOutputStream(cs.getOutputStream());
            response = Observable.interval(50, TimeUnit.MILLISECONDS, Schedulers.io())
                .flatMap(v -> Observable.just(in.available())
                    .filter(f -> f > 0))
                .flatMap(v -> Observable.just(in.readUTF()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect(String login) {
        writeUTF(Constant.TAG_login.concat(login));
    }

    @Override
    public void send(String message) throws IOException {
        // Отправляет сообщение на сервер
        writeUTF(Constant.TAG_msg.concat(message));
    }

    @Override
    public Observable<String> response() {
        return response.filter(f -> f != null && !f.isEmpty());
    }

    @Override
    public void disconnect() {
        writeUTF(Constant.TAG_exit);
        super.disconnect();
        //compositeDisposable.dispose();
    }
}