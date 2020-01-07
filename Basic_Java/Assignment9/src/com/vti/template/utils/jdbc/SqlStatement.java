package com.vti.template.utils.jdbc;

/**
 * This class is contain sql statement
 * 
 * @author NNDuy
 * @version 1.0
 * @Date Oct 31, 2017
 */
public class SqlStatement {
	
	 public static final String SELECT_ALL_USER = 
		      "SELECT firstname, lastname, email "
		      + "FROM user";
	 
	 public static final String SQL_EXITS_USER_BY_EMAIL = 
		      "SELECT firstname, lastname, email "
		      + "FROM user "
		      + "WHERE email= ?";
	 
	 public static final String SQL_GET_BY_FNAME_USER = 
			 "SELECT firstname, lastname, email "
			  + "FROM user"
			  + "WHERE firstname=? ";
	
	 public static final String SQL_INSERT_USER = 
		      "INSERT INTO user (firstname,lastname,email) " 
		      + "VALUES (?, ?, ?)";
	 
	 public static final String SQL_UPDATE_USER = 
		      "UPDATE user SET lastname= ?,firstname= ? WHERE email=? ";
	 
	 public static final String SQL_DELETE_USER = 
		      "DELETE FROM user WHERE  firstname=? ";
	 
	 public static final String SELECT_ALL_SUBJECT = 
		      "SELECT ID, `Name` "
		      + "FROM `Subject`";
	 
	 public static final String SELECT_ALL_STUDENT_SUBJECT = 
		      "SELECT s.Name,s.Age,s2.Name " + 
		      "FROM Student s " + 
		      "JOIN StudentSubject s1 ON s.RN=s1.RN " + 
		      "JOIN	Subject s2 ON s1.ID=s2.ID ";
	 
	 public static final String SQL_SORT_STUDENT_SUBJECT_BY_AGE = 
		      "SELECT s.Name,s.Age,s2.Name " + 
		      "FROM Student s " + 
		      "JOIN StudentSubject s1 ON s.RN=s1.RN " + 
		      "JOIN	Subject s2 ON s1.ID=s2.ID "+ 
		      "ORDER BY	s.Age ASC";
	 
	 public static final String SQL_SORT_STUDENT_SUBJECT_BY_STUDEN_TNAME = 
		      "SELECT s.Name,s.Age,s2.Name " + 
		      "FROM Student s " + 
		      "JOIN StudentSubject s1 ON s.RN=s1.RN " + 
		      "JOIN	Subject s2 ON s1.ID=s2.ID "+ 
		      "ORDER BY	s.Name ASC";
	 
	 public static final String SQL_SORT_STUDENT_SUBJECT_BY_SUBJECT_TNAME = 
		      "SELECT s.Name,s.Age,s2.Name " + 
		      "FROM Student s " + 
		      "JOIN StudentSubject s1 ON s.RN=s1.RN " + 
		      "JOIN	Subject s2 ON s1.ID=s2.ID "+ 
		      "ORDER BY	s2.Name ASC";
	 
	  public static final String SQL_GET_BY_ID_STUDENT = 
		      "SELECT RN, Name, Age, Gender "
		      + "FROM Student "
		      + "WHERE RN = ?";
	  
	  public static final String SQL_GET_STUDENT_BY_ID_SUBJECT = 
		      "SELECT s.RN,s.Name,s.Age,s.Gender " + 
		      " FROM Student s" + 
		      " JOIN StudentSubject s1 ON s.RN=s1.RN"+ 
		      " JOIN Subject s2 ON s1.ID=s2.ID " + 
		      " WHERE s2.ID=? ";
	  
	  public static final String SQL_GET_BY_ID_SUBJECT = 
		      "SELECT ID, Name "
		      + "FROM Subject "
		      + "WHERE ID = ?";
	 
	 public static final String SQL_CREATE_STUDENT = 
		      "INSERT INTO Student (Name, Age, Gender) " 
		      + "VALUES (?, ?, ?)";
	 
	 public static final String SQL_CREATE_SUBJECT = 
		      "INSERT INTO Subject (Name) " 
		      + "VALUES (?)";
	 
	 public static final String SQL_UPDATE_SUBJECT = 
			 "UPDATE Subject "
			 + "SET Name= ? "
			 + "WHERE ID=?";
	 
	 public static final String SQL_DELETE_SUBJECT = 
			 "DELETE FROM Subject "
			 + "WHERE ID= ? ";
	 
	  public static final String SQL_EXITS_STUDENT_BY_ID = 
		      "SELECT RN, Name, Age, Gender "
		      + "FROM Student "
		      + "WHERE RN = ?";
	  
	  public static final String SQL_EXITS_SUBJECT_BY_ID = 
		      "SELECT ID, Name"
		      + " FROM Subject "
		      + " WHERE ID = ? ";
	  
	  public static final String SQL_EXITS_STUDENT_BY_NAME = 
		      "SELECT RN, Name, Age, Gender "
		      + "FROM Student "
		      + "WHERE Name = ?";
	 
	
  public static final String SQL_SELECT_ALL_EXPERIENCE = 
      "SELECT FirstName, LastName, BirthDate, Address, Phone, Email, ExperienceInYear, ProSkill "
      + "FROM Candidate "
      + "WHERE Candidate_type = 0";

  public static final String SQL_SELECT_ALL_FRESHER = 
      "SELECT FirstName, LastName, BirthDate, Address, Phone, Email, Graduation_date, Graduation_rank, Education "
      + "FROM Candidate "
      + "WHERE Candidate_type = 1";

  public static final String SQL_SELECT_ALL_INTERN = 
      "SELECT FirstName, LastName, BirthDate, Address, Phone, Email, Majors, Semester, University_Name "
      + "FROM Candidate "
      + "WHERE Candidate_type = 2";

  public static final String SQL_INSERT_EXPERIENCE = 
      "INSERT INTO Candidate (FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type, ExperienceInYear, ProSkill) " 
      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

  public static final String SQL_INSERT_FRESHER = 
      "INSERT INTO Candidate (FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type, Graduation_date, Graduation_rank, Education) " 
      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  public static final String SQL_INSERT_INTERN = 
      "INSERT INTO Candidate (FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type, Majors, Semester, University_Name) " 
      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  public static final String SQL_CHECK_PACKAGE = 
      "SELECT * "
      + "FROM Recruiment r "
      + "JOIN ("
            + "SELECT  CASE Candidate_type "
                         + "WHEN 0 THEN 'A' "
                         + "WHEN 1 THEN 'B' "
                         + "WHEN 2 THEN 'C' "
                         + "ELSE null "
                    + "END Candidate_type "
            + "FROM Candidate c "
            + "WHERE c.Email = ?) C ON c.Candidate_type = r.RecruimentPackage "
      + "WHERE r.Code = ?";

  public static final String SQL_CHECK_EMAIL_EXITS = 
      "SELECT * "
      + "FROM Candidate "
      + "WHERE Email = ?";

  public static final String SQL_CHECK_CODE_RECRUITMENT_EXITS = 
      "SELECT * "
      + "FROM Recruiment "
      + "WHERE Code = ?";

  
}
