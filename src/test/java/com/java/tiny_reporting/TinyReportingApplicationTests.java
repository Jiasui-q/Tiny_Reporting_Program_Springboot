package com.java.tiny_reporting;

import com.java.tiny_reporting.flow2.FlowEngine;
import com.java.tiny_reporting.flow2.model.Flow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TinyReportingApplicationTests {

    @Autowired
    FlowEngine flowEngine;

	@Test
	void contextLoads() {

	    String s = "{\n"
                + "  \"flowCode\": \"DECLARE_1\",\n"
                + "  \"nodeList\": [\n"
                + "    {\n"
                + "      \"nodeCode\": \"CIPHER_FILE\",\n"
                + "      \"nodeName\": \"加密哦加密啊\",\n"
                + "      \"processorName\": \"cipherProcessor\",\n"
                + "      \"controlParam\": {\n"
                + "        \"srcFileDir\": \"src/data/zip_files\",\n"
                + "        \"encryptFileDir\": \"src/data/encrypt_files\",\n"
                + "        \"password\":\"123456\"\n"
                + "      }\n"
                + "    }\n"
                + "  ]\n"
                + "}";
	    Flow flow = flowEngine.constructAFlow(s);
	    flowEngine.perform(flow);

	}

}
