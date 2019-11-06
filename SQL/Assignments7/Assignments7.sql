-- Use Database
		USE Project_Company;
   
-- Ex1 Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ
-- (Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
-- Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn) 

		DROP TRIGGER IF EXISTS Check_date;
		DELIMITER $$
		CREATE TRIGGER Check_date BEFORE INSERT ON Project_Modules
		FOR EACH ROW 	
		BEGIN
			DECLARE ModulesDate DATE;
			DECLARE	ModulesCompletedOn DATE;
			DECLARE	StartDate DATE;
			DECLARE	CompletedOn DATE;
			SET		ModulesDate=NEW.ProjectModulesDate;
			SET		ModulesCompletedOn=NEW.ProjectModulesCompledOn;
			SELECT 	ProjectStartDate INTO StartDate
			FROM    Projects;
			SELECT 	ProjectCompletedOn INTO CompletedOn
			FROM    Projects;
			IF 		((ModulesDate<StartDate)AND(ModulesCompletedOn>CompletedOn))
			THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Hãy nhập đúng định dạng ngày ProjectModulesDate<ProjectStartDate và ProjectModulesCompledOn>ProjectCompletedOn';
			END IF;
		END$$
		DELIMITER ;
-- Thử insert dữ liệu để check trigger
		INSERT INTO Project_Modules
		(ProjectID, 			EmployeeID,			ProjectModulesDate,		ProjectModulesCompledOn,		ProjectModulesDescription)
		VALUES
		(3,						3,					'2000-03-01',			'2005-08-01',					'ABC');
		
-- Ex2 : Tạo view
		USE Fresher;
		DROP VIEW IF EXISTS v1;
		CREATE VIEW 		v1 
		AS
		SELECT 		 		*
		FROM		 		Trainee
		WHERE		 		(ET_IQ + ET_Gmath>=20) AND (ET_IQ>=8) AND (ET_Gmath>=8) AND (ET_English>=18 );
-- Hiển Thị view
		SELECT 				*
        FROM				v1
	
    