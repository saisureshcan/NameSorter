package com.company.project.service;

import com.company.project.model.FullName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

@ExtendWith(SpringExtension.class)
public class NameSorterApplicationTest {

    @Test
    public void compareNamesTest(){
        FullName adams = new FullName("Kaila","Adams");
        FullName banks = new FullName("Summer","Banks");
        //Alphabetically Banks appears after Adams Banks compare to Adams should be a positive value
        Assertions.assertTrue(banks.compareTo(adams) > 0);
        //Adams compared to Banks should have a negative value
        Assertions.assertTrue(adams.compareTo(banks) < 0 );
    }

    @Test
    public void sameLastNameTest(){
        //With same last names they should be sorted by Given Names
        //Spider should have a greater value than Iron and Iron Man should appear first in the sorted list
        FullName ironman = new FullName("Iron","Man");
        FullName spiderman = new FullName("Spider","Man");
        Assertions.assertTrue(spiderman.compareTo(ironman) > 0);
        Assertions.assertTrue(ironman.compareTo(spiderman) < 0);
    }

    @Test
    public void multipleGivenNamesSameLastNameTest(){
        //When given name has more than one name with same last name
        //Names have same first given name and different other given names
        // Peter Should have a greater value than Parker, Parker appear first in list

        FullName peter = new FullName("Spider Peter","Man");
        FullName parker= new FullName("Spider Parker","Man");
        Assertions.assertTrue(peter.compareTo(parker) > 0);
        Assertions.assertTrue(parker.compareTo(peter) < 0);
    }

    @Test
    public void invalidFileNameArgumentTest(){
        //Name sorting unsuccessful if input file name is invalid
        SortingLastNameService sortingLastNameService = new SortingLastNameServiceImpl();
        boolean successful= sortingLastNameService.sortLastNames("invalid_read_filename.txt","writeFile.txt");
        Assertions.assertFalse(successful);
    }

    @Test
    public void writeToFileTest(){
        //This test reads a test input file and writes to a output file
        //Test deletes the file that is written and assert the deletion
        SortingLastNameService sortingLastNameService = new SortingLastNameServiceImpl();
        sortingLastNameService.sortLastNames("junit-test-names.txt","junit-test-write.txt");
        File existingFile = new File("junit-test-write.txt");
        Assertions.assertTrue(existingFile.isFile());
        Assertions.assertTrue(existingFile.delete());
    }

    @Test
    public void sortFewNamesTest(){
        SortingLastNameService sortingLastNameService= new SortingLastNameServiceImpl();
        //Reading file and converting to strings asserting the size of array and elements
        ArrayList<String> namesAsStrings = sortingLastNameService.readFromFile("junit-test-names.txt");
        Assertions.assertEquals(7,namesAsStrings.size());
        Assertions.assertEquals("Spider Man",namesAsStrings.get(0));
        Assertions.assertEquals("Spider Peter Man",namesAsStrings.get(3));

        //Converting Name Strings to FullName objects, asserting array elements
        ArrayList<FullName> fullNames = sortingLastNameService.stringToNameConversion(namesAsStrings);
        Assertions.assertEquals(7,fullNames.size());
        Assertions.assertEquals("Spider",fullNames.get(0).getGivenName());
        Assertions.assertEquals("Man",fullNames.get(0).getLastName());

        //Asserting Multiple Given Names scenario
        Assertions.assertEquals("Spider Peter",fullNames.get(3).getGivenName());
        Assertions.assertEquals("Man",fullNames.get(3).getLastName());

        //Sorting the names
        Collections.sort(fullNames);

        ArrayList<String> sortedNamesStringList = sortingLastNameService.fullNameToStringConversion(fullNames);
        Assertions.assertEquals("Kaila Adams",sortedNamesStringList.get(0));
        Assertions.assertEquals("Summer Banks",sortedNamesStringList.get(1));
        Assertions.assertEquals("Iron Man",sortedNamesStringList.get(2));
        Assertions.assertEquals("Spider Man",sortedNamesStringList.get(3));
        Assertions.assertEquals("Spider Parker Man",sortedNamesStringList.get(4));
        Assertions.assertEquals("Spider Peter Man",sortedNamesStringList.get(5));
        Assertions.assertEquals("Peter Parker",sortedNamesStringList.get(6));

        //Write To File
        sortingLastNameService.writeToFile(sortedNamesStringList,"junit-test-write.txt");
        File writeFile = new File("junit-test-write.txt");
        Assertions.assertTrue(writeFile.isFile());
        Assertions.assertTrue(writeFile.delete());
    }
}
