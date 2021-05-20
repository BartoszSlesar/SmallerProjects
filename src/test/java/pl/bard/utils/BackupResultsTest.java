package pl.bard.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BackupResultsTest {

    private static BackupResults backupResults;

    @BeforeAll
    static void setUp() throws IOException {
        backupResults = new BackupResults();
        backupResults.createFile();
    }

    @Test
    void saveToFileStringValue() throws IOException {
        //given
        String value = "This value will be saved to a file";
        //when
        backupResults.backupValue(value);
        //then
        System.out.println("Value was added");
    }

    @AfterAll
    static void tearDown() throws IOException {
        backupResults.closeFile();
    }

}