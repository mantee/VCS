package models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;


public class FileProcess {
    public ArrayList<String> readData(String file) throws FileNotFoundException {
        File inFile = new File(file);
        ArrayList<String> data = new ArrayList<String>();

        Scanner sc = new Scanner(inFile);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            data.add(line);
        }
        sc.close();

        return data;
    }

    public void writeData(String file, ArrayList<String> data) throws FileNotFoundException {
        Path path = Paths.get(file);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            for(String line : data){
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createRepoDir(Integer id) {
        String dbDir = "db/repositories/repository"+id;
        File dbFile = new File(dbDir, "commits.dat");

        String filesDir = "user_files/repository"+id;
        File filesFile = new File(filesDir, "readme.txt");

        try {
            new File(dbDir).mkdir();
            dbFile.createNewFile();

            new File(filesDir).mkdir();
            filesFile.createNewFile();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
