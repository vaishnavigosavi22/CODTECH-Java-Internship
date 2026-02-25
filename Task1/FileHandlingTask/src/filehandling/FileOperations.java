/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filehandling;

import java.io.*;
/**
 *
 * @author vyshnvi
 */




public class FileOperations {

    public static void main(String[] args) {
        String fileName = "sample.txt";

        writeFile(fileName);
        readFile(fileName);
        modifyFile(fileName);
        readFile(fileName);
    }

    // Write to file
    public static void writeFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("Hello CODTECH Internship\n");
            fw.write("This is Java File Handling Task\n");
            fw.close();
            System.out.println("File written successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read from file
    public static void readFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("Reading file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Modify file (append text)
    public static void modifyFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write("File modified successfully!\n");
            fw.close();
            System.out.println("File modified.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
