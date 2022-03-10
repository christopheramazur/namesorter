package NameSorter.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// FullName object used to handle sorting
// could instead import data science libraries and treat like csv
class FullName {
    private String fullName, firstName, lastName;
    
    FullName(String name) {
        this.fullName = name;
        ParseName();
    }

    public void ParseName() {
        this.firstName = this.fullName.split(", ")[1];
        this.lastName = this.fullName.split(", ")[0];
    }

    public String getFullName() {
        return this.fullName;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
}

public class SortNames {
    
    private List<String> names = new ArrayList<String>();
    private List<String> sortedNames = new ArrayList<String>();
    private List<FullName> fullNames = new ArrayList<FullName>();


    public SortNames() {

    }

    public void SetNamesList(List<String> names) {
        this.names = names;
        // initialize list of FullNames
        for (String name : this.names) {
            FullName fullName = new FullName(name);
            this.fullNames.add(fullName);
        }   
    }

    public List<String> GetSortedNames() {
        SortNameList();
        return this.sortedNames;
    }

    // sort by comparing lastnames first, then firstnames if there's a match on lastnames. 
    private void SortNameList() {
        this.fullNames.sort(new Comparator<FullName>() {
            public int compare(FullName fullName1, FullName fullName2) {
                int result = fullName1.getLastName().compareToIgnoreCase(fullName2.getLastName());
                if (result != 0)
                    return result;
                return fullName1.getFirstName().compareToIgnoreCase(fullName2.getFirstName());
            }
        });

        for (FullName fullName : fullNames) {
            String name = fullName.getFullName();
            this.sortedNames.add(name);
        }
    }


   


}
