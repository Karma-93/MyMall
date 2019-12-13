package com.alone.mymall;

import com.alone.mymall.common.utils.JwtTokenUtil;
import com.alone.mymall.dao.PmsProductCategoryDao;
import com.alone.mymall.mgb.mapper.PmsBrandMapper;
import com.alone.mymall.mgb.model.PmsBrand;
import com.alone.mymall.pojo.PmsProductCategoryWithChildrenItem;
import com.alone.mymall.service.PmsBrandService;
import com.alone.mymall.service.PmsProductCategoryService;
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
    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Test
    public void JwtTokenUtilsTest(){

        String username=jwtTokenUtil.getUsernameFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbG9uZSIsImNyZWF0ZWQiOjE1NzYyMzg0NjM2NDAsImV4cCI6MTU3Njg0MzI2M30.1M7Ln_S4SJc9PtMdM2aY4swQhOSVh3Uibp3gNJK3zNWmQquL3-ipd0njZxJHP7LV89RygXtaTbwHguSDGcEgyg");
        //String s=jwtTokenUtil;
        System.out.println(username);
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void PmsProductCategoryDaoTest(){
        List<PmsProductCategoryWithChildrenItem> pmsProductCategoryWithChildrenItem= pmsProductCategoryDao.listWithChildren();
        System.out.println(pmsProductCategoryWithChildrenItem.toString());
    }

    @Test
    public void PmsProductCategoryServiceTest(){
        List<PmsProductCategoryWithChildrenItem> list= pmsProductCategoryService.listWithChildren();
        System.out.println(list);
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
