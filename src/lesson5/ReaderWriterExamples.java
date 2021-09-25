package lesson5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReaderWriterExamples {
    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("1.txt"), StandardCharsets.UTF_8)) {
            int x;
            while ((x = inputStreamReader.read()) != -1) {
                System.out.println(x);
                System.out.println((char)x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt"))) {
            System.out.println(bufferedReader.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Student> students = new ArrayList<>();

        String tempString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))) {
            while ((tempString = bufferedReader.readLine()) != null) {
                String[] studentParametersArray = tempString.split(" ");
                students.add(new Student(studentParametersArray[0], studentParametersArray[1],
                        Integer.parseInt(studentParametersArray[2])));
            }
            System.out.println(students);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter printWriter = new PrintWriter("new_students.csv")) {
            for (Student student : students)
                printWriter.println(student.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
