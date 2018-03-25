/*
 Navicat MySQL Data Transfer

 Source Server         : keji
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : blog_keji

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 03/25/2018 20:04:37 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `content` text COMMENT '文章内容',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章状态，0：正常；1：删除',
  `is_top` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否置顶，0：置顶；1：不置顶',
  `user_id` bigint(20) NOT NULL COMMENT '发表用户',
  `category_id` bigint(20) NOT NULL,
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_7` (`category_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
--  Table structure for `article_ext`
-- ----------------------------
DROP TABLE IF EXISTS `article_ext`;
CREATE TABLE `article_ext` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `good` int(11) DEFAULT NULL COMMENT '文章顶数量',
  `bad` int(11) DEFAULT NULL COMMENT '文章踩数量',
  `article_id` bigint(20) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`article_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章的扩展属性表：图片 点击量 顶 踩等';

-- ----------------------------
--  Table structure for `blog_keji`
-- ----------------------------
DROP TABLE IF EXISTS `blog_keji`;
CREATE TABLE `blog_keji` (
  `field1` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
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

-- ----------------------------
--  Records of `category`
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES ('4', 'redis', '一级菜单', '0', '0', '2018-03-25 16:51:03', '2018-03-25 17:57:15'), ('6', 'redis入門', 'cashi22', '1', '4', '2018-03-25 17:27:38', '2018-03-25 17:57:33'), ('7', 'java', '一级菜单', '0', '0', '2018-03-25 17:57:01', '2018-03-25 17:57:01'), ('8', 'java基础', 'java', '1', '7', '2018-03-25 17:57:57', '2018-03-25 17:59:29');
COMMIT;

-- ----------------------------
--  Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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

-- ----------------------------
--  Table structure for `hits`
-- ----------------------------
DROP TABLE IF EXISTS `hits`;
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

-- ----------------------------
--  Table structure for `info_board`
-- ----------------------------
DROP TABLE IF EXISTS `info_board`;
CREATE TABLE `info_board` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Xin xi ban ';

-- ----------------------------
--  Records of `info_board`
-- ----------------------------
BEGIN;
INSERT INTO `info_board` VALUES ('2', '2018-03-24 10:19:50', '2018-03-24 11:02:12', '网站信息', '<ul><li>网站名称：克己的博客</li><li>博客系统：<a href=\"//github.com/miyakowork\" target=\"_blank\" style=\"font-style: italic;\"><i class=\"layui-icon\"></i> NoteBlog</a></li><li>qq群：123456789</li><li>前端UI：<a href=\"//layui.com\" target=\"_blank\">layui 2.x</a></li><li>后端架构：<a href=\"https://projects.spring.io/spring-boot/\" target=\"_blank\">SpringBoot</a> 1.6.9 系列等</li></ul>'), ('3', '2018-03-24 11:03:48', '2018-03-24 11:03:48', '用户登录', '请登录');
COMMIT;

-- ----------------------------
--  Table structure for `nav`
-- ----------------------------
DROP TABLE IF EXISTS `nav`;
CREATE TABLE `nav` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(20) NOT NULL COMMENT '导航的名称',
  `icon` varchar(20) NOT NULL COMMENT 'icon',
  `url` varchar(255) NOT NULL COMMENT '跳转地址',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='首页导航表';

-- ----------------------------
--  Records of `nav`
-- ----------------------------
BEGIN;
INSERT INTO `nav` VALUES ('5', '2018-03-23 14:05:22', '2018-03-23 14:05:22', '主页', 'icon-home1', '/index', '1'), ('6', '2018-03-23 14:07:35', '2018-03-23 14:07:35', '笔记', 'icon-timeline', '/home/note.html', '1'), ('7', '2018-03-23 14:11:53', '2018-03-23 14:11:53', 'Github', 'icon-GitHub', 'https://github.com/', '1'), ('8', '2018-03-23 14:12:40', '2018-03-23 14:12:40', '关于', 'icon-about', '/home/about.html', '1');
COMMIT;

-- ----------------------------
--  Table structure for `picture`
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
--  Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `qrtz_cron_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `qrtz_cron_triggers`
-- ----------------------------
BEGIN;
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', '0/5 * * * * ? ', 'Asia/Shanghai');
COMMIT;

-- ----------------------------
--  Table structure for `qrtz_fired_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
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

-- ----------------------------
--  Table structure for `qrtz_job_details`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
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

-- ----------------------------
--  Records of `qrtz_job_details`
-- ----------------------------
BEGIN;
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', null, 'com.keji.blog.util.schedule.ScheduleJob', '0', '0', '0', '0', 0xaced0005737200156f72672e71756172747a2e4a6f62446174614d61709fb083e8bfa9b0cb020000787200266f72672e71756172747a2e7574696c732e537472696e674b65794469727479466c61674d61708208e8c3fbc55d280200015a0013616c6c6f77735472616e7369656e74446174617872001d6f72672e71756172747a2e7574696c732e4469727479466c61674d617013e62ead28760ace0200025a000564697274794c00036d617074000f4c6a6176612f7574696c2f4d61703b787001737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c7708000000100000000174000d4a4f425f504152414d5f4b455973720026636f6d2e6b656a692e626c6f672e646174616f626a6563742e5363686564756c654a6f62444f26f5e3308839e4500200094c00086265616e4e616d657400124c6a6176612f6c616e672f537472696e673b4c000e63726f6e45787072657373696f6e71007e00094c000a676d74437265617465647400104c6a6176612f7574696c2f446174653b4c000b676d744d6f64696669656471007e000a4c000269647400104c6a6176612f6c616e672f4c6f6e673b4c000a6d6574686f644e616d6571007e00094c0006706172616d7371007e00094c000672656d61726b71007e00094c00067374617475737400134c6a6176612f6c616e672f496e74656765723b7870740008746573745461736b74000e302f35202a202a202a202a203f2070707372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b02000078700000000000000004740004746573747070737200116a6176612e6c616e672e496e746567657212e2a0a4f781873802000149000576616c75657871007e0011000000007800);
COMMIT;

-- ----------------------------
--  Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `qrtz_locks`
-- ----------------------------
BEGIN;
INSERT INTO `qrtz_locks` VALUES ('BlogScheduler', 'STATE_ACCESS'), ('BlogScheduler', 'TRIGGER_ACCESS'), ('RenrenScheduler', 'STATE_ACCESS'), ('RenrenScheduler', 'TRIGGER_ACCESS');
COMMIT;

-- ----------------------------
--  Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `qrtz_scheduler_state`
-- ----------------------------
BEGIN;
INSERT INTO `qrtz_scheduler_state` VALUES ('BlogScheduler', 'MININT-LGP9OM31510018374057', '1510103956560', '15000'), ('RenrenScheduler', 'nieyideMacBook-Pro.local1521966391919', '1521979463923', '15000');
COMMIT;

-- ----------------------------
--  Table structure for `qrtz_simple_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
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

-- ----------------------------
--  Table structure for `qrtz_simprop_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
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

-- ----------------------------
--  Table structure for `qrtz_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
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

-- ----------------------------
--  Records of `qrtz_triggers`
-- ----------------------------
BEGIN;
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', 'TASK_4', 'DEFAULT', null, '1510105655000', '1510105650000', '5', 'PAUSED', 'CRON', '1509694754000', '0', null, '2', '');
COMMIT;

-- ----------------------------
--  Table structure for `requirement`
-- ----------------------------
DROP TABLE IF EXISTS `requirement`;
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

-- ----------------------------
--  Records of `requirement`
-- ----------------------------
BEGIN;
INSERT INTO `requirement` VALUES ('6', 'CodeReview', '前面完成了权限管理以及需求管理，可以先review一下代码', null, '2', '2017-10-31 10:20:43', '2017-11-03 16:08:11'), ('10', '定时任务需求', '移植renren项目的定时任务', '定时任务的相关知识还需要学习', '2', '2017-11-01 14:43:38', '2017-11-03 16:09:49'), ('11', '定时任务有一个线程池操作，灵狐警告了，改掉', '学习总结java线程池相关知识', null, '2', '2017-11-03 16:09:15', '2017-11-06 10:55:49');
COMMIT;

-- ----------------------------
--  Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `resource`
-- ----------------------------
BEGIN;
INSERT INTO `resource` VALUES ('1', '0', null, '系统管理', '/**', '', '0', 'fa fa-cogs', '0', '0', '2017-10-19 14:54:31', '2018-03-25 14:58:31'), ('2', '59', '系统管理', '用户管理', 'modules/authority/user.html', '', '1', 'fa fa-user', '1', '0', '2017-10-20 09:49:06', '2018-03-19 17:29:31'), ('3', '59', '系统管理', '菜单管理', 'modules/authority/menu.html', null, '1', 'fa fa-th-list', '2', '0', '2017-10-24 15:44:07', '2018-03-19 17:29:37'), ('4', '3', '菜单管理', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0', '0', '2017-10-24 20:34:36', '2017-10-24 20:34:38'), ('5', '3', '菜单管理', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0', '0', '2017-10-24 20:35:18', '2017-10-24 20:35:21'), ('6', '3', '菜单管理', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0', '0', '2017-10-24 20:35:50', '2017-10-24 20:35:54'), ('7', '3', '菜单管理', '删除', null, 'sys:menu:delete', '2', null, '0', '0', '2017-10-24 20:36:27', '2017-10-24 20:36:30'), ('8', '2', '用户管理', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0', '0', '2017-10-25 10:30:47', '2017-10-25 10:30:50'), ('9', '2', '用户管理', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0', '0', '2017-10-25 10:31:21', '2017-10-25 10:31:23'), ('10', '2', '用户管理', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0', '0', '2017-10-25 10:31:53', '2017-10-25 10:31:55'), ('11', '2', '用户管理', '删除', null, 'sys:role:delete', '2', null, '0', '0', '2017-10-25 10:32:18', '2017-10-25 10:32:21'), ('12', '59', '系统管理', '角色管理', 'modules/authority/role.html', null, '1', 'fa fa-user-secret', '3', '0', '2017-10-25 10:34:56', '2018-03-19 17:29:44'), ('13', '12', '角色管理', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0', '0', '2017-10-25 10:36:27', '2017-10-25 10:36:29'), ('14', '12', '角色管理', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0', '0', '2017-10-25 10:36:50', '2017-10-25 10:36:52'), ('15', '12', '角色管理', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0', '0', '2017-10-25 10:37:10', '2017-10-25 10:37:12'), ('16', '12', '角色管理', '删除', null, 'sys:user:delete', '2', null, '0', '0', '2017-10-25 10:37:30', '2017-10-25 10:37:33'), ('46', '1', '系统管理', '需求管理', 'modules/sys/requirement.html', '', '1', 'fa fa-list', '0', '0', '2017-10-30 17:14:02', '2018-03-25 14:45:21'), ('47', '46', '需求管理', '新增', null, 'sys:requirement:save,sys:requirement:select', '2', null, '0', '0', '2017-10-30 17:48:48', '2017-10-30 17:50:03'), ('48', '46', '需求管理', '修改', null, 'sys:requirement:update,sys:requirement:select', '2', null, '0', '0', '2017-10-30 17:49:47', '2017-10-30 17:49:47'), ('49', '46', '需求管理', '删除', null, 'sys:requirement:delete,sys:requirement:select', '2', null, '0', '0', '2017-10-30 17:50:32', '2017-10-30 17:50:32'), ('50', '1', '系统管理', '定时任务', 'modules/sys/schedule.html', null, '1', 'fa fa-tasks', '5', '0', '2017-11-02 15:01:52', '2018-03-19 14:36:58'), ('51', '50', '定时任务', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0', '0', '2017-11-02 15:41:32', '2017-11-02 15:41:32'), ('52', '50', '定时任务', '新增', null, 'sys:schedule:save', '2', null, '0', '0', '2017-11-02 15:41:51', '2017-11-02 15:41:51'), ('53', '50', '定时任务', '修改', null, 'sys:schedule:update', '2', null, '0', '0', '2017-11-02 15:42:07', '2017-11-02 15:42:07'), ('54', '50', '定时任务', '删除', null, 'sys:schedule:delete', '2', null, '0', '0', '2017-11-02 15:42:19', '2017-11-02 15:42:19'), ('55', '50', '定时任务', '暂停', null, 'sys:schedule:pause', '2', null, '0', '0', '2017-11-02 15:42:34', '2017-11-02 15:42:34'), ('56', '50', '定时任务', '恢复', null, 'sys:schedule:resume', '2', null, '0', '0', '2017-11-02 15:42:48', '2017-11-03 10:32:22'), ('57', '50', '定时任务', '日志列表', null, 'sys:schedule:log', '2', null, '0', '0', '2017-11-02 15:43:11', '2017-11-02 15:43:11'), ('58', '50', '定时任务', '立即执行', null, 'sys:schedule:run', '2', null, '0', '0', '2017-11-03 10:33:00', '2017-11-03 10:33:00'), ('59', '0', '一级菜单', '权限控制', null, null, '0', 'fa fa-user-circle', '2', '0', '2018-03-19 17:25:20', '2018-03-19 17:39:06'), ('60', '1', '系统管理', '博客设置', 'modules/sys/settings.html', 'admin_sys_setting', '1', 'fa fa-cog', '1', '0', '2018-03-19 17:32:17', '2018-03-19 17:44:06'), ('61', '1', '系统管理', '导航管理', 'modules/sys/nav', 'modules:sys:nav', '1', 'fa fa-bars', '3', '0', '2018-03-22 16:18:47', '2018-03-22 16:18:47'), ('62', '1', '系统管理', '信息板管理', '/admin/modules/sys/infoBoard.html', 'sys:infoBoard', '1', 'fa fa-info', '3', '0', '2018-03-23 22:46:15', '2018-03-23 22:46:15'), ('64', '1', '系统管理', '分类管理', 'modules/sys/category.html', 'sys:category', '1', 'fa fa-coffee', '5', '0', '2018-03-25 14:58:31', '2018-03-25 16:32:20');
COMMIT;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'roleId',
  `role_code` varchar(255) NOT NULL COMMENT '角色code',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `status` tinyint(11) NOT NULL DEFAULT '0' COMMENT '取值范围：{0:正常,1:停用}',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', 'admin', '管理员', '0', '2017-10-19 10:55:39', '2017-10-19 10:55:43'), ('2', 'common', '普通会员', '0', '2017-10-19 10:56:52', '2017-10-19 10:56:55');
COMMIT;

-- ----------------------------
--  Table structure for `role_resource_rel`
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_rel`;
CREATE TABLE `role_resource_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:正常 1:可用',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role_resource_rel`
-- ----------------------------
BEGIN;
INSERT INTO `role_resource_rel` VALUES ('1', '2', '2', '0', '2017-10-19 14:55:30', '2017-10-19 14:55:32'), ('2', '1', '1', '0', '2017-10-19 14:55:40', '2017-10-19 14:55:43'), ('3', '1', '2', '0', '2017-10-25 10:00:41', '2017-10-25 10:00:44'), ('4', '1', '3', '0', '2017-10-25 10:01:16', '2017-10-25 10:01:19'), ('5', '1', '4', '0', '2017-10-25 10:02:19', '2017-10-25 10:02:22'), ('6', '1', '5', '0', '2017-10-25 10:02:29', '2017-10-25 10:02:31'), ('7', '1', '6', '0', '2017-10-25 10:02:40', '2017-10-25 10:02:42'), ('9', '1', '8', '0', '2017-10-25 10:32:42', '2017-10-25 10:32:45'), ('10', '1', '9', '0', '2017-10-25 10:32:52', '2017-10-25 10:32:54'), ('11', '1', '10', '0', '2017-10-25 10:33:02', '2017-10-25 10:33:04'), ('12', '1', '11', '0', '2017-10-25 10:33:11', '2017-10-25 10:33:14'), ('13', '1', '12', '0', '2017-10-25 10:37:54', '2017-10-25 10:37:56'), ('14', '1', '13', '0', '2017-10-25 10:38:03', '2017-10-25 10:38:06'), ('15', '1', '14', '0', '2017-10-25 10:38:16', '2017-10-25 10:38:18'), ('16', '1', '15', '0', '2017-10-25 10:38:45', '2017-10-25 10:38:48'), ('17', '1', '16', '0', '2017-10-25 10:38:55', '2017-10-25 10:38:58');
COMMIT;

-- ----------------------------
--  Table structure for `schedule_job`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
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

-- ----------------------------
--  Records of `schedule_job`
-- ----------------------------
BEGIN;
INSERT INTO `schedule_job` VALUES ('4', 'testTask', 'test', null, '0/5 * * * * ? ', null, '1', '2017-11-03 15:39:14', '2017-11-08 09:47:31');
COMMIT;

-- ----------------------------
--  Table structure for `schedule_job_log`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
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
) ENGINE=InnoDB AUTO_INCREMENT=59365 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
--  Table structure for `text_settings`
-- ----------------------------
DROP TABLE IF EXISTS `text_settings`;
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
  `announcement` text COMMENT '公告信息',
  `leave_word_announcement` varchar(255) DEFAULT NULL COMMENT '留言公告信息',
  `icon_url` varchar(100) NOT NULL COMMENT 'http://iconfont.cn/manage/index?spm=a313x.7781069.1998910419.11&manage_type=myprojects&projectId=601117 最新地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `text_settings`
-- ----------------------------
BEGIN;
INSERT INTO `text_settings` VALUES ('1', '2018-03-21 11:31:30', '2018-03-21 11:31:32', '的博客', '克己的博客', '有志，则不甘为下流；有识，则只学问之无尽;有恒，则断无不成之事', '克己的博客', '搜一搜', 'icon-search', '1', '1', '<li>网站名称：克己的博客</li><li>博客系统：<a href=\"//github.com/miyakowork\" target=\"_blank\"style=\"font-style: italic;\"><i class=\"layui-icon\">&#xe628;</i> NoteBlog</a></li><li>qq群：123456789</li><li>前端UI：<a href=\"//layui.com\" target=\"_blank\">layui 2.x</a></li><li>后端架构：<a href=\"https://projects.spring.io/spring-boot/\" target=\"_blank\">SpringBoot</a> 1.5.9 系列等</li>', '1111', '//at.alicdn.com/t/font_601117_r68dogh1ev1jor.js');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
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

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'admin@qq.com', '克己', 'admin', '啥时候脱单？', '等我完成100功', null, null, null, null, '1', '2017-08-07 11:13:00', '2017-08-07 11:13:02'), ('2', '123@qq.com', '克己', '2870386', '你小时候最好的朋友', '123', null, '10.63.14.102', null, '17671689099', '1', '2017-08-07 17:04:43', '2017-10-26 15:26:02'), ('5', 'nieyinie2008@163.com', '聂毅', '2870386', null, null, null, null, null, '17671689059', '1', '2017-10-26 11:08:28', '2017-10-26 15:26:01');
COMMIT;

-- ----------------------------
--  Table structure for `user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rel`;
CREATE TABLE `user_role_rel` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(255) NOT NULL,
  `role_id` bigint(255) NOT NULL,
  `status` tinyint(11) NOT NULL DEFAULT '0' COMMENT '0:正常 1:停用',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_role_rel`
-- ----------------------------
BEGIN;
INSERT INTO `user_role_rel` VALUES ('1', '1', '1', '0', '2017-10-19 10:57:25', '2017-10-19 10:57:28'), ('2', '2', '2', '0', '2017-10-19 10:57:37', '2017-10-19 10:57:39'), ('3', '5', '2', '0', '2017-10-26 11:08:31', '2017-10-26 11:08:31'), ('4', '6', '2', '0', '2017-10-26 14:30:03', '2017-10-26 14:30:03');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
