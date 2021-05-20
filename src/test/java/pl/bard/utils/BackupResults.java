package pl.bard.utils;

import java.io.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BackupResults {
    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

    public void createFile() throws FileNotFoundException {
        String time = getDateTime() + ".txt";
        File file = new File("src/main/resources/" + time);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        this.writer = new BufferedWriter(outputStreamWriter);
    }

    public void BackupValue(String value) throws IOException {
        this.writer.append(value);
    }

    public void closeFile() throws IOException {
        writer.close();
    }

    private String getDateTime() {
//        get Current Time and Date of your Time Zone with format dd-MM-yyyy_HH:mm
        ZonedDateTime date = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm");
        return date.format(formatter);
    }
}
