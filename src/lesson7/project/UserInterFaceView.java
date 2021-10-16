package lesson7.project;

import java.io.IOException;
import java.util.Scanner;

public class UserInterFaceView {
    private Controller controller = new Controller();

    public void runInterface() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для прогноза на 1 день;" +
                    "Введите 5 для прогноза на 5 дней;" +
                    "Для выхода введите 0.");

            String command = scanner.nextLine();

            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
