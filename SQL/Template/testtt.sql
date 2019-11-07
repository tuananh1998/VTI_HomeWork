-- Create DB
	DROP DATABASE IF EXISTS Project;
	CREATE DATABASE IF NOT EXISTS Project;
  -- Use Database
	USE Project;
-- Drop table if exists 
	DROP TABLE IF EXISTS CUSTOMER;
	DROP TABLE IF EXISTS CAR_ORDER;
	DROP TABLE IF EXISTS CAR;
    -- Create Table   
   -- Create Table Employee
	CREATE TABLE 	CUSTOMER ( 
		CustomerID 					INT AUTO_INCREMENT PRIMARY KEY,
		`Name`						VARCHAR(30) NOT NULL,
		Phone 						CHAR(13) NOT NULL,
		Email 						VARCHAR(50) UNIQUE NOT NULL,
		Address 					VARCHAR(100) NOT NULL,
        Note						VARCHAR(500) NOT NULL
	);
    -- Create Table CAR
	CREATE TABLE 	CAR (
		CarID 						INT AUTO_INCREMENT PRIMARY KEY,
		Maker						ENUM('HONDA','TOYOTA','NISSAN') NOT NULL ,
		Model 						CHAR(13) NOT NULL,
		`Year` 						SMALLINT UNIQUE NOT NULL,
		Color 						VARCHAR(50) NOT NULL,
        Note						VARCHAR(500) NOT NULL
	);
    -- Create Table CAR_ORDER
	CREATE TABLE 	CAR_ORDER ( 
		OrderID 					INT AUTO_INCREMENT PRIMARY KEY,
		CustomerID					INT NOT NULL ,
		CarID 						INT NOT NULL,
		Amount						SMALLINT DEFAULT 1 NOT NULL,
		SalePrice 					DOUBLE NOT NULL,
		OrderDate 					DATE NOT NULL,
		DeliveryDate 				DATE NOT NULL,
		DeliveryAddress 			VARCHAR(100) NOT NULL,
		Staus 						TINYINT(2) DEFAULT 0 NOT NULL,
        Note						VARCHAR(500) NOT NULL,
        FOREIGN KEY (CarID) REFERENCES  CAR(CarID) ON DELETE CASCADE,
        FOREIGN KEY (CustomerID) REFERENCES  CUSTOMER(CustomerID) ON DELETE CASCADE
	);
     -- Insert CUSTOMER
    INSERT INTO	CUSTOMER
	(`Name`,				Phone,				Email,					Address,						Note	)
	VALUES
	('A',					'123456',			'acb@gmail.com',		'HN',							'1'		),
	('A1',					'1234562',			'acb1@gmail.com',		'H1N',							'21'	),
	('A2',					'1234564',			'acb2@gmail.com',		'HN2',							'12'	);
     INSERT INTO	CAR
	(Maker,					 Model,				`Year`,					Color,							Note)
	VALUES
	('HONDA',				'HONDA1',			1990,					'YEALLOW',						'1'		),
	('TOYOTA',				'TOYOTA1',			1992,					'BLUE',							'12'	),
	('NISSAN',				'NISSAN1',			1994,					'RED',							'111'	);
    INSERT INTO		CAR_ORDER 
	(CustomerID,			CarID,				Amount,					SalePrice, 						OrderDate, 					DeliveryDate, 				DeliveryAddress,							Note)
	VALUES
	(1,						2,					2,						 5.000000,						'2000-03-01',				'2000-03-21',				 'HN' ,										'123'	),
	(2,						2,					2,						 6.000000,						'2000-03-04',				'2000-03-10',				 'HN1',										'1234'	),
	(3,						2,					2,						 8.000000,						'2000-03-08',				'2000-03-15',				 'HN2',										'1235'	),
	(3,						1,					7,						 8.000000,						'2000-03-08',				'2000-03-15',				 'HN2',										'1235'	);
    -- a
    SELECT 			c.`Name`,SUM(co.Amount)AS Amount
    FROM			CUSTOMER c
    INNER JOIN		CAR_ORDER co ON c.CustomerID=co.CustomerID
    GROUP BY		c.`Name`
    ORDER BY		co.Amount ASC;
	DROP FUNCTION IF EXISTS MostSale;
	DELIMITER $$
	CREATE FUNCTION MostSale() 
	 RETURNS VARCHAR(50)
      READS SQL DATA
			BEGIN
			DECLARE CarName VARCHAR(50); 
           
            
					
					SELECT 		c.Maker INTO CarName
					FROM 		CAR c
                    INNER JOIN	CAR_ORDER co ON c.CarID=co.CarID
                    WHERE		co.Amount IN(
							SELECT	    SUM(co.Amount)
							FROM	  	CAR_ORDER co
                            GROUP BY	co.CarID
                    );
			RETURN 	CarName;
		END $$
	DELIMITER ;
    -- USE Function
    SELECT 	MostSale() AS Maker_Name;
	
							
    
    