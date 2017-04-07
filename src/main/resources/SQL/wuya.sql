/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : wuya

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-07 19:05:54
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
INSERT INTO `answer` VALUES ('37d16abf-94aa-4020-818c-1b1ada072f09', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', 'testInfo1', '1491462535272', '1');
INSERT INTO `answer` VALUES ('d2852c7f-1e21-41e5-ad81-1c5538c7b6b3', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', 'testInfo2', '1491462687252', '1');
INSERT INTO `answer` VALUES ('78dadd32-6c58-4591-ad65-e0e281226fec', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>请输入内容...</p>\n              <p>123213123<img src=\"/wuya/upload/answer/88cd27c4-e146-478d-a4c0-15e2882c5bb9.jpg\" alt=\"headpic\" style=\"max-width: 100%;\">我也不知道 测试回答</p><p><br></p>', '1491546272030', '1');
INSERT INTO `answer` VALUES ('6d9ca932-22ad-4f65-b63a-900a1397e310', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p><br></p>\n              <p><img src=\"/wuya/upload/answer/2d38ee98-8ef8-495f-a985-7f8ea868e13e.jpg\" alt=\"headpic2\" style=\"max-width: 100%; width: 105px; height: 98px;\" class=\"\"><br>大家好啊 &nbsp;这个数字 很顺啊</p><p><br></p>', '1491547080975', '1');
INSERT INTO `answer` VALUES ('246a8345-b3e2-47c0-822b-30bce0b8b4a7', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p><br></p>\n              <p><img src=\"/wuya/upload/answer/2d38ee98-8ef8-495f-a985-7f8ea868e13e.jpg\" alt=\"headpic2\" style=\"max-width: 100%; width: 105px; height: 98px;\" class=\"\"><br>大家好啊 &nbsp;这个数字 很顺啊</p><p><br></p>', '1491547083014', '1');
INSERT INTO `answer` VALUES ('60682825-3769-4bbb-a447-5ee704f04dff', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p><ol><li>我不知道题主说的什么</li><li>这个命题不成立</li><li>哈哈哈</li></ol></p>\n              <p><br></p>', '1491547199394', '1');
INSERT INTO `answer` VALUES ('4fb90038-6592-46ef-b3f5-c24cf559d2e0', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c9/dindongjenliwu_thumb.gif\">给力啊</p>\n              <p><br></p>', '1491547611791', '1');
INSERT INTO `answer` VALUES ('e1753926-f039-4e1a-ae8f-2e06d640d87f', '394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3c/pcmoren_wu_thumb.png\">&nbsp;hahah&nbsp;<img src=\"http://api.map.baidu.com/staticimage?center=121.226791,31.021245&zoom=13&amp;width=478&amp;height=258&amp;markers=121.226791,31.021245\" style=\"max-width: 100%;\"></p>\n              <p><br></p>', '1491547787666', '1');
INSERT INTO `answer` VALUES ('7ba5be8d-6b85-45d5-b62c-70d829326600', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p><img src=\"/wuya/upload/answer/c6c08e27-3d7f-444c-92b3-c4fde28ae8a3.jpg\" alt=\"headpic\" style=\"max-width: 100%;\">沙发<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/tootha_thumb.gif\"></p>\n              <p><br></p>', '1491548073038', '1');
INSERT INTO `answer` VALUES ('3caa3aba-57ff-4963-9e47-003b5cf8f66e', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>请输入内容...<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/laugh.gif\"></p>\n              <p><br></p>', '1491548330778', '1');
INSERT INTO `answer` VALUES ('29d815d8-bd4d-4e6f-913c-a84341d492b9', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>请输入内容...<img src=\"http://api.map.baidu.com/staticimage?center=121.480237,31.236305&zoom=11&amp;width=478&amp;height=258\" style=\"max-width: 100%;\"></p>\n              <p><br></p>', '1491548491683', '1');
INSERT INTO `answer` VALUES ('73a63dc3-4924-4a7f-9d8d-2d0570e59333', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>answer answer</p>', '1491548656892', '1');
INSERT INTO `answer` VALUES ('fccce765-8397-4adf-a17b-79f9254de84d', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>...<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/huanglianwx_thumb.gif\"></p>\n              <p><br></p>', '1491548767365', '1');
INSERT INTO `answer` VALUES ('ecf74a93-b330-41c1-ace1-b325091bbb77', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>请输入内容...<img src=\"/wuya/upload/answer/4ddaf9dc-d40c-4d45-9533-12c424191321.jpg\" alt=\"bgimg\" style=\"max-width: 100%;\"></p>\n              <p><br></p>', '1491548796106', '1');
INSERT INTO `answer` VALUES ('44523771-cb96-4091-9b46-b0d6a99beea6', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>请输入内容...<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/huanglianwx_thumb.gif\"></p>\n              <p>qwqe</p>', '1491549080436', '1');
INSERT INTO `answer` VALUES ('9ba4fafe-875c-4b75-ad0f-a2dd66a57115', '7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>请输入内容...<img src=\"http://api.map.baidu.com/staticimage?center=121.48189,31.234939&zoom=18&amp;width=478&amp;height=258&amp;markers=121.414964,31.246502|121.423013,31.253417|121.423013,31.253417|121.409215,31.24255|121.408065,31.243538|121.431061,31.204999|121.504651,31.205988|121.482018,31.234723\" style=\"max-width: 100%;\"></p>\n              <p><br></p>', '1491549384318', '1');
INSERT INTO `answer` VALUES ('147bbe5a-0218-4a51-897a-866b5a5fe4d3', '394bf1aa-f386-4b22-92ad-bf9df19020e6', 'a643c7bc-ffe3-4675-8d10-79fa1de44b3d', '\n                  <p>请输入内容...<img src=\"/wuya/upload/answer/06a74f94-1409-44dc-80ba-03d9561158b0.jpg\" alt=\"headpic\" style=\"max-width: 100%;\"></p>\n              <p>adsasdas</p>', '1491554155259', '1');
INSERT INTO `answer` VALUES ('dc3377ef-a8f9-46be-8ab3-3018324fd0ac', '2791bb3c-8f89-420c-84d1-836d710c9a3f', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '\n                  <p>请输入内容...</p>\n              <p><img src=\"http://localhost:8080/wuya/emotions/default/6.gif\"><br></p><p><br></p>', '1491559093630', '1');

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
INSERT INTO `question` VALUES ('14ddf6d2-dd5d-4716-a2b4-14205b445062', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', 'php还能发展对酒？', '0', '1491477436205', '1');
INSERT INTO `question` VALUES ('2791bb3c-8f89-420c-84d1-836d710c9a3f', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '爱迪生阿萨德', '1', '1491381116366', '1');
INSERT INTO `question` VALUES ('394bf1aa-f386-4b22-92ad-bf9df19020e6', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', '如嫌疑人这部电影如何？', '3', '1491380990918', '1');
INSERT INTO `question` VALUES ('7959eb94-1471-4185-8d8d-5373012c856c', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', 'java前景？', '4', '1491380834533', '1');

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
INSERT INTO `topic` VALUES ('0', 'Cinyky', '默认话题', 'default_topic.jpg', '1491556865898', '1');
INSERT INTO `topic` VALUES ('1', 'Cinyky', '科技', 'default_topic.jpg', '1491556877218', '1');
INSERT INTO `topic` VALUES ('10', 'Cinyky', '旅游', 'default_topic.jpg', '1491556977184', '1');
INSERT INTO `topic` VALUES ('2', 'Cinyky', '游戏', 'default_topic.jpg', '1491556889124', '1');
INSERT INTO `topic` VALUES ('3', 'Cinyky', '运动', 'default_topic.jpg', '1491556900216', '1');
INSERT INTO `topic` VALUES ('4', 'Cinyky', '美食', 'default_topic.jpg', '1491556922347', '1');
INSERT INTO `topic` VALUES ('5', 'Cinyky', '汽车', 'default_topic.jpg', '1491556932410', '1');
INSERT INTO `topic` VALUES ('6', 'Cinyky', '动漫', 'default_topic.jpg', '1491556941210', '1');
INSERT INTO `topic` VALUES ('7', 'Cinyky', '电影', 'default_topic.jpg', '1491556950252', '1');
INSERT INTO `topic` VALUES ('8', 'Cinyky', '科学', 'default_topic.jpg', '1491556959403', '1');
INSERT INTO `topic` VALUES ('9', 'Cinyky', '历史', 'default_topic.jpg', '1491556969301', '1');

-- ----------------------------
-- Table structure for upvote
-- ----------------------------
DROP TABLE IF EXISTS `upvote`;
CREATE TABLE `upvote` (
  `upvoteId` varchar(255) NOT NULL DEFAULT '' COMMENT 'like id',
  `uid` varchar(255) DEFAULT '' COMMENT 'user id',
  `answerId` varchar(255) DEFAULT '' COMMENT '回答id',
  `upvoteTime` bigint(255) DEFAULT '0' COMMENT '点赞时间 默认0',
  `status` int(2) DEFAULT '1' COMMENT '默认1生效 0失效',
  PRIMARY KEY (`upvoteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upvote
-- ----------------------------
INSERT INTO `upvote` VALUES ('cc8d4e9a-531c-4b07-9dfd-5e001d3043e5', '7d9db1cf-cc01-461a-af7b-be98e9aea0c0', 'd2852c7f-1e21-41e5-ad81-1c5538c7b6b3', '1491472855539', '1');

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
INSERT INTO `user` VALUES ('7d9db1cf-cc01-461a-af7b-be98e9aea0c0', 'cyy2013142202', '5d4aa108dadc446fe849346a19b6563d', 'cyy1079276272@163.com', '7a3c235abec79194f1cddbf25c21de96', 'Cinyky1234', '1', '这个人很懒', '个人简介', '中国', 'default_headpic.jpg', '0', '1490787789317', '0', '-1');
INSERT INTO `user` VALUES ('a643c7bc-ffe3-4675-8d10-79fa1de44b3d', '1079276272', '9034ab708f195b961e5ea00a76d33336', 'cyy1079276272@163.com', '7a3c235abec79194f1cddbf25c21de96', 'Cinyky1234', '1', '这个人很懒', '个人简介', '中国', 'default_headpic.jpg', '0', '1491533698993', '0', '-1');
SET FOREIGN_KEY_CHECKS=1;
