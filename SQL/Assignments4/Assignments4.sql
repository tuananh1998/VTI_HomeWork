-- Ex1
-- Question 1
-- Create Database
	DROP DATABASE IF EXISTS Assignment;
	CREATE DATABASE IF NOT EXISTS Assignment;
-- Use Database
	USE Assignment;
-- Drop table if exists 
	DROP TABLE IF EXISTS Employee_Table;
	DROP TABLE IF EXISTS Department;
	DROP TABLE IF EXISTS Employee_Skill_Table;
    
 -- Create Table   
-- Create Table Department

	CREATE TABLE 	Department (
		Department_Number 	TINYINT AUTO_INCREMENT PRIMARY KEY,
		Department_Name 	NVARCHAR(100) NOT NULL UNIQUE
	);
    
-- Create Table Employee

	CREATE TABLE 	Employee_Table (
		Employee_Number 	TINYINT AUTO_INCREMENT PRIMARY KEY,
		Employee_Name 		NVARCHAR(100) NOT NULL,
		Department_Number 	TINYINT NOT NULL,
		FOREIGN KEY (Department_Number) REFERENCES Department (Department_Number) ON DELETE CASCADE
	);
 
-- Create Table Employee_Skill_Table

	CREATE TABLE 	Employee_Skill_Table (
		Skill_Code 			VARCHAR(30) NOT NULL PRIMARY KEY,
		Employee_Number 	TINYINT  NOT NULL,
		Date_Registered 	DATE NOT NULL, 
       FOREIGN KEY (Employee_Number) REFERENCES  Employee_Table(Employee_Number) ON DELETE CASCADE
	);
	 
-- Question 2
-- Insert Table
-- Insert Department

	INSERT INTO 	Department
    (Department_Name)
	VALUES
	('Department 1'),
	('Department 2'),
	('Department 3'),
	('Department 4'),
	('Department 5'),
	('Department 6'),
	('Department 7'),
	('Department 8'),
	('Department 9'),
	('Department 10'),
	('Department 11');
    
-- Insert Employee_Table           

	INSERT INTO 	Employee_Table
	(Employee_Name,			Department_Number)
	VALUES
	('nguyễn văn A',		1),
	('nguyễn văn B',		2),
	('nguyễn văn C',		3),
	('nguyễn văn D',		4),
	('nguyễn văn E',		5),
	('nguyễn văn F',		6),
	('nguyễn văn G',		1),
	('nguyễn văn H',		1),
	('nguyễn văn J',		9),
	('nguyễn văn K',		1);
    
-- Insert Employee_Skill_Table

	INSERT INTO 	Employee_Skill_Table
	(Skill_Code,			Employee_Number,			Date_Registered)
	VALUES
	('java',				1,							'2000-03-01'),
	('.C',					1,							'2001-03-01'),
	('.net',				1,							'2001-03-01'),
	('Oracel',				2,							'2002-03-01'),
	('C++',					2,							'2003-03-01'),
	('JavaScript',			3,							'2004-03-01'),
	('Fortran',				4,							'2005-03-01');
	
	
-- Question 3
	SELECT 			et.Employee_Number,et.Employee_Name
	FROM 			Employee_Table et
    INNER JOIN		Employee_Skill_Table est ON et.Employee_Number=est.Employee_Number
    WHERE 			est.Skill_Code='java';
    
-- Question 4
	
	SELECT 			d.Department_Number,d.Department_Name,COUNT(d.Department_Number) AS Department_count
	FROM 			Department d
    INNER JOIN		Employee_Table et ON et.Department_Number=d.Department_Number
    GROUP BY		d.Department_Number
	HAVING			COUNT(d.Department_Number)>3;
    
-- Question 5

	SELECT 			d.Department_Number,d.Department_Name,et.Employee_Number,et.Employee_Name
	FROM 			Department d
    INNER JOIN		Employee_Table et ON et.Department_Number=d.Department_Number
	ORDER BY    	d.Department_Number ASC;
    
-- Question 6
			
    SELECT 			et.Employee_Number,et.Employee_Name,et.Department_Number,COUNT(est.Employee_Number) AS Employee_Skill_Count
	FROM 			Employee_Table et
    INNER JOIN		Employee_Skill_Table est ON et.Employee_Number=est.Employee_Number
    GROUP BY		est.Employee_Number
    HAVING			COUNT(est.Employee_Number)>1;

		
	




