package com.practice.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter_Utils {
 public static void write_content_to_file(String file,String content) throws IOException {
	  FileWriter myWriter = new FileWriter(file);
      myWriter.write(content);
      myWriter.close();
 }
 public static void append_content_to_file(String file,String content)throws IOException  {
	try {
	    Files.write(Paths.get(file), content.getBytes(), StandardOpenOption.APPEND);
	}catch (IOException e) {
	    //exception handling left as an exercise for the reader
	}
 }
}
