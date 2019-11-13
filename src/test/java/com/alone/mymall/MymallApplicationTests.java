package com.alone.mymall;

import com.alone.mymall.dao.PmsProductCategoryDao;
import com.alone.mymall.mgb.mapper.PmsBrandMapper;
import com.alone.mymall.mgb.model.PmsBrand;
import com.alone.mymall.mgb.model.PmsBrandExample;
import com.alone.mymall.mgb.model.PmsProductCategory;
import com.alone.mymall.pojo.PmsProductCategoryWithChildrenItem;
import com.alone.mymall.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MymallApplicationTests {


    @Autowired
    private PmsBrandMapper mapper;
    @Autowired
    private PmsBrandService pmsBrandService;

    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao;




    @Test
    void contextLoads() {
    }

    @Test
    public void PmsProductCategoryDaoTest(){
        List<PmsProductCategoryWithChildrenItem> pmsProductCategoryWithChildrenItem= pmsProductCategoryDao.listWithChildren();
        System.out.println(pmsProductCategoryWithChildrenItem.toString());
    }





    @Test
    public void test(){
        List<PmsBrand> list;

        PmsBrand pmsBrand= mapper.selectByPrimaryKey((long)2);
        System.out.println(pmsBrand);
    }

    @Test
    public void pmsBrandTest(){

        List<Long> list=new ArrayList<Long>();
        list.add(new Long(1));
        System.out.println(pmsBrandService.updateFactoryStatus(list,1));

    }
}
