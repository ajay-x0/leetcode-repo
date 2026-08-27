# Write your MySQL query statement below
SELECT e.name , b.bonus
FROM Employee AS e
LEFT JOIN Bonus as b
    ON e.empId = b.empId
WHERE b.bonus < 1000
OR b.empId IS NULL;