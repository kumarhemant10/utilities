package com.hk.prj.jsontocsv.reader;

import java.io.File;

public interface JsonReader<T> {
	
	T read(File file); 

}
