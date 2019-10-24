-- use DB Fresher
	USE Fresher;
-- ex1
-- question 1
-- INSERT TABLE Trainee
	INSERT INTO Trainee(Full_Name,Birth_Date,Gender,ET_IQ,ET_Gmath,ET_English,Training_Class,Evaluation_Notes,VTI_Account) VALUES("Cấn Tuấn Anh","2007-03-28","F",20,20,20,"LK1","","CTA"),
		 ("Cấn Tuấn A","2007-03-28","F",10,20,20,"LK1","","CTC"),
		 ("Cấn Tuấn B","2007-03-28","F",15,20,20,"LK1","","CTD"),
		 ("Cấn Tuấn C","2007-03-28","F",14,20,20,"LK1","","CTE"),
		 ("Cấn Tuấn D","2007-04-28","F",15,20,20,"LK1","","CTF"),
		 ("Cấn Tuấn E","2007-05-28","F",20,20,20,"LK1","","CTG"),
		 ("Cấn Tuấn F","2007-06-28","F",20,20,20,"LK1","","CTH"),
		 ("Cấn Tuấn G","2007-08-28","F",20,20,20,"LK1","","CTJ"),
		 ("Cấn Tuấn H","2007-03-28","F",20,20,20,"LK1","","CTK"),
		 ("Cấn Tuấn J","2007-03-28","F",20,20,20,"LK1","","CTL"),
		 ("Cấn Tuấn J","2007-02-28","F",20,20,20,"LK1","","CTY"),
		 ("Cấn Tuấn J","2007-08-28","F",20,20,20,"LK1","","CTP"),
		 ("Cấn Tuấn J","2007-09-28","F",20,20,20,"LK1","","CTQ");
        
 -- question 2

	SELECT    
		 MONTH(Birth_Date) AS THÁNG,COUNT(TraineeID) AS SỐNGƯỜI
    FROM      
		 Trainee
    GROUP BY MONTH(Birth_Date);
    
-- question 3

    SELECT    	
		 TraineeID,Full_Name,Birth_Date,Gender,ET_IQ,ET_Gmath,ET_English,Training_Class,Evaluation_Notes,VTI_Account
    FROM     	
		 Trainee
    GROUP BY LENGTH(Full_Name)
    HAVING LENGTH(Full_Name)=MAX(LENGTH(Full_Name))
    LIMIT 1;
    
-- question 4

    SELECT   
		 *
    FROM     
		 Trainee
    WHERE	 
		(ET_IQ + ET_Gmath>=20) AND (ET_IQ>=8) AND (ET_Gmath>=8) AND (ET_English>=18);
    
-- question 5

	DELETE FROM Trainee 
    WHERE 
		TraineeID = 3;
    
-- question 6

	UPDATE Trainee 
    SET   
		TraineeID = 2 
    WHERE 
		TraineeID = 5;
   
    
    
    
