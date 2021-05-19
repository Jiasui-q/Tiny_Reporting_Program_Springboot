package com.java.tiny_reporting;

import com.java.tiny_reporting.dal.dao.TinyBizInfoDAO;
import com.java.tiny_reporting.dal.dao.TinyFlowConfigDAO;
import com.java.tiny_reporting.dal.dataobject.TinyBizInfoDO;
import com.java.tiny_reporting.dal.dataobject.TinyFlowConfigDO;
import com.java.tiny_reporting.flow.FlowEngine;
import com.java.tiny_reporting.utils.DateUtil;
import com.java.tiny_reporting.utils.JsonConfigUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TinyReportingApplicationTests {

	@Autowired
	FlowEngine flowEngine;

	@Autowired
	TinyBizInfoDAO tinyBizInfoDAO;

	@Autowired
	TinyFlowConfigDAO tinyFlowConfigDAO;

	@Test
	public void testInsertBizInfo() throws Exception {

		// TinyBizInfoDO 实例
		TinyBizInfoDO tinyBizInfoDO = new TinyBizInfoDO();
		tinyBizInfoDO.setBizInfoId(1);
		tinyBizInfoDO.setBizName("地方金融组织统计");
		tinyBizInfoDO.setBu("微贷");
		tinyBizInfoDO.setOwner("嘉穗");
		tinyBizInfoDO.setDescription("监管报送，涉及文件生成，文件拆分，log生成，打包，加密。");
		tinyBizInfoDO.setGmtCreate(DateUtil.getGMTDate());
		tinyBizInfoDO.setGmtModified(DateUtil.getGMTDate());
		System.out.println(tinyBizInfoDO.toString());

		// 将实例加入 tiny_biz_info 表, 检测是否成功
		tinyBizInfoDAO.insertTinyBizInfo(tinyBizInfoDO);
		System.out.println(tinyBizInfoDAO.queryByBizInfoId(1).toString());
	}

	@Test
	public void testInsertFlowConfig() throws Exception {

		// TinyFlowConfigDO 实例
		TinyFlowConfigDO tinyFlowConfigDO = new TinyFlowConfigDO();
		tinyFlowConfigDO.setConfigId(1);
		tinyFlowConfigDO.setBizInfoId(1);
		tinyFlowConfigDO.setJsonConfig(JsonConfigUtil.getJsonString("src/main/resources/json_files/declare_1.json"));
		tinyFlowConfigDO.setGmtCreate(DateUtil.getGMTDate());
		tinyFlowConfigDO.setGmtModified(DateUtil.getGMTDate());
		System.out.println(tinyFlowConfigDO.toString());

		// 将实例加入 tiny_flow_config 表, 检测是否成功
		tinyFlowConfigDAO.insertTinyFlowConfig(tinyFlowConfigDO);
		System.out.println(tinyFlowConfigDAO.queryByConfigId(1).toString());
	}

	@Test
	public void testFlowEngine() throws Exception {
		Integer flowId = 1;
		Integer configId = 1;
		flowEngine.perform(flowId, configId);
	}
}
