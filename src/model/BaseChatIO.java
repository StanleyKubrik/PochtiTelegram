package model;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class BaseChatIO {
    protected Socket cs;
    protected DataInputStream in;
    protected DataOutputStream out;
    protected CompositeDisposable compositeDisposable;
    protected Observable<String> response;

    protected abstract void connect(String login);

    protected void writeUTF(String message){
        if (cs != null && cs.isConnected() && out != null){
            try {
                out.writeUTF(message);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void disconnect(){
        if (cs != null && cs.isConnected()){
            try {
                in.close();
                out.close();
                cs.close();
                in = null;
                out = null;
                cs = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
