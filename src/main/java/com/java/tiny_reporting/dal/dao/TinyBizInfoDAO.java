/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.dao;

import com.java.tiny_reporting.dal.dataobject.TinyBizInfoDO;
import org.apache.ibatis.annotations.*;

/**
 * @author qinjiasui.qjs
 * @version TinyBizInfoMapper: TinyBizInfoMapper.java, v 0.1 2021年05月19日 1:40 下午 qinjiasui.qjs Exp $
 */

@Mapper
public interface TinyBizInfoDAO {

    @Insert("INSERT INTO tiny_biz_info VALUES(#{bizInfoId}, #{bizName}, #{bu}, #{owner}, #{description}, #{gmtCreate}, #{gmtModified})")
    int insertTinyBizInfo(TinyBizInfoDO tinyBizInfoDO);

    @Select("SELECT * FROM tiny_biz_info WHERE biz_info_id = #{bizInfoId}")
    TinyBizInfoDO queryByBizInfoId(@Param("bizInfoId") Integer bizInfoId);

    @Update("UPDATE tiny_biz_info SET biz_name=#{bizName}, bu=#{bu}, owner=#{owner}, description=#{description}, gmt_modified=#{gmtModified} WHERE biz_info_id = #{bizInfoId}")
    int update(TinyBizInfoDO tinyBizInfoDO);

    @Delete("DELETE FROM tiny_biz_info WHERE biz_info_id = #{bizInfoId}")
    void delete(@Param("bizInfoId") Integer bizInfoId);
}