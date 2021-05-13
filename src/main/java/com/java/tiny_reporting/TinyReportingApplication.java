package com.java.tiny_reporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.java.tiny_reporting.utils.FileGenerator;
import com.java.tiny_reporting.utils.LogGenerator;
import com.java.tiny_reporting.utils.ZipGenerator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class TinyReportingApplication {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		SpringApplication.run(TinyReportingApplication.class, args);

		// Generate txt files
		String filePath = "src/data/original/2021-05-08_test1kw.txt";
		FileGenerator.createWholeFile(filePath,100);
		FileGenerator.createSplitFile(filePath,10);

		// Generate log files
		String groupFilePath = "";
		for(int i = 1; i <= 10; i++){
			groupFilePath = "src/data/original/2021-05-08_test1kw_" + i + ".txt";
			LogGenerator.generateLogFile(groupFilePath);
		}

		// Generate zip files
		String dataPath = "src/data/original";
		ZipGenerator.serialZip(dataPath);
		//ZipGenerator.parallelZip(dataPath);
	}

}
