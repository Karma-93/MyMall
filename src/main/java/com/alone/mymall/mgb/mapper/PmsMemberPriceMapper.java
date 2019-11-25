package com.alone.mymall.mgb.mapper;

import com.alone.mymall.mgb.model.PmsMemberPrice;
import com.alone.mymall.mgb.model.PmsMemberPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsMemberPriceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int countByExample(PmsMemberPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int deleteByExample(PmsMemberPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int insert(PmsMemberPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int insertSelective(PmsMemberPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    List<PmsMemberPrice> selectByExample(PmsMemberPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    PmsMemberPrice selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int updateByExampleSelective(@Param("record") PmsMemberPrice record, @Param("example") PmsMemberPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int updateByExample(@Param("record") PmsMemberPrice record, @Param("example") PmsMemberPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int updateByPrimaryKeySelective(PmsMemberPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_member_price
     *
     * @mbggenerated Sat Nov 23 21:20:45 CST 2019
     */
    int updateByPrimaryKey(PmsMemberPrice record);
}