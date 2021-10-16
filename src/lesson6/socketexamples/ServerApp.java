package lesson6.socketexamples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        //создали серверсоккет и повесили его на порт 1234
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            //выводим сообщение, что сервер у нас запущен и ожидает запросы
            System.out.println("Сервер запущен и ожидает запросы от клиента...");

            // вводим accept для того, чтобы сервер начала получать сообщения
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//наладили поток обмена данными.
// Теперь посмотрим, что  нам передаст клиент. Будет бесконечный цикл. Создадим строку энд по которой мы будем выходить.
            while (true) {
                String clientRequest = dataInputStream.readUTF();

                if (clientRequest.equals("end")) break;
//equals сравнивает на равенство ссылочные типы.
                System.out.println("Запрос от клиента: " + clientRequest);
                //отправим обратно клиенту.
                dataOutputStream.writeUTF(clientRequest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
