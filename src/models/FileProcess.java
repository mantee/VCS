package models;

import java.io.File;
import java.io.FileNotFoundException;
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
}
