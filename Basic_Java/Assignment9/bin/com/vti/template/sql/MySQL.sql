-- =============================================
-- Create database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS QuanLyUser;
-- Create database
CREATE DATABASE IF NOT EXISTS QuanLyUser;
USE QuanLyUser;

-- Drop the table if it already exists
DROP TABLE IF EXISTS 	`user`;
CREATE TABLE `user` (
		`firstname` 		VARCHAR(50) NOT NULL,
		`lastname`  		VARCHAR(50) NOT NULL,
		`email` 			VARCHAR(30) NOT NULL PRIMARY KEY
		);

