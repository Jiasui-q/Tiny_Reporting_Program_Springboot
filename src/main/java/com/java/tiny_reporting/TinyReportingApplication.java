package com.java.tiny_reporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.FileGenerator;
import utils.LogGenerator;
import utils.ZipGenerator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class TinyReportingApplication {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		//SpringApplication.run(TinyReportingApplication.class, args);

		// Generate txt files
		String file_path = "src/data/original/2021-05-08_test1kw.txt";
		FileGenerator fg = new FileGenerator();
		fg.createAll(file_path,1000);
		fg.createEach(file_path,10);

		// Generate log files
		String file_path_group = "";
		for(int i = 1; i <= 10; i++){
			file_path_group = "src/data/original/2021-05-08_test1kw_" + i + ".txt";
			LogGenerator lg = new LogGenerator();
			lg.generateLogFile(file_path_group);
		}

		// Generate zip files
		String data_path = "src/data/original";
		ZipGenerator zipUtils = new ZipGenerator();
		zipUtils.serialZip(data_path);
	}

}
