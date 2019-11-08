package com.alone.mymall.mgb;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于生产MGB的代码
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        //MGB执行过程中的警告信息
        List<String> warnings=new ArrayList<>();
        //当生成代码重复时，覆盖原代码
        boolean overwrite=true;
        //读取我们的MGB配置文件
        InputStream is=Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser ap=new ConfigurationParser(warnings);
        Configuration config =ap.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback=new DefaultShellCallback(overwrite);
        //创建MGB
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
        //执行生成代码
        myBatisGenerator.generate(null);
        for (String warning:warnings){
            System.out.println(warning);
        }


    }
}
