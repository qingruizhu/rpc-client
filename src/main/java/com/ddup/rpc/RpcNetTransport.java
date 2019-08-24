package com.ddup.rpc;
import java.io.*;
import java.net.Socket;
/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2019-08-22 17:16
 */
public class RpcNetTransport {
    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest request) {
        Object result = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            Socket socket = null;
            try {
                socket = new Socket(host, port);
            } catch (IOException e) {
                e.printStackTrace();
            }
            OutputStream os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(request);
            oos.flush();
            InputStream is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            result = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
