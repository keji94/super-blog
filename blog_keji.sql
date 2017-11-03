/*
Navicat MySQL Data Transfer

Source Server         : blog-keji
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : blog_keji

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-03 17:43:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
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
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '第一篇', '123', '0', '1', '1', '1', '2017-08-07 15:01:24', '2017-08-07 15:01:26');

-- ----------------------------
-- Table structure for article_ext
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
-- Records of article_ext
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0表示正常，1表示删除',
  `url` varchar(255) DEFAULT NULL,
  `order_num` int(11) NOT NULL DEFAULT '1' COMMENT '数值越低，优先级越大',
  `is_parent` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否是父节点:0表示是，1表示不是',
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '首页', '0', '/index', '1', '1', '0', '2017-08-07 15:01:46', '2017-08-07 15:01:49');
INSERT INTO `category` VALUES ('2', '后台', '0', '/backstage/index', '1', '0', '1', '2017-08-07 16:14:15', '2017-08-07 16:14:15');
INSERT INTO `category` VALUES ('3', 'test', '0', null, '1', '0', '1', '2017-09-13 12:32:35', '2017-09-13 12:32:35');

-- ----------------------------
-- Table structure for comments
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
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for hits
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
-- Records of hits
-- ----------------------------

-- ----------------------------
-- Table structure for picture
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
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', '首页图片轮播1', '/images/001.jpg', '1', '1', '1', '2017-08-07 14:57:35', '2017-08-07 14:57:38');
INSERT INTO `picture` VALUES ('2', '首页图片轮播1', '/images/002.jpg', '0', '1', '1', '2017-08-07 15:05:55', '2017-08-07 15:05:58');
INSERT INTO `picture` VALUES ('3', '首页图片轮播3', '/images/003.jpg', '0', '1', '1', '2017-08-07 15:06:35', '2017-08-07 15:06:38');
INSERT INTO `picture` VALUES ('4', '首页图片轮播4', '/images/004.jpg', '0', '1', '1', '2017-08-07 15:07:05', '2017-08-07 15:07:09');
INSERT INTO `picture` VALUES ('5', '首页图片轮播5', '/images/005.jpg', '0', '1', '1', '2017-08-07 15:19:52', '2017-08-07 15:19:58');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
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
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
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
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', '0/5 * * * * ? ', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
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
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
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
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', null, 'com.keji.blog.util.schedule.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720026636F6D2E6B656A692E626C6F672E646174616F626A6563742E5363686564756C654A6F62444F26F5E3308839E4500200094C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000A676D74437265617465647400104C6A6176612F7574696C2F446174653B4C000B676D744D6F64696669656471007E000A4C000269647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B74000E302F35202A202A202A202A203F2070707372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000004740004746573747070737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0011000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
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
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'MININT-LGP9OM31509694809902', '1509702194384', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
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
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
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
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
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
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', 'TASK_4', 'DEFAULT', null, '1509695735000', '1509695730000', '5', 'PAUSED', 'CRON', '1509694754000', '0', null, '2', '');

-- ----------------------------
-- Table structure for requirement
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
-- Records of requirement
-- ----------------------------
INSERT INTO `requirement` VALUES ('6', 'CodeReview', '前面完成了权限管理以及需求管理，可以先review一下代码', null, '2', '2017-10-31 10:20:43', '2017-11-03 16:08:11');
INSERT INTO `requirement` VALUES ('10', '定时任务需求', '移植renren项目的定时任务', '定时任务的相关知识还需要学习', '2', '2017-11-01 14:43:38', '2017-11-03 16:09:49');
INSERT INTO `requirement` VALUES ('11', '定时任务有一个线程池操作，灵狐警告了，改掉', '学习总结java线程池相关知识', null, '1', '2017-11-03 16:09:15', '2017-11-03 16:09:15');

-- ----------------------------
-- Table structure for resource
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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '0', null, '系统管理', '/**', '', '0', 'fa fa-cog', '0', '0', '2017-10-19 14:54:31', '2017-11-02 15:01:52');
INSERT INTO `resource` VALUES ('2', '1', '系统管理', '用户管理', 'modules/sys/user.html', '', '1', 'fa fa-user', '1', '0', '2017-10-20 09:49:06', '2017-10-20 09:49:09');
INSERT INTO `resource` VALUES ('3', '1', '系统管理', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '2', '0', '2017-10-24 15:44:07', '2017-10-24 15:44:11');
INSERT INTO `resource` VALUES ('4', '3', '菜单管理', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0', '0', '2017-10-24 20:34:36', '2017-10-24 20:34:38');
INSERT INTO `resource` VALUES ('5', '3', '菜单管理', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0', '0', '2017-10-24 20:35:18', '2017-10-24 20:35:21');
INSERT INTO `resource` VALUES ('6', '3', '菜单管理', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0', '0', '2017-10-24 20:35:50', '2017-10-24 20:35:54');
INSERT INTO `resource` VALUES ('7', '3', '菜单管理', '删除', null, 'sys:menu:delete', '2', null, '0', '0', '2017-10-24 20:36:27', '2017-10-24 20:36:30');
INSERT INTO `resource` VALUES ('8', '2', '用户管理', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0', '0', '2017-10-25 10:30:47', '2017-10-25 10:30:50');
INSERT INTO `resource` VALUES ('9', '2', '用户管理', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0', '0', '2017-10-25 10:31:21', '2017-10-25 10:31:23');
INSERT INTO `resource` VALUES ('10', '2', '用户管理', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0', '0', '2017-10-25 10:31:53', '2017-10-25 10:31:55');
INSERT INTO `resource` VALUES ('11', '2', '用户管理', '删除', null, 'sys:role:delete', '2', null, '0', '0', '2017-10-25 10:32:18', '2017-10-25 10:32:21');
INSERT INTO `resource` VALUES ('12', '1', '系统管理', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '3', '0', '2017-10-25 10:34:56', '2017-10-30 09:55:26');
INSERT INTO `resource` VALUES ('13', '12', '角色管理', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0', '0', '2017-10-25 10:36:27', '2017-10-25 10:36:29');
INSERT INTO `resource` VALUES ('14', '12', '角色管理', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0', '0', '2017-10-25 10:36:50', '2017-10-25 10:36:52');
INSERT INTO `resource` VALUES ('15', '12', '角色管理', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0', '0', '2017-10-25 10:37:10', '2017-10-25 10:37:12');
INSERT INTO `resource` VALUES ('16', '12', '角色管理', '删除', null, 'sys:user:delete', '2', null, '0', '0', '2017-10-25 10:37:30', '2017-10-25 10:37:33');
INSERT INTO `resource` VALUES ('46', '1', '系统管理', '需求管理', 'modules/sys/requirement.html', '', '1', 'fa fa-list', '0', '0', '2017-10-30 17:14:02', '2017-11-02 15:03:26');
INSERT INTO `resource` VALUES ('47', '46', '需求管理', '新增', null, 'sys:requirement:save,sys:requirement:select', '2', null, '0', '0', '2017-10-30 17:48:48', '2017-10-30 17:50:03');
INSERT INTO `resource` VALUES ('48', '46', '需求管理', '修改', null, 'sys:requirement:update,sys:requirement:select', '2', null, '0', '0', '2017-10-30 17:49:47', '2017-10-30 17:49:47');
INSERT INTO `resource` VALUES ('49', '46', '需求管理', '删除', null, 'sys:requirement:delete,sys:requirement:select', '2', null, '0', '0', '2017-10-30 17:50:32', '2017-10-30 17:50:32');
INSERT INTO `resource` VALUES ('50', '1', '系统管理', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5', '0', '2017-11-02 15:01:52', '2017-11-03 10:33:16');
INSERT INTO `resource` VALUES ('51', '50', '定时任务', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0', '0', '2017-11-02 15:41:32', '2017-11-02 15:41:32');
INSERT INTO `resource` VALUES ('52', '50', '定时任务', '新增', null, 'sys:schedule:save', '2', null, '0', '0', '2017-11-02 15:41:51', '2017-11-02 15:41:51');
INSERT INTO `resource` VALUES ('53', '50', '定时任务', '修改', null, 'sys:schedule:update', '2', null, '0', '0', '2017-11-02 15:42:07', '2017-11-02 15:42:07');
INSERT INTO `resource` VALUES ('54', '50', '定时任务', '删除', null, 'sys:schedule:delete', '2', null, '0', '0', '2017-11-02 15:42:19', '2017-11-02 15:42:19');
INSERT INTO `resource` VALUES ('55', '50', '定时任务', '暂停', null, 'sys:schedule:pause', '2', null, '0', '0', '2017-11-02 15:42:34', '2017-11-02 15:42:34');
INSERT INTO `resource` VALUES ('56', '50', '定时任务', '恢复', null, 'sys:schedule:resume', '2', null, '0', '0', '2017-11-02 15:42:48', '2017-11-03 10:32:22');
INSERT INTO `resource` VALUES ('57', '50', '定时任务', '日志列表', null, 'sys:schedule:log', '2', null, '0', '0', '2017-11-02 15:43:11', '2017-11-02 15:43:11');
INSERT INTO `resource` VALUES ('58', '50', '定时任务', '立即执行', null, 'sys:schedule:run', '2', null, '0', '0', '2017-11-03 10:33:00', '2017-11-03 10:33:00');

-- ----------------------------
-- Table structure for role
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员', '0', '2017-10-19 10:55:39', '2017-10-19 10:55:43');
INSERT INTO `role` VALUES ('2', 'common', '普通会员', '0', '2017-10-19 10:56:52', '2017-10-19 10:56:55');

-- ----------------------------
-- Table structure for role_resource_rel
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
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource_rel
-- ----------------------------
INSERT INTO `role_resource_rel` VALUES ('1', '2', '2', '0', '2017-10-19 14:55:30', '2017-10-19 14:55:32');
INSERT INTO `role_resource_rel` VALUES ('2', '1', '1', '0', '2017-10-19 14:55:40', '2017-10-19 14:55:43');
INSERT INTO `role_resource_rel` VALUES ('3', '1', '2', '0', '2017-10-25 10:00:41', '2017-10-25 10:00:44');
INSERT INTO `role_resource_rel` VALUES ('4', '1', '3', '0', '2017-10-25 10:01:16', '2017-10-25 10:01:19');
INSERT INTO `role_resource_rel` VALUES ('5', '1', '4', '0', '2017-10-25 10:02:19', '2017-10-25 10:02:22');
INSERT INTO `role_resource_rel` VALUES ('6', '1', '5', '0', '2017-10-25 10:02:29', '2017-10-25 10:02:31');
INSERT INTO `role_resource_rel` VALUES ('7', '1', '6', '0', '2017-10-25 10:02:40', '2017-10-25 10:02:42');
INSERT INTO `role_resource_rel` VALUES ('9', '1', '8', '0', '2017-10-25 10:32:42', '2017-10-25 10:32:45');
INSERT INTO `role_resource_rel` VALUES ('10', '1', '9', '0', '2017-10-25 10:32:52', '2017-10-25 10:32:54');
INSERT INTO `role_resource_rel` VALUES ('11', '1', '10', '0', '2017-10-25 10:33:02', '2017-10-25 10:33:04');
INSERT INTO `role_resource_rel` VALUES ('12', '1', '11', '0', '2017-10-25 10:33:11', '2017-10-25 10:33:14');
INSERT INTO `role_resource_rel` VALUES ('13', '1', '12', '0', '2017-10-25 10:37:54', '2017-10-25 10:37:56');
INSERT INTO `role_resource_rel` VALUES ('14', '1', '13', '0', '2017-10-25 10:38:03', '2017-10-25 10:38:06');
INSERT INTO `role_resource_rel` VALUES ('15', '1', '14', '0', '2017-10-25 10:38:16', '2017-10-25 10:38:18');
INSERT INTO `role_resource_rel` VALUES ('16', '1', '15', '0', '2017-10-25 10:38:45', '2017-10-25 10:38:48');
INSERT INTO `role_resource_rel` VALUES ('17', '1', '16', '0', '2017-10-25 10:38:55', '2017-10-25 10:38:58');

-- ----------------------------
-- Table structure for schedule_job
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
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('4', 'testTask', 'test', null, '0/5 * * * * ? ', null, '1', '2017-11-03 15:39:14', '2017-11-03 15:55:33');

-- ----------------------------
-- Table structure for schedule_job_log
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
) ENGINE=InnoDB AUTO_INCREMENT=13192 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('13187', '4', 'testTask', 'test', null, null, '5', '0', '2017-11-03 15:55:10', '2017-11-03 15:55:10');
INSERT INTO `schedule_job_log` VALUES ('13188', '4', 'testTask', 'test', null, null, '3', '0', '2017-11-03 15:55:15', '2017-11-03 15:55:15');
INSERT INTO `schedule_job_log` VALUES ('13189', '4', 'testTask', 'test', null, null, '5', '0', '2017-11-03 15:55:20', '2017-11-03 15:55:20');
INSERT INTO `schedule_job_log` VALUES ('13190', '4', 'testTask', 'test', null, null, '1', '0', '2017-11-03 15:55:25', '2017-11-03 15:55:25');
INSERT INTO `schedule_job_log` VALUES ('13191', '4', 'testTask', 'test', null, null, '3', '0', '2017-11-03 15:55:30', '2017-11-03 15:55:30');

-- ----------------------------
-- Table structure for user
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
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin@qq.com', '克己', 'admin', '啥时候脱单？', '等我完成100功', null, null, null, null, '0', '2017-08-07 11:13:00', '2017-08-07 11:13:02');
INSERT INTO `user` VALUES ('2', '123@qq.com', '克己', '2870386', '你小时候最好的朋友', '123', null, '10.63.14.102', null, '17671689099', '1', '2017-08-07 17:04:43', '2017-10-26 15:26:02');
INSERT INTO `user` VALUES ('5', 'nieyinie2008@163.com', '聂毅', '2870386', null, null, null, null, null, '17671689059', '1', '2017-10-26 11:08:28', '2017-10-26 15:26:01');

-- ----------------------------
-- Table structure for user_role_rel
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
-- Records of user_role_rel
-- ----------------------------
INSERT INTO `user_role_rel` VALUES ('1', '1', '1', '0', '2017-10-19 10:57:25', '2017-10-19 10:57:28');
INSERT INTO `user_role_rel` VALUES ('2', '2', '2', '0', '2017-10-19 10:57:37', '2017-10-19 10:57:39');
INSERT INTO `user_role_rel` VALUES ('3', '5', '2', '0', '2017-10-26 11:08:31', '2017-10-26 11:08:31');
INSERT INTO `user_role_rel` VALUES ('4', '6', '2', '0', '2017-10-26 14:30:03', '2017-10-26 14:30:03');
