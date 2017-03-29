/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : wuya

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-03-29 09:02:09
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
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answerId` varchar(255) NOT NULL DEFAULT '' COMMENT '回答id',
  `questionId` varchar(255) DEFAULT '' COMMENT '问题id',
  `uid` varchar(255) DEFAULT '' COMMENT 'uid',
  `answerInfo` varchar(10240) DEFAULT '' COMMENT 'answerInfo',
  `answerTime` bigint(20) DEFAULT NULL,
  `status` int(2) DEFAULT '1' COMMENT '默认 1 删除0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `focusId` varchar(255) DEFAULT '' COMMENT 'focusId',
  `uid` varchar(255) DEFAULT '' COMMENT 'userid',
  `focusType` int(2) DEFAULT '0' COMMENT 'focusType 默认 0',
  `id` varchar(255) DEFAULT '' COMMENT 'focus 的 id',
  `focusTime` bigint(255) DEFAULT '0' COMMENT '默认0',
  `status` int(2) DEFAULT '1' COMMENT '状态 默认1 失效0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of focus
-- ----------------------------

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `uid` varchar(255) DEFAULT NULL,
  `anotherUid` varchar(255) DEFAULT NULL,
  `friendTime` bigint(255) DEFAULT NULL,
  `status` int(2) DEFAULT '1' COMMENT '默认1.生效 0.失效'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `likeId` varchar(255) NOT NULL DEFAULT '' COMMENT 'like id',
  `uid` varchar(255) DEFAULT '' COMMENT 'user id',
  `answerId` varchar(255) DEFAULT '' COMMENT '回答id',
  `likeTime` bigint(255) DEFAULT '0' COMMENT '点赞时间 默认0',
  `status` int(2) DEFAULT '1' COMMENT '默认1生效 0失效',
  PRIMARY KEY (`likeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `questionId` varchar(255) NOT NULL DEFAULT '' COMMENT 'questionId',
  `uid` varchar(255) DEFAULT '' COMMENT 'uid',
  `questionInfo` varchar(10240) DEFAULT '' COMMENT 'questionInfo',
  `topicId` varchar(255) DEFAULT '' COMMENT 'topicId',
  `questionTime` bigint(255) DEFAULT '0' COMMENT '提出问题时间 默认0',
  `status` int(2) DEFAULT '1' COMMENT '状态 默认1生效',
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `reportId` varchar(255) NOT NULL DEFAULT '' COMMENT 'reportId',
  `uid` varchar(255) DEFAULT '' COMMENT 'uid',
  `reportType` int(2) DEFAULT '0' COMMENT 'focusType 默认0',
  `id` varchar(255) DEFAULT '' COMMENT 'id ',
  `reportInfo` varchar(10240) DEFAULT '' COMMENT 'reportInfo',
  `reportTime` bigint(255) DEFAULT '0' COMMENT 'reportTime 默认0',
  `status` int(2) DEFAULT '1' COMMENT 'status 默认1 生效',
  PRIMARY KEY (`reportId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for secret_question
-- ----------------------------
DROP TABLE IF EXISTS `secret_question`;
CREATE TABLE `secret_question` (
  `questionId` varchar(255) NOT NULL DEFAULT '0' COMMENT '密保问题id 随机产生',
  `uid` varchar(255) NOT NULL DEFAULT '' COMMENT '用户id',
  `questionInfo` varchar(255) DEFAULT '' COMMENT '问题详情',
  `answerInfo` varchar(255) DEFAULT '' COMMENT '密保问题答案',
  `status` int(2) DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`questionId`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of secret_question
-- ----------------------------
INSERT INTO `secret_question` VALUES ('1', '1', '1', '1', null);
INSERT INTO `secret_question` VALUES ('2', '2', '2', '2', null);
INSERT INTO `secret_question` VALUES ('3', '1', '3', '3', null);
INSERT INTO `secret_question` VALUES ('4', '1', '学号？', '2013142202', null);
INSERT INTO `secret_question` VALUES ('tt', 'tt', '测试', '无题', null);
INSERT INTO `secret_question` VALUES ('tt2', 'tt', '测试2', '无题2', '11');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `shareId` varchar(255) NOT NULL DEFAULT '' COMMENT 'shareId',
  `uid` varchar(255) DEFAULT '' COMMENT 'uid',
  `shareType` int(2) DEFAULT '0' COMMENT 'shareType 默认0',
  `id` varchar(255) DEFAULT NULL,
  `shareTime` bigint(255) DEFAULT '0' COMMENT 'shareTime 默认0',
  `status` int(2) DEFAULT '1' COMMENT 'status 默认1',
  PRIMARY KEY (`shareId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share
-- ----------------------------

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topicId` varchar(255) NOT NULL DEFAULT '' COMMENT 'topicId',
  `uid` varchar(255) DEFAULT '' COMMENT 'uid',
  `topicName` varchar(255) DEFAULT '' COMMENT 'topicName',
  `topicPic` varchar(255) DEFAULT '' COMMENT 'topicPic',
  `topicTime` bigint(255) DEFAULT '0' COMMENT 'topicTime 默认0',
  `status` int(2) DEFAULT '1' COMMENT 'status 默认1',
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(255) NOT NULL DEFAULT '' COMMENT '用户唯一id',
  `loginName` varchar(255) NOT NULL DEFAULT '' COMMENT '用户登录名',
  `pwd` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  `bind_email` varchar(255) DEFAULT '' COMMENT '绑定邮箱账号',
  `email_code` varchar(255) DEFAULT '' COMMENT '邮箱验证码存放',
  `nickName` varchar(255) DEFAULT '' COMMENT '用户昵称',
  `sex` int(2) DEFAULT '1' COMMENT '性别 默认1->男 0->女',
  `signature` varchar(255) DEFAULT '' COMMENT '个性签名',
  `profile` varchar(255) DEFAULT '' COMMENT '用户个人简介',
  `location` varchar(255) DEFAULT '' COMMENT '居住地',
  `headPic` varchar(255) DEFAULT '' COMMENT '头像',
  `birth` bigint(255) DEFAULT '0' COMMENT '生日',
  `regTime` bigint(255) DEFAULT NULL COMMENT '注册时间',
  `banTime` bigint(255) DEFAULT '0' COMMENT '封号时间点',
  `status` int(2) DEFAULT '-1' COMMENT '用户账号状态 -1未激活 0 正常 1封号',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2013142203', 'cyy2', 'cyy10208023cy', '1079276272@qq.com', '123123', 'Cinyky', '1', 'i\'m a boy', 'haha', 'China', 'asd', '0', '0', '0', '1');
INSERT INTO `user` VALUES ('2013142204', 'cyy3', '9ac81ed1a7aeb8e442c3596a229776aa', '1079276272@qq.com', '123123', 'Cinyky', '1', 'i\'m a boy', 'haha', 'China', 'asd', '0', '0', '0', '1');
