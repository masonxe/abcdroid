/*
 Navicat Premium Data Transfer

 Source Server         : EjmRoboGuiceSqlite
 Source Server Type    : SQLite
 Source Server Version : 3007010
 Source Database       : main

 Target Server Type    : SQLite
 Target Server Version : 3007010
 File Encoding         : utf-8

 Date: 08/03/2012 22:54:32 PM
*/

PRAGMA foreign_keys = false;

-- ----------------------------
--  Table structure for "personas"
-- ----------------------------
DROP TABLE IF EXISTS "personas";
CREATE TABLE "personas" (
	 "dni" text NOT NULL,
	 "apPaterno" text NOT NULL,
	 "apMaterno" text NOT NULL,
	 "nombres" text NOT NULL,
	PRIMARY KEY("dni")
);

-- ----------------------------
--  Records of "personas"
-- ----------------------------
BEGIN;
INSERT INTO "personas" VALUES (44444444, 'Perez', 'Lopez', 'Juan');
INSERT INTO "personas" VALUES (12121212, 'Vargas', 'Dominguez', 'Maria');
INSERT INTO "personas" VALUES (23232323, 'Suarez', 'Alva', 'Jose');
COMMIT;

PRAGMA foreign_keys = true;
