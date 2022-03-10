package com.megaport.NameSorter.iowrapper;

import java.io.File; 
import java.io.FileWriter; 
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    
    private File readFile, writeFile;
    private String filePath; // the filepath passed to the file handler initially
    private String fileName; // the name of the file separated from the path
    private String filePrefix; // the name of the file without extension
    private String fileExtension; // the extension of the file
    private String appendString; // the string we append to the filename to create the output filename
    private String outputPathPrefix; // the path we prepend to the filename to create the output filename.
    private String finalOutputPath; // the combined output filename
    private List<String> names; // list of names read from file
    
    // allows us to fail silently unless asked
    public FileNotFoundException FNFError;
    public IOException IOError; 

    
    public FileHandler() {
        this.appendString = "-sorted.";
        this.outputPathPrefix = "./";
        this.names = new ArrayList<String>();
    }

    public void SetFile(String inputFilePath) {
        this.filePath = inputFilePath; 
        this.readFile = new File(inputFilePath);
    }

    // used to get the relevant information for producing output later
    private void ParseFilePath() {
        this.readFile = new File(this.filePath);
        this.fileName = this.readFile.getName();
        // break filename into {name, extension}
        String[] fileNameComponents = this.fileName.split("\\.(?=[^\\.]+$)");        
        // prefix is name minus suffix
        this.filePrefix = fileNameComponents[0];
        // suffix as e.g. .txt, .csv
        this.fileExtension = fileNameComponents[1];
        // appendString is -sorted + suffix
        this.appendString += this.fileExtension;
        this.finalOutputPath = this.outputPathPrefix + this.filePrefix + this.appendString;
    }

    // read file to internal array
    public void ReadFileToNamesList() {
        ParseFilePath();
        try {
            Scanner scanner = new Scanner(this.readFile);
            while (scanner.hasNextLine()) {
                this.names.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            this.FNFError = e;   
        }
    }

    // read file to external array
    public void ReadFileToNamesList(List<String> namesList) {
        ReadFileToNamesList();
        namesList = this.names;
    }

    // note: overwrites existing file of same name.
    public void WriteNamesListToFile(List<String> namesList) {
        try {
            this.writeFile = new File(finalOutputPath);
            if (writeFile.createNewFile()) {
                FileWriter fileWriter = new FileWriter(finalOutputPath);
                for (String name : namesList) {
                    fileWriter.write(name);
                    fileWriter.append("\n");
                }
                fileWriter.close();
            } else {
                this.IOError = new IOException("Cannot write to file: Already exists!");
            }
        } catch (IOException e){
            this.IOError = e;
        }
    }

    public List<String> getNames() {
        return this.names;
    }
    

    public String getOutputPath() {
        return finalOutputPath;
    }



}
