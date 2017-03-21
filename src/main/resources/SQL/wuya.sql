/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : wuya

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-03-21 18:34:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uid` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员id',
  `loginName` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员登录名',
  `pwd` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(255) NOT NULL DEFAULT '' COMMENT '用户唯一id',
  `loginName` varchar(255) NOT NULL DEFAULT '' COMMENT '用户登录名',
  `pwd` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  `nickName` varchar(255) DEFAULT '' COMMENT '用户昵称',
  `sex` int(2) DEFAULT '1' COMMENT '性别 默认1->男 0->女',
  `signature` varchar(255) DEFAULT '' COMMENT '个性签名',
  `birth` bigint(255) DEFAULT '0' COMMENT '生日',
  `location` varchar(255) DEFAULT '' COMMENT '居住地',
  `headPic` varchar(255) DEFAULT '' COMMENT '头像',
  `regTime` bigint(255) DEFAULT NULL COMMENT '注册时间',
  `status` int(2) DEFAULT '-1' COMMENT '用户账号状态 -1未激活 0 正常 1封号',
  `banTime` bigint(255) DEFAULT '0' COMMENT '封号时间点',
  `profile` varchar(255) DEFAULT '' COMMENT '用户个人简介',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
