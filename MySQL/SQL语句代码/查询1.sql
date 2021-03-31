-- 查询 姓名和年龄
SELECT 
	NAME, -- 姓名
	age  -- 年龄
FROM 
	student; -- 学生表
SELECT * FROM student;
SELECT address FROM student;

-- 去除重复的结果集
SELECT DISTINCT address FROM student;
