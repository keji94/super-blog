-- MySQL dump 10.13  Distrib 5.7.18, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: blog_keji
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `content` longtext NOT NULL COMMENT '文章内容',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '文章状态，0：正常；1：删除',
  `top` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否置顶，1：置顶；0：不置顶',
  `commentable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可以评论 1：可以；0：不可以',
  `user_id` bigint(20) NOT NULL COMMENT '发表用户',
  `category_id` bigint(20) NOT NULL,
  `category_name` varchar(20) NOT NULL,
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_7` (`category_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'1','1',0,1,1,1,7,'java','2018-03-26 16:26:41','2018-03-26 16:26:43'),(2,'2','2',0,1,1,1,4,'redis','2018-03-26 16:28:30','2018-03-26 16:28:33'),(5,'1','',0,0,1,1,4,'redis','2018-05-17 18:56:53','2018-05-17 18:56:53'),(6,'1','',0,0,1,1,4,'redis','2018-05-17 18:58:32','2018-05-17 18:58:32'),(7,'1','123',0,0,1,1,4,'redis','2018-05-17 19:00:58','2018-05-17 19:00:58'),(8,'1','123',0,0,1,1,7,'java','2018-05-17 19:02:10','2018-05-17 19:02:10'),(9,'1','123',0,0,1,1,7,'java','2018-05-17 19:04:13','2018-05-17 19:04:13'),(10,'1','123',0,0,1,1,7,'java','2018-05-17 19:04:46','2018-05-17 19:04:46'),(11,'设计模式之策略模式','# 定义\n\n《Head First》中对策略模式定义如下:**策略模式定义了算法族，分别封装起来，让他们之间可以互相替换。此模式让算法的变化独立于使用算法的客户。**\n\nok,相信对于初学者而言，看到这个定义肯定一脸懵逼，没关系，往下看，我会用实际例子让你明白什么是策略模式。\n\n# 案例\n## 背景\n现在要编写一个不断生产鸭子的程序，这些鸭子其他地方都一样，只有飞行行为(flyBehavior)和叫的行为(quackBehavior)不同。\n## 方案一：继承\n思路：使用一个超类Duck统领全局，其他鸭子类继承Duck类\n```\n/**\n * 鸭子超类\n *\n * @author wb-ny291824\n * @version $Id: Duck.java, v 0.1 2018-03-16 16:56 wb-ny291824 Exp $$\n */\npublic abstract class Duck {\n\n    /**\n     * 腿的数量\n     */\n    protected int legs;\n\n    /**\n     * 飞行\n     */\n    public void fly() {\n        System.out.println(\"I can fly\");\n    }\n\n    /**\n     * 叫\n     */\n    public void quack() {\n        System.out.println(\"呱呱呱\");\n    }\n}\n```',0,0,1,1,8,'java基础','2018-05-17 19:40:53','2018-05-17 19:40:53'),(13,'1','<h1 id=\"-\">定义</h1>\n<p>《Head First》中对策略模式定义如下:<strong>策略模式定义了算法族，分别封装起来，让他们之间可以互相替换。此模式让算法的变化独立于使用算法的客户。</strong></p>\n<p>ok,相信对于初学者而言，看到这个定义肯定一脸懵逼，没关系，往下看，我会用实际例子让你明白什么是策略模式。</p>\n<h1 id=\"-\">案例</h1>\n<h2 id=\"-\">背景</h2>\n<p>现在要编写一个不断生产鸭子的程序，这些鸭子其他地方都一样，只有飞行行为(flyBehavior)和叫的行为(quackBehavior)不同。</p>\n<h2 id=\"-\">方案一：继承</h2>\n<p>思路：使用一个超类Duck统领全局，其他鸭子类继承Duck类</p>\n<pre><code>/**\n * 鸭子超类\n *\n * @author wb-ny291824\n * @version $Id: Duck.java, v 0.1 2018-03-16 16:56 wb-ny291824 Exp $$\n */\npublic abstract class Duck {\n\n    /**\n     * 腿的数量\n     */\n    protected int legs;\n\n    /**\n     * 飞行\n     */\n    public void fly() {\n        System.out.println(&quot;I can fly&quot;);\n    }\n\n    /**\n     * 叫\n     */\n    public void quack() {\n        System.out.println(&quot;呱呱呱&quot;);\n    }\n}\n</code></pre>',0,0,1,1,7,'java','2018-05-30 20:36:07','2018-05-30 20:36:07');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_ext`
--

DROP TABLE IF EXISTS `article_ext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_ext` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `good` int(11) DEFAULT '0' COMMENT '文章顶数量',
  `bad` int(11) DEFAULT '0' COMMENT '文章踩数量',
  `pageviews` int(20) DEFAULT '0' COMMENT '浏览数',
  `article_id` bigint(20) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`article_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文章的扩展属性表：图片 点击量 顶 踩等';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_ext`
--

LOCK TABLES `article_ext` WRITE;
/*!40000 ALTER TABLE `article_ext` DISABLE KEYS */;
INSERT INTO `article_ext` VALUES (1,1,1,100,1,'2018-04-27 08:08:01','2018-04-27 08:08:07');
/*!40000 ALTER TABLE `article_ext` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_tag_rel`
--

DROP TABLE IF EXISTS `article_tag_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_tag_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `article_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  `tag_name` varchar(20) NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_tag_rel`
--

LOCK TABLES `article_tag_rel` WRITE;
/*!40000 ALTER TABLE `article_tag_rel` DISABLE KEYS */;
INSERT INTO `article_tag_rel` VALUES (1,'2018-03-26 16:27:30','2018-03-26 16:27:32',1,1,'java'),(2,'2018-03-26 16:27:55','2018-03-26 16:27:57',1,2,'spring'),(3,'2018-03-26 16:28:43','2018-03-26 16:28:44',2,1,'java'),(4,'2018-03-26 16:42:45','2018-03-26 16:42:47',2,2,'spring'),(5,'2018-03-26 16:43:10','2018-03-26 16:43:12',1,2,'spring'),(6,'2018-05-17 18:57:06','2018-05-17 18:57:06',5,26,'1'),(7,'2018-05-17 18:57:06','2018-05-17 18:57:06',5,27,'2'),(8,'2018-05-17 18:57:06','2018-05-17 18:57:06',5,28,'3'),(9,'2018-05-17 18:58:32','2018-05-17 18:58:32',6,29,'1'),(10,'2018-05-17 18:58:32','2018-05-17 18:58:32',6,30,'2'),(11,'2018-05-17 18:58:32','2018-05-17 18:58:32',6,31,'3'),(12,'2018-05-17 19:00:58','2018-05-17 19:00:58',7,32,'1'),(13,'2018-05-17 19:00:58','2018-05-17 19:00:58',7,33,'2'),(14,'2018-05-17 19:00:58','2018-05-17 19:00:58',7,34,'3'),(15,'2018-05-17 19:02:10','2018-05-17 19:02:10',8,35,'1'),(16,'2018-05-17 19:04:13','2018-05-17 19:04:13',9,36,'1'),(17,'2018-05-17 19:04:46','2018-05-17 19:04:46',10,37,'1'),(18,'2018-05-17 19:40:53','2018-05-17 19:40:53',11,38,'设计模式'),(20,'2018-05-30 20:36:07','2018-05-30 20:36:07',13,40,'测试');
/*!40000 ALTER TABLE `article_tag_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_keji`
--

DROP TABLE IF EXISTS `blog_keji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_keji` (
  `field1` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_keji`
--

LOCK TABLES `blog_keji` WRITE;
/*!40000 ALTER TABLE `blog_keji` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_keji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `parent_name` varchar(10) NOT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否是父节点:1表示是，0表示不是',
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (4,'redis','一级菜单',0,0,'2018-03-25 16:51:03','2018-03-25 17:57:15'),(6,'redis入門','cashi22',1,4,'2018-03-25 17:27:38','2018-03-25 17:57:33'),(7,'java','一级菜单',0,0,'2018-03-25 17:57:01','2018-03-25 17:57:01'),(8,'java基础','java',1,7,'2018-03-25 17:57:57','2018-03-25 17:59:29');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post` int(20) DEFAULT NULL COMMENT '预留字段',
  `content` text,
  `article_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '评论状态 0：正常，1：删除',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_3` (`article_id`),
  KEY `FK_Reference_4` (`user_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hits`
--

DROP TABLE IF EXISTS `hits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hits` (
  `hits_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) DEFAULT NULL,
  `hit_count` bigint(20) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`hits_id`),
  KEY `FK_Reference_5` (`article_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点击量表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hits`
--

LOCK TABLES `hits` WRITE;
/*!40000 ALTER TABLE `hits` DISABLE KEYS */;
/*!40000 ALTER TABLE `hits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_board`
--

DROP TABLE IF EXISTS `info_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info_board` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Xin xi ban ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_board`
--

LOCK TABLES `info_board` WRITE;
/*!40000 ALTER TABLE `info_board` DISABLE KEYS */;
INSERT INTO `info_board` VALUES (2,'2018-03-24 10:19:50','2018-03-24 11:02:12','网站信息','<ul><li>网站名称：克己的博客</li><li>博客系统：<a href=\"//github.com/miyakowork\" target=\"_blank\" style=\"font-style: italic;\"><i class=\"layui-icon\"></i> NoteBlog</a></li><li>qq群：123456789</li><li>前端UI：<a href=\"//layui.com\" target=\"_blank\">layui 2.x</a></li><li>后端架构：<a href=\"https://projects.spring.io/spring-boot/\" target=\"_blank\">SpringBoot</a> 1.6.9 系列等</li></ul>'),(3,'2018-03-24 11:03:48','2018-03-24 11:03:48','用户登录','请登录');
/*!40000 ALTER TABLE `info_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nav`
--

DROP TABLE IF EXISTS `nav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nav` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(20) NOT NULL COMMENT '导航的名称',
  `icon` varchar(20) NOT NULL COMMENT 'icon',
  `url` varchar(255) NOT NULL COMMENT '跳转地址',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='首页导航表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nav`
--

LOCK TABLES `nav` WRITE;
/*!40000 ALTER TABLE `nav` DISABLE KEYS */;
INSERT INTO `nav` VALUES (5,'2018-03-23 14:05:22','2018-03-23 14:05:22','主页','icon-home1','/index',1),(6,'2018-03-23 14:07:35','2018-03-23 14:07:35','笔记','icon-timeline','/home/note.html',1),(7,'2018-03-23 14:11:53','2018-03-23 14:11:53','Github','icon-GitHub','https://github.com/',1),(8,'2018-03-23 14:12:40','2018-03-23 14:12:40','关于','icon-about','/home/about.html',1),(11,'2018-05-02 18:20:46','2018-05-02 18:27:00','写博客','icon-create','/home/createBlog.html',1);
/*!40000 ALTER TABLE `nav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `resource` varchar(255) NOT NULL COMMENT '图片地址',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '图片状态',
  `order_num` int(11) DEFAULT '1' COMMENT '排序',
  `article_id` bigint(20) NOT NULL,
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_6` (`article_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_blob_triggers`
--

DROP TABLE IF EXISTS `qrtz_blob_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_blob_triggers`
--

LOCK TABLES `qrtz_blob_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_blob_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_calendars`
--

DROP TABLE IF EXISTS `qrtz_calendars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_calendars`
--

LOCK TABLES `qrtz_calendars` WRITE;
/*!40000 ALTER TABLE `qrtz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_calendars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_cron_triggers`
--

DROP TABLE IF EXISTS `qrtz_cron_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_cron_triggers`
--

LOCK TABLES `qrtz_cron_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_cron_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler','TASK_4','DEFAULT','0/5 * * * * ? ','Asia/Shanghai');
/*!40000 ALTER TABLE `qrtz_cron_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_fired_triggers`
--

DROP TABLE IF EXISTS `qrtz_fired_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_fired_triggers`
--

LOCK TABLES `qrtz_fired_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_fired_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_fired_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_job_details`
--

DROP TABLE IF EXISTS `qrtz_job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_job_details`
--

LOCK TABLES `qrtz_job_details` WRITE;
/*!40000 ALTER TABLE `qrtz_job_details` DISABLE KEYS */;
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler','TASK_4','DEFAULT',NULL,'com.keji.blog.util.schedule.ScheduleJob','0','0','0','0','�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0&com.keji.blog.dataobject.ScheduleJobDO&�\�0�9\�P\0	L\0beanNamet\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0\ngmtCreatedt\0Ljava/util/Date;L\0gmtModifiedq\0~\0\nL\0idt\0Ljava/lang/Long;L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0testTaskt\00/5 * * * * ? ppsr\0java.lang.Long;�\�̏#\�\0J\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0\0\0\0\0t\0testppsr\0java.lang.Integer⠤���8\0I\0valuexq\0~\0\0\0\0\0x\0');
/*!40000 ALTER TABLE `qrtz_job_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_locks`
--

DROP TABLE IF EXISTS `qrtz_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_locks`
--

LOCK TABLES `qrtz_locks` WRITE;
/*!40000 ALTER TABLE `qrtz_locks` DISABLE KEYS */;
INSERT INTO `qrtz_locks` VALUES ('BlogScheduler','STATE_ACCESS'),('BlogScheduler','TRIGGER_ACCESS'),('RenrenScheduler','STATE_ACCESS'),('RenrenScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `qrtz_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_paused_trigger_grps`
--

LOCK TABLES `qrtz_paused_trigger_grps` WRITE;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_scheduler_state`
--

DROP TABLE IF EXISTS `qrtz_scheduler_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_scheduler_state`
--

LOCK TABLES `qrtz_scheduler_state` WRITE;
/*!40000 ALTER TABLE `qrtz_scheduler_state` DISABLE KEYS */;
INSERT INTO `qrtz_scheduler_state` VALUES ('BlogScheduler','MININT-LGP9OM31510018374057',1510103956560,15000),('RenrenScheduler','localhost1536749119633',1536808855826,15000);
/*!40000 ALTER TABLE `qrtz_scheduler_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simple_triggers`
--

DROP TABLE IF EXISTS `qrtz_simple_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simple_triggers`
--

LOCK TABLES `qrtz_simple_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simple_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simprop_triggers`
--

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simprop_triggers`
--

LOCK TABLES `qrtz_simprop_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_triggers`
--

DROP TABLE IF EXISTS `qrtz_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_triggers`
--

LOCK TABLES `qrtz_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler','TASK_4','DEFAULT','TASK_4','DEFAULT',NULL,1510105655000,1510105650000,5,'PAUSED','CRON',1509694754000,0,NULL,2,'');
/*!40000 ALTER TABLE `qrtz_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '需求表',
  `title` varchar(255) NOT NULL COMMENT '需求的标题',
  `content` text COMMENT '需求内容',
  `summary` text COMMENT '完成总结',
  `status` tinyint(11) NOT NULL COMMENT '状态(0:新建;1:开发中;2:完成;3:放弃)',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` VALUES (6,'CodeReview','前面完成了权限管理以及需求管理，可以先review一下代码',NULL,2,'2017-10-31 10:20:43','2017-11-03 16:08:11'),(10,'定时任务需求','移植renren项目的定时任务','定时任务的相关知识还需要学习',2,'2017-11-01 14:43:38','2017-11-03 16:09:49'),(11,'定时任务有一个线程池操作，灵狐警告了，改掉','学习总结java线程池相关知识',NULL,2,'2017-11-03 16:09:15','2017-11-06 10:55:49');
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '0：目录   1：菜单   2：按钮''资源id',
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '父资源名字',
  `resource_name` varchar(255) NOT NULL,
  `resource_url` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '资源类型 0：目录   1：菜单   2：按钮''',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` tinyint(11) DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:正常 1:停用',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,0,NULL,'系统管理','/**','',0,'fa fa-cogs',0,0,'2017-10-19 14:54:31','2018-03-27 15:25:06'),(2,59,'系统管理','用户管理','modules/authority/user.html','',1,'fa fa-user',1,0,'2017-10-20 09:49:06','2018-03-19 17:29:31'),(3,59,'系统管理','菜单管理','modules/authority/menu.html',NULL,1,'fa fa-th-list',2,0,'2017-10-24 15:44:07','2018-03-19 17:29:37'),(4,3,'菜单管理','查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0,0,'2017-10-24 20:34:36','2017-10-24 20:34:38'),(5,3,'菜单管理','新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0,0,'2017-10-24 20:35:18','2017-10-24 20:35:21'),(6,3,'菜单管理','修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0,0,'2017-10-24 20:35:50','2017-10-24 20:35:54'),(7,3,'菜单管理','删除',NULL,'sys:menu:delete',2,NULL,0,0,'2017-10-24 20:36:27','2017-10-24 20:36:30'),(8,2,'用户管理','查看',NULL,'sys:role:list,sys:role:info',2,NULL,0,0,'2017-10-25 10:30:47','2017-10-25 10:30:50'),(9,2,'用户管理','新增',NULL,'sys:role:save,sys:menu:perms',2,NULL,0,0,'2017-10-25 10:31:21','2017-10-25 10:31:23'),(10,2,'用户管理','修改',NULL,'sys:role:update,sys:menu:perms',2,NULL,0,0,'2017-10-25 10:31:53','2017-10-25 10:31:55'),(11,2,'用户管理','删除',NULL,'sys:role:delete',2,NULL,0,0,'2017-10-25 10:32:18','2017-10-25 10:32:21'),(12,59,'系统管理','角色管理','modules/authority/role.html',NULL,1,'fa fa-user-secret',3,0,'2017-10-25 10:34:56','2018-03-19 17:29:44'),(13,12,'角色管理','查看',NULL,'sys:user:list,sys:user:info',2,NULL,0,0,'2017-10-25 10:36:27','2017-10-25 10:36:29'),(14,12,'角色管理','新增',NULL,'sys:user:save,sys:role:select',2,NULL,0,0,'2017-10-25 10:36:50','2017-10-25 10:36:52'),(15,12,'角色管理','修改',NULL,'sys:user:update,sys:role:select',2,NULL,0,0,'2017-10-25 10:37:10','2017-10-25 10:37:12'),(16,12,'角色管理','删除',NULL,'sys:user:delete',2,NULL,0,0,'2017-10-25 10:37:30','2017-10-25 10:37:33'),(46,1,'系统管理','需求管理','modules/sys/requirement.html','',1,'fa fa-list',0,0,'2017-10-30 17:14:02','2018-03-25 14:45:21'),(47,46,'需求管理','新增',NULL,'sys:requirement:save,sys:requirement:select',2,NULL,0,0,'2017-10-30 17:48:48','2017-10-30 17:50:03'),(48,46,'需求管理','修改',NULL,'sys:requirement:update,sys:requirement:select',2,NULL,0,0,'2017-10-30 17:49:47','2017-10-30 17:49:47'),(49,46,'需求管理','删除',NULL,'sys:requirement:delete,sys:requirement:select',2,NULL,0,0,'2017-10-30 17:50:32','2017-10-30 17:50:32'),(50,1,'系统管理','定时任务','modules/sys/schedule.html',NULL,1,'fa fa-tasks',5,0,'2017-11-02 15:01:52','2018-03-19 14:36:58'),(51,50,'定时任务','查看',NULL,'sys:schedule:list,sys:schedule:info',2,NULL,0,0,'2017-11-02 15:41:32','2017-11-02 15:41:32'),(52,50,'定时任务','新增',NULL,'sys:schedule:save',2,NULL,0,0,'2017-11-02 15:41:51','2017-11-02 15:41:51'),(53,50,'定时任务','修改',NULL,'sys:schedule:update',2,NULL,0,0,'2017-11-02 15:42:07','2017-11-02 15:42:07'),(54,50,'定时任务','删除',NULL,'sys:schedule:delete',2,NULL,0,0,'2017-11-02 15:42:19','2017-11-02 15:42:19'),(55,50,'定时任务','暂停',NULL,'sys:schedule:pause',2,NULL,0,0,'2017-11-02 15:42:34','2017-11-02 15:42:34'),(56,50,'定时任务','恢复',NULL,'sys:schedule:resume',2,NULL,0,0,'2017-11-02 15:42:48','2017-11-03 10:32:22'),(57,50,'定时任务','日志列表',NULL,'sys:schedule:log',2,NULL,0,0,'2017-11-02 15:43:11','2017-11-02 15:43:11'),(58,50,'定时任务','立即执行',NULL,'sys:schedule:run',2,NULL,0,0,'2017-11-03 10:33:00','2017-11-03 10:33:00'),(59,0,'一级菜单','权限控制',NULL,NULL,0,'fa fa-user-circle',2,0,'2018-03-19 17:25:20','2018-03-19 17:39:06'),(60,1,'系统管理','博客设置','modules/sys/settings.html','admin_sys_setting',1,'fa fa-cog',1,0,'2018-03-19 17:32:17','2018-03-19 17:44:06'),(61,1,'系统管理','导航管理','modules/sys/nav','modules:sys:nav',1,'fa fa-bars',3,0,'2018-03-22 16:18:47','2018-03-22 16:18:47'),(62,1,'系统管理','信息板管理','/admin/modules/sys/infoBoard.html','sys:infoBoard',1,'fa fa-info',3,0,'2018-03-23 22:46:15','2018-03-23 22:46:15'),(64,1,'系统管理','分类管理','modules/sys/category.html','sys:category',1,'fa fa-coffee',5,0,'2018-03-25 14:58:31','2018-03-25 16:32:20'),(65,1,'系统管理','标签管理','modules/sys/tag.html','sys:tag',1,'fa fa-tags',5,0,'2018-03-26 11:03:02','2018-03-26 11:03:32'),(66,1,'系统管理','文章管理','modules/sys/article.html','admin:article',1,'fa fa-book',6,0,'2018-03-27 15:25:06','2018-03-27 15:25:41');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'roleId',
  `role_code` varchar(255) NOT NULL COMMENT '角色code',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `status` tinyint(11) NOT NULL DEFAULT '0' COMMENT '取值范围：{0:正常,1:停用}',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','管理员',0,'2017-10-19 10:55:39','2017-10-19 10:55:43'),(2,'common','普通会员',0,'2017-10-19 10:56:52','2017-10-19 10:56:55');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_resource_rel`
--

DROP TABLE IF EXISTS `role_resource_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_resource_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:正常 1:可用',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_resource_rel`
--

LOCK TABLES `role_resource_rel` WRITE;
/*!40000 ALTER TABLE `role_resource_rel` DISABLE KEYS */;
INSERT INTO `role_resource_rel` VALUES (1,2,2,0,'2017-10-19 14:55:30','2017-10-19 14:55:32'),(2,1,1,0,'2017-10-19 14:55:40','2017-10-19 14:55:43'),(3,1,2,0,'2017-10-25 10:00:41','2017-10-25 10:00:44'),(4,1,3,0,'2017-10-25 10:01:16','2017-10-25 10:01:19'),(5,1,4,0,'2017-10-25 10:02:19','2017-10-25 10:02:22'),(6,1,5,0,'2017-10-25 10:02:29','2017-10-25 10:02:31'),(7,1,6,0,'2017-10-25 10:02:40','2017-10-25 10:02:42'),(9,1,8,0,'2017-10-25 10:32:42','2017-10-25 10:32:45'),(10,1,9,0,'2017-10-25 10:32:52','2017-10-25 10:32:54'),(11,1,10,0,'2017-10-25 10:33:02','2017-10-25 10:33:04'),(12,1,11,0,'2017-10-25 10:33:11','2017-10-25 10:33:14'),(13,1,12,0,'2017-10-25 10:37:54','2017-10-25 10:37:56'),(14,1,13,0,'2017-10-25 10:38:03','2017-10-25 10:38:06'),(15,1,14,0,'2017-10-25 10:38:16','2017-10-25 10:38:18'),(16,1,15,0,'2017-10-25 10:38:45','2017-10-25 10:38:48'),(17,1,16,0,'2017-10-25 10:38:55','2017-10-25 10:38:58');
/*!40000 ALTER TABLE `role_resource_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_job`
--

DROP TABLE IF EXISTS `schedule_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bean_name` varchar(255) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(255) DEFAULT NULL COMMENT '方法名',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) NOT NULL COMMENT '状态(0:正常,1:暂停,2:停用)',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_job`
--

LOCK TABLES `schedule_job` WRITE;
/*!40000 ALTER TABLE `schedule_job` DISABLE KEYS */;
INSERT INTO `schedule_job` VALUES (4,'testTask','test',NULL,'0/5 * * * * ? ',NULL,1,'2017-11-03 15:39:14','2017-11-08 09:47:31');
/*!40000 ALTER TABLE `schedule_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_job_log`
--

DROP TABLE IF EXISTS `schedule_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `error_msg` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `consume_time` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_job_log`
--

LOCK TABLES `schedule_job_log` WRITE;
/*!40000 ALTER TABLE `schedule_job_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'2018-03-26 11:03:49','2018-03-26 11:05:13','java'),(2,'2018-03-26 11:05:18','2018-03-26 11:05:18','spring'),(4,'2018-03-26 11:05:29','2018-03-26 11:05:29','redis'),(26,'2018-05-17 18:56:22','2018-05-17 18:56:22','1'),(27,'2018-05-17 18:56:22','2018-05-17 18:56:22','2'),(28,'2018-05-17 18:56:22','2018-05-17 18:56:22','3'),(29,'2018-05-17 18:58:32','2018-05-17 18:58:32','1'),(30,'2018-05-17 18:58:32','2018-05-17 18:58:32','2'),(31,'2018-05-17 18:58:32','2018-05-17 18:58:32','3'),(32,'2018-05-17 19:00:58','2018-05-17 19:00:58','1'),(33,'2018-05-17 19:00:58','2018-05-17 19:00:58','2'),(34,'2018-05-17 19:00:58','2018-05-17 19:00:58','3'),(35,'2018-05-17 19:02:10','2018-05-17 19:02:10','1'),(36,'2018-05-17 19:04:13','2018-05-17 19:04:13','1'),(37,'2018-05-17 19:04:46','2018-05-17 19:04:46','1'),(38,'2018-05-17 19:40:53','2018-05-17 19:40:53','设计模式'),(40,'2018-05-30 20:36:07','2018-05-30 20:36:07','测试');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `text_settings`
--

DROP TABLE IF EXISTS `text_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `text_settings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `logo` varchar(20) NOT NULL DEFAULT '' COMMENT 'logo图标右侧文案',
  `title` varchar(20) NOT NULL DEFAULT '' COMMENT '博客标题',
  `page_header` varchar(40) DEFAULT NULL COMMENT '页眉文案',
  `page_rooting` varchar(20) DEFAULT NULL COMMENT '页尾',
  `search` varchar(20) NOT NULL COMMENT '搜索文案',
  `search_icon` varchar(20) DEFAULT NULL,
  `comment_open` tinyint(4) NOT NULL DEFAULT '1' COMMENT '评论功能0:关闭,1:开启',
  `leave_word_open` tinyint(4) NOT NULL COMMENT '留言功能0:关闭,1:开启',
  `create_time_icon` varchar(20) DEFAULT NULL,
  `announcement` text COMMENT '公告信息',
  `hot_icon` varchar(20) DEFAULT NULL COMMENT '文章热度icon',
  `leave_word_announcement` varchar(255) DEFAULT NULL COMMENT '留言公告信息',
  `icon_url` varchar(100) NOT NULL COMMENT 'http://iconfont.cn/manage/index?spm=a313x.7781069.1998910419.11&manage_type=myprojects&projectId=601117 最新地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `text_settings`
--

LOCK TABLES `text_settings` WRITE;
/*!40000 ALTER TABLE `text_settings` DISABLE KEYS */;
INSERT INTO `text_settings` VALUES (1,'2018-03-21 11:31:30','2018-03-21 11:31:32','的博客','克己的博客','有志，则不甘为下流；有识，则只学问之无尽;有恒，则断无不成之事','克己的博客','搜一搜','icon-search',1,1,'icon-time','<li>网站名称：克己的博客</li><li>博客系统：<a href=\"//github.com/miyakowork\" target=\"_blank\"style=\"font-style: italic;\"><i class=\"layui-icon\">&#xe628;</i> NoteBlog</a></li><li>qq群：123456789</li><li>前端UI：<a href=\"//layui.com\" target=\"_blank\">layui 2.x</a></li><li>后端架构：<a href=\"https://projects.spring.io/spring-boot/\" target=\"_blank\">SpringBoot</a> 1.5.9 系列等</li>','icon-temperature-','1111','//at.alicdn.com/t/font_601117_r68dogh1ev1jor.js');
/*!40000 ALTER TABLE `text_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `email` varchar(255) NOT NULL COMMENT '登录邮箱',
  `name` varchar(20) NOT NULL COMMENT '用户昵称',
  `password` varchar(20) NOT NULL COMMENT '登录密码',
  `question` varchar(255) DEFAULT NULL COMMENT '密码保护问题',
  `answer` varchar(255) DEFAULT NULL COMMENT '答案',
  `picture` varchar(255) DEFAULT NULL COMMENT '头像',
  `ip` varchar(255) DEFAULT NULL COMMENT '上次登录的ip',
  `series_number` varchar(255) DEFAULT NULL COMMENT '用户登录的序列号',
  `phone` varchar(255) DEFAULT NULL COMMENT '绑定手机号，注意加密',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '用户状态，0表示正常1表示封禁',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@qq.com','克己','admin','啥时候脱单？','等我完成100功',NULL,NULL,NULL,NULL,1,'2017-08-07 11:13:00','2017-08-07 11:13:02'),(2,'123@qq.com','克己','2870386','你小时候最好的朋友','123',NULL,'10.63.14.102',NULL,'17671689099',1,'2017-08-07 17:04:43','2017-10-26 15:26:02'),(5,'nieyinie2008@163.com','聂毅','2870386',NULL,NULL,NULL,NULL,NULL,'17671689059',1,'2017-10-26 11:08:28','2017-10-26 15:26:01');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_rel`
--

DROP TABLE IF EXISTS `user_role_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role_rel` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(255) NOT NULL,
  `role_id` bigint(255) NOT NULL,
  `status` tinyint(11) NOT NULL DEFAULT '0' COMMENT '0:正常 1:停用',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_rel`
--

LOCK TABLES `user_role_rel` WRITE;
/*!40000 ALTER TABLE `user_role_rel` DISABLE KEYS */;
INSERT INTO `user_role_rel` VALUES (1,1,1,0,'2017-10-19 10:57:25','2017-10-19 10:57:28'),(2,2,2,0,'2017-10-19 10:57:37','2017-10-19 10:57:39'),(3,5,2,0,'2017-10-26 11:08:31','2017-10-26 11:08:31'),(4,6,2,0,'2017-10-26 14:30:03','2017-10-26 14:30:03');
/*!40000 ALTER TABLE `user_role_rel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-13 16:35:35
