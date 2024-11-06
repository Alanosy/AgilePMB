/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023 (8.0.23)
 Source Host           : localhost:3306
 Source Schema         : DB_AgilePM

 Target Server Type    : MySQL
 Target Server Version : 80023 (8.0.23)
 File Encoding         : 65001

 Date: 06/11/2024 11:38:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_Files
-- ----------------------------
DROP TABLE IF EXISTS `T_Files`;
CREATE TABLE `T_Files` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `itemid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Files
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for T_Issues
-- ----------------------------
DROP TABLE IF EXISTS `T_Issues`;
CREATE TABLE `T_Issues` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '问题名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类型',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '问题内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `priority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '优先级',
  `itemid` bigint DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `principalid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  `delete_flag` tinyint DEFAULT '0',
  `teamid` bigint DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Issues
-- ----------------------------
BEGIN;
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (2, '博客点赞异常', '0', '<p>afsdasdfa</p>', '2024-08-26 11:49:07', '1', 2, '0', 2, 1, 0, 1, '2024-08-11 00:00:00', '2024-08-05 00:00:00');
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (21, '测试', '3', '<p>测试</p>', '2024-10-28 14:04:45', '1', 10, '0', 7, 7, 0, 1, '2024-10-01 00:00:00', '2024-10-30 00:00:00');
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (23, '测试新增问题', '3', '<p>测试问题</p>', '2024-10-28 14:50:05', '1', 2, '0', 1, 1, 0, 1, '2024-09-29 00:00:00', '2024-10-30 00:00:00');
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (26, '测试创建问题', '2', '<p>测试</p>', '2024-10-28 14:52:10', '1', 2, '0', 1, 1, 0, 1, '2024-10-06 00:00:00', '2024-10-31 00:00:00');
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (27, '测试创建问题2', '2', '<p>测试</p>', '2024-10-28 14:53:48', '1', 2, '0', 1, 1, 0, 1, '2024-10-06 00:00:00', '2024-10-31 00:00:00');
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (28, '测试问题', '1', '<p>测试</p>', '2024-10-28 15:08:37', '1', 10, '0', 7, 7, 0, 8, '2024-10-31 00:00:00', '2024-11-08 00:00:00');
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (29, '测试问题', '0', '<p>适当放松d</p>', '2024-11-04 15:32:54', '1', 14, '1', 1, 1, 0, 1, '2024-11-04 00:00:00', '2024-11-21 00:00:00');
INSERT INTO `T_Issues` (`id`, `name`, `type`, `content`, `createtime`, `priority`, `itemid`, `state`, `principalid`, `userid`, `delete_flag`, `teamid`, `startdate`, `enddate`) VALUES (30, '评论异常', '0', '<p>评论异常bug</p>', '2024-11-05 20:13:43', '1', 16, '0', 1, 1, 0, 1, '2024-11-01 00:00:00', '2024-11-15 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for T_Projects
-- ----------------------------
DROP TABLE IF EXISTS `T_Projects`;
CREATE TABLE `T_Projects` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '项目名称',
  `content` text COMMENT '项目文档',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '创建人',
  `startdate` datetime DEFAULT NULL COMMENT '项目开始时间',
  `enddate` datetime DEFAULT NULL COMMENT '项目结束时间',
  `state` varchar(255) DEFAULT NULL COMMENT '项目状态',
  `teamid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Projects
-- ----------------------------
BEGIN;
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (2, '电商项目', '<p>测试</p>', NULL, 1, '2024-07-22 00:00:00', '2024-08-09 00:00:00', '1', 1);
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (6, '电商系统6', NULL, NULL, 7, '2024-07-22 00:00:00', '2024-07-15 00:00:00', '1', 8);
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (7, '电商系统6', NULL, NULL, 7, '2024-07-22 00:00:00', '2024-07-15 00:00:00', '1', 8);
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (8, '电商系统6', NULL, NULL, 7, '2024-07-22 00:00:00', '2024-07-15 00:00:00', '1', 8);
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (10, '电商系统6', '<p>行啊</p>', NULL, 7, '2024-07-22 00:00:00', '2024-07-15 00:00:00', '1', 8);
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (14, '演示项目', '<p>测试</p>', NULL, 1, '2024-11-01 00:00:00', '2024-11-30 00:00:00', '1', 1);
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (15, '测试第二个团队的项目1', NULL, NULL, 1, NULL, NULL, '1', 2);
INSERT INTO `T_Projects` (`id`, `name`, `content`, `createtime`, `userid`, `startdate`, `enddate`, `state`, `teamid`) VALUES (16, '博客项目', NULL, NULL, 1, '2024-11-01 00:00:00', '2024-11-30 00:00:00', '3', 1);
COMMIT;

-- ----------------------------
-- Table structure for T_Remarks
-- ----------------------------
DROP TABLE IF EXISTS `T_Remarks`;
CREATE TABLE `T_Remarks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userid` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `itemid` bigint DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Remarks
-- ----------------------------
BEGIN;
INSERT INTO `T_Remarks` (`id`, `userid`, `content`, `itemid`, `createtime`) VALUES (6, 1, '<p><br></p>', 2, NULL);
INSERT INTO `T_Remarks` (`id`, `userid`, `content`, `itemid`, `createtime`) VALUES (7, 7, '<p>行啊</p>', 10, NULL);
INSERT INTO `T_Remarks` (`id`, `userid`, `content`, `itemid`, `createtime`) VALUES (8, 1, '<p>添加备注</p>', 14, NULL);
INSERT INTO `T_Remarks` (`id`, `userid`, `content`, `itemid`, `createtime`) VALUES (9, 1, '<p>测试</p>', 14, NULL);
INSERT INTO `T_Remarks` (`id`, `userid`, `content`, `itemid`, `createtime`) VALUES (10, 1, '<p>测试备注征文</p>', 14, NULL);
COMMIT;

-- ----------------------------
-- Table structure for T_Requirements
-- ----------------------------
DROP TABLE IF EXISTS `T_Requirements`;
CREATE TABLE `T_Requirements` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '需求名称',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '需求文档',
  `userid` bigint NOT NULL COMMENT '创建人',
  `priority` int NOT NULL COMMENT '优先级',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `itemid` bigint DEFAULT NULL,
  `principalid` bigint DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `delete_flag` tinyint DEFAULT '0',
  `teamid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Requirements
-- ----------------------------
BEGIN;
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (2, '电商购物车功能', '<p>sadfasdf </p>', 1, 1, '2024-08-20 11:04:50', 2, 1, '0', '2024-08-14 16:57:33', '2024-08-29 16:57:37', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (8, '电商秒杀功能', '<p>asdf</p>', 1, 3, '2024-08-26 10:52:28', 2, 1, '1', '2024-07-04 20:58:47', '2024-10-15 20:59:26', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (9, '电商物流状态', '<p>asdf</p>', 1, 1, '2024-08-26 10:53:16', 2, 1, '1', '2024-05-09 20:58:42', '2024-10-15 20:59:29', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (25, '测试7', '<p>测6</p>', 7, 2, '2024-10-28 13:45:10', 6, 7, '0', '2024-10-07 00:00:00', '2024-10-15 00:00:00', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (26, '测试7', '<p>测6</p>', 7, 3, '2024-10-28 13:46:04', 6, 7, '2', '2024-10-07 00:00:00', '2024-10-15 00:00:00', 0, 8);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (27, '测试', '<p>测试</p>', 7, 3, '2024-10-28 13:56:35', 10, 7, '3', '2024-10-09 00:00:00', '2024-10-07 00:00:00', 0, 8);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (28, '演示需求', '<p>演示需求文档</p>', 1, 0, '2024-11-04 15:27:39', 2, 1, '0', '2024-10-31 00:00:00', '2024-11-04 00:00:00', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (29, '测试需求', '<p>测试需求</p>', 1, 0, '2024-11-04 15:28:29', 2, 1, '4', '2024-11-03 00:00:00', '2024-11-08 00:00:00', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (30, '测试需求', '<p>测试需求</p>', 1, 3, '2024-11-04 15:28:51', 14, 1, '5', '2024-11-03 00:00:00', '2024-11-08 00:00:00', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (31, '测试需求2', '<p>测试文档</p>', 1, 0, '2024-11-04 15:32:37', 14, 1, '0', '2024-10-29 00:00:00', '2024-11-18 00:00:00', 0, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (32, '测试新建需求', '<p>从电商</p>', 1, 2, '2024-11-04 15:35:41', 2, 1, '0', '2024-11-04 00:00:00', '2024-11-21 00:00:00', 1, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (33, '测试新建需求2', '<p>从电商</p>', 1, 2, '2024-11-04 15:35:49', 2, 1, '0', '2024-11-04 00:00:00', '2024-11-21 00:00:00', 1, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (34, '', '<p><br></p>', 1, 0, '2024-11-04 15:46:14', NULL, NULL, '0', NULL, NULL, 1, 1);
INSERT INTO `T_Requirements` (`id`, `name`, `content`, `userid`, `priority`, `createtime`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `delete_flag`, `teamid`) VALUES (35, '评论功能', '<p>可以多用户评论，回复，点赞等</p>', 1, 0, '2024-11-05 20:14:14', 16, 24, '0', '2024-11-01 00:00:00', '2024-11-05 00:00:00', 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for T_Tasks
-- ----------------------------
DROP TABLE IF EXISTS `T_Tasks`;
CREATE TABLE `T_Tasks` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务名称',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务文档',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类型',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `priority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '优先级',
  `evaluation` varchar(255) DEFAULT NULL COMMENT '评估时间',
  `userid` bigint DEFAULT NULL COMMENT '创建人',
  `itemid` bigint DEFAULT NULL,
  `principalid` bigint DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `finishtime` datetime DEFAULT NULL,
  `delete_flag` tinyint DEFAULT '0',
  `teamid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Tasks
-- ----------------------------
BEGIN;
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (19, '电商购物车功能开发', '<p>adsfa</p>', '1', '2024-08-20 12:59:07', '1', NULL, 1, 2, 1, '1', '2024-08-22 09:58:42', '2024-08-25 09:58:45', '2024-08-22 09:58:47', NULL, 1, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (23, '电商物流状态更新功能', '<p>asaa</p>', NULL, '2024-09-19 19:25:05', NULL, NULL, 1, 2, 1, '1', '2024-09-19 00:00:00', '2024-09-20 00:00:00', NULL, NULL, 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (25, '测试', '<p>测试</p>', NULL, '2024-10-28 14:09:31', NULL, NULL, 7, 10, 7, '2', '2024-10-06 00:00:00', '2024-10-30 00:00:00', NULL, '2024-11-04 14:43:35', 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (26, '测试', '<p>测试</p>', NULL, '2024-10-28 14:59:11', NULL, NULL, 1, 2, 1, '2', NULL, NULL, NULL, '2024-10-28 15:55:50', 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (27, '测试22', '<p>测试</p>', NULL, '2024-10-28 15:04:45', NULL, NULL, 1, 2, 1, '2', '2024-10-07 00:00:00', '2024-10-29 00:00:00', '2024-11-05 10:56:18', '2024-11-05 10:56:18', 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (28, '测试', '<p>测试</p>', NULL, '2024-10-28 15:08:52', NULL, NULL, 7, 10, 7, '1', '2024-09-30 00:00:00', '2024-10-31 00:00:00', NULL, NULL, 0, 8);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (29, '测试遗留', '<p>测试遗留</p>', NULL, '2024-10-28 15:17:14', NULL, NULL, 1, 2, 1, '2', '2024-09-30 00:00:00', '2024-10-20 00:00:00', NULL, '2024-11-05 10:43:02', 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (30, '测试任务', '<p>测试任务</p>', NULL, '2024-11-04 15:34:12', NULL, NULL, 1, 14, 1, '2', '2024-11-03 00:00:00', '2024-11-06 00:00:00', NULL, '2024-11-04 19:29:53', 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (31, '测试任务2', '<p>测试</p>', NULL, '2024-11-04 19:35:14', NULL, NULL, 1, 14, 1, '2', '2024-11-01 00:00:00', '2024-11-05 00:00:00', '2024-11-05 10:56:40', '2024-11-05 10:56:40', 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (32, '演示项目-测试任务1', '<p>演示项目-测试任务-任务文档</p><p>这里是是任务文档，这里是是任务文档，这里是是任务文档，这里是是任务文档，这里是是任务文档，</p>', NULL, '2024-11-05 19:43:04', NULL, NULL, 1, 14, 1, '0', '2024-11-01 00:00:00', '2024-11-07 00:00:00', NULL, NULL, 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (33, '演示项目-测试任务2', '<p>这里是任务文档正文，这里是任务文档正文</p><p>，这里是任务文档正文，这里是任务文档正文，这里是任务文档正文，这里是任务文档正文</p>', NULL, '2024-11-05 19:47:10', NULL, NULL, 1, 14, 1, '1', '2024-11-01 00:00:00', '2024-11-07 00:00:00', '2024-11-05 19:49:47', NULL, 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (34, '演示项目-测试任务3', '<p>这里是任务文档</p>', NULL, '2024-11-05 19:49:07', NULL, NULL, 1, 14, 1, '0', '2024-11-01 00:00:00', '2024-11-06 00:00:00', NULL, NULL, 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (35, '演示项目-测试任务-测试分页', '<p>测试测试测试</p>', NULL, '2024-11-05 19:50:49', NULL, NULL, 1, 14, 1, '2', '2024-11-01 00:00:00', '2024-11-08 00:00:00', '2024-11-06 08:20:25', '2024-11-06 08:20:25', 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (36, '测试任务，分配给其他用户', '<p>测试任务</p>', NULL, '2024-11-05 19:51:33', NULL, NULL, 1, 14, 23, '1', '2024-11-01 00:00:00', '2024-11-07 00:00:00', NULL, NULL, 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (37, '评论开发', '<p>使用vue和element开发评论功能，可以使用第三方插件</p>', NULL, '2024-11-05 20:12:27', NULL, NULL, 1, 16, 24, '1', '2024-11-01 00:00:00', '2024-11-08 00:00:00', NULL, NULL, 0, 1);
INSERT INTO `T_Tasks` (`id`, `name`, `content`, `type`, `createtime`, `priority`, `evaluation`, `userid`, `itemid`, `principalid`, `state`, `starttime`, `endtime`, `updatetime`, `finishtime`, `delete_flag`, `teamid`) VALUES (38, '分类和标签功能开发', '<p>分类和标签功能开发，先开发出来看看</p>', NULL, '2024-11-05 20:13:08', NULL, NULL, 1, 16, 1, '1', '2024-11-01 00:00:00', '2024-11-08 00:00:00', NULL, NULL, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for T_Team_Project
-- ----------------------------
DROP TABLE IF EXISTS `T_Team_Project`;
CREATE TABLE `T_Team_Project` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tid` bigint NOT NULL COMMENT '团队id',
  `pid` bigint NOT NULL COMMENT '项目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Team_Project
-- ----------------------------
BEGIN;
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (1, 1, 1);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (2, 8, 6);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (3, 8, 10);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (4, 1, 11);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (5, 1, 12);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (6, 1, 13);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (7, 1, 14);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (8, 2, 15);
INSERT INTO `T_Team_Project` (`id`, `tid`, `pid`) VALUES (9, 1, 16);
COMMIT;

-- ----------------------------
-- Table structure for T_Teams
-- ----------------------------
DROP TABLE IF EXISTS `T_Teams`;
CREATE TABLE `T_Teams` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '团队名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '团队代码',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Teams
-- ----------------------------
BEGIN;
INSERT INTO `T_Teams` (`id`, `name`, `code`, `createtime`, `userid`) VALUES (1, '第一个团队', 'fistteam', '2024-08-05 22:43:24', 1);
INSERT INTO `T_Teams` (`id`, `name`, `code`, `createtime`, `userid`) VALUES (2, '第二个团队', 'towteam', '2024-08-30 07:57:19', 1);
INSERT INTO `T_Teams` (`id`, `name`, `code`, `createtime`, `userid`) VALUES (8, 'test3', 'ODrkPSzXaB1bGWIe0k', '2024-10-28 12:06:41', 7);
INSERT INTO `T_Teams` (`id`, `name`, `code`, `createtime`, `userid`) VALUES (9, '测试团队5', 'NvHVt5ijOXgcMyIZy7', '2024-10-28 12:49:58', 8);
INSERT INTO `T_Teams` (`id`, `name`, `code`, `createtime`, `userid`) VALUES (10, 'cest', 'wy48e7AeXgKupKLrh2', '2024-11-04 16:16:20', 11);
INSERT INTO `T_Teams` (`id`, `name`, `code`, `createtime`, `userid`) VALUES (11, 'aaa', 'fcfy9Ut6G6qkaf8za1', '2024-11-04 16:39:31', 21);
COMMIT;

-- ----------------------------
-- Table structure for T_User_Team
-- ----------------------------
DROP TABLE IF EXISTS `T_User_Team`;
CREATE TABLE `T_User_Team` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tid` bigint NOT NULL COMMENT '团队表ID',
  `uid` bigint NOT NULL COMMENT '用户表ID',
  `state` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_User_Team
-- ----------------------------
BEGIN;
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (1, 1, 1, '1', '2024-08-23 23:17:36');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (2, 1, 2, '2', '2024-08-06 22:52:05');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (3, 2, 1, '0', '2024-08-28 07:57:44');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (4, 8, 7, '1', '2024-10-28 12:06:41');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (5, 9, 8, '1', '2024-10-28 12:49:58');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (6, 10, 11, '1', '2024-11-04 16:16:20');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (7, 1, 20, '1', '2024-11-04 16:37:05');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (8, 11, 21, '1', '2024-11-04 16:39:31');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (9, 1, 22, '1', '2024-11-04 16:40:10');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (10, 1, 23, '1', '2024-11-04 17:38:23');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (11, 1, 24, '2', '2024-11-05 19:58:48');
INSERT INTO `T_User_Team` (`id`, `tid`, `uid`, `state`, `createtime`) VALUES (12, 1, 25, '2', '2024-11-06 08:24:34');
COMMIT;

-- ----------------------------
-- Table structure for T_Users
-- ----------------------------
DROP TABLE IF EXISTS `T_Users`;
CREATE TABLE `T_Users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `realname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `avater` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_Users
-- ----------------------------
BEGIN;
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (1, 'Alan', 'admin', '$2a$10$aePGy8geX69BUvIeH/sGRe3xcM4ck8QN84IyvY2brcyncTQAPgwLa', '2024-07-15 22:45:37', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (2, 'sdfa', 'user', '$2a$10$aePGy8geX69BUvIeH/sGRe3xcM4ck8QN84IyvY2brcyncTQAPgwLa', '2024-08-25 23:48:07', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (3, 'user2', 'user2', '$2a$10$aePGy8geX69BUvIeH/sGRe3xcM4ck8QN84IyvY2brcyncTQAPgwLa', '2024-08-27 21:36:47', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (4, 'test', 'test', '$2a$10$csSoMbNIxcmF0VsPpPC.MuBIFQXRmdPr9yDKUDGsj7qrkuL88L3ba', '2024-10-28 11:39:43', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (5, 'test1', 'test1', '$2a$10$7DPVS.Euk8gO65uXvCCx7O/OtkylNNv5b88m3HSI5ZfRgVF/FFy/a', '2024-10-28 11:58:20', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (6, 'test2', 'test2', '$2a$10$RNzDrk.znyIyrfHGtDa65uVV26fGpHtvKC0EE8d3mBLlrtHcRY.Xa', '2024-10-28 11:59:29', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (7, 'test3', 'test3', '$2a$10$Qo9p5foYwOhRjuCEy1kXjOibRiuCVJ4nPmrDZwnG6U6XhGQykSdpa', '2024-10-28 12:03:58', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (8, 'test4', 'test4', '$2a$10$FKA9QnVvzfNcoi3mptdtX.70uYiG9LyY0c.IOC3ZSIDjDRG59KnQK', '2024-10-28 12:49:47', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (9, 'admin2', 'admin2', '$2a$10$OgYoVzRinFjPiyPxS3m3t.dOmDOC1A7NVRFX.R5EiPXroIvXZHO5.', '2024-11-04 16:12:21', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (10, 'test16', 'test16', '$2a$10$oedEZyjRJZuPFPM4EPjfqOPtxoz0A/d7c3IFqOdZmKO0XI/gqmGG2', '2024-11-04 16:12:45', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (11, 'test17', 'test17', '$2a$10$0hQzH/jGEuigFdK6bQpJLObayyb0WN5nbgMn8dJ5Q4yhhM.31sjXK', '2024-11-04 16:14:07', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (12, 'admin3', 'admin3', '$2a$10$LnQIsM1TL3Tyy/bPTu595ONN5OWGbornneyKxD/MrdfqUO88lFPr.', '2024-11-04 16:17:51', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (13, '123', '123', '$2a$10$NWFHC.Ew34.VAAqiFUSE0.AYfwcIF1NSyW5opVM9fAhC3IKPQSQeq', '2024-11-04 16:24:01', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (14, '1234', '1234', '$2a$10$GTIb37UEL9xrHVhlVrI5cupCEFk3Fz9RynL7O673013yrYoP3UnGK', '2024-11-04 16:25:52', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (15, '12344', '12344', '$2a$10$Sphmhkv/GHHpBAP4QhAAme21GCJ/.m69BVY7aGfPYWk2ld1oFdiYm', '2024-11-04 16:26:48', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (16, '1233', '1233', '$2a$10$UwbR5bCXlbPpyGlwOGUDSuvsW/G9d.vpg8lxLWjwASsFc3jcGJrTu', '2024-11-04 16:28:57', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (17, '12333', '12333', '$2a$10$FudNNXab4FIlcKecsLaL.u.bsNAqm3YKtpSDrQqb5iBVj1lFWXwVi', '2024-11-04 16:29:46', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (18, '1232', '1232', '$2a$10$AvmbStUWIWW5dDMwe.k9Su6.j6yqbBheYo4yazNGRXgD8V0WEB9he', '2024-11-04 16:32:45', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (19, '1111', '1111', '$2a$10$Fwu9nHRME9dxi7HMfY.zpugMwvaYd/DdEIjHCUooj1lA/Xzq0B38i', '2024-11-04 16:33:38', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (20, '1111', '1111', '$2a$10$4jG.dpQ/tLXvLh0QaZTi9uSwQ7z3w0ig5nBa/m6VvLz5MAoI9njuu', '2024-11-04 16:36:53', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (21, '123222', '123222', '$2a$10$x1nelMA3AfmmFwRbHvty6u6NYN1FTyKweIYOE1.Wuo4nhfLK2mt16', '2024-11-04 16:39:22', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (22, 'admin4', 'admin4', '$2a$10$oYRcWuR2UB/5AblXXSORS.abxsRU8FMSgJLuLlJWhGWHgIRUmsIwC', '2024-11-04 16:40:05', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (23, 'admin6', 'admin6', '$2a$10$e7SyhgZShodJGmrDATp8EebH7StkxH.qvmJKbOsWHTeLXKVp4q7Xm', '2024-11-04 17:38:15', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (24, 'testuser1', 'testuser1', '$2a$10$Id8hBBnpdCN4aplcHu48yeOhXz5J2aCOr4M4RhAwrGr1sYF/UETym', '2024-11-05 19:58:45', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
INSERT INTO `T_Users` (`id`, `realname`, `username`, `password`, `createtime`, `avater`) VALUES (25, 'admin77', 'admin77', '$2a$10$Zb8WsJmu9N9uoIx1I6Sa.O1GZmYPPAm5oX2PiN1yXIXpPyJEEja2K', '2024-11-06 08:24:25', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
