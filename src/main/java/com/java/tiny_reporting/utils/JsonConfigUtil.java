/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.java.tiny_reporting.flow.model.Flow;
import com.java.tiny_reporting.flow.nodes.Node;
import com.java.tiny_reporting.service.CipherService;
import com.java.tiny_reporting.utils.logger.LogUtil;
import org.apache.commons.io.FileUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author qinjiasui.qjs
 * @version JsonFileConfig: JsonFileConfig.java, v 0.1 2021年05月18日 上午10:54 qinjiasui.qjs Exp $
 */

public class JsonConfigUtil {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CipherService.class);

    public static JSONObject getRoleJson(String jsonFilePath) {
        try{
            File file=new File(jsonFilePath);
            String content= FileUtils.readFileToString(file,"UTF-8");
            JSONObject jsonObject= JSON.parseObject(content);
            System.out.println(jsonObject);
            return jsonObject;
        }catch (IOException e){
            LogUtil.error(LOGGER, e, "Json文件解析出错, 文件路径{0}", jsonFilePath);
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        JSONObject flowJson = getRoleJson("src/main/resources/declare_1.json");
        Flow flow = JSON.toJavaObject(flowJson,Flow.class);
        System.out.println(flow.getFlowName());
//        for(Node n: flow.getNodeList()){
//            System.out.println(n.getNodeName());
//            //n.execute();
//            System.out.println(n.getClass().getMethods().toString());
//        }
        JSONArray nodeJson = (JSONArray)flowJson.get("nodeList");
        for(int i = 0; i < nodeJson.size(); i++) {
            JSONObject nodeObject = nodeJson.getJSONObject(i);
            String name = nodeObject.getString("nodeName");
            Node n = (Node) JSON.toJavaObject(nodeObject, Class.forName("com.java.tiny_reporting.flow.nodes."+name));
            System.out.println(n.getClass());
            n.execute();
        }
    }

}
