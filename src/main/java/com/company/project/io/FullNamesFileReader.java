package com.company.project.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to read a file and return the names as list of strings
 *
 * @author Suresh
 * @version 1.0
 * @since 01 July 2023
 */
public class FullNamesFileReader {

    public ArrayList<String> readNamesFromTheFile(String fileName){
        ArrayList<String> listOfNames = new ArrayList<>();
        try{
            File readFile = new File(fileName);
            Scanner fileReader = new Scanner(readFile);
            while(fileReader.hasNextLine()){
                String newLine = fileReader.nextLine();
                //Making Sure there are no empty or single name files
                String[] nameSplit = newLine.split(" ");
                if(nameSplit.length>1){
                    listOfNames.add(newLine);
                }
            }
            fileReader.close();
        }catch(FileNotFoundException fileNotFoundException){
            System.out.println("Input file " +fileName+" not found");
        }

        return listOfNames;
    }
}
