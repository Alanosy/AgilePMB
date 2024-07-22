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

 Date: 22/07/2024 12:27:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_Issue_Requirement
-- ----------------------------
DROP TABLE IF EXISTS `T_Issue_Requirement`;
CREATE TABLE `T_Issue_Requirement` (
  `id` bigint NOT NULL COMMENT '主键',
  `iid` bigint NOT NULL COMMENT '问题id',
  `rid` bigint NOT NULL COMMENT '需求id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Issue_User
-- ----------------------------
DROP TABLE IF EXISTS `T_Issue_User`;
CREATE TABLE `T_Issue_User` (
  `id` bigint NOT NULL COMMENT '主键',
  `iid` bigint NOT NULL COMMENT '问题id',
  `uid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Issues
-- ----------------------------
DROP TABLE IF EXISTS `T_Issues`;
CREATE TABLE `T_Issues` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '问题名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类型',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '问题内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `priority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '优先级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `state` int DEFAULT NULL COMMENT '项目状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Requirement_Client
-- ----------------------------
DROP TABLE IF EXISTS `T_Requirement_Client`;
CREATE TABLE `T_Requirement_Client` (
  `id` bigint NOT NULL COMMENT '主键',
  `rid` bigint NOT NULL COMMENT '需求id',
  `uid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Requirement_User
-- ----------------------------
DROP TABLE IF EXISTS `T_Requirement_User`;
CREATE TABLE `T_Requirement_User` (
  `id` bigint NOT NULL COMMENT '主键',
  `uid` bigint NOT NULL COMMENT '用户id',
  `rid` bigint NOT NULL COMMENT '需求id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Requirements
-- ----------------------------
DROP TABLE IF EXISTS `T_Requirements`;
CREATE TABLE `T_Requirements` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '需求名称',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '需求文档',
  `userid` bigint NOT NULL COMMENT '创建人',
  `priority` int NOT NULL COMMENT '优先级',
  `plantime` datetime DEFAULT NULL COMMENT '计划时间',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Task_Issue
-- ----------------------------
DROP TABLE IF EXISTS `T_Task_Issue`;
CREATE TABLE `T_Task_Issue` (
  `id` bigint NOT NULL COMMENT '主键',
  `tid` bigint NOT NULL COMMENT '任务id',
  `iid` bigint NOT NULL COMMENT '问题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Task_Requirement
-- ----------------------------
DROP TABLE IF EXISTS `T_Task_Requirement`;
CREATE TABLE `T_Task_Requirement` (
  `id` bigint NOT NULL COMMENT '主键',
  `tid` bigint NOT NULL COMMENT '任务id',
  `rid` bigint NOT NULL COMMENT '需求id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Task_User
-- ----------------------------
DROP TABLE IF EXISTS `T_Task_User`;
CREATE TABLE `T_Task_User` (
  `id` bigint NOT NULL COMMENT '主键',
  `tid` bigint NOT NULL COMMENT '任务id',
  `uid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Tasks
-- ----------------------------
DROP TABLE IF EXISTS `T_Tasks`;
CREATE TABLE `T_Tasks` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务名称',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务文档',
  `plantime` datetime DEFAULT NULL COMMENT '计划时间',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类型',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `priority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '优先级',
  `evaluation` varchar(255) DEFAULT NULL COMMENT '评估时间',
  `userid` bigint NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Team_Project
-- ----------------------------
DROP TABLE IF EXISTS `T_Team_Project`;
CREATE TABLE `T_Team_Project` (
  `id` bigint NOT NULL COMMENT '主键',
  `tid` bigint NOT NULL COMMENT '团队id',
  `pid` bigint NOT NULL COMMENT '项目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Teams
-- ----------------------------
DROP TABLE IF EXISTS `T_Teams`;
CREATE TABLE `T_Teams` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '团队名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '团队代码',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_User_Team
-- ----------------------------
DROP TABLE IF EXISTS `T_User_Team`;
CREATE TABLE `T_User_Team` (
  `id` bigint NOT NULL COMMENT '主键',
  `tid` bigint NOT NULL COMMENT '团队表ID',
  `uid` bigint NOT NULL COMMENT '用户表ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for T_Users
-- ----------------------------
DROP TABLE IF EXISTS `T_Users`;
CREATE TABLE `T_Users` (
  `id` bigint NOT NULL COMMENT '主键',
  `realname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
