/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost
 Source Database       : youhao
 
 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : utf-8

 Date: 05/08/2017 22:55:34 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cartitem`
-- ----------------------------
DROP TABLE IF EXISTS `cartitem`;
CREATE TABLE `cartitem` (
  `id` int(11) DEFAULT NULL,
  `recordId` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `recordinfo`
-- ----------------------------
DROP TABLE IF EXISTS `recordinfo`;
CREATE TABLE `recordinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `intro` varchar(500) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `recordinfo`
-- ----------------------------
BEGIN;
INSERT INTO recordinfo VALUES ('152', 'xxx歌曲1', '作者1', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。1', '13.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('153', 'xxx歌曲2', '作者2', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。2', '14.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('154', 'xxx歌曲3', '作者3', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。3', '15.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('155', 'xxx歌曲4', '作者4', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。4', '16.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('156', 'xxx歌曲5', '作者5', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。5', '17.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('157', 'xxx歌曲6', '作者6', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。6', '18.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('158', 'xxx歌曲7', '作者7', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。7', '19.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('159', 'xxx歌曲8', '作者8', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。8', '20.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('160', 'xxx歌曲9', '作者9', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。9', '21.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('161', 'xxx歌曲10', '作者10', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。10', '22.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('162', 'xxx歌曲11', '作者11', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。11', '23.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('163', 'xxx歌曲12', '作者12', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。12', '24.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('164', 'xxx歌曲13', '作者13', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。13', '25.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('165', 'xxx歌曲14', '作者14', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。14', '26.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('166', 'xxx歌曲15', '作者15', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。15', '27.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('167', 'xxx歌曲16', '作者16', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。16', '28.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('168', 'xxx歌曲17', '作者17', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。17', '29.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('169', 'xxx歌曲18', '作者18', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。18', '30.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('170', 'xxx歌曲19', '作者19', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。19', '31.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('171', 'xxx歌曲20', '作者20', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。20', '32.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('172', 'xxx歌曲21', '作者21', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。21', '33.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('173', 'xxx歌曲22', '作者22', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。22', '34.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('174', 'xxx歌曲23', '作者23', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。23', '35.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('175', 'xxx歌曲24', '作者24', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。24', '36.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('176', 'xxx歌曲25', '作者25', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。25', '37.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('177', 'xxx歌曲26', '作者26', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。26', '38.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('178', 'xxx歌曲27', '作者27', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。27', '39.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('179', 'xxx歌曲28', '作者28', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。28', '40.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('180', 'xxx歌曲29', '作者29', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。29', '41.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('181', 'xxx歌曲30', '作者30', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。30', '42.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('182', 'xxx歌曲31', '作者31', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。31', '43.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('183', 'xxx歌曲32', '作者32', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。32', '44.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('184', 'xxx歌曲33', '作者33', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。33', '45.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('185', 'xxx歌曲34', '作者34', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。34', '46.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('186', 'xxx歌曲35', '作者35', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。35', '47.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('187', 'xxx歌曲36', '作者36', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。36', '48.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('188', 'xxx歌曲37', '作者37', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。37', '49.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('189', 'xxx歌曲38', '作者38', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。38', '50.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('190', 'xxx歌曲39', '作者39', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。39', '51.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('191', 'xxx歌曲40', '作者40', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。40', '52.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('192', 'xxx歌曲41', '作者41', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。41', '53.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('193', 'xxx歌曲42', '作者42', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。42', '54.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('194', 'xxx歌曲43', '作者43', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。43', '55.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('195', 'xxx歌曲44', '作者44', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。44', '56.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('196', 'xxx歌曲45', '作者45', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。45', '57.3', 'disc001.jpg');
INSERT INTO recordinfo VALUES ('197', 'xxx歌曲46', '作者46', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。46', '58.3', 'disc002.jpg');
INSERT INTO recordinfo VALUES ('198', 'xxx歌曲47', '作者47', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。47', '59.3', 'disc003.jpg');
INSERT INTO recordinfo VALUES ('199', 'xxx歌曲48', '作者48', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。48', '60.3', 'disc004.jpg');
INSERT INTO recordinfo VALUES ('200', 'xxx歌曲49', '作者49', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。49', '61.3', 'disc005.jpg');
INSERT INTO recordinfo VALUES ('201', 'xxx歌曲50', '作者50', '简介:DNS 查找失败，因此找不到 www.baidu.com 的服务器。DNS 是将网站名称解析为互联网地址的网络服务。引起此错误的最常见原因是未连接到互联网或网络配置不正确，也可能是因为 DNS 服务器未响应或防火墙阻止了 360极速浏览器访问网络。50', '62.3', 'disc001.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '游浩', '29', 'e10adc3949ba59abbe56e057f20f88'), ('2', '李艳玲', '28', 'e10adc3949ba59abbe56e057f20f88'), ('3', '游思齐', '2', 'e10adc3949ba59abbe56e057f20f88');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
