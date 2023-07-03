package com.company.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * Class to store a name as an model Entity
 *
 * @author Suresh
 * @version 1.0
 * @since 01 July 2023
 */
@Getter
@Setter
@AllArgsConstructor
public class FullName implements Comparable<FullName> {
    private String givenName;
    private String lastName;

    //FullName object to String
    @Override
    public String toString(){
        return givenName +" "+lastName;
    }

    //Compare FullName object, order by lastName then by givenNames.
    @Override
    public int compareTo(FullName fullName) {
        return Comparator.comparing(FullName::getLastName)
                .thenComparing(FullName::getGivenName)
                .compare(this,fullName);
    }
}
