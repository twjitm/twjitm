/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : twjitm

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-02-08 09:26:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `announcement` varchar(100) DEFAULT NULL,
  `max_num` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `join_type` int(2) DEFAULT NULL,
  `tags` varchar(100) DEFAULT NULL,
  `group_type` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `have_child` int(11) DEFAULT NULL,
  `is_hidden` int(11) DEFAULT NULL,
  `menu_img` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '1', '1', 'fa fa-dashboard', '账单管理', '/receipt/init.do', '1', '0');
INSERT INTO `menu` VALUES ('2', '1', '1', 'fa fa-desktop', '游戏帧同步', '/game/into.do', '3', '0');
INSERT INTO `menu` VALUES ('3', '1', '1', 'fa fa-qrcode', '五子棋对战', '/game/gobang.do', '2', '0');
INSERT INTO `menu` VALUES ('4', '1', '1', 'fa fa-user fa-fw', 'Elasticsearch搜索引擎', '/books/collectionList.do', '4', '0');
INSERT INTO `menu` VALUES ('8', '1', '1', 'fa fa-upload fa-fw', '个人信息', '/user/userinfor.do', '8', '0');
INSERT INTO `menu` VALUES ('9', '1', '1', 'fa fa-user fa-fw', '修改密码', '/user/updatepsdUI.do', '10', '0');
INSERT INTO `menu` VALUES ('10', '1', '1', 'fa fa-twitter fa-fw', '读者留言', '/sys/leavesmg.do', '6', '0');
INSERT INTO `menu` VALUES ('12', '1', '1', 'fa fa-twitter fa-fw', '添加图书', '/books/addbookUI?type=0', '1', '0');
INSERT INTO `menu` VALUES ('13', '1', '1', 'fa fa-twitter fa-fw', '添加期刊', '/books/addbookUI?type=1', '2', '0');
INSERT INTO `menu` VALUES ('14', '1', '1', 'fa fa-twitter fa-fw', '添加论文', '/books/addbookUI?type=2', '3', '0');
INSERT INTO `menu` VALUES ('15', '1', '1', 'fa fa-qrcode', '全部图书', '/books/adminlist.do', '1', '0');
INSERT INTO `menu` VALUES ('16', '1', '1', 'fa fa-qrcode', '信息服务', ' ', '4', '0');
INSERT INTO `menu` VALUES ('17', '1', '1', 'fa fa-upload fa-fw', '入馆教育', '/borrows/regular.do', '1', '16');
INSERT INTO `menu` VALUES ('18', '1', '1', 'fa fa-qrcode', '借阅规则', '/sys/intolibstu.do', '2', '16');
INSERT INTO `menu` VALUES ('19', '1', '1', 'fa fa-qrcode', '全部图书', '/books/allbook.do', '2', '0');

-- ----------------------------
-- Table structure for moneys
-- ----------------------------
DROP TABLE IF EXISTS `moneys`;
CREATE TABLE `moneys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moneys
-- ----------------------------
INSERT INTO `moneys` VALUES ('1', '0.5');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('1', '1', '5');
INSERT INTO `power` VALUES ('2', '2', '5');
INSERT INTO `power` VALUES ('3', '3', '5');
INSERT INTO `power` VALUES ('4', '4', '5');
INSERT INTO `power` VALUES ('8', '8', '1');
INSERT INTO `power` VALUES ('9', '9', '1');
INSERT INTO `power` VALUES ('10', '2', '1');
INSERT INTO `power` VALUES ('11', '10', '1');
INSERT INTO `power` VALUES ('12', '12', '2');
INSERT INTO `power` VALUES ('13', '13', '2');
INSERT INTO `power` VALUES ('14', '14', '2');
INSERT INTO `power` VALUES ('15', '15', '4');
INSERT INTO `power` VALUES ('16', '3', '2');
INSERT INTO `power` VALUES ('17', '16', '4');
INSERT INTO `power` VALUES ('18', '19', '1');

-- ----------------------------
-- Table structure for receipt
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `money` double DEFAULT NULL,
  `in_time` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receipt
-- ----------------------------
INSERT INTO `receipt` VALUES ('1', '1', '100', '2017-10-15 21:38:40', '买的白菜', '0');

-- ----------------------------
-- Table structure for tests
-- ----------------------------
DROP TABLE IF EXISTS `tests`;
CREATE TABLE `tests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '',
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tests
-- ----------------------------
INSERT INTO `tests` VALUES ('1', 'twjitm1111', null);
INSERT INTO `tests` VALUES ('2', 'twjitm1111', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `regTime` datetime DEFAULT NULL,
  `regIp` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1111', '123456', 'admin', '10', '1', '2017-10-13 22:54:01', '127.0.0.1');

-- ----------------------------
-- Table structure for usergroup
-- ----------------------------
DROP TABLE IF EXISTS `usergroup`;
CREATE TABLE `usergroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  `join_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usergroup
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
