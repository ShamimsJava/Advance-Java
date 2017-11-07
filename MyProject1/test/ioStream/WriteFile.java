package ioStream;

import java.io.*;

public class WriteFile {
    
    public static void main(String[] args) throws Exception {
        Student s = new Student("Shamim", "Dhaka");
        File file = new File("shihab.txt");
        file.createNewFile();
        
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.append(s.getName()+" "+s.getAddress());
        printWriter.close();
    }
}
