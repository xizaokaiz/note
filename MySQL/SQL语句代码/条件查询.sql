SELECT * FROM student

-- 查询年龄大于20岁
SELECT * FROM student WHERE age>20;
SELECT * FROM student WHERE age>=20;

-- 查询年龄等于20岁
SELECT * FROM student WHERE age=20;

-- 查询年龄不等于20岁
SELECT * FROM student WHERE age!=20;
SELECT * FROM student WHERE age<>20;

-- 查询年龄大于等于20且小于等于30
SELECT * FROM student WHERE age>=20 && age<=30;
SELECT * FROM student WHERE age>=20 AND age<=30;
SELECT * FROM student WHERE age BETWEEN 20 AND 30;

-- 查询年龄22岁，19岁，25岁的信息
SELECT * FROM student WHERE age= 22 OR age = 19 OR age = 25;
SELECT * FROM student WHERE age IN(22,19,25);

-- 查询英语成绩为null
select * from student where english = null; -- 不对的，null值不能使用= (!=) 判断
select * from student where english is null;

-- 查询英语成绩不为null
SELECT * FROM student WHERE english IS not NULL;

-- 查询姓马的有哪些？like
select * from student where name like '马%';
-- 查询姓名第二个字是化的人
SELECT * FROM student WHERE NAME LIKE '_化%';
-- 查询姓名是三个字的人
SELECT * FROM student WHERE NAME LIKE '___';
-- 查询姓名中包含马的人
select * from student where name like '%马%';







