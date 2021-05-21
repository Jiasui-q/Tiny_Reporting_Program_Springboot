/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.dao;

import com.java.tiny_reporting.dal.dataobject.TinyBizInfoDO;
import com.java.tiny_reporting.dal.dataobject.TinyFlowConfigDO;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowConfigMapper: TinyFlowConfigMapper.java, v 0.1 2021年05月19日 1:39 下午 qinjiasui.qjs Exp $
 */

@Mapper
public interface TinyFlowConfigDAO {

    @Insert("INSERT INTO tiny_flow_config VALUES(#{configId}, #{bizInfoId}, #{jsonConfig}, #{gmtCreate}, #{gmtModified})")
    int insertTinyFlowConfig(TinyFlowConfigDO tinyFlowConfigDO);

    @Select("SELECT * FROM tiny_flow_config WHERE config_id = #{configId}")
    TinyFlowConfigDO queryByConfigId(@Param("configId") Integer configId);

    @Select("SELECT * FROM tiny_flow_config")
    List<TinyFlowConfigDO> queryAllFlowConfig();

    @Select("SELECT json_config FROM tiny_flow_config WHERE config_id = #{configId}")
    String queryJsonConfigByConfigId(@Param("configId") Integer configId);

    @Update("UPDATE tiny_flow_config SET json_config=#{jsonConfig}, gmt_modified=#{gmtModified} WHERE config_id = #{configId}")
    int update(@Param("jsonConfig") String jsonConfig, @Param("gmtModified") Date gmtModified, @Param("configId") Integer configId);

    @Delete("DELETE FROM tiny_flow_config WHERE config_id = #{configId}")
    void deleteByConfigId(@Param("configId") Integer configId);

}