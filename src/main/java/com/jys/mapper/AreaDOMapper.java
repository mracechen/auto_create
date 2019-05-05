package com.jys.mapper;

import com.jys.model.AreaDO;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface AreaDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_area
     *
     * @mbggenerated
     */
    @Delete({
        "delete from t_sys_area",
        "where tid = #{tid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_area
     *
     * @mbggenerated
     */
    @Insert({
        "insert into t_sys_area (tid, city_id, ",
        "area_code, area_name, ",
        "create_date, update_date, ",
        "del_flag)",
        "values (#{tid,jdbcType=VARCHAR}, #{cityId,jdbcType=VARCHAR}, ",
        "#{areaCode,jdbcType=VARCHAR}, #{areaName,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(AreaDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_area
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "tid, city_id, area_code, area_name, create_date, update_date, del_flag",
        "from t_sys_area",
        "where tid = #{tid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_code", property="areaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR)
    })
    AreaDO selectByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_area
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "tid, city_id, area_code, area_name, create_date, update_date, del_flag",
        "from t_sys_area"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_code", property="areaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR)
    })
    List<AreaDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_area
     *
     * @mbggenerated
     */
    @Update({
        "update t_sys_area",
        "set city_id = #{cityId,jdbcType=VARCHAR},",
          "area_code = #{areaCode,jdbcType=VARCHAR},",
          "area_name = #{areaName,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "del_flag = #{delFlag,jdbcType=VARCHAR}",
        "where tid = #{tid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AreaDO record);
}