/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_5432
 Source Server Type    : PostgreSQL
 Source Server Version : 140002
 Source Host           : 127.0.0.1:5432
 Source Catalog        : icu
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140002
 File Encoding         : 65001

 Date: 28/05/2022 08:56:05
*/


-- ----------------------------
-- Sequence structure for admin_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."admin_id_seq";
CREATE SEQUENCE "public"."admin_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."menu_id_seq";
CREATE SEQUENCE "public"."menu_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."admin";
CREATE TABLE "public"."admin" (
  "id" int8 NOT NULL DEFAULT nextval('admin_id_seq'::regclass),
  "pwd" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "phone" varchar(11) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "avatar" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "email" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "department_id" int8 DEFAULT 0,
  "add_time" timestamp(0),
  "edit_time" timestamp(0),
  "add_admin" int8 DEFAULT 0,
  "edit_admin" int8 DEFAULT 0,
  "del" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar,
  "status" char(1) COLLATE "pg_catalog"."default" DEFAULT '1'::bpchar
)
;
COMMENT ON COLUMN "public"."admin"."pwd" IS '密码';
COMMENT ON COLUMN "public"."admin"."phone" IS '手机号码';
COMMENT ON COLUMN "public"."admin"."avatar" IS '头像';
COMMENT ON COLUMN "public"."admin"."name" IS '姓名';
COMMENT ON COLUMN "public"."admin"."email" IS '邮箱';
COMMENT ON COLUMN "public"."admin"."department_id" IS '部门 department id';
COMMENT ON COLUMN "public"."admin"."add_time" IS '添加时间';
COMMENT ON COLUMN "public"."admin"."edit_time" IS '编辑时间';
COMMENT ON COLUMN "public"."admin"."add_admin" IS '添加管理员 admin id';
COMMENT ON COLUMN "public"."admin"."edit_admin" IS '编辑管理员 admin id';
COMMENT ON COLUMN "public"."admin"."del" IS '删除（0：否，1：是）';
COMMENT ON COLUMN "public"."admin"."status" IS '状态（0：禁用，1：正常）';
COMMENT ON TABLE "public"."admin" IS '管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO "public"."admin" VALUES (1, '92925488b28ab12584ac8fcaa8a27a0f497b2c62940c8f4fbc8ef19ebc87c43e', '15989788839', '', '', '', 0, NULL, NULL, 0, 0, '0', '1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."menu";
CREATE TABLE "public"."menu" (
  "id" int8 NOT NULL DEFAULT nextval('menu_id_seq'::regclass),
  "name" varchar(32) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "permission" varchar(32) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "path" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "pid" int8 DEFAULT 0,
  "icon" varchar(32) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "sort" int2 DEFAULT 0,
  "type" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar,
  "add_time" timestamp(0),
  "edit_time" timestamp(0),
  "add_admin" int8 DEFAULT 0,
  "edit_admin" int8 DEFAULT 0,
  "del" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar
)
;
COMMENT ON COLUMN "public"."menu"."name" IS '名称';
COMMENT ON COLUMN "public"."menu"."permission" IS '权限标识';
COMMENT ON COLUMN "public"."menu"."path" IS '组件路径';
COMMENT ON COLUMN "public"."menu"."pid" IS '父级id（menu id）';
COMMENT ON COLUMN "public"."menu"."icon" IS '图标';
COMMENT ON COLUMN "public"."menu"."sort" IS '排序';
COMMENT ON COLUMN "public"."menu"."type" IS '类型（0：左菜单，1：按钮，2：顶菜单）';
COMMENT ON COLUMN "public"."menu"."add_time" IS '添加时间';
COMMENT ON COLUMN "public"."menu"."edit_time" IS '编辑时间';
COMMENT ON COLUMN "public"."menu"."add_admin" IS '添加管理员 admin id';
COMMENT ON COLUMN "public"."menu"."edit_admin" IS '编辑管理员 admin id';
COMMENT ON COLUMN "public"."menu"."del" IS '删除（0：否，1：是）';
COMMENT ON TABLE "public"."menu" IS '菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO "public"."menu" VALUES (1, '权限管理', '', '', 0, '', 0, '0', NULL, NULL, 0, 0, '0');
INSERT INTO "public"."menu" VALUES (2, '菜单管理', '', 'menu/list', 1, '', 0, '0', NULL, NULL, 0, 0, '0');
INSERT INTO "public"."menu" VALUES (3, '菜单添加', '', 'menu/add', 2, '', 0, '1', NULL, NULL, 0, 0, '0');
INSERT INTO "public"."menu" VALUES (4, '', '', '', 0, '', 0, '1', NULL, NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (5, '', '', '', 0, '', 0, '1', NULL, NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (7, '', '', '', 0, '', 0, '1', NULL, NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (8, '', '', '', 0, '', 0, '1', '2022-05-27 00:00:00', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (9, '', '', '', 0, '', 0, '1', '2022-05-27 00:00:00', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (10, '', '', '', 0, '', 0, '1', NULL, NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (6, '', '', '', 0, '', 0, '1', '2022-05-27 00:00:00', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (12, '', '', '', 0, '', 0, '1', NULL, NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (13, '', '', '', 0, '', 0, '1', '2022-05-27 00:00:00', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (14, '', '', '', 0, '', 0, '1', '2022-05-27 00:00:00', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (11, '', '', '', 0, '', 0, '1', '2022-05-27 00:00:00', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (15, '', '', '', 0, '', 0, '1', '2022-05-27 00:00:00', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (16, '', '', '', 0, '', 0, '1', '2022-05-27 17:56:18', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (17, '', '', '', 0, '', 0, '1', '2022-05-27 17:56:36', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (18, '', '', '', 0, '', 0, '1', '2022-05-27 17:56:36', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (19, '', '', '', 0, '', 0, '1', '2022-05-27 17:57:09', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (20, '', '', '', 0, '', 0, '1', '2022-05-27 17:57:38', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (21, '', '', '', 0, '', 0, '1', '2022-05-27 17:58:07', NULL, 1, 0, '0');
INSERT INTO "public"."menu" VALUES (22, '', '', '', 0, '', 0, '1', '2022-05-27 18:03:42', '2022-05-27 18:03:42', 1, 0, '0');
INSERT INTO "public"."menu" VALUES (23, '', '', '', 0, '', 0, '1', '2022-05-27 18:05:30', '2022-05-27 18:05:30', 1, 0, '0');
INSERT INTO "public"."menu" VALUES (24, '', '', '', 0, '', 0, '1', '2022-05-27 18:07:25', '2022-05-27 18:07:25', 1, 0, '0');

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."admin_id_seq"
OWNED BY "public"."admin"."id";
SELECT setval('"public"."admin_id_seq"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."menu_id_seq"
OWNED BY "public"."menu"."id";
SELECT setval('"public"."menu_id_seq"', 24, true);

-- ----------------------------
-- Uniques structure for table admin
-- ----------------------------
ALTER TABLE "public"."admin" ADD CONSTRAINT "admin_phone_del_key" UNIQUE ("phone", "del");

-- ----------------------------
-- Primary Key structure for table admin
-- ----------------------------
ALTER TABLE "public"."admin" ADD CONSTRAINT "admin_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table menu
-- ----------------------------
ALTER TABLE "public"."menu" ADD CONSTRAINT "menu_pkey" PRIMARY KEY ("id");
