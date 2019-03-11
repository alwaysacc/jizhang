/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : jizhang

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-03-11 17:23:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `money` decimal(20,2) DEFAULT '0.00',
  `bank` decimal(20,2) DEFAULT '0.00',
  `credit` decimal(20,2) DEFAULT '0.00',
  `alipay` decimal(20,2) DEFAULT '0.00',
  `huabei` decimal(20,2) DEFAULT '0.00',
  `WeChat` decimal(20,2) DEFAULT '0.00',
  `jingdong` decimal(20,2) DEFAULT '0.00',
  `other` decimal(20,2) DEFAULT '0.00',
  `userid` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '6500000.00', '6.55', '555.00', '99990.00', '2000.00', '2002.00', '3000.00', '62.30', '201931110571389748');

-- ----------------------------
-- Table structure for income_outlay
-- ----------------------------
DROP TABLE IF EXISTS `income_outlay`;
CREATE TABLE `income_outlay` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `amount` double(20,0) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `dates` varchar(20) DEFAULT NULL,
  `createDate` varchar(20) DEFAULT NULL,
  `remarks` varchar(20) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `account` varchar(20) DEFAULT NULL,
  `userId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of income_outlay
-- ----------------------------
INSERT INTO `income_outlay` VALUES ('1', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('2', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('3', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('4', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('5', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('6', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('7', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('8', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('9', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('10', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('11', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('12', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('13', '6666', '一日三餐', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `id` varchar(30) NOT NULL,
  `openid` varchar(50) NOT NULL COMMENT '小程序用户openid',
  `nickname` varchar(30) NOT NULL COMMENT '用户昵称',
  `avatarurl` varchar(500) NOT NULL COMMENT '用户头像',
  `gender` tinyint(1) DEFAULT '0' COMMENT '性别   0 男  1  女  2 人妖',
  `country` varchar(100) DEFAULT NULL COMMENT '所在国家',
  `province` varchar(100) DEFAULT NULL COMMENT '省份',
  `city` varchar(100) DEFAULT '' COMMENT '城市',
  `language` varchar(100) DEFAULT NULL,
  `ctime` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机类型',
  `telnum` char(13) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_user
-- ----------------------------
INSERT INTO `wx_user` VALUES ('201931110571389748', 'oMAps5fHMW6xuqMIIXz4MOMWiHS8', '说', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKpgOYib8MqAYdnqndLXIGu3ESRjdIYVzibUdABzTYdw63eDvL11ZyYgsw5sOpYr26RzsvicKibYhibDYw/132', '1', '中国', '河南', '商丘', null, '20190311105713', null, null);
