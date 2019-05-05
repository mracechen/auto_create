package com.jys.mapper;

import com.jys.model.CityDO;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface CityDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_city
     *
     * @mbggenerated
     */
    @Delete({
        "delete from t_sys_city",
        "where tid = #{tid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_city
     *
     * @mbggenerated
     */
    @Insert({
        "insert into t_sys_city (tid, province_id, ",
        "city_code, city_name, ",
        "create_date, update_date, ",
        "del_flag)",
        "values (#{tid,jdbcType=VARCHAR}, #{provinceId,jdbcType=VARCHAR}, ",
        "#{cityCode,jdbcType=VARCHAR}, #{cityName,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(CityDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_city
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "tid, province_id, city_code, city_name, create_date, update_date, del_flag",
        "from t_sys_city",
        "where tid = #{tid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR)
    })
    CityDO selectByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_city
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "tid, province_id, city_code, city_name, create_date, update_date, del_flag",
        "from t_sys_city"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR)
    })
    List<CityDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_city
     *
     * @mbggenerated
     */
    @Update({
        "update t_sys_city",
        "set province_id = #{provinceId,jdbcType=VARCHAR},",
          "city_code = #{cityCode,jdbcType=VARCHAR},",
          "city_name = #{cityName,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "del_flag = #{delFlag,jdbcType=VARCHAR}",
        "where tid = #{tid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CityDO record);
}