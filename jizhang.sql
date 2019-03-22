/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : jizhang

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-03-22 16:44:07
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
INSERT INTO `account` VALUES ('1', '6500000.00', '6.55', '888.00', '99990.00', '2000.00', '2002.00', '3000.00', '62.30', '201931110571389748');

-- ----------------------------
-- Table structure for income_outlay
-- ----------------------------
DROP TABLE IF EXISTS `income_outlay`;
CREATE TABLE `income_outlay` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `amount` double(50,0) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `dates` varchar(20) DEFAULT NULL,
  `createDate` varchar(20) DEFAULT NULL,
  `remarks` varchar(20) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `account` varchar(20) DEFAULT NULL,
  `userId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of income_outlay
-- ----------------------------
INSERT INTO `income_outlay` VALUES ('2', '222', '1', '3', '2019-03-11', '4', '12', '1', '123', '1');
INSERT INTO `income_outlay` VALUES ('3', '2333', '1', '4', '2019-03-11', '4', '1234', '1', '123', '1');
INSERT INTO `income_outlay` VALUES ('22', '2223', '一日三餐5', '地址', '2019-03-11', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('221', '2223', '一日三餐5', '地址', '2019-03-12', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('222', '2223', '一日三餐5', '地址', '2019-03-13', '20190311145046', '备注123', '1', '123', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('223', '111', '1', '2', '2019-03-11', '4', '213', '1', '123', '1');
INSERT INTO `income_outlay` VALUES ('334', '123', '交通出行', '333', '2019-03-21', '20190321150425', '33', '1', '银行卡\n', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('335', '3333345', '其他', '5', '2019-03-21', '20190321152955', '4', '1', '花呗\n', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('336', '222', '', '5', '2019-03-21', '20190321153024', '4', '1', '花呗\n', '201931110571389748');
INSERT INTO `income_outlay` VALUES ('337', '123', '交通出行', '2', '2019-03-21', '20190321153035', '2', '1', '花呗\n', '201931110571389748');

-- ----------------------------
-- Table structure for suggest
-- ----------------------------
DROP TABLE IF EXISTS `suggest`;
CREATE TABLE `suggest` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `userid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suggest
-- ----------------------------
INSERT INTO `suggest` VALUES ('1', null, 'sddasdadsa', '20190313165542', '201931110571389748');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('101', 'article', '文章管理', 'article:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('102', 'article', '文章管理', 'article:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('103', 'article', '文章管理', 'article:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('601', 'user', '用户', 'user:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('602', 'user', '用户', 'user:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('603', 'user', '用户', 'user:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('701', 'role', '角色权限', 'role:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('702', 'role', '角色权限', 'role:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('703', 'role', '角色权限', 'role:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('704', 'role', '角色权限', 'role:delete', '删除', '2');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '2', '101', '2017-11-22 16:26:21', '2017-11-22 16:26:32', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '2', '102', '2017-11-22 16:26:21', '2019-03-22 15:13:19', '2');
INSERT INTO `sys_role_permission` VALUES ('5', '2', '602', '2017-11-22 16:28:28', '2019-03-22 15:13:19', '2');
INSERT INTO `sys_role_permission` VALUES ('6', '2', '601', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '2', '603', '2017-11-22 16:28:28', '2019-03-22 15:13:36', '2');
INSERT INTO `sys_role_permission` VALUES ('8', '2', '703', '2017-11-22 16:28:28', '2019-03-22 15:13:36', '2');
INSERT INTO `sys_role_permission` VALUES ('9', '2', '701', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '2', '702', '2017-11-22 16:28:28', '2019-03-22 15:13:36', '2');
INSERT INTO `sys_role_permission` VALUES ('11', '2', '704', '2017-11-22 16:28:31', '2019-03-22 15:13:36', '2');
INSERT INTO `sys_role_permission` VALUES ('12', '2', '103', '2017-11-22 16:28:31', '2019-03-22 15:13:36', '2');
INSERT INTO `sys_role_permission` VALUES ('13', '3', '601', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '3', '701', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '3', '702', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('16', '3', '704', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('17', '3', '102', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('18', '3', '101', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('19', '3', '603', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('20', '4', '101', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('21', '4', '102', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('22', '4', '103', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('23', '4', '601', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('24', '4', '602', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('25', '4', '603', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('26', '4', '701', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('27', '4', '702', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('28', '4', '703', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('29', '4', '704', '2018-11-29 14:17:17', '2018-11-29 14:17:23', '2');
INSERT INTO `sys_role_permission` VALUES ('30', '5', '101', '2019-03-22 15:16:31', '2019-03-22 15:28:53', '2');
INSERT INTO `sys_role_permission` VALUES ('31', '5', '601', '2019-03-22 15:16:31', '2019-03-22 15:28:53', '2');
INSERT INTO `sys_role_permission` VALUES ('32', '5', '701', '2019-03-22 15:16:31', '2019-03-22 15:28:53', '2');
INSERT INTO `sys_role_permission` VALUES ('33', '6', '101', '2019-03-22 15:29:10', '2019-03-22 15:30:14', '2');
INSERT INTO `sys_role_permission` VALUES ('34', '6', '601', '2019-03-22 15:29:10', '2019-03-22 15:30:14', '2');
INSERT INTO `sys_role_permission` VALUES ('35', '6', '701', '2019-03-22 15:29:10', '2019-03-22 15:30:14', '2');
INSERT INTO `sys_role_permission` VALUES ('36', '3', '602', '2019-03-22 15:31:58', '2019-03-22 15:33:33', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8 COMMENT='运营后台用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10003', 'admin', '123456', '超级用户23', '1', '2017-10-30 11:52:38', '2017-11-17 23:51:40', '1');
INSERT INTO `sys_user` VALUES ('10004', 'user', '123456', '莎士比亚', '1', '2017-10-30 16:13:02', '2019-03-22 15:13:06', '1');
INSERT INTO `sys_user` VALUES ('10005', 'aaa', '123456', 'abba', '1', '2017-11-15 14:02:56', '2017-11-17 23:51:42', '1');
INSERT INTO `sys_user` VALUES ('10007', 'test', '123456', '就看看列表', '2', '2017-11-22 16:29:41', '2019-03-22 16:00:03', '1');

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
