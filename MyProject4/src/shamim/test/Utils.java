package shamim.test;

import java.io.*;
import java.util.List;

public class Utils {
    public static void writeTofile(String filename, List<Student> students) throws Exception {
        File destFile = new File(filename + ".txt");
        try {
            if (destFile.exists() == false) {
                destFile.createNewFile();
            }
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(destFile, true))) {
                students.forEach((s) -> { 
                    printWriter.append(s.getName() + ", " + s.getAge()+ ", " + s.getEmail()  + ", " + s.getGender() + ", " + s.getHobby() + ", " + s.getRound() + ", " + s.getNote() + "\n");
                });
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
