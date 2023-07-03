package com.company.project.service;

import com.company.project.io.FullNamesFileReader;
import com.company.project.io.SortedNamesFileWriter;
import com.company.project.model.FullName;
import java.util.ArrayList;
import java.util.Collections;

public class SortingLastNameServiceImpl implements SortingLastNameService{

    /**
     * Read the File from the given location, process the names in the file, sort them and write to a new file.
     *
     * @param fileReadName this is the location to read the file from.
     * @param fileWriteName This is the location to write the file to.
     * @return boolean Successful or Unsuccessful Sorting of file
     *
     */
    @Override
    public boolean sortLastNames(String fileReadName,String fileWriteName) {

        // Read the file with names to be sorted into list of Strings
        ArrayList<String> namesAsStrings = readFromFile(fileReadName);
        if(namesAsStrings.size()==0){
            return false;
        }

        // Convert the list of String into list of "FullName" objects
        ArrayList<FullName> fullNames = stringToNameConversion(namesAsStrings);

        // Sort the list of objects, uses the comparator in the model
        Collections.sort(fullNames);

        // Convert sorted name objects to list of Strings
        ArrayList<String> sortedNamesStringList = fullNameToStringConversion(fullNames);

        //printing to screen
        for (String name: sortedNamesStringList) {
            System.out.println(name);
        }

        //Write the sorted list of names into file
        writeToFile(sortedNamesStringList,fileWriteName);

        return true;
    }

    /**
     * Take in ArrayList of unsorted Strings and convert them to list of FullName Objects.
     * The String is split by space delimiter, then check if there is at least one GivenName and LastName
     * The last part is stored as LastName and the rest of the String as GivenName
     *
     * @param nameAsString This is an unsorted list of names as Strings.
     * @return listOfFullNames This is an unsorted list of FullNames as Objects.
     */

    @Override
    public ArrayList<FullName> stringToNameConversion(ArrayList<String> nameAsString) {
        ArrayList<FullName> listOfFullNames = new ArrayList<FullName>();
        for (String name : nameAsString) {
            int lastNameIndex = name.lastIndexOf(" ");
            String firstName = name.substring(0, lastNameIndex);
            String lastName = name.substring(lastNameIndex + 1);
            FullName fullName = new FullName(firstName, lastName);
            listOfFullNames.add(fullName);
        }
        return listOfFullNames;
    }

    /**
     * Read the text file and map the list of names into an ArrayList of String Names
     *
     * @param readFileName This is a text file location.
     * @return namesAsStrings This is an array list of unsorted names from txt file.
     */
    @Override
    public ArrayList<String> readFromFile(String readFileName) {
        FullNamesFileReader fullNamesFileReader = new FullNamesFileReader();
        ArrayList<String> namesAsStrings = fullNamesFileReader.readNamesFromTheFile(readFileName);
        return namesAsStrings;
    }

    /**
     * Write the list of sorted names in the array into file with given fileName
     *
     * @param sortedNamesStringList this is a list of sorted names as strings
     * @param writeFileName This is the text file to be created.
     *
     */
    @Override
    public void writeToFile(ArrayList<String> sortedNamesStringList,String writeFileName) {
        SortedNamesFileWriter sortedNamesFileWriter = new SortedNamesFileWriter();
        sortedNamesFileWriter.writeSortedNamestoFile(sortedNamesStringList,writeFileName);
    }

    /**
     * Take in ArrayList of sorted FullName Objects and convert them to list of Strings
     *
     * @param fullNames This is a sorted list of FullName objects.
     * @return sortedNamesStringList This is a sorted list of names as Strings.
     */
    @Override
    public ArrayList<String> fullNameToStringConversion(ArrayList<FullName> fullNames) {
        ArrayList<String> sortedNamesStringList = new ArrayList<>();
        for (FullName sortedNames : fullNames) {
            sortedNamesStringList.add(sortedNames.toString());
        }
        return sortedNamesStringList;
    }
}
