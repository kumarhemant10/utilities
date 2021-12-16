package com.hk.prj.jsontocsv.reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonSimpleReader implements JsonReader<Object> {

	private final JSONParser jsonParser;

	@Override
	public Object read(File file) {
		try {
			FileReader fileReader = new FileReader(file);
			return jsonParser.parse(fileReader);
		} catch (IOException | ParseException e) {
			throw new JsonReaderException("Exception in reading json file :" + ExceptionUtils.getStackTrace(e));
		}
	}

}
