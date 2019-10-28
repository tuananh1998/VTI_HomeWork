-- Use DB adventureworks
	USE adventureworks;
-- Ex1
-- Question 1

   SELECT 		p.Name
   FROM 		product AS p
   WHERE		p.ProductSubcategoryID IN(
	   SELECT 		psc.ProductSubcategoryID
	   FROM 		productsubcategory AS psc
	   WHERE		psc.Name='Saddles');
   
-- Question 2
   
   SELECT 		p.Name
   FROM 		product AS p
   WHERE		p.ProductSubcategoryID IN(
	   SELECT 		psc.ProductSubcategoryID
	   FROM 		productsubcategory AS psc
	   WHERE		psc.Name LIKE 'Bo%');
	   
-- Question 3
     
   SELECT 		p.Name
   FROM 		product	AS p
   WHERE		p.ListPrice IN(
		SELECT 		MIN(p.ListPrice)
		FROM 		product AS p
		WHERE		p.ProductSubcategoryID IN(
			SELECT 		psc.ProductSubcategoryID
			FROM 		productsubcategory AS psc
			WHERE		psc.Name='Touring Bikes'));
     
-- Ex2
-- Question 1

   SELECT 			cr.Name,spr.Name
   FROM 			countryregion AS cr
   INNER JOIN		stateprovince AS spr ON cr.CountryRegionCode=spr.CountryRegionCode;
   
-- Question 2
   SELECT 			cr.Name,spr.Name
   FROM 			countryregion AS cr
   INNER JOIN		stateprovince AS spr ON cr.CountryRegionCode=spr.CountryRegionCode
   WHERE			cr.Name IN('Germany','Canada');
  
-- Question 3
-- Use Full outer Join
   SELECT 			soh.SalesOrderID,soh.OrderDate,soh.SalesPersonID,sp.SalesPersonID AS BusinessEntityID,sp.Bonus,sp.SalesYTD
   FROM 			salesorderheader AS soh
   LEFT JOIN		salesperson AS sp ON sp.SalesPersonID=soh.SalesPersonID
   INNER JOIN		employee AS e ON e.EmployeeID=soh.SalesPersonID
   WHERE			soh.SalesPersonID=NULL AND soh.OnlineOrderFlag=1
   UNION ALL
   SELECT 			soh.SalesOrderID,soh.OrderDate,soh.SalesPersonID,sp.SalesPersonID AS BusinessEntityID,sp.Bonus,sp.SalesYTD
   FROM 			salesorderheader AS soh
   RIGHT JOIN		salesperson AS sp ON sp.SalesPersonID=soh.SalesPersonID;
   
   -- Question 4
	
   SELECT 			soh.SalesOrderID,soh.OrderDate,e.Title AS Jobtitle,sp.Bonus,sp.SalesYTD
   FROM 			salesorderheader AS soh
   LEFT JOIN		salesperson AS sp ON sp.SalesPersonID=soh.SalesPersonID
   INNER JOIN		employee AS e ON e.EmployeeID=soh.SalesPersonID
   WHERE			soh.SalesPersonID=NULL AND soh.OnlineOrderFlag=1
   UNION ALL
   SELECT 			soh.SalesOrderID,soh.OrderDate,e.Title AS Jobtitle,sp.Bonus,sp.SalesYTD
   FROM 			salesorderheader AS soh
   RIGHT JOIN		salesperson AS sp ON sp.SalesPersonID=soh.SalesPersonID
   INNER JOIN		employee AS e ON e.EmployeeID=soh.SalesPersonID;
		
    
    