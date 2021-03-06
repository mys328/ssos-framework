package com.ssos.formengine.mapper;

import com.ssos.formengine.entity.AddData;
import com.ssos.formengine.entity.AutoDefinition;
import com.ssos.formengine.vo.FieldLoadVo;
import com.ssos.formengine.vo.FieldShowVO;
import com.ssos.mybatilspro.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
public interface AutoDefinitionMapper extends BaseMapper<AutoDefinition> {

    void  autoCreateTable(@Param("table") String table,@Param("sql") String sql);

    /**
     * 通过标识查询父字段值和表名（实际上表的定义名，并非实际表名，避免sql注入）
     * @param tableMark
     * @return
     */
    List<FieldShowVO> showMarkField(@Param("tableMark") String tableMark);

    /**
     * 通过表名查询父字段值
     * @param tableName
     * @return
     */
    List<FieldShowVO> showNameField(@Param("tableName") String tableName);

    /**
     * 通过表名查询当前父表名下的所有制
     * @param tableName
     * @return
     */
    List<Map<String,Object>> showValue(@Param("tableName")String tableName);


    /**
     * 通过表名查询当前父表下的一条数据
     * @param tableName
     * @Param id
     * @return List<Map<String,Object>>
     */
    List<Map<String,Object>> showOneValue(@Param("tableName")String tableName,@Param("id") Long id);

    /**
     * 通过父表的名称来找子表的字段和表名
     * @param tableName
     * @return
     */
    List<FieldShowVO> showSonField(String tableName);


    /**
     * 查找子表的数据
     * 通过子表的名称和父表的id
     * @param tableName
     * @param id
     * @return
     */
    List<Map<String,Object>> showSonValue(@Param("tableName")String tableName, @Param("id") Long id);


    /**
     * 根据标识去
     * @param definitionName
     * @return
     */
    String isExistSon(String definitionName);

    /**
     * 干掉表
     * @param tableName
     */
    void dropTable(@Param("tableName") String tableName);

    /**
     * 根据定义名找到真正的表名
     * @param name
     * @return
     */
    String queryTableName(@Param("name")String name);

    /**
     * 动态给表添加字段
     */
    void updateDefinitionTable(@Param("tableName") String tableName,@Param("sql") String sql);

    /**
     * 根据id查找动态表表名
     * @param id
     * @return
     */
    String findTableName(@Param("id") Long id);



    /**
     * 通过标识查询父字段值和表名（实际上表的定义名，并非实际表名，避免sql注入）
     * @param mark
     * @return
     */
    List<FieldLoadVo> loadMarkField(@Param("mark") String mark);


    /**
     * 根据定义名称
     * @param definitionName
     * @return
     */
    List<FieldLoadVo> loadSonField(String definitionName);


    @Insert("${sql}")
    @Options(useGeneratedKeys = true)
    Long insertData(AddData addData);




}
