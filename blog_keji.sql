/*
Navicat MySQL Data Transfer

Source Server         : blog-keji
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : blog_keji

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-23 11:53:20
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
-- Table structure for requirement
-- ----------------------------
DROP TABLE IF EXISTS `requirement`;
CREATE TABLE `requirement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '需求表',
  `title` varchar(255) NOT NULL COMMENT '需求的标题',
  `content` text COMMENT '需求内容',
  `summarize` text COMMENT '完成总结',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requirement
-- ----------------------------

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `parent_id` bigint(20) DEFAULT NULL,
  `resource_name` varchar(255) NOT NULL,
  `resource_code` varchar(255) NOT NULL COMMENT '资源code',
  `resource_url` varchar(255) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:正常 1:停用',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '0', '所有资源', 'admin', '/**', '0', '2017-10-19 14:54:31', '2017-10-19 14:54:34');
INSERT INTO `resource` VALUES ('2', '0', '普通', 'common', null, '0', '2017-10-20 09:49:06', '2017-10-20 09:49:09');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource_rel
-- ----------------------------
INSERT INTO `role_resource_rel` VALUES ('1', '2', '2', '0', '2017-10-19 14:55:30', '2017-10-19 14:55:32');
INSERT INTO `role_resource_rel` VALUES ('2', '1', '1', '0', '2017-10-19 14:55:40', '2017-10-19 14:55:43');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `email` varchar(255) NOT NULL COMMENT '登录邮箱',
  `name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin@qq.com', '克己', 'admin', '啥时候脱单？', '等我完成100功', null, null, null, null, '0', '2017-08-07 11:13:00', '2017-08-07 11:13:02');
INSERT INTO `user` VALUES ('2', '123@qq.com', '克己', '2870386', '你小时候最好的朋友', '123', null, '10.63.14.102', null, null, '0', '2017-08-07 17:04:43', '2017-08-07 17:04:43');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_rel
-- ----------------------------
INSERT INTO `user_role_rel` VALUES ('1', '1', '1', '0', '2017-10-19 10:57:25', '2017-10-19 10:57:28');
INSERT INTO `user_role_rel` VALUES ('2', '2', '2', '0', '2017-10-19 10:57:37', '2017-10-19 10:57:39');
