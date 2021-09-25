package automatedtellermachine;

import java.io.FileWriter;

public class FileData {
    public static void writeFile(String user) {
        try (FileWriter fileWriter = new FileWriter("FileData", false)) {
            fileWriter.write(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
