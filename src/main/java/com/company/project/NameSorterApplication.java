package com.company.project;

import com.company.project.service.SortingLastNameService;
import com.company.project.service.SortingLastNameServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Application : Sorting Names
 * Given a file with a list of names, sort the names first by last name and then by any given names. A name must have at least 1 given name
 * and may have up to 3 given names.
 *
 * @author Suresh
 * @version 1.0
 * @since 1st July 2023
 */
@EnableConfigurationProperties
@SpringBootApplication
public class NameSorterApplication {

    private static String fileWriteName= "sorted-names-list.txt";

    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(NameSorterApplication.class, args);
        //Reading input file with names from arguments
        if(args.length < 1){
            System.out.println("Provide valid arguments to run the application");
            context.close();
        }
        String fileReadName = args[0];
        // Calling the Name Sorting Service
        // Returns a successful or unsuccessful completion of sorting
        SortingLastNameService sortingLastNameService = new SortingLastNameServiceImpl();
        Boolean successfulSorting=sortingLastNameService.sortLastNames(fileReadName,fileWriteName);
        if(successfulSorting){
            System.out.println("Names file sorting successful");
        }
        else{
            System.out.println("Name file sorting unsuccessful");
        }
        context.close();
    }
}
