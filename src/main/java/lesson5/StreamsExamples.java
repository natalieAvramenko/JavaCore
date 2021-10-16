package lesson5;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StreamsExamples {
    public static void main(String[] args) throws FileNotFoundException {
        // byte: 00000000 10101010 11111111 2^8 = 256 {0 255} (-128 +127)
        // 1 - 1, 127 = 127, 128 = -128, 48 = 128 + (128-48) = 208

        String tempString = "cat";
        System.out.println(Arrays.toString(tempString.getBytes(StandardCharsets.UTF_8)));

        System.out.println(Charset.defaultCharset());
        System.out.println(Charset.availableCharsets());


        File file = new File("1.txt");
        File file2 = new File("outputExamples.txt");

        OutputStream outputStream = null; //открыли поток на запись

        try {
            outputStream = new FileOutputStream(file); //передали файл
            outputStream.write(tempString.getBytes(StandardCharsets.UTF_8));
            //сказали потоку пиши

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //создадим новый поток и напишем еще один символ
        try (OutputStream outputStream1 = new FileOutputStream(file2, true)) {
            outputStream1.write(65);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //засечем время, за которое запишется код и записать поток
//        long time = System.currentTimeMillis();
//        try (OutputStream outputStream1 = new FileOutputStream(file)) {
//            for (int i = 0; i <= 5 * 1024 * 1024; i++) {
//                outputStream1.write(65);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Время на запись 5 МБ: " + (System.currentTimeMillis() - time));

        long timeNew = System.currentTimeMillis();
        try (OutputStream outputStream1 = new BufferedOutputStream (new FileOutputStream(file2))) {
            for (int i = 0; i <= 5 * 1024 * 1024; i++) {
                outputStream1.write(65);
                outputStream1.flush(); //очистить буфер
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время на запись 5 МБ с буфером: " + (System.currentTimeMillis() - timeNew));
        //читать из файла

        try (InputStream inputStream = new FileInputStream(file)) {
            for (int i = 0; i < file.length(); i++) {
                System.out.println(i + ": " + (char) inputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = null;
        try (InputStream inputStream2 = new FileInputStream(file)) {
            bytes = new byte[inputStream2.available()];
            inputStream2.read(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println (new String (bytes, StandardCharsets.UTF_8));
    }

}
