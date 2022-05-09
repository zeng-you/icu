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

 Date: 09/05/2022 18:00:41
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
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."admin";
CREATE TABLE "public"."admin" (
  "id" int8 NOT NULL DEFAULT nextval('admin_id_seq'::regclass),
  "pwd" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "salt" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "phone" varchar(11) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "avatar" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "email" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "department_id" int8 DEFAULT 0,
  "add_time" timestamp(6),
  "edit_time" timestamp(6),
  "add_admin" int8 DEFAULT 0,
  "edit_admin" int8 DEFAULT 0,
  "del" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar,
  "status" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar
)
;
COMMENT ON COLUMN "public"."admin"."pwd" IS '密码';
COMMENT ON COLUMN "public"."admin"."salt" IS '盐';
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

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."admin_id_seq"
OWNED BY "public"."admin"."id";
SELECT setval('"public"."admin_id_seq"', 1, false);

-- ----------------------------
-- Primary Key structure for table admin
-- ----------------------------
ALTER TABLE "public"."admin" ADD CONSTRAINT "admin_pkey" PRIMARY KEY ("id");
