package kz.ori.networkchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerApp {

    // 3. Если клиент отправит команду /stat, то сервер должен выслать клиенту
    // сообщение 'Количество сообщений - n'
    public static void main( String[] args ) {
        int messageCount = 0;
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен на порту 8189. Ожидаем подключение клиента...");
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент подключился");

            String msg;
            while (true) {
                msg = in.readUTF();
                messageCount++;
                if ("/stat".equalsIgnoreCase(msg)) {
                    out.writeUTF("Количество сообщений - " + messageCount);
                } else {
                    System.out.print(msg + "\n");
                    out.writeUTF("ECHO: " + msg);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}