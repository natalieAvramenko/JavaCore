package lesson6.socketexamples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 1234);
//DataOutputStream и DataInputStream байтовые потоки, тут нас это устроит
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//необходимо реализовать прослушивание от ввода клиента: while true, будем слушать, что там пользователь вводит и отправлять на сервер, до тех пор пока не будет введено энд.
            while (true) {
                System.out.println("Введите запрос ");
                String request = scanner.nextLine();

                dataOutputStream.writeUTF(request);

                if (request.equals("end")) break;

                System.out.println("Ответ сервера: " + dataInputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
