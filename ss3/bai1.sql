use quan_ly_sinh_vien;
SELECT * FROM student WHERE name LIKE '% % h%';
SELECT * FROM student JOIN class ON student.sID = class.id WHERE class.name LIKE '% hieu';
SELECT FROM subject WHERE credit BETWEEN 3 AND 5;
UPDATE student SET class_id = 2 WHERE name LIKE '% hieu';
SELECT name, sub_name, point FROM student
ORDER BY point DESC , name ASC;