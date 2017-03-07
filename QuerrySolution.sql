CREATE TABLE Employee(EmpNo NUMBER PRIMARY KEY, Ename VARCHAR2(20), 
Job VARCHAR2(20), MGR VARCHAR2(20), Hiredate DATE, Salary NUMBER(10,2), DeptNo NUMBER);   

CREATE TABLE Department(DeptNo NUMBER PRIMARY KEY, Dname VARCHAR2(20), Location VARCHAR2(20));

SOLUTION QUERY 1;
SELECT d.dname, count(*) FROM Employee e,Department d WHERE e.deptno=d.deptno GROUP BY d.dname;

SOLUTION QUERY 1;
SELECT dept.dname, count(*) FROM Employee emp INNER JOIN Department dept ON emp.deptno = dept.deptno 
GROUP BY dept.dname;

