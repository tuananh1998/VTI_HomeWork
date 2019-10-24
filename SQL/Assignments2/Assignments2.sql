-- Ex1
-- Create database fresher
CREATE DATABASE IF NOT EXISTS Fresher;
-- use DB fresher
USE Fresher;
-- Create Table Trainee
CREATE TABLE Trainee
(
	TraineeID 		 INT AUTO_INCREMENT PRIMARY KEY,
	Full_Name 		 NVARCHAR(50) NOT NULL,
	Birth_Date 		 DATE NOT NULL,
	Gender 			 ENUM('M','F','U') NOT NULL, -- (M: Male, F: Female, U: Unknown)
	ET_IQ 			 TINYINT(20),
	ET_Gmath 		 TINYINT(20),
	ET_English		 TINYINT(50),
	Training_Class 	 CHAR(10) NOT NULL,
	Evaluation_Notes NVARCHAR(500)
);

-- Add VTI_Account
ALTER TABLE Trainee 
ADD VTI_Account VARCHAR(100) NOT NULL UNIQUE;

-- Ex2
-- Add Table student
CREATE TABLE student
(
	ID 				INT AUTO_INCREMENT PRIMARY KEY,
	Name  			VARCHAR(200) NOT NULL,
	Code 			CHAR(5) NOT NULL,
	ModifiedDate	DATETIME
);

-- Ex3
-- Add Table teacher
CREATE TABLE teacher
(
	ID 				INT  AUTO_INCREMENT PRIMARY KEY,
	Name  			VARCHAR(200) NOT NULL,
	Code 			CHAR(5) NOT NULL,
	BirtDate		DATE NOT NULL,
    Gender			TINYINT(2), -- 0: M, 1:F, 2:U
    IsDeleteFlag    BIT NOT NULL -- (0: Active,1: Deleted)
);
-- drop database if exists fresher
