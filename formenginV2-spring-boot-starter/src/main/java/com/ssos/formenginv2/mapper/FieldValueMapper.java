package com.ssos.formenginv2.mapper;

import com.ssos.formenginv2.entity.FieldValue;
import com.ssos.mybatilspro.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: FieldValueMapper
 * @Description: TODD
 * @Author: xwl
 * @Date: 2019-05-27 13:55
 * @Vsersion: 1.0
 */
public interface FieldValueMapper extends BaseMapper<FieldValue> {
    @Select("select content from field_value where table_name = #{tableName} and table_id = #{id}")
    String findValue(@Param("tableName") String tableName,@Param("id") Long id);


}
