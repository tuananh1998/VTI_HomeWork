-- Ex1
-- Question 1
-- Create Database
	DROP DATABASE IF EXISTS Project_Company;
	CREATE DATABASE IF NOT EXISTS Project_Company;
-- Use Database
	USE Project_Company;
-- Drop table if exists 
	DROP TABLE IF EXISTS Work_Done;
	DROP TABLE IF EXISTS Project_Modules;
	DROP TABLE IF EXISTS Projects;
	DROP TABLE IF EXISTS Employee;
-- Create Table   
   -- Create Table Employee
	CREATE TABLE 	Employee (
		EmployeeID 					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
		EmployeeLastName 			VARCHAR(30) NOT NULL,
		EmployeeFistName 			VARCHAR(30) NOT NULL,
		EmployeeHireDate 			DATE NOT NULL,
		EmployeeStatus 				BIT NOT NULL,
        SupervisorID				MEDIUMINT NOT NULL,
        SocialSecurityNumber		MEDIUMINT NOT NULL,
		FOREIGN KEY (SupervisorID) REFERENCES Employee(EmployeeID)
	);
     -- Create Table Projects
	CREATE TABLE 	Projects (
		ProjectID 					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
		EmployeeID 					MEDIUMINT NOT NULL,
		ProjectName 				VARCHAR(200) NOT NULL,
		ProjectStartDate 			DATE NOT NULL,
		ProjectDescription 			VARCHAR(500) NOT NULL,
        ProjectDetailt				VARCHAR(500) NOT NULL,
        ProjectCompletedOn			DATE NOT NULL,
		FOREIGN KEY (EmployeeID) REFERENCES  Employee(EmployeeID) ON DELETE NO ACTION
	);
-- Create Table Project_Modules
	CREATE TABLE 	Project_Modules (
		ModuleID 					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
		ProjectID 					MEDIUMINT NOT NULL,
        EmployeeID					MEDIUMINT NOT NULL,
        ProjectModulesDate			DATE NOT NULL,
        ProjectModulesCompledOn 	DATE NOT NULL,
        ProjectModulesDescription	VARCHAR(500) NOT NULL,
        FOREIGN KEY (ProjectID)  REFERENCES  Projects(ProjectID)  ON DELETE CASCADE,
        FOREIGN KEY (EmployeeID) REFERENCES  Employee(EmployeeID) ON DELETE NO ACTION
	);
    -- Create Table Work_Done
	CREATE TABLE 	Work_Done (
		WorkDoneID 					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
		EmployeeID 					MEDIUMINT NOT NULL,
		ModuleID 					MEDIUMINT NOT NULL,
		WorkDoneDate 				DATE NOT NULL,
		WorkDoneDescription 		VARCHAR(500) NOT NULL,
        WorkDoneStatus				BIT NOT NULL,
		FOREIGN KEY (ModuleID) 	REFERENCES  Project_Modules(ModuleID) ON DELETE CASCADE,
        FOREIGN KEY (EmployeeID) REFERENCES  Employee(EmployeeID) ON DELETE NO ACTION
	);
   
   
    -- Question A
     -- Insert Employee
    INSERT INTO	Employee
	(EmployeeLastName, 		EmployeeFistName,	EmployeeHireDate,		EmployeeStatus,					SupervisorID,			  SocialSecurityNumber)
	VALUES
	('A',					'CT',				'2000-03-01',			0,								1,						   123),
	('B',					'CT',				'2000-05-01',			1,								2,						   1234),
	('C',					'CT',				'2000-06-01',			1,								3,						   1236);
     -- Insert Projects
    INSERT INTO	Projects
	(EmployeeID, 			ProjectName,		ProjectStartDate,		ProjectDescription,				ProjectDetailt,			  ProjectCompletedOn)
	VALUES
	(1,						'XYZ',				'2000-05-01',			'AAA',							'BBB',					  '2000-08-01'),
	(2,						'XYZ',				'2000-06-01',			'AAA',							'BBB',					  '2000-08-01'),
	(3,						'XXX',				'2000-05-01',			'AAA',							'BBB',					  '2000-08-01');
    -- Insert Project_Modules
	INSERT INTO Project_Modules
	(ProjectID, 			EmployeeID,			ProjectModulesDate,		ProjectModulesCompledOn,		ProjectModulesDescription)
	VALUES
	(1,						1,					'2000-03-01',			'2000-08-01',					'ABC'),
	(2,						2,					'2019-10-01',			'2019-11-05',					'ABC'),
	(1,						1,					'2000-05-01',			'2000-08-01',					'ABC'),
    (1,						1,					'2019-06-01',			'2019-11-05',					'ABC'),
    (1,						2,					'2019-06-01',			'2019-11-05',					'ABCE');
   
	-- Insert Work_Done
	INSERT INTO Work_Done
	(EmployeeID, 			ModuleID,			WorkDoneDate,			WorkDoneDescription,			WorkDoneStatus)
	VALUES
	(1,						1,					'2000-03-01',			'MMM',							1),
	(2,						1,					'2000-04-01',			'MMM',							1),
	(3,						2,					'2000-04-01',			'MMM',							1);
    
    -- Question B
     -- Drop procedure if exists Remove_project()
    DROP PROCEDURE IF EXISTS Remove_project;
    DELIMITER $$ 
    CREATE PROCEDURE Remove_project(OUT rNUM INT)
			BEGIN
				DROP TABLE IF EXISTS Find;
				CREATE TEMPORARY TABLE Find(
                row_Num SMALLINT);
				INSERT INTO 	Find(
					SELECT 	COUNT(*)
					FROM 	Projects
					WHERE 	MONTH(ProjectCompletedOn)-MONTH(ProjectStartDate)=3);
                -- print rownumber    
				SELECT row_Num INTO rNum
				FROM   			Find;
                -- DELETE project workdone on 3 month
				DELETE FROM 	Projects 
                WHERE 			MONTH(ProjectCompletedOn)-MONTH(ProjectStartDate)=3;
                
			END$$
	DELIMITER ;
    CALL 	Remove_project(@rNUM);
    SELECT	@rNUM AS Row_Number_effect;
    
    -- Question C
     -- Drop procedure if exists Remove_Project_Modules()
    DROP PROCEDURE IF EXISTS get_Active_Modules;
    DELIMITER $$ 
    CREATE PROCEDURE get_Active_Modules()
			BEGIN
				SELECT 		* 
                FROM  		Project_Modules 
                WHERE 		ProjectModulesCompledOn>CURDATE();
			END$$
	DELIMITER ;
   
    -- Call Remove_project()
    CALL get_Active_Modules();
	
	-- Question D
    DROP FUNCTION IF EXISTS findEmployee;
	DELIMITER $$
	CREATE FUNCTION findEmployee() 
	 RETURNS MEDIUMINT
	 READS SQL DATA
			BEGIN
			DECLARE ID INT;
					SELECT 	e.EmployeeID INTO ID
					FROM 	Employee e
					WHERE 	e.EmployeeID IN(
							SELECT	  wd.EmployeeID
							FROM	  Work_Done wd
							WHERE 	  wd.EmployeeID NOT IN(
										SELECT	  pm.EmployeeID
										FROM	  Project_Modules pm));
			RETURN ID;
		END $$
	DELIMITER ;
    -- USE Function
    SELECT 	findEmployee() AS EmployeeID;
    -- PRINT INFORMATION EMPLOYEE (Question D)
	SELECT   *
	FROM   	Employee
	WHERE  	EmployeeID = (SELECT FINDEMPLOYEE());
    
  
    
    
	
	
