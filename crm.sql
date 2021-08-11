/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 11/08/2021 14:12:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_activity
-- ----------------------------
DROP TABLE IF EXISTS `tbl_activity`;
CREATE TABLE `tbl_activity`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_date` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_date` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cost` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_activity
-- ----------------------------
INSERT INTO `tbl_activity` VALUES ('1e69037800924bdc8551e62210871260', '06f5fc056eac41558a964f96daa7f27c', '发传单5', '2021-04-16', '2021-09-09', '1', '11', '2021-04-19 09:15:05', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-19 10:28:04', '40f6cdea0bd34aceb77492a1656d9fb3');
INSERT INTO `tbl_activity` VALUES ('221807f712f843aeb67bf58f6a501d72', '06f5fc056eac41558a964f96daa7f27c', '发单', '2021-06-21', '2021-06-29', '122', '123', '2021-06-19 20:59:25', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('24bbf07284e84641bdaf4ceb4ba99d0e', '06f5fc056eac41558a964f96daa7f27c', '销售材料', '2021-06-06', '2021-06-07', '222', '青蛙大全', '2021-06-08 08:56:15', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('2899227110cc454aa06604f38c10e303', '40f6cdea0bd34aceb77492a1656d9fb3', '发传单2', '2021-04-07', '2021-04-27', '1231', '123', '2021-04-03 19:52:19', '张三', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('2f52b6c2042b4f9194ede90755f1a2bb', '06f5fc056eac41558a964f96daa7f27c', '直播', '2021-06-02', '2021-06-06', '123222', '22222', '2021-06-08 08:56:35', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('36c5cebbfaeb4fb28064f885b6775afb', '40f6cdea0bd34aceb77492a1656d9fb3', '卖车', '2021-05-11', '2021-05-23', '123', '卖出车', '2021-05-02 13:54:13', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('3e4fdb1fbe5f4e0abd36d83030518012', '40f6cdea0bd34aceb77492a1656d9fb3', '发传单4', '2020-01-05', '2021-09-09', '11', '123', '2021-04-19 08:26:21', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-19 10:27:10', '40f6cdea0bd34aceb77492a1656d9fb3');
INSERT INTO `tbl_activity` VALUES ('3e4fdb1fbe5f4e0abd36d830305180ae', '40f6cdea0bd34aceb77492a1656d9fb3', '发传单4', '2020-01-01', '2021-09-09', '11', '123', '2021-04-19 08:26:21', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-19 10:27:10', '40f6cdea0bd34aceb77492a1656d9fb3');
INSERT INTO `tbl_activity` VALUES ('6995088a64104cb1b80658addcf73d55', '06f5fc056eac41558a964f96daa7f27c', '发传单1', '2021-04-07', '2021-04-22', '12311', '22222', '2021-04-19 09:15:49', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-22 14:39:18', '40f6cdea0bd34aceb77492a1656d9fb3');
INSERT INTO `tbl_activity` VALUES ('7b0d3a6a25c940de8c5b72d11cd7b964', '40f6cdea0bd34aceb77492a1656d9fb3', '发传单1', '2021-04-07', '2021-04-21', '1', '123', '2021-04-03 19:52:01', '张三', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('951a22e7ce084e298ff728f978a9c47d', '40f6cdea0bd34aceb77492a1656d9fb3', '发传单1', '2021-03-30', '2021-04-14', '1', '123', '2021-04-17 10:39:29', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('c706a3e00025424793e37abd134988ce', '06f5fc056eac41558a964f96daa7f27c', '发传单2', '2021-04-19', '2021-04-23', '1231', '123', '2021-04-17 10:39:54', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('e7eb0190b75e474e9f37252bd5ddc1e2', '40f6cdea0bd34aceb77492a1656d9fb3', '发传单5', '2020-01-01', '2021-09-09', '12312', '123', '2021-04-19 09:12:36', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-19 10:26:29', '40f6cdea0bd34aceb77492a1656d9fb3');
INSERT INTO `tbl_activity` VALUES ('ebac1ebe8f7a44dcb8ae64e401149dc9', '40f6cdea0bd34aceb77492a1656d9fb3', '售楼', '2021-06-02', '2021-06-13', '11111', '111111', '2021-06-08 08:55:51', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);

-- ----------------------------
-- Table structure for tbl_activity_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_activity_remark`;
CREATE TABLE `tbl_activity_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0表示未修改，1表示已修改',
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_activity_remark
-- ----------------------------
INSERT INTO `tbl_activity_remark` VALUES ('12c74a50e12b48f3b75bb65d73cd164c', '12312d', '2021-04-22 20:47:45', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '951a22e7ce084e298ff728f978a9c47d');
INSERT INTO `tbl_activity_remark` VALUES ('1c6edfb8661d4a359dd2c122f3f1a343', '33', '2021-04-22 15:49:27', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', NULL);
INSERT INTO `tbl_activity_remark` VALUES ('1f5b0355ae8444edaf2f511d15e4b79b', 'niubi', '2021-04-22 16:07:10', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', 'e7eb0190b75e474e9f37252bd5ddc1e2');
INSERT INTO `tbl_activity_remark` VALUES ('20ba01c7ae6f4f91ac1f743df50c3aba', '121222', '2021-04-22 20:50:35', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', 'e7eb0190b75e474e9f37252bd5ddc1e2');
INSERT INTO `tbl_activity_remark` VALUES ('3d82935721024cd7a3b0511a24aa4bd5', 'aaa122', '2021-04-04 13:31:48', '张三', '2021-04-04 13:53:32', '张三', '1', '2899227110cc454aa06604f38c10e303');
INSERT INTO `tbl_activity_remark` VALUES ('3ea89330e46d48bb9d3506e1d4eba6a4', '22312r', '2021-04-22 15:59:46', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-22 20:46:33', '40f6cdea0bd34aceb77492a1656d9fb3', '1', '6995088a64104cb1b80658addcf73d55');
INSERT INTO `tbl_activity_remark` VALUES ('45cd2a6337174218acb854b91e388ec7', 'ascascacaw', '2021-04-22 16:03:47', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-22 20:45:25', '40f6cdea0bd34aceb77492a1656d9fb3', '1', '6995088a64104cb1b80658addcf73d55');
INSERT INTO `tbl_activity_remark` VALUES ('4d3b878f4579472eb33ee15330ee3c81', 'sss', '2021-04-22 16:16:37', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', 'c706a3e00025424793e37abd134988ce');
INSERT INTO `tbl_activity_remark` VALUES ('522b2a707cff420aa93ac8dd8440f1fc', '123fachaundan 4', '2021-04-22 16:15:28', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '3e4fdb1fbe5f4e0abd36d830305180ae');
INSERT INTO `tbl_activity_remark` VALUES ('53235470de5243f48dc8cd8ed7d30448', '1212222222', '2021-04-22 20:48:08', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '951a22e7ce084e298ff728f978a9c47d');
INSERT INTO `tbl_activity_remark` VALUES ('7816dc0b7983483bacf33fa5c5426712', '在学此', '2021-04-17 10:40:07', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', 'c706a3e00025424793e37abd134988ce');
INSERT INTO `tbl_activity_remark` VALUES ('8da48a43522a4237a09e013415bf236f', '1234', '2021-04-22 15:42:24', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', NULL);
INSERT INTO `tbl_activity_remark` VALUES ('a0840a45d06a4d0a9a2341ed8ca12887', '22qqwe', '2021-04-22 16:16:52', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', 'c706a3e00025424793e37abd134988ce');
INSERT INTO `tbl_activity_remark` VALUES ('d0345905f20946f0bb86bb7814c9160b', '123', '2021-04-04 13:31:44', '张三', NULL, NULL, '0', '2899227110cc454aa06604f38c10e303');
INSERT INTO `tbl_activity_remark` VALUES ('d05d8d10771c4e8dace4ce94792ecbd6', '1233aazhasgawcn', '2021-04-22 20:42:57', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '1e69037800924bdc8551e62210871260');
INSERT INTO `tbl_activity_remark` VALUES ('d0ee3ac6fc0d412cafa4ec605fc556a1', '1233aa', '2021-04-22 20:42:51', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '1e69037800924bdc8551e62210871260');
INSERT INTO `tbl_activity_remark` VALUES ('d3384ca2ef3d42fdaf193148d23f97b8', 'zxc222', '2021-04-04 13:31:54', '张三', NULL, NULL, '0', '2899227110cc454aa06604f38c10e303');
INSERT INTO `tbl_activity_remark` VALUES ('f2ff0fcbe1dd426680d7c7696666aa04', '1111', '2021-04-17 10:40:10', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', 'c706a3e00025424793e37abd134988ce');
INSERT INTO `tbl_activity_remark` VALUES ('f654cb932269400582ac4eef6637f8b9', '222', '2021-04-22 15:43:51', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', NULL);

-- ----------------------------
-- Table structure for tbl_clue
-- ----------------------------
DROP TABLE IF EXISTS `tbl_clue`;
CREATE TABLE `tbl_clue`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `full_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_clue
-- ----------------------------
INSERT INTO `tbl_clue` VALUES ('7b0135475d5c4415be7c3000d9ca1f84', '2', '', '40f6cdea0bd34aceb77492a1656d9fb3', '1', '2', '123@163.com', '2222', '', '2222', '', '', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-17 10:42:29', NULL, NULL, '123', '123', '123', '123');
INSERT INTO `tbl_clue` VALUES ('db414f6c049349d0aee7c4324173d82b', '2der', 'e5f383d2622b4fc0959f4fe131dafc80', '06f5fc056eac41558a964f96daa7f27c', '安氏2', 'asd22', 'sb@qq.com2', '31864912', '123123.com2', '123123123', '966170ead6fa481284b7d21f90364984', 'a83e75ced129421dbf11fab1f05cf8b4', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-23 20:55:33', NULL, NULL, '2222', '22', '31214', '412412');

-- ----------------------------
-- Table structure for tbl_clue_activity_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_clue_activity_relation`;
CREATE TABLE `tbl_clue_activity_relation`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clue_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_clue_activity_relation
-- ----------------------------
INSERT INTO `tbl_clue_activity_relation` VALUES ('120f7057192645e784ed0e4e2e5d1fbd', '7b0135475d5c4415be7c3000d9ca1f84', '7b0d3a6a25c940de8c5b72d11cd7b964');
INSERT INTO `tbl_clue_activity_relation` VALUES ('5171f87182a444d8bbc58c5b90925ece', '7b0135475d5c4415be7c3000d9ca1f84', '6995088a64104cb1b80658addcf73d55');
INSERT INTO `tbl_clue_activity_relation` VALUES ('778156a69fab4cbf9bf3fd3653edba42', 'db414f6c049349d0aee7c4324173d82b', '2f52b6c2042b4f9194ede90755f1a2bb');
INSERT INTO `tbl_clue_activity_relation` VALUES ('ea8e3587a7234650bd79bf7eb48f81e2', '7b0135475d5c4415be7c3000d9ca1f84', '3e4fdb1fbe5f4e0abd36d830305180ae');
INSERT INTO `tbl_clue_activity_relation` VALUES ('f8df7ed85f2b4ded9cf51cc7fa235a8a', 'db414f6c049349d0aee7c4324173d82b', 'c706a3e00025424793e37abd134988ce');

-- ----------------------------
-- Table structure for tbl_clue_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_clue_remark`;
CREATE TABLE `tbl_clue_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clue_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_clue_remark
-- ----------------------------
INSERT INTO `tbl_clue_remark` VALUES ('2c3864df8d59462288ca52c3d1af4ec0', '阿为', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:04:29', NULL, NULL, '0', '7b0135475d5c4415be7c3000d9ca1f84');
INSERT INTO `tbl_clue_remark` VALUES ('6537d8f668b94393887ce14b7589b616', '阿的2', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:04:33', NULL, NULL, '0', '7b0135475d5c4415be7c3000d9ca1f84');
INSERT INTO `tbl_clue_remark` VALUES ('98532f1ded5e413fb899c3ba93686a9b', '2asc 3', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 14:46:42', NULL, NULL, '0', 'db414f6c049349d0aee7c4324173d82b');
INSERT INTO `tbl_clue_remark` VALUES ('a21df2d6302547569b1fd2d2c3948dc0', 'ascx', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 14:46:36', NULL, NULL, '0', 'db414f6c049349d0aee7c4324173d82b');

-- ----------------------------
-- Table structure for tbl_contacts
-- ----------------------------
DROP TABLE IF EXISTS `tbl_contacts`;
CREATE TABLE `tbl_contacts`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_contacts
-- ----------------------------
INSERT INTO `tbl_contacts` VALUES ('3f5732a367124e62b044e4cc21bd77b0', '40f6cdea0bd34aceb77492a1656d9fb3', 'b924d911426f4bc5ae3876038bc7e0ad', '95d4be466fd6462992187d87040d3d2e', '13333', '', '123@qq.com', '515161651', '222', '2000-05-05', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-06-08 09:01:01', NULL, NULL, 'asc', 'ascw', 'asc', 'asc');
INSERT INTO `tbl_contacts` VALUES ('a8d566fc52da4c80be8d91c5ef5556c9', '40f6cdea0bd34aceb77492a1656d9fb3', '48512bfed26145d4a38d3616e2d2cf79', 'e6a007f612a945b4b0817bb01101b2af', '贾zz', '', 'sb@163.com', 'ASD222', 'CHE', '2001-01-01', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 17:58:25', NULL, NULL, '实验2', '纪要2', '2020-05-05', '235-3');
INSERT INTO `tbl_contacts` VALUES ('ad569d5a8dee492dbab86c27387d5fb2', '40f6cdea0bd34aceb77492a1656d9fb3', '86c56aca9eef49058145ec20d5466c17', '6957f349de644f0d9b3f1bf31f1e1887', '安zz', '', 'sb@qq.com', '123093912', '自行车', '2010-10-10', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 19:32:31', NULL, NULL, '实验1', '纪要1', '2020-05-04', '235');

-- ----------------------------
-- Table structure for tbl_contacts_activity_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_contacts_activity_relation`;
CREATE TABLE `tbl_contacts_activity_relation`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contacts_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_contacts_activity_relation
-- ----------------------------
INSERT INTO `tbl_contacts_activity_relation` VALUES ('4da2d2289b6f4326b68f1c103b0cca88', '3f5732a367124e62b044e4cc21bd77b0', 'e7eb0190b75e474e9f37252bd5ddc1e2');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('92bb23f818484ac79a9a002ecc60cb66', '3f5732a367124e62b044e4cc21bd77b0', '1e69037800924bdc8551e62210871260');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('fc29873d61fa483f8d61ab91e1f60519', '3f5732a367124e62b044e4cc21bd77b0', '3e4fdb1fbe5f4e0abd36d830305180ae');

-- ----------------------------
-- Table structure for tbl_contacts_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_contacts_remark`;
CREATE TABLE `tbl_contacts_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contacts_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_contacts_remark
-- ----------------------------
INSERT INTO `tbl_contacts_remark` VALUES ('013e69f508514bd9a307f09f34cc5a73', '额21', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:06:43', NULL, NULL, '0', '3f5732a367124e62b044e4cc21bd77b0');
INSERT INTO `tbl_contacts_remark` VALUES ('07a46d3eff464488a5aa95cc403c9cf9', 'h', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:46:34', NULL, NULL, '0', '3f5732a367124e62b044e4cc21bd77b0');
INSERT INTO `tbl_contacts_remark` VALUES ('0e91dde511df47f7a4e2d57e867adbb1', 'zz', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 11:56:34', NULL, NULL, '0', 'a8d566fc52da4c80be8d91c5ef5556c9');
INSERT INTO `tbl_contacts_remark` VALUES ('310e45d12ec34c0dbec9eeef393d5a58', 'ascwwww', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 11:58:57', NULL, NULL, '0', 'a8d566fc52da4c80be8d91c5ef5556c9');
INSERT INTO `tbl_contacts_remark` VALUES ('57e0aecd8b5d439192f517f12aed4763', '12dddd', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:23:46', NULL, NULL, '0', 'ad569d5a8dee492dbab86c27387d5fb2');
INSERT INTO `tbl_contacts_remark` VALUES ('b943dc4132294aa79681daa640cecaca', '123', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:06:40', NULL, NULL, '0', '3f5732a367124e62b044e4cc21bd77b0');

-- ----------------------------
-- Table structure for tbl_customer
-- ----------------------------
DROP TABLE IF EXISTS `tbl_customer`;
CREATE TABLE `tbl_customer`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_customer
-- ----------------------------
INSERT INTO `tbl_customer` VALUES ('127b61336d364dedbd58b1eb110c6a31', '40f6cdea0bd34aceb77492a1656d9fb3', '实时', 'qwe.com', NULL, '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 23:57:43', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_customer` VALUES ('1a4d85269e074e76bbc2cff73bd7bebb', '40f6cdea0bd34aceb77492a1656d9fb3', '安氏', '阿萨.com', '1615', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-17 11:07:49', NULL, NULL, 'yyy', '2020-05-06', 'ssss', '2125-5');
INSERT INTO `tbl_customer` VALUES ('6957f349de644f0d9b3f1bf31f1e1887', '40f6cdea0bd34aceb77492a1656d9fb3', '安氏', '123123.com', '12344', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 19:32:31', NULL, NULL, '纪要1', '2020-05-04', '实验1', '235');
INSERT INTO `tbl_customer` VALUES ('7b837162787449dbb9a26535fc5e390a', '40f6cdea0bd34aceb77492a1656d9fb3', '11', 'asc.cw', 'a1651', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-17 11:07:41', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_customer` VALUES ('95d4be466fd6462992187d87040d3d2e', '40f6cdea0bd34aceb77492a1656d9fb3', 'jjasc', 'ascw#.cn', '1548113', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-06-08 09:01:01', NULL, NULL, 'ascw', 'asc', 'asc', 'asc');
INSERT INTO `tbl_customer` VALUES ('dbcbb5795d5b498eb65fc0663e42d043', '40f6cdea0bd34aceb77492a1656d9fb3', '安氏', '22.16322', NULL, '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 23:58:26', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_customer` VALUES ('e6a007f612a945b4b0817bb01101b2af', '40f6cdea0bd34aceb77492a1656d9fb3', '贾氏', '1222.COM', '12312312312', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 17:58:25', NULL, NULL, '纪要2', '2020-05-05', '实验2', '235-3');
INSERT INTO `tbl_customer` VALUES ('f20349d5cec044c99a4b409b2b5fc2e6', '40f6cdea0bd34aceb77492a1656d9fb3', '11', 'ascw.com', NULL, '40f6cdea0bd34aceb77492a1656d9fb3', '2021-06-08 08:50:54', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_customer_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_customer_remark`;
CREATE TABLE `tbl_customer_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_customer_remark
-- ----------------------------
INSERT INTO `tbl_customer_remark` VALUES ('3ab9b086f8e9411b872d3e5e7325a342', '额21', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:06:43', NULL, NULL, '0', '95d4be466fd6462992187d87040d3d2e');
INSERT INTO `tbl_customer_remark` VALUES ('6b06caa9f1404f15a93a8149ff4ff0ce', 'h', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:46:34', NULL, NULL, '0', '95d4be466fd6462992187d87040d3d2e');
INSERT INTO `tbl_customer_remark` VALUES ('72a7459ddd0a4948b0bac316320f241a', '123', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:06:40', NULL, NULL, '0', '95d4be466fd6462992187d87040d3d2e');
INSERT INTO `tbl_customer_remark` VALUES ('7b33d31097b64931a811f4a1fd36c699', 'ascwwww', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 11:58:57', NULL, NULL, '0', 'e6a007f612a945b4b0817bb01101b2af');
INSERT INTO `tbl_customer_remark` VALUES ('8e532d66fc6245af9b27f8939cb1cbbb', '12dddd', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:23:46', NULL, NULL, '0', '6957f349de644f0d9b3f1bf31f1e1887');
INSERT INTO `tbl_customer_remark` VALUES ('e1aceb2ea6a24b4492c2719cab83c994', 'zz', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 11:56:34', NULL, NULL, '0', 'e6a007f612a945b4b0817bb01101b2af');

-- ----------------------------
-- Table structure for tbl_dic_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dic_type`;
CREATE TABLE `tbl_dic_type`  (
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码是主键，不能为空，不能含有中文。',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_dic_type
-- ----------------------------
INSERT INTO `tbl_dic_type` VALUES ('appellation', '称呼', '');
INSERT INTO `tbl_dic_type` VALUES ('clueState', '线索状态', '');
INSERT INTO `tbl_dic_type` VALUES ('minzu', '种族', '种族');
INSERT INTO `tbl_dic_type` VALUES ('returnPriority', '回访优先级', '');
INSERT INTO `tbl_dic_type` VALUES ('returnState', '回访状态', '');
INSERT INTO `tbl_dic_type` VALUES ('source', '来源', '');
INSERT INTO `tbl_dic_type` VALUES ('stage', '阶段', '');

-- ----------------------------
-- Table structure for tbl_dic_value
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dic_value`;
CREATE TABLE `tbl_dic_value`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键，采用UUID',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '不能为空，并且要求同一个字典类型下字典值不能重复，具有唯一性。',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可以为空',
  `order_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可以为空，但不为空的时候，要求必须是正整数',
  `type_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_dic_value
-- ----------------------------
INSERT INTO `tbl_dic_value` VALUES ('06e3cbdf10a44eca8511dddfc6896c55', '虚假线索', '虚假线索', '4', 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('0fe33840c6d84bf78df55d49b169a894', '销售邮件', '销售邮件', '8', 'source');
INSERT INTO `tbl_dic_value` VALUES ('12302fd42bd349c1bb768b19600e6b20', '交易会', '交易会', '11', 'source');
INSERT INTO `tbl_dic_value` VALUES ('1615f0bb3e604552a86cde9a2ad45bea', '最高', '最高', '2', 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('176039d2a90e4b1a81c5ab8707268636', '教授', '教授', '5', 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('1e0bd307e6ee425599327447f8387285', '将来联系', '将来联系', '2', 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('2173663b40b949ce928db92607b5fe57', '丢失线索', '丢失线索', '5', 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('2876690b7e744333b7f1867102f91153', '未启动', '未启动', '1', 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('29805c804dd94974b568cfc9017b2e4c', '07成交', '07成交', '7', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('310e6a49bd8a4962b3f95a1d92eb76f4', '试图联系', '试图联系', '1', 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('31539e7ed8c848fc913e1c2c93d76fd1', '博士', '博士', '4', 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('37ef211719134b009e10b7108194cf46', '01资质审查', '01资质审查', '1', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('391807b5324d4f16bd58c882750ee632', '08丢失的线索', '08丢失的线索', '8', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('3a39605d67da48f2a3ef52e19d243953', '聊天', '聊天', '14', 'source');
INSERT INTO `tbl_dic_value` VALUES ('474ab93e2e114816abf3ffc596b19131', '低', '低', '3', 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('48512bfed26145d4a38d3616e2d2cf79', '广告', '广告', '1', 'source');
INSERT INTO `tbl_dic_value` VALUES ('4d03a42898684135809d380597ed3268', '合作伙伴研讨会', '合作伙伴研讨会', '9', 'source');
INSERT INTO `tbl_dic_value` VALUES ('59795c49896947e1ab61b7312bd0597c', '先生', '先生', '1', 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('5c6e9e10ca414bd499c07b886f86202a', '高', '高', '1', 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('67165c27076e4c8599f42de57850e39c', '夫人', '夫人', '2', 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('68a1b1e814d5497a999b8f1298ace62b', '09因竞争丢失关闭', '09因竞争丢失关闭', '9', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('6b86f215e69f4dbd8a2daa22efccf0cf', 'web调研', 'web调研', '13', 'source');
INSERT INTO `tbl_dic_value` VALUES ('72f13af8f5d34134b5b3f42c5d477510', '合作伙伴', '合作伙伴', '6', 'source');
INSERT INTO `tbl_dic_value` VALUES ('7c07db3146794c60bf975749952176df', '未联系', '未联系', '6', 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('86c56aca9eef49058145ec20d5466c17', '内部研讨会', '内部研讨会', '10', 'source');
INSERT INTO `tbl_dic_value` VALUES ('9095bda1f9c34f098d5b92fb870eba17', '进行中', '进行中', '3', 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('966170ead6fa481284b7d21f90364984', '已联系', '已联系', '3', 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('96b03f65dec748caa3f0b6284b19ef2f', '推迟', '推迟', '2', 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('9ca96290352c40688de6596596565c12', '完成', '完成', '4', 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('9e6d6e15232549af853e22e703f3e015', '需要条件', '需要条件', '7', 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('9ff57750fac04f15b10ce1bbb5bb8bab', '02需求分析', '02需求分析', '2', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('a70dc4b4523040c696f4421462be8b2f', '等待某人', '等待某人', '5', 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('a83e75ced129421dbf11fab1f05cf8b4', '推销电话', '推销电话', '2', 'source');
INSERT INTO `tbl_dic_value` VALUES ('ab8472aab5de4ae9b388b2f1409441c1', '常规', '常规', '5', 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('ab8c2a3dc05f4e3dbc7a0405f721b040', '05提案/报价', '05提案/报价', '5', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('b924d911426f4bc5ae3876038bc7e0ad', 'web下载', 'web下载', '12', 'source');
INSERT INTO `tbl_dic_value` VALUES ('c13ad8f9e2f74d5aa84697bb243be3bb', '03价值建议', '03价值建议', '3', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('c83c0be184bc40708fd7b361b6f36345', '最低', '最低', '4', 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('db867ea866bc44678ac20c8a4a8bfefb', '员工介绍', '员工介绍', '3', 'source');
INSERT INTO `tbl_dic_value` VALUES ('e44be1d99158476e8e44778ed36f4355', '04确定决策者', '04确定决策者', '4', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('e5f383d2622b4fc0959f4fe131dafc80', '女士', '女士', '3', 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('e81577d9458f4e4192a44650a3a3692b', '06谈判/复审', '06谈判/复审', '6', 'stage');
INSERT INTO `tbl_dic_value` VALUES ('fb65d7fdb9c6483db02713e6bc05dd19', '在线商场', '在线商场', '5', 'source');
INSERT INTO `tbl_dic_value` VALUES ('fd677cc3b5d047d994e16f6ece4d3d45', '公开媒介', '公开媒介', '7', 'source');
INSERT INTO `tbl_dic_value` VALUES ('ff802a03ccea4ded8731427055681d48', '外部介绍', '外部介绍', '4', 'source');

-- ----------------------------
-- Table structure for tbl_tran
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tran`;
CREATE TABLE `tbl_tran`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expected_date` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contacts_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tran
-- ----------------------------
INSERT INTO `tbl_tran` VALUES ('07ca93cdcd2944e893a59856ad7cbf03', '40f6cdea0bd34aceb77492a1656d9fb3', '200', '吐车上200', '2020-05-09', 'dbcbb5795d5b498eb65fc0663e42d043', '9ff57750fac04f15b10ce1bbb5bb8bab', '954b410341e7433faa468d3c4f7cf0d2', '48512bfed26145d4a38d3616e2d2cf79', NULL, '3f5732a367124e62b044e4cc21bd77b0', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 23:58:26', NULL, NULL, '1234', '1124', '2020-05-05');
INSERT INTO `tbl_tran` VALUES ('50d6363589b147a88523d718702ad06f', '06f5fc056eac41558a964f96daa7f27c', '22', '魏晨魏晨', '', '127b61336d364dedbd58b1eb110c6a31', '37ef211719134b009e10b7108194cf46', '954b410341e7433faa468d3c4f7cf0d2', '48512bfed26145d4a38d3616e2d2cf79', NULL, '3f5732a367124e62b044e4cc21bd77b0', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 23:57:43', NULL, NULL, '', '', '');
INSERT INTO `tbl_tran` VALUES ('84f1a909da0940309df0ce11fac282d5', '06f5fc056eac41558a964f96daa7f27c', '123', '作者', '2020-05-15', 'f20349d5cec044c99a4b409b2b5fc2e6', '9ff57750fac04f15b10ce1bbb5bb8bab', '954b410341e7433faa468d3c4f7cf0d2', '86c56aca9eef49058145ec20d5466c17', NULL, 'a8d566fc52da4c80be8d91c5ef5556c9', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-06-08 08:50:54', NULL, NULL, '12', '12', '12');
INSERT INTO `tbl_tran` VALUES ('a4d166b242f842b6862d87db601b5005', '40f6cdea0bd34aceb77492a1656d9fb3', '1111111', 'jjasc-', '2021-06-04', '95d4be466fd6462992187d87040d3d2e', 'c13ad8f9e2f74d5aa84697bb243be3bb', '954b410341e7433faa468d3c4f7cf0d2', '48512bfed26145d4a38d3616e2d2cf79', '1e69037800924bdc8551e62210871260', '3f5732a367124e62b044e4cc21bd77b0', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-06-08 09:01:01', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_tran` VALUES ('fa5dd11b5d2f4daea74c9b6c50bcac23', '40f6cdea0bd34aceb77492a1656d9fb3', '800', '贾氏-交易1', '2020-05-15', 'e6a007f612a945b4b0817bb01101b2af', 'e44be1d99158476e8e44778ed36f4355', '954b410341e7433faa468d3c4f7cf0d2', '86c56aca9eef49058145ec20d5466c17', '3e4fdb1fbe5f4e0abd36d830305180ae', 'a8d566fc52da4c80be8d91c5ef5556c9', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 17:58:25', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_tran_history
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tran_history`;
CREATE TABLE `tbl_tran_history`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expected_date` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tran_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tran_history
-- ----------------------------
INSERT INTO `tbl_tran_history` VALUES ('075ae65e965e4bd1bdc78af4bf501d6d', '9ff57750fac04f15b10ce1bbb5bb8bab', '200', '2020-05-09', '2021-04-24 23:58:26', '40f6cdea0bd34aceb77492a1656d9fb3', '07ca93cdcd2944e893a59856ad7cbf03');
INSERT INTO `tbl_tran_history` VALUES ('4db7b88c1ad44171a9d6ffb83634fa94', '', '111', '2020-4-29', '2021-04-17 11:07:42', '40f6cdea0bd34aceb77492a1656d9fb3', 'f594374ffcda4066907f1e643025b6dd');
INSERT INTO `tbl_tran_history` VALUES ('5c2ab3332cf34fd3ade171eb36a71a13', '37ef211719134b009e10b7108194cf46', '', '', '2021-04-24 23:57:43', '40f6cdea0bd34aceb77492a1656d9fb3', '50d6363589b147a88523d718702ad06f');
INSERT INTO `tbl_tran_history` VALUES ('91da781b2bcf45d0947a5d2b06b599e8', '', '', '', '2021-04-17 11:07:49', '40f6cdea0bd34aceb77492a1656d9fb3', '3c26b2cc5b69488cb6fb47566680ce4f');
INSERT INTO `tbl_tran_history` VALUES ('a98e4515c15b4e1fb80598080b28fb5a', '9ff57750fac04f15b10ce1bbb5bb8bab', '123', '2020-05-15', '2021-06-08 08:50:54', '40f6cdea0bd34aceb77492a1656d9fb3', '84f1a909da0940309df0ce11fac282d5');

-- ----------------------------
-- Table structure for tbl_tran_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tran_remark`;
CREATE TABLE `tbl_tran_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tran_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tran_remark
-- ----------------------------
INSERT INTO `tbl_tran_remark` VALUES ('83fa96dfc9d74c6ab2010c86fc5fb3b1', 'h', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:46:34', NULL, NULL, '0', 'a4d166b242f842b6862d87db601b5005');
INSERT INTO `tbl_tran_remark` VALUES ('aea7fb05e4ab475680fe5c58be20f4ea', 'zz', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 11:56:34', NULL, NULL, '0', 'fa5dd11b5d2f4daea74c9b6c50bcac23');
INSERT INTO `tbl_tran_remark` VALUES ('bccb1cd12e2a4409af7eab4cee013820', 'ascwwww', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 11:58:57', NULL, NULL, '0', 'fa5dd11b5d2f4daea74c9b6c50bcac23');
INSERT INTO `tbl_tran_remark` VALUES ('f0f05f867d104c239bc1cd9f2d0c4848', '123', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:06:40', NULL, NULL, '0', 'a4d166b242f842b6862d87db601b5005');
INSERT INTO `tbl_tran_remark` VALUES ('f8e864eebe474001adaabd0e9dcef1b3', '额21', '40f6cdea0bd34aceb77492a1656d9fb3', '2021-04-24 18:06:43', NULL, NULL, '0', 'a4d166b242f842b6862d87db601b5005');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uuid\r\n            ',
  `login_act` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '???벻?ܲ??????Ĵ洢?????????ģ?MD5????֮?????',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expire_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ʧЧʱ??Ϊ?յ?ʱ????ʾ????ʧЧ??ʧЧʱ??Ϊ2018-10-10 10:10:10??????ʾ?ڸ?ʱ??֮ǰ???˻????á?',
  `lock_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????״̬Ϊ??ʱ??ʾ???ã?Ϊ0ʱ??ʾ??????Ϊ1ʱ??ʾ???á?',
  `dept_no` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `allow_ips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '???????ʵ?IPΪ??ʱ??ʾIP??ַ???????ޣ????????ʵ?IP??????һ????Ҳ?????Ƕ???????????IP??ַ??ʱ????ð??Ƕ??ŷָ???????IP??192.168.100.2????ʾ???û?ֻ????IP??ַΪ192.168.100.2?Ļ?????ʹ?á?',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('06f5fc056eac41558a964f96daa7f27c', 'ls', '李四', '202cb962ac59075b964b07152d234b70', 'ls@163.com', '2018-11-27 21:50:05', '1', 'A001', '192.168.1.1', '2018-11-22 12:11:40', '李四', NULL, NULL);
INSERT INTO `tbl_user` VALUES ('40f6cdea0bd34aceb77492a1656d9fb3', 'zs', '张三', '123', 'zs@qq.com', '2021-11-30 23:50:55', '1', 'A001', '192.168.1.1,192.168.1.2,127.0.0.1，0:0:0:0:0:0:0:1', '2020-11-22 11:37:34', '张三', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
