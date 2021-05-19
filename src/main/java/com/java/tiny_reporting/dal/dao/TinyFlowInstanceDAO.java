/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.dao;

import com.java.tiny_reporting.dal.dataobject.TinyFlowInstanceDO;
import org.apache.ibatis.annotations.*;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowInstanceMapper: TinyFlowInstanceMapper.java, v 0.1 2021年05月19日 1:39 下午 qinjiasui.qjs Exp $
 */

@Mapper
public interface TinyFlowInstanceDAO {

    @Insert("INSERT INTO tiny_flow_instance VALUES(#{flowId}, #{configId}, #{status}, #{currNode}, #{gmtCreate}, #{gmtModified})")
    int insertTinyFlowInstance(TinyFlowInstanceDO tinyFlowInstanceDO);

    @Select("SELECT * FROM tiny_flow_instance WHERE flow_id = #{flowId}")
    TinyFlowInstanceDO queryByFlowId(@Param("flowId") Integer flowId);

    @Update("UPDATE tiny_flow_instance SET status=#{status}, curr_node=#{currNode}, gmt_modified=#{gmtModified} WHERE flow_id = #{flowId}")
    int update(@Param("status") String status, @Param("currNode") String currNode, @Param("gmtModified") String gmtModified, @Param("flowId") Integer flowId);

    @Delete("DELETE FROM tiny_flow_instance WHERE flow_id = #{flowId}")
    void delete(@Param("flowId") Integer flowId);

}