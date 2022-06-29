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

 Date: 29/06/2022 10:35:30
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
-- Sequence structure for role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."role_id_seq";
CREATE SEQUENCE "public"."role_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tenant_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tenant_id_seq";
CREATE SEQUENCE "public"."tenant_id_seq" 
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
  "nickname" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "email" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "dept_id" int8 DEFAULT 0,
  "add_time" timestamp(0),
  "edit_time" timestamp(0),
  "del" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar,
  "status" char(1) COLLATE "pg_catalog"."default" DEFAULT '1'::bpchar,
  "tenant_id" int8 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."admin"."pwd" IS '密码';
COMMENT ON COLUMN "public"."admin"."phone" IS '手机号码';
COMMENT ON COLUMN "public"."admin"."avatar" IS '头像';
COMMENT ON COLUMN "public"."admin"."nickname" IS '昵称';
COMMENT ON COLUMN "public"."admin"."email" IS '邮箱';
COMMENT ON COLUMN "public"."admin"."dept_id" IS '部门 dept id';
COMMENT ON COLUMN "public"."admin"."add_time" IS '添加时间';
COMMENT ON COLUMN "public"."admin"."edit_time" IS '编辑时间';
COMMENT ON COLUMN "public"."admin"."del" IS '删除（0：否，1：是）';
COMMENT ON COLUMN "public"."admin"."status" IS '状态（0：禁用，1：正常）';
COMMENT ON COLUMN "public"."admin"."tenant_id" IS '所属租户 tenant id';
COMMENT ON TABLE "public"."admin" IS '管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO "public"."admin" VALUES (1, '92925488b28ab12584ac8fcaa8a27a0f497b2c62940c8f4fbc8ef19ebc87c43e', '15989788839', '', '', '', 0, NULL, NULL, '0', '1', 0);

-- ----------------------------
-- Table structure for admin_id_card
-- ----------------------------
DROP TABLE IF EXISTS "public"."admin_id_card";
CREATE TABLE "public"."admin_id_card" (
  "name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "gender" char(1) COLLATE "pg_catalog"."default" DEFAULT '男'::bpchar,
  "nationality" varchar(10) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "number" varchar(20) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "address" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "issuing_authority" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "effective_start_time" date,
  "effective_deadline" date,
  "admin_id" int8 DEFAULT 0,
  "front" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "back" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "birthday" date,
  "age" int2 DEFAULT 0,
  "avatar" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "add_time" timestamp(0),
  "edit_time" timestamp(0),
  "del" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar,
  "tenant_id" int8
)
;
COMMENT ON COLUMN "public"."admin_id_card"."name" IS '姓名';
COMMENT ON COLUMN "public"."admin_id_card"."gender" IS '性别';
COMMENT ON COLUMN "public"."admin_id_card"."nationality" IS '民族';
COMMENT ON COLUMN "public"."admin_id_card"."number" IS '身份证号码';
COMMENT ON COLUMN "public"."admin_id_card"."address" IS '地址';
COMMENT ON COLUMN "public"."admin_id_card"."issuing_authority" IS '发证机关';
COMMENT ON COLUMN "public"."admin_id_card"."effective_start_time" IS '有效起始时间';
COMMENT ON COLUMN "public"."admin_id_card"."effective_deadline" IS '有效截止时间';
COMMENT ON COLUMN "public"."admin_id_card"."admin_id" IS 'admin id';
COMMENT ON COLUMN "public"."admin_id_card"."front" IS '身份证扫描件正面';
COMMENT ON COLUMN "public"."admin_id_card"."back" IS '身份证扫描件反面';
COMMENT ON COLUMN "public"."admin_id_card"."birthday" IS '出生日期';
COMMENT ON COLUMN "public"."admin_id_card"."age" IS '年龄';
COMMENT ON COLUMN "public"."admin_id_card"."avatar" IS '身份证头像';
COMMENT ON COLUMN "public"."admin_id_card"."add_time" IS '添加时间';
COMMENT ON COLUMN "public"."admin_id_card"."edit_time" IS '编辑时间';
COMMENT ON COLUMN "public"."admin_id_card"."del" IS '删除（0：否，1：是）';
COMMENT ON COLUMN "public"."admin_id_card"."tenant_id" IS '所属租户 tenant id';
COMMENT ON TABLE "public"."admin_id_card" IS '管理身份证';

-- ----------------------------
-- Records of admin_id_card
-- ----------------------------
INSERT INTO "public"."admin_id_card" VALUES ('', '男', '', '', '', '', NULL, NULL, 1, '', '', NULL, 0, '', NULL, NULL, '0', NULL);

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
COMMENT ON COLUMN "public"."menu"."del" IS '删除（0：否，1：是）';
COMMENT ON TABLE "public"."menu" IS '菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO "public"."menu" VALUES (38, '', '', '', 0, '', 0, '1', '2022-06-14 15:11:25', '2022-06-18 17:00:13', '0');
INSERT INTO "public"."menu" VALUES (2, '菜单管理', '', 'menu/list', 1, '', 0, '0', NULL, NULL, '0');
INSERT INTO "public"."menu" VALUES (3, '菜单添加', '', 'menu/add', 2, '', 0, '1', NULL, NULL, '0');
INSERT INTO "public"."menu" VALUES (1, '权限管理', '', '', 0, '', 0, '0', NULL, '2022-06-14 15:35:33', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "public"."role";
CREATE TABLE "public"."role" (
  "id" int8 NOT NULL DEFAULT nextval('role_id_seq'::regclass),
  "name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "remark" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "add_time" timestamp(0),
  "edit_time" timestamp(0),
  "del" char(1) COLLATE "pg_catalog"."default" DEFAULT 0,
  "tenant_id" int8 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."role"."name" IS '名称';
COMMENT ON COLUMN "public"."role"."remark" IS '备注';
COMMENT ON COLUMN "public"."role"."add_time" IS '添加时间';
COMMENT ON COLUMN "public"."role"."edit_time" IS '编辑时间';
COMMENT ON COLUMN "public"."role"."del" IS '删除（0：否，1：是）';
COMMENT ON COLUMN "public"."role"."tenant_id" IS '所属租户 tenant id';
COMMENT ON TABLE "public"."role" IS '角色';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO "public"."role" VALUES (3, '角色3', '', '2022-06-16 16:16:44', '2022-06-16 16:29:52', '1', 0);
INSERT INTO "public"."role" VALUES (4, '角色3', '', '2022-06-16 16:21:06', '2022-06-16 16:30:48', '1', 0);
INSERT INTO "public"."role" VALUES (5, '角色22', '', '2022-06-16 17:15:36', '2022-06-16 17:15:36', '0', 0);
INSERT INTO "public"."role" VALUES (1, '角色22', '', NULL, '2022-06-16 17:25:58', '1', 0);
INSERT INTO "public"."role" VALUES (2, '角色2', '', NULL, '2022-06-16 17:39:44', '1', 0);

-- ----------------------------
-- Table structure for tenant
-- ----------------------------
DROP TABLE IF EXISTS "public"."tenant";
CREATE TABLE "public"."tenant" (
  "id" int8 NOT NULL DEFAULT nextval('tenant_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "add_time" timestamp(0),
  "edit_time" timestamp(0),
  "del" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar
)
;
COMMENT ON COLUMN "public"."tenant"."name" IS '名称';
COMMENT ON COLUMN "public"."tenant"."add_time" IS '添加时间';
COMMENT ON COLUMN "public"."tenant"."edit_time" IS '编辑时间';
COMMENT ON COLUMN "public"."tenant"."del" IS '删除（0：否，1：是）';
COMMENT ON TABLE "public"."tenant" IS '租户';

-- ----------------------------
-- Records of tenant
-- ----------------------------

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
SELECT setval('"public"."menu_id_seq"', 38, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."role_id_seq"
OWNED BY "public"."role"."id";
SELECT setval('"public"."role_id_seq"', 5, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tenant_id_seq"
OWNED BY "public"."tenant"."id";
SELECT setval('"public"."tenant_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table admin
-- ----------------------------
CREATE INDEX "admin_del_idx" ON "public"."admin" USING btree (
  "del" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table admin
-- ----------------------------
ALTER TABLE "public"."admin" ADD CONSTRAINT "admin_phone_tenant_id_key" UNIQUE ("phone", "tenant_id");

-- ----------------------------
-- Primary Key structure for table admin
-- ----------------------------
ALTER TABLE "public"."admin" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table admin_id_card
-- ----------------------------
CREATE INDEX "admin_id_card_del_idx" ON "public"."admin_id_card" USING btree (
  "del" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table admin_id_card
-- ----------------------------
ALTER TABLE "public"."admin_id_card" ADD CONSTRAINT "admin_id_card_number_tenant_id_key" UNIQUE ("number", "tenant_id");

-- ----------------------------
-- Indexes structure for table menu
-- ----------------------------
CREATE INDEX "menu_del_idx" ON "public"."menu" USING btree (
  "del" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table menu
-- ----------------------------
ALTER TABLE "public"."menu" ADD CONSTRAINT "menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table role
-- ----------------------------
CREATE INDEX "role_del_idx" ON "public"."role" USING btree (
  "del" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);
CREATE INDEX "role_tenant_id_idx" ON "public"."role" USING btree (
  "tenant_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE "public"."role" ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tenant
-- ----------------------------
CREATE INDEX "tenant_del_idx" ON "public"."tenant" USING btree (
  "del" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tenant
-- ----------------------------
ALTER TABLE "public"."tenant" ADD CONSTRAINT "tenant_pkey" PRIMARY KEY ("id");
