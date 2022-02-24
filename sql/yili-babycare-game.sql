/*
 Navicat Premium Data Transfer

 Source Server         : 本地基础库
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 192.168.189.132:3306
 Source Schema         : yili-babycare-game

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 24/02/2022 14:09:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mail_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `mail_subscribe`;
CREATE TABLE `mail_subscribe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `mail_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱地址',
  `has_mailed` int(11) NOT NULL DEFAULT 0 COMMENT '已接收推送次数',
  `notify_id` int(11) NOT NULL COMMENT '订阅内容id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `address`(`mail_address`) USING BTREE COMMENT '地址索引',
  INDEX `notify_id`(`notify_id`) USING BTREE COMMENT '订阅id'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户的通知信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for monitor_info
-- ----------------------------
DROP TABLE IF EXISTS `monitor_info`;
CREATE TABLE `monitor_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订阅id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品地址',
  `type` int(11) NOT NULL COMMENT '产品所属平台（用于不同抓取方式）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '监控列表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
