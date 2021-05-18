package com.java.tiny_reporting;

import com.java.tiny_reporting.flow.FlowEngine;
import com.java.tiny_reporting.flow.model.Flow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TinyReportingApplicationTests {

	@Autowired
	FlowEngine flowEngine;

	@Test
	void contextLoads() throws Exception {
		String s = "{\n"
				+ "  \"flowCode\": \"DECLARE_1\",\n"
				+ "  \"nodeList\": [\n"
				+ "    {\n"
				+ "      \"nodeCode\": \"DATA_FILE\",\n"
				+ "      \"nodeName\": \"生成文件\",\n"
				+ "      \"processorName\": \"dataFileProcessor\",\n"
				+ "      \"controlParam\": {\n"
				+ "        \"wholeFilePath\": \"src/data/original/wholeData.txt\",\n"
				+ "        \"splitFileDir\": \"src/data/split_files\",\n"
				+ "        \"splitFileName\": \"split\",\n"
				+ "        \"totalCount\": 100,\n"
				+ "        \"eachFileCount\": 10\n"
				+ "      }\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
		Flow flow = flowEngine.constructAFlow(s);
		flowEngine.perform(flow);
	}

}
