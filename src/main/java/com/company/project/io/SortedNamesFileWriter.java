package com.company.project.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to write names to a file from a list of strings
 *
 * @author Suresh
 * @version 1.0
 * @since 01 July 2023
 */
public class SortedNamesFileWriter {
    public  void writeSortedNamestoFile(ArrayList<String> sortedNames, String fileName) {
        try {
            File existingFile = new File(fileName);
            //Check for existing file with the same name and delete
            if(existingFile.delete()){
                System.out.println("Deleting/Overwriting existing file ");
            }
            //Write to file
            FileWriter fileWriter = new FileWriter(fileName);
            for(String name : sortedNames) {
                fileWriter.write(name);
                fileWriter.write(String.format("%n"));
            }
            fileWriter.close(); //Close the connection
            System.out.println("Done writing to file");
        } catch (IOException ioException) {
            System.out.println("Error Occurred while writing to file");
        }
    }
}
