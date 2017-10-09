/*
Navicat MySQL Data Transfer

Source Server         : blog-keji
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : blog_keji

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-18 19:36:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `article_title` varchar(255) NOT NULL COMMENT '文章标题',
  `article_content` text COMMENT '文章内容',
  `article_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章状态，0：正常；1：删除',
  `article_isTop` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否置顶，0：置顶；1：不置顶',
  `user_id` bigint(20) NOT NULL COMMENT '发表用户',
  `category_id` bigint(20) NOT NULL,
  `article_created` datetime NOT NULL COMMENT '创建时间',
  `article_updated` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`article_id`),
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_7` (`category_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `blog_user` (`user_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('1', '第一篇', '123', '0', '1', '1', '1', '2017-08-07 15:01:24', '2017-08-07 15:01:26');

-- ----------------------------
-- Table structure for blog_article_ext
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_ext`;
CREATE TABLE `blog_article_ext` (
  `ext_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ext_good` int(11) DEFAULT NULL COMMENT '文章顶数量',
  `ext_bad` int(11) DEFAULT NULL COMMENT '文章踩数量',
  `article_id` bigint(20) NOT NULL,
  `ext_create` datetime NOT NULL,
  `ext_updated` datetime NOT NULL,
  PRIMARY KEY (`ext_id`),
  KEY `FK_Reference_2` (`article_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章的扩展属性表：图片 点击量 顶 踩等';

-- ----------------------------
-- Records of blog_article_ext
-- ----------------------------

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  `category_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0表示正常，1表示删除',
  `category_url` varchar(255) DEFAULT NULL,
  `category_orderNum` int(11) NOT NULL DEFAULT '1' COMMENT '数值越低，优先级越大',
  `category_isParent` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否是父节点:0表示是，1表示不是',
  `categpry_parentId` bigint(20) NOT NULL DEFAULT '0',
  `category_created` datetime NOT NULL,
  `category_updated` datetime NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('1', '首页', '0', '/index', '1', '1', '0', '2017-08-07 15:01:46', '2017-08-07 15:01:49');
INSERT INTO `blog_category` VALUES ('2', '后台', '0', '/backstage/index', '1', '0', '1', '2017-08-07 16:14:15', '2017-08-07 16:14:15');
INSERT INTO `blog_category` VALUES ('3', 'test', '0', null, '1', '0', '1', '2017-09-13 12:32:35', '2017-09-13 12:32:35');

-- ----------------------------
-- Table structure for blog_comments
-- ----------------------------
DROP TABLE IF EXISTS `blog_comments`;
CREATE TABLE `blog_comments` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_content` text,
  `article_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `comment_created` datetime NOT NULL,
  `comment_updated` datetime NOT NULL,
  `comment_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '评论状态 0：正常，1：删除',
  PRIMARY KEY (`comment_id`),
  KEY `FK_Reference_3` (`article_id`),
  KEY `FK_Reference_4` (`user_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`article_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `blog_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of blog_comments
-- ----------------------------

-- ----------------------------
-- Table structure for blog_hits
-- ----------------------------
DROP TABLE IF EXISTS `blog_hits`;
CREATE TABLE `blog_hits` (
  `hits_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) DEFAULT NULL,
  `hit_count` bigint(20) DEFAULT NULL,
  `hits_created` datetime DEFAULT NULL,
  `hits_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`hits_id`),
  KEY `FK_Reference_5` (`article_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点击量表';

-- ----------------------------
-- Records of blog_hits
-- ----------------------------

-- ----------------------------
-- Table structure for blog_picture
-- ----------------------------
DROP TABLE IF EXISTS `blog_picture`;
CREATE TABLE `blog_picture` (
  `picture_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `picture_name` varchar(50) DEFAULT NULL,
  `picture_resource` varchar(255) NOT NULL COMMENT '图片地址',
  `picture_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '图片状态',
  `picture_orderNum` int(11) DEFAULT '1' COMMENT '排序',
  `article_id` bigint(20) NOT NULL,
  `picture_created` datetime NOT NULL,
  `picture_updated` datetime NOT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `FK_Reference_6` (`article_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
-- Records of blog_picture
-- ----------------------------
INSERT INTO `blog_picture` VALUES ('1', '首页图片轮播1', '/images/001.jpg', '1', '1', '1', '2017-08-07 14:57:35', '2017-08-07 14:57:38');
INSERT INTO `blog_picture` VALUES ('2', '首页图片轮播1', '/images/002.jpg', '0', '1', '1', '2017-08-07 15:05:55', '2017-08-07 15:05:58');
INSERT INTO `blog_picture` VALUES ('3', '首页图片轮播3', '/images/003.jpg', '0', '1', '1', '2017-08-07 15:06:35', '2017-08-07 15:06:38');
INSERT INTO `blog_picture` VALUES ('4', '首页图片轮播4', '/images/004.jpg', '0', '1', '1', '2017-08-07 15:07:05', '2017-08-07 15:07:09');
INSERT INTO `blog_picture` VALUES ('5', '首页图片轮播5', '/images/005.jpg', '0', '1', '1', '2017-08-07 15:19:52', '2017-08-07 15:19:58');

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) NOT NULL COMMENT '登录用户名',
  `user_nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `user_password` varchar(20) NOT NULL COMMENT '登录密码',
  `user_question` varchar(255) DEFAULT NULL COMMENT '密码保护问题',
  `user_answer` varchar(255) DEFAULT NULL COMMENT '答案',
  `user_picture` varchar(255) DEFAULT NULL COMMENT '头像',
  `user_status` tinyint(1) DEFAULT '0' COMMENT '用户状态，0表示正常1表示封禁',
  `user_ip` varchar(255) DEFAULT NULL COMMENT '上次登录的ip',
  `user_created` datetime NOT NULL,
  `user_updated` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('1', 'admin', '克己', 'admin', '啥时候脱单？', '等我完成100功', null, '0', null, '2017-08-07 11:13:00', '2017-08-07 11:13:02');
INSERT INTO `blog_user` VALUES ('2', '798631828@qq.com', null, '2870386', null, null, null, '0', '10.63.14.102', '2017-08-07 17:04:43', '2017-08-07 17:04:43');
INSERT INTO `blog_user` VALUES ('3', '123', '', '', null, null, null, '0', '10.63.14.102', '2017-08-07 17:44:46', '2017-08-07 17:44:46');
