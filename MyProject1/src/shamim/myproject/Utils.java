package shamim.myproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Utils {

    public void writeTofile(String filename, List<Student> students) throws Exception {
        File destFile = new File(filename + ".txt");
        try {
            if (destFile.exists() == false) {
                System.out.println("We had to make a new file.");
                destFile.createNewFile();
            }
            
            FileWriter fileWriter = new FileWriter(destFile, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                students.forEach((s) -> {
                    printWriter.append(s.getName() + ", " + s.getAge()+ ", " + s.getEmail()  + ", " + s.getGender() + ", " + s.getHobby() + ", " + s.getRound() + ", " + s.getNote() + "\n");
                });
            }
        } catch (IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
    }

    public static void displayStudentsdataFromFile(String filename, DefaultTableModel model) {
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename + ".txt"));

            while ((line = reader.readLine()) != null) {
                model.addRow(line.split(", ")); //this has a comma and a space bc that  is how the file is written to
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
        }
    }
}
