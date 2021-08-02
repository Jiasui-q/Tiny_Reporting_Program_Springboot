/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinjiasui.qjs
 * @version JsonFileConfig: JsonFileConfig.java, v 0.1 2021年05月18日 上午10:54 qinjiasui.qjs Exp $
 */

public class JsonConfigUtil {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConfigUtil.class);

    /**
     * 读取 json file 并解析为 String
     *
     * @param jsonFilePath json文件路径
     * @return String
     */
    public static String getJsonString(String jsonFilePath) {
        try{
            File file=new File(jsonFilePath);
            String content= FileUtils.readFileToString(file,"UTF-8");
            Preconditions.checkArgument(StringUtils.isNotBlank(content), "Blank String!");
            return content;
        }catch (IOException e){
            LogUtil.error(LOGGER, e, "Json文件解析出错, 文件路径{0}", jsonFilePath);
        }
        return null;
    }

    /**
     * 读取 json string 并解析为 JSONObject
     *
     * @param jsonString json字符串
     * @return JSONObject
     */
    public static JSONObject getJsonObject(String jsonString) {
        JSONObject jsonObject= JSON.parseObject(jsonString);
        Preconditions.checkArgument(jsonObject!=null,"Null JsonObject!");
        System.out.println(jsonObject);
        return jsonObject;
    }

    /**
     * json string 转换为 map 对象
     * @param jsonString
     * @return map<String, String>
     */
    public static Map<String, String> jsonToMap(String jsonString) {
        if (StringUtils.isBlank(jsonString)) {
            return new HashMap<>();
        }
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Map<String, String> map = JSONObject.toJavaObject(jsonObject, Map.class);
        return map;
    }
}