package com.hk.prj.jsontocsv;

import com.hk.prj.jsontocsv.datamapper.DataMapper;
import com.hk.prj.jsontocsv.reader.JsonReader;
import com.hk.prj.jsontocsv.writer.CsvWriter;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final JsonReader jsonSimpleReader;
    private final CsvWriter<Collection<String[]>> csvWriter;
    private final DataMapper<Collection<String[]>> dataMapper = (data) -> {
        assertNotNull(data);

        List<String[]> dataList = new ArrayList<>();
        //TODO : specify header
        dataList.add(new String[]{"id", "name", "sampleProperty"});
        // TODO get data from json using property names
        JSONObject jsonObject = (JSONObject) data;
        JSONObject responseData = (JSONObject) jsonObject.get("responseData");
        JSONArray sampleData = (JSONArray) responseData.get("sampleData");
        Iterator<?> iterator = sampleData.iterator();
        //iterate over data
        while (iterator.hasNext()) {
            JSONObject systemObj = (JSONObject) iterator.next();
            String id = systemObj.get("id").toString();
            String name = (String) systemObj.get("name");
            String sampleProperty = (String) systemObj.get("sampleProperty");
            // TODO add data to collection as arrays
            dataList.add(new String[]{id, name, sampleProperty});
        }
        return dataList;
    };

    @Override
    public void run(String... args) throws Exception {
        // 1. read json
        File file = new File("sample.json");
        Object jsonData = jsonSimpleReader.read(file);
        // 2. map json to required format
        Collection<String[]> sampleJsonData = dataMapper.map(jsonData);
        // write to csv file
        File csvFile = new File("sample.csv");
        // create FileWriter object with file as parameter
        FileWriter csvFileWriter = new FileWriter(csvFile);
        csvWriter.write(sampleJsonData, csvFileWriter);
    }

}
