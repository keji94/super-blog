-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: super_blog
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_updated` datetime NOT NULL COMMENT '修改时间',
  `status` int(4) NOT NULL DEFAULT '1' COMMENT '状态(0:已删除 1：正常 2：置顶)',
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `is_comment` int(11) NOT NULL DEFAULT '1' COMMENT '是否允许评论(0:不允许 1:允许)',
  `preview_style` int(1) NOT NULL DEFAULT '0' COMMENT '首页预览样式(0:normal 1:advanced 2:多图模式)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'2018-09-21 09:15:55','2018-09-21 09:15:56',1,'关于super-blog以及杭州两年回顾',1,2);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_content`
--

DROP TABLE IF EXISTS `article_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `article_id` bigint(20) NOT NULL COMMENT '文章id',
  `content` longtext COMMENT '文章内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章内容表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_content`
--

LOCK TABLES `article_content` WRITE;
/*!40000 ALTER TABLE `article_content` DISABLE KEYS */;
INSERT INTO `article_content` VALUES (1,'2018-09-21 10:47:37','2018-09-21 10:47:38',1,'<h2>萌芽</h2><p>2017年5月中旬，我从武汉来到了杭州，入职佰钧成到阿里做外包。当时的项目组没什么事儿干，整天闲的发慌，于是产生了自己写一个博客系统的想法。一方面打磨一下自己的技术，另一方面搭建一个企业级的开发环境，以便以后学习实践新的技术。</p><h2>发展</h2><p>2017年6月写下了第一行代码，当时的项目并不是现在上线的这个，而是我github上面的<a href=\"https://github.com/keji94/blog-keji\">blog-keji</a>，这个项目采用传统的ssm+mysql+html+js。这个项目并没有完成，仅仅是将环境搭建起来了。不过，搭建这个分模块的企业级java开发环境却也花费了很多时间。</p><p>这个项目的第二个难点就是前端页面，16年我对前端的了解，就只是认识一些html标签，知道一个js，jquery语法，连半桶水都算不上。<br>遇到问题解决问题，于是我开始学前端，学模板引擎（velocity,freemarker），我将大部分时间花了学习前端上面，以至于后面换项目组的时候，第一次没面试通过…</p><p>2017年9月份，换到了盒马餐饮项目组，第一次接触到了springboot，立马被其吸引，使用springboot，我可以不用繁琐的配置，快速搭建一个web应用。于是，我果断抛弃了blog-keji，仿照餐饮项目代码结构使用springboot重新搭建了一个新的项目，起名：super-blog。</p><p>项目环境搭建好了之后，首先搭建了一个后台系统，并且使用shiro做权限控制，写页面的过程自然不用说充满了坎坷。在这个过程中<a href=\"https://gitee.com/renrenio/renren-security\">renren-security</a>给我提供了巨大的帮助，万分感谢。</p><p>这一套权限系统，后来被我搬到了盒马的餐饮后台。我深深的感受到，平时自己积累的一些东西，是会排上用场的。</p><p>之后，super-blog进度停滞了一段时间，一直到今年年初从家里回杭州开始工作后，又闲置了下来。于是我决定把super-blog的首页做出来。在网上找模板的时候，发现了<a href=\"https://wuwenbin.me/\">笔记博客</a><br><img src=\"http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-19/1893238.jpg\" alt=\"\"></p><p>这个页面在我看来比大多数个人博客好看，于是我开始在这个基础上编写自己的博客首页。并且完成了80%的功能。</p><p><img src=\"http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-19/12637750.jpg\" alt=\"\"><br><img src=\"http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-19/57232115.jpg\" alt=\"\"></p><p>这个页面的完成程度其实比现在的高，不管是前端还是后端基本都已经完成，只差一个发布页面。</p><p>只不过我心里面还是觉得首页不怎么好看，而且显得特别繁杂。加上要到新的公司<a href=\"http://www.myweimai.com/\">微脉</a>上班了，于是再次停滞了下来。</p><p>顺便提一句，super-blog里面，除了博客系统的代码，其实还有很多的基础代码，比如java8 lambda表达式的例子、比如各种各样的工具类。这个平时积累下来的代码，对我的工作帮助非常大。</p><p>然后便到了今年的9月12号，经过一段时间的996之后，终于完成了手中的任务，再次有了比较多的时间。闲下来之后，我的心思便又放到了super-blog上面。</p><p>我再次决定对博客首页改版，以前已经改过几次了。这次我决定将首页弄的简约一点。截止到2018年9月19日，新的首页开发完成，并且在这期间购买了阿里云服务器，提交了备案申请，过一段时间便可以通过域名访问了(<a href=\"http://www.myweimai.com/\">http://www.myweimai.com/</a>)。</p><h2>结尾</h2><p>super-blog还有很多不完善的地方：</p><ol><li>后台不够完善，首页有bug，功能也不够齐全，目前是直接修改数据库。</li><li>发布博客的页面还没有，之前做过一版，插件加载有点慢，不是很满意。</li><li>网站的安全性非常非常低，几乎没有考虑这方面的东西。</li><li>文章分类页面没有。</li><li>只能根据博客标题查询。未来准备搭建全文检索引擎</li><li>首页性能可以优化<br>…</li></ol>');
/*!40000 ALTER TABLE `article_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_image`
--

DROP TABLE IF EXISTS `article_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article_image` (
  `id` bigint(20) NOT NULL,
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `image_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `status` int(1) NOT NULL COMMENT '状态(0:已删除 1:未删除)',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_image`
--

LOCK TABLES `article_image` WRITE;
/*!40000 ALTER TABLE `article_image` DISABLE KEYS */;
INSERT INTO `article_image` VALUES (1,1,'/static/images/tmp/diego-ph-249471-2-800x1000.jpg',1,'2018-09-19 12:15:22','2018-09-21 09:17:03');
/*!40000 ALTER TABLE `article_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_tag_rel`
--

DROP TABLE IF EXISTS `article_tag_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article_tag_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `article_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  `tag_name` varchar(20) NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_tag_rel`
--

LOCK TABLES `article_tag_rel` WRITE;
/*!40000 ALTER TABLE `article_tag_rel` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_tag_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `index_setting`
--

DROP TABLE IF EXISTS `index_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `index_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_updated` datetime NOT NULL COMMENT '修改时间',
  `title` varchar(50) DEFAULT NULL COMMENT '首页title',
  `logo_url` varchar(255) DEFAULT NULL COMMENT 'logo路径',
  `favicon_url` varchar(255) DEFAULT NULL COMMENT 'favicon地址',
  `is_search` int(1) DEFAULT NULL COMMENT '是否开启全文搜索(0：不开启 1:开启)',
  `search_icon` varchar(20) DEFAULT NULL COMMENT '搜索图标',
  `search_tip` varchar(100) DEFAULT NULL COMMENT '搜索input框提示语',
  `background_image_url` varchar(255) DEFAULT NULL COMMENT '背景图片地址',
  `bottom_text` varchar(255) DEFAULT NULL COMMENT '底部展示文字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='首页设置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `index_setting`
--

LOCK TABLES `index_setting` WRITE;
/*!40000 ALTER TABLE `index_setting` DISABLE KEYS */;
INSERT INTO `index_setting` VALUES (1,'2018-09-21 06:52:09','2018-09-21 06:52:10','克己的博客','http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-21/56222871.jpg','http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-21/95871763.jpg',1,'iconfont icon-search','输入文章标题按enter搜索','http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-15/82070817.jpg','Copyright&copy;2018. Design by 克己');
/*!40000 ALTER TABLE `index_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(255) NOT NULL COMMENT '链接名称',
  `url` varchar(2000) NOT NULL COMMENT '链接地址',
  `status` int(1) NOT NULL COMMENT '状态 0：删除 1:正常',
  `icon` varchar(2000) DEFAULT NULL COMMENT 'icon图标',
  `category_name` varchar(20) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='友情链接';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
INSERT INTO `link` VALUES (1,'2018-09-16 03:46:49','2018-09-16 03:46:51','baidu','https://www.baidu.com/',1,'http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-21/16839235.jpg','常用'),(2,'2018-09-16 03:47:19','2018-09-16 03:47:20','bilibili','www.bilibili.com',0,'/static/images/tmp/8e5da64c712d2bb59235d8d746108cb1.jpeg','常用'),(3,'2018-09-16 03:47:54','2018-09-16 03:47:55','开源中国','https://www.oschina.net/',1,'http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-21/32551669.jpg','it'),(4,'2018-09-16 03:48:27','2018-09-16 03:48:28','阮一峰的网络日志','http://www.ruanyifeng.com/home.html',1,'http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-21/27674322.jpg','it');
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nav`
--

DROP TABLE IF EXISTS `nav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nav` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(20) NOT NULL COMMENT '导航的名称',
  `icon` varchar(50) NOT NULL COMMENT 'icon',
  `url` varchar(255) NOT NULL COMMENT '跳转地址',
  `status` tinyint(4) NOT NULL COMMENT '状态(0:删除,1:正常)',
  `sort_id` int(11) DEFAULT NULL COMMENT '排序号',
  `position` varchar(20) DEFAULT NULL COMMENT '导航位置(header,bottom)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='首页导航表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nav`
--

LOCK TABLES `nav` WRITE;
/*!40000 ALTER TABLE `nav` DISABLE KEYS */;
INSERT INTO `nav` VALUES (5,'2018-03-23 14:05:22','2018-03-23 14:05:22','首页','icon-home1','/index',1,0,'header'),(6,'2018-03-23 14:07:35','2018-03-23 14:07:35','更新','icon-timeline','/home/update.html',1,1,'header'),(7,'2018-03-23 14:11:53','2018-03-23 14:11:53','链接','icon-GitHub','/home/link.html',1,2,'header'),(8,'2018-03-23 14:12:40','2018-03-23 14:12:40','归档','icon-about','/home/archives.html',1,3,'header'),(11,'2018-05-02 18:20:46','2018-05-02 18:27:00','留言','icon-create','/home/gustbook.html',1,4,'header'),(12,'2018-09-21 06:36:58','2018-09-21 06:36:59','github','iconfont icon-github','https://github.com/keji94/super-blog',1,5,'bottom'),(13,'2018-09-21 06:37:00','2018-09-21 06:37:01','wechat','iconfont icon-weixin1','http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-15/58927749.jpg',1,6,'bottom'),(14,'2018-09-21 06:37:01','2018-09-21 06:37:02','qq','iconfont icon-qq2','http://keji-image.oss-cn-hangzhou.aliyuncs.com/18-9-15/69039151.jpg',1,7,'bottom');
/*!40000 ALTER TABLE `nav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `update_time_line`
--

DROP TABLE IF EXISTS `update_time_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `update_time_line` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `status` int(1) DEFAULT NULL COMMENT '状态(0:normal（计划执行），1:warning(警告),2：success（成功更新))',
  `is_del` int(11) NOT NULL COMMENT '0：未删除 1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='网站更新时间线';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `update_time_line`
--

LOCK TABLES `update_time_line` WRITE;
/*!40000 ALTER TABLE `update_time_line` DISABLE KEYS */;
INSERT INTO `update_time_line` VALUES (1,'super-blog正式上线了','断断续续开发了一年多，经历数次改版，终于上线了','2018-09-21 07:17:04','2018-09-21 07:17:05',2,0);
/*!40000 ALTER TABLE `update_time_line` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21 20:32:56
