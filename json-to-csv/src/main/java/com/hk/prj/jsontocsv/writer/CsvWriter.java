package com.hk.prj.jsontocsv.writer;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.Collection;


public interface CsvWriter<T> {
    void write(T data, FileWriter outputFile);
}
