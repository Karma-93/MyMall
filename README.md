# 前言 #
*作为初学java web新手的第一个项目，用来练手。参考了大量的网络资源。*
*****
# 电商管理系统后台接口 #




*****

### 项目结构 ###
``` lua
    mymall
    |—— common
    |—— component
    |—— config
    |—— controller
    |—— dao
    |—— mgb
    |—— pojo
    |—— service
    |——validator
```
> ### 框架技术 ###
   技术 | 说明
   -|-
   Spring | 容器框架  
   Spring MVC | MVC框架  
   MyBatis | ORM框架  
   Spring Boot框架 | SSM整合
   MySql数据库 | 数据库
   PageHelper分页插件 | 分页插件
   Lombook | POJO类的注解工具
   Swagger-UI生成在线API | 文档产生工具
   SpringSecurity | 认证和授权框架
   JWT(JSON WEB TOKEN) | 登录支持
   对象存储OSS | 对象存储
 
  
  
### **后台功能** ###
#### 商品管理(pms): ####
- 商品分类管理    
- 商品品牌管理  
- 商品属性分类管理  
- 商品属性管理
- 商品管理
- 库存管理
#### 用户管理(ums) ####
- admin用户管理
- 权限管理
- 角色管理
#### 促销管理(sms)
- 优惠券领取记录管理
- 优惠券管理
- 限时购商品管理
- 限时购活动管理
- 限时够场次管理
- 首页广告管理
- 首页品牌管理
- 首页新品管理
- 首页人气推荐管理
- 首页专题活动管理
#### 内容管理(cms)
- 优选专区管理
- 商品专题管理
#### 订单管理(oms)
- 收货地址管理
- 退货申请管理
- 订单退货原因管理
- 订单管理
- 订单设置管理