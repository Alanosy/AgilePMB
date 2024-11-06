# 基于SpringBoot的项目管理系统后端

#### 介绍

本系统是用于监控项目完成进度，项目开发协同使用

这个是我的后端仓库，前端仓库请看[前端项目地址](https://github.com/Alanosy/AgilePMF.git)

这个项目是本人的毕业设计，基于SpringBoot的项目管理系统，有参考现在市面上的产品，仅用于学术研究，如有冒犯请联系邮箱fignet@163.com下架,由于开发项目时平时不注意项目进度从而导致，到了交产品时延期，所以开发了这款系统，用户可以在项目管理创建项目，然后对项目的需求、任务进行划分、出现问题也可以在问题中心新建问题，让对应的开发人员去解决，在首页我们也能看到本周任务和延期的任务，在燃尽图页面，可以看到我们的任务数，随着时间的变化而逐步减少，最后归于0，来观察我们的开发完成趋势，当然，在项目详情里也可以看到完成趋势。有任何疑问可以在issue中留言，看到必回复，或者至信到我邮箱。

如果你对这款项目感兴趣，欢迎您加入我们，可以联系我邮箱fignet@163.com，或者直接提交PR请求，目前这个项目是一个很简单的一个实现，并没有很复杂的功能，有些sql或方法也待优化

如果觉得还不错，还请动动你的小手，帮我点个star吧

#### 页面展示

![截屏2024-11-06 上午11.24.20](https://alantypora.oss-cn-chengdu.aliyuncs.com/%E6%88%AA%E5%B1%8F2024-11-06%20%E4%B8%8A%E5%8D%8811.24.20.png)

![截屏2024-11-06 上午11.23.40](https://alantypora.oss-cn-chengdu.aliyuncs.com/%E6%88%AA%E5%B1%8F2024-11-06%20%E4%B8%8A%E5%8D%8811.23.40.png)

![截屏2024-11-06 上午11.28.37](https://alantypora.oss-cn-chengdu.aliyuncs.com/%E6%88%AA%E5%B1%8F2024-11-06%20%E4%B8%8A%E5%8D%8811.28.37.png)

![截屏2024-11-06 上午11.23.59](https://alantypora.oss-cn-chengdu.aliyuncs.com/%E6%88%AA%E5%B1%8F2024-11-06%20%E4%B8%8A%E5%8D%8811.23.59.png)

![截屏2024-11-06 上午11.24.07](https://alantypora.oss-cn-chengdu.aliyuncs.com/%E6%88%AA%E5%B1%8F2024-11-06%20%E4%B8%8A%E5%8D%8811.24.07.png)

![截屏2024-11-06 上午11.24.13](https://alantypora.oss-cn-chengdu.aliyuncs.com/%E6%88%AA%E5%B1%8F2024-11-06%20%E4%B8%8A%E5%8D%8811.24.13.png)



#### 系统架构

##### 功能结构图

![image-20241106112528524](https://alantypora.oss-cn-chengdu.aliyuncs.com/image-20241106112528524.png)

##### ER图

![image-20241106112556977](https://alantypora.oss-cn-chengdu.aliyuncs.com/image-20241106112556977.png)



### 技术选型

![image-20241106112624123](https://alantypora.oss-cn-chengdu.aliyuncs.com/image-20241106112624123.png)

#### 后端技术


| 技术             | 说明             | 官网                                           |
| ---------------- | ---------------- | ---------------------------------------------- |
| SpringBoot       | Web应用开发框架  | https://spring.io/projects/spring-boot         |
| SpringSecurity   | 认证和授权框架   | https://spring.io/projects/spring-security     |
| MyBatisPlus      | ORM框架          | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator | 数据层代码生成器 | http://www.mybatis.org/generator/index.html    |
| Redis            | 内存数据存储     | https://redis.io/                              |
| Druid            | 数据库连接池     | https://github.com/alibaba/druid               |
| OSS              | 对象存储         | https://github.com/aliyun/aliyun-oss-java-sdk  |
| MinIO            | 对象存储         | https://github.com/minio/minio                 |
| JWT              | JWT登录支持      | https://github.com/jwtk/jjwt                   |
| Lombok           | Java语言增强库   | https://github.com/rzwitserloot/lombok         |
| Hutool           | Java工具类库     | https://github.com/looly/hutool                |

### 开发工具


| 工具         | 说明                | 官网                                                  |
| ------------ | ------------------- | ----------------------------------------------------- |
| IDEA         | 开发IDE             | https://www.jetbrains.com/idea/download               |
| RedisDesktop | redis客户端连接工具 | https://github.com/qishibo/AnotherRedisDesktopManager |
| SwitchHosts  | 本地host管理        | https://oldj.github.io/SwitchHosts/                   |
| Navicat      | 数据库连接工具      | http://www.formysql.com/xiazai.html                   |
| Xmind        | 思维导图设计工具    | http://www.edrawsoft.cn/mindmaster                    |
| Draw         | 流程图绘制工具      | https://draw.io                                       |
| Apifox       | API接口调试工具     | http://apifox.com                                     |
| Typora       | Markdown编辑器      | https://typora.io/                                    |

### 开发环境


| 工具  | 版本号 | 下载                                                                                 |
| ----- | ------ | ------------------------------------------------------------------------------------ |
| JDK   | 17     | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| MySQL | 5.7    | https://www.mysql.com/                                                               |
| Redis | 7.0    | https://redis.io/download                                                            |
| Nginx | 1.22   | http://nginx.org/en/download.html                                                    |




#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

## 许可证

[Apache License 2.0](https://github.com/macrozheng/mall/blob/master/LICENSE)

