package NameSorter.iowrapper;
import java.io.FileNotFoundException;  
import java.io.IOException;

import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileHandlerTests {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private FileHandler fh;
    private String validFile = "validTestInput.txt";
    private String emptyFile = "emptyTestInput.txt";
    private String wrongFormatFile = "wrongFormatTestInput.txt";

    @Before
    void setUp() throws Exception {
        fh = new FileHandler();
    }

    @Test(expected = FileNotFoundException.class)
    public void FNFExceptionShouldThrowProperMessage() {
        // given we set an file name for a file that doesn't exist and try to read it
        fh.SetFile("this file does not exist");
        fh.ReadFileToNamesList();
        // when we check the exception it should be file not found
    }

    @Test(expected = IOException.class)
    public void readEmptyFileThrowsProperMessage() {
        // given we set a file with no information and try to read it
        fh.SetFile(emptyFile);
        // when we check the exception it should be ioexception
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void readWrongFormatFileThrowsProperMessage() {
        // given we set a file with the wrong format and try to read it
        fh.SetFile(wrongFormatFile);
        // when we check the exception it should be aioob

    }
}
