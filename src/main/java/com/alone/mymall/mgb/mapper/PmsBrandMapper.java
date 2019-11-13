package com.alone.mymall.mgb.mapper;

import com.alone.mymall.mgb.model.PmsBrand;
import com.alone.mymall.mgb.model.PmsBrandExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper

public interface PmsBrandMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int countByExample(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int deleteByExample(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int insert(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int insertSelective(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    List<PmsBrand> selectByExampleWithBLOBs(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    List<PmsBrand> selectByExample(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    PmsBrand selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int updateByPrimaryKeySelective(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sat Nov 09 21:36:28 CST 2019
     */
    int updateByPrimaryKey(PmsBrand record);
}