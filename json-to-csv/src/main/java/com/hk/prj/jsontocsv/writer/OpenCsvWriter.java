package com.hk.prj.jsontocsv.writer;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

@Service
public class OpenCsvWriter implements  CsvWriter<Collection<String[]>>{

    @Override
    public void write(Collection<String[]> data, FileWriter outputFile){
        try {
            // create CSVWriter object file-writer object as parameter
            CSVWriter writer = new CSVWriter(outputFile);
            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
