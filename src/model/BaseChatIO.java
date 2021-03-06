package model;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

import static javax.swing.JOptionPane.showMessageDialog;

public abstract class BaseChatIO {
    protected Socket cs;
    protected DataInputStream in;
    protected DataOutputStream out;
    protected CompositeDisposable compositeDisposable;
    protected Observable<String> response;

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

    protected void disconnect() { //throws IOException {
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