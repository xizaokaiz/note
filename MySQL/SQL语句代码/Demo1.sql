INSERT INTO stu(id,NAME,age) VALUES(1,'张无忌',18);
INSERT INTO stu VALUES(2,'赵敏',17,99.9,NULL,NULL);
INSERT INTO stu VALUES(3,"张三丰",17,99.9,"1893-11-11",NULL);
DELETE FROM stu WHERE id = 1;
DELETE FROM stu;
SELECT * FROM stu;
TRUNCATE TABLE stu; -- 删除表，然后再创建一个一模一样的空表
UPDATE stu SET age = 117 WHERE id = 3;
UPDATE stu SET age = 118 , score = 100 WHERE id  = 2;
UPDATE stu SET age = 20;

CREATE TABLE student(
	id INT ,
	NAME VARCHAR(32),
	age INT ,
	sex VARCHAR(1),
	address VARCHAR(4),
	math INT,
	english INT
);

