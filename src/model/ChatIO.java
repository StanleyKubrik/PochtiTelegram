package model;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ChatIO extends BaseChatIO implements IChatIO {

    public ChatIO() {
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
    public void send(String message) {
        // Отправляет сообщение на сервер
        writeUTF(Constant.TAG_msg);
    }

    @Override
    public Observable<String> response() {
        return response.filter(f -> f != null && !f.isEmpty());
    }

    @Override
    public void disconnect() {
        writeUTF(Constant.TAG_exit);
        disconnect();
        compositeDisposable.dispose();
    }
}
