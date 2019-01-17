package model;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class BaseChatIO {
    protected Socket sc;
    protected DataInputStream in;
    protected DataOutputStream out;
    protected CompositeDisposable compositeDisposable;
    protected Observable<String> response;

    protected abstract void connect(String login);

    protected void writeUTF(String message){
        if (sc != null && sc.isConnected() && out != null){
            try {
                out.writeUTF(message);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void disconnect(){
        if (sc != null && sc.isConnected()){
            try {
                in.close();
                out.close();
                sc.close();
                in = null;
                out = null;
                sc = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
