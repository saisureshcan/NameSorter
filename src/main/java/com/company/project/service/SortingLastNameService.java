package com.company.project.service;

import com.company.project.model.FullName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public interface SortingLastNameService {
    ArrayList<FullName> stringToNameConversion(ArrayList<String> nameAsString);
    boolean sortLastNames(String fileReadName, String fileWriteName); //returns true after sorting, returns false in case of errors

    ArrayList<String> readFromFile(String fileName);

    void writeToFile(ArrayList<String> sortedNamesStringList, String fileName);
    ArrayList<String> fullNameToStringConversion(ArrayList<FullName> namesAsObject);
}
