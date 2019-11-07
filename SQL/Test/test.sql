-- Create DB
	DROP DATABASE IF EXISTS Project;
	CREATE DATABASE IF NOT EXISTS Project;
  -- Use Database
	USE Project;
-- Drop table if exists 

	DROP TABLE IF EXISTS Student;
	DROP TABLE IF EXISTS `Subject`;
	DROP TABLE IF EXISTS StudentSubject;
    -- Create Table   
   -- Create Table Student
   
	CREATE TABLE 	Student ( 
		RN 							INT AUTO_INCREMENT PRIMARY KEY,
		`Name`						VARCHAR(50) NOT NULL,
		Age 						TINYINT NOT NULL,
		Gender 						TINYINT(1) -- 0: Male,  1: Female, null 
	);
    -- Create Table Subject
    
	CREATE TABLE 	`Subject` ( 
		sID 						INT AUTO_INCREMENT PRIMARY KEY,
		sName						VARCHAR(50) NOT NULL
	);
    -- Create Table StudentSubject
    
	CREATE TABLE 	StudentSubject (  	 	
		RN 							INT AUTO_INCREMENT,
		sID 						INT NOT NULL,
		Mark 						FLOAT NOT NULL,
		`Date` 						DATE NOT NULL,
        PRIMARY KEY(RN,sID),
        FOREIGN KEY (RN) REFERENCES   Student(RN) ON DELETE CASCADE ,
        FOREIGN KEY (sID) REFERENCES  `Subject`(sID) ON DELETE CASCADE ON UPDATE CASCADE 
	);
	-- Insert `Subject`
    INSERT INTO	Student
	(`Name`,			Age,			Gender	)
	VALUES
	('CTA',				18,				0		),
	('CTB',				19,				1		),
	('CTC',				20,				null	);
    
    -- Insert `Subject`
    INSERT INTO	`Subject`
	(sName)
	VALUES
	('Math'		),
	('Biology'	),
	('Logic'	);
    
	-- Insert StudentSubject
    INSERT INTO	StudentSubject
	(sID,			Mark,			`Date`	)
	VALUES
	(1,				9,				'2000-03-01'	),
	(1,				10,				'2000-03-02'	),
	(3,				8,				'2000-03-03'	);
    -- Question b
    -- b.a : Lấy tất cả các môn học không có bất kì điểm nào 
    SELECT  *
    FROM	`Subject` s
    WHERE	s.sID NOT IN( 
			SELECT  ss.sID
			FROM	StudentSubject ss );
	-- b.b : Lấy danh sách các môn học có ít nhất 2 điểm
     SELECT  *
	 FROM	`Subject` s
     WHERE	s.sID IN( 
			SELECT  ss.sID
			FROM	StudentSubject ss 
            GROUP BY ss.sID
            HAVING	 COUNT(ss.sID)>=2
            );
    -- Question c: Tạo "StudentInfo" view có các thông tin về học sinh bao gồm:
	-- RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show
	-- 	Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho null
	
		DROP VIEW IF EXISTS vStudentInfo;
		CREATE VIEW 		vStudentInfo 
		AS
		SELECT 	ss.RN,
				ss.sID,
                s1.`Name`,
                s1.Age, 
				CASE Gender
				WHEN 0 THEN 'Male'
				WHEN 1 THEN 'Female'
				ELSE 'Unknown'
				END AS Gender,
				s2.sName, ss.Mark, ss.`Date`
		FROM	Student s1,StudentSubject ss,`Subject` s2
        WHERE	(s1.RN=ss.RN) AND (ss.sID=s2.sID) ;
		
-- Hiển Thị view vStudentInfo
		SELECT 				*
        FROM				vStudentInfo;
        
-- Question d: 
-- d.A: Trigger CasUpdate: khi thay đổi data của cột sID, thì giá trị của
-- cột sID của table StudentSubject cũng thay đổi theo	

		DROP TRIGGER IF EXISTS CasUpdate;
		DELIMITER $$
		CREATE TRIGGER CasUpdate AFTER UPDATE ON `Subject`
		FOR EACH ROW 	
		BEGIN
			UPDATE	StudentSubject SET sID = NEW.sID
			WHERE   sID = OLD.sID ;
		END$$
		DELIMITER ;
        
-- Thử update dữ liệu để check trigger
		UPDATE `Subject` SET sID=6 WHERE sID=1;
        SELECT * FROM `Subject`;
        SELECT * FROM StudentSubject;
 -- d.b: Trigger casDel: Khi xóa 1 student, các dữ liệu của table
 -- StudentSubject cũng sẽ bị xóa theo
		DROP TRIGGER IF EXISTS casDel;
		DELIMITER $$
		CREATE TRIGGER casDel AFTER UPDATE ON Student
		FOR EACH ROW 	
		BEGIN
			DELETE FROM	StudentSubject WHERE RN = OLD.RN;
		END$$
		DELIMITER ;
-- Thử DELETE dữ liệu để check trigger
		DELETE 	FROM Student WHERE RN=2;
-- In ra Student để check Trigger        
        SELECT * FROM Student;
-- In ra StudentSubject để check Trigger   
        SELECT * FROM StudentSubject;
-- Question E
	DROP PROCEDURE IF EXISTS Remove_Student;
    DELIMITER $$ 
    CREATE PROCEDURE Remove_Student(IN student_name VARCHAR(50),IN mark FLOAT)
			BEGIN
				-- Tạo bảng getID để lấy ra getID để từ nhập vào student_name nhập vào
				DROP TEMPORARY TABLE IF EXISTS getID;
				CREATE TEMPORARY TABLE getID(
                RN INT);
				INSERT INTO 	getID(
					SELECT 	RN
                    FROM	Student
                    WHERE 	`Name`=student_name
                );
                -- Tạo bảng getDiem để in ra Điểm từ student_name nhập vào
                DROP TEMPORARY TABLE IF EXISTS getDiem;
				CREATE TEMPORARY TABLE getDiem(
                Diem FLOAT);
				INSERT INTO 	getDiem(
						SELECT 		ss.Mark
                        FROM  		StudentSubject ss
                        INNER JOIN	getID g ON ss.RN=g.RN
                );
                --  xóa tất học sinh với Tên truyền vào
				DELETE FROM	Student
				WHERE 	`Name`=student_name ;
                
                --  xóa tất cả các điểm nhỏ hơn của các học sinh đó.
				DELETE  FROM  getDiem 
                WHERE	Diem<mark;
			END$$
	DELIMITER ;
    CALL 	Remove_Student('CTA','5');
    -- In ra StudentSubject và Student để Check Remove_Student
    SELECT * FROM StudentSubject;
    SELECT * FROM Student;
	
    

        
    
    
    
    
    
    
    
