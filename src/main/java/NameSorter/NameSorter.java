package NameSorter;
import java.util.List;

import NameSorter.iowrapper.*;
import NameSorter.sorting.*;

public class NameSorter {


    public static void main(String[] args) {

        // Initialize relevant variables
        UIHandler uiHandler = new UIHandler();
        FileHandler fileHandler = new FileHandler();
        SortNames nameSorter = new SortNames();
        List<String> nameList;
        List<String> sortedNames;
        
        // Display Instructions
        uiHandler.WriteOutput("Please enter the name of the file to read:");

        // Get user input
        uiHandler.ReadInput();
        String fileName = uiHandler.getUserInput();

        // for fun, repeat the filename received to the console
        uiHandler.WriteOutput(fileName);

        // give the fileName to the fileHandler
        fileHandler.SetFile(fileName);

        // Read Line from Name File
        // we could also do fileHandler.ReadFileToNamesList(nameList);
        fileHandler.ReadFileToNamesList();
        if (fileHandler.FNFException != null) {
            fileHandler.FNFException.printStackTrace();
            uiHandler.WriteOutput("Please enter the name of a file. Ensure the path to the file is correct. The file path can be relative to your PWD, or absolute.");
            System.exit(1);
        }
        if (fileHandler.IOException != null) {
            fileHandler.IOException.printStackTrace();
            uiHandler.WriteOutput("Please select a file that isn't empty.");
            System.exit(1);
        }

        // take output from fileHandler
        nameList = fileHandler.getNames();
        

        // pass to sorter
        nameSorter.SetNamesList(nameList);

        // receive results
        sortedNames = nameSorter.GetSortedNames();
        
        // print reuslts to console
        for (String name : sortedNames) {
            uiHandler.WriteOutput(name);
        }

        // write results to file
        fileHandler.WriteNamesListToFile(sortedNames);
        if (fileHandler.IOException != null) {
            fileHandler.IOException.printStackTrace();
            uiHandler.WriteOutput("File could not be created.");
            System.exit(1);
        }

        // report completion to console
        uiHandler.WriteOutput("Finished: Created " + fileHandler.getOutputPath());

        // exit with no issues
        System.exit(0);
    }
}