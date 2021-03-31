SELECT * FROM student;

INSERT INTO student VALUES(1,'马云',55,'男','杭州',66,78),(2,'马化腾',45,'女','深圳',98,87),
(3,'马景涛',55,'男','香港',56,77),(4,'柳岩',20,'女','湖南',76,65),(5,'柳青',20,'男','湖南',86,NULL);

SELECT * FROM student ORDER BY math DESC; -- 排序方式


-- 按照数学成绩排名，如果数学成绩一样，则按照英语成绩排名
SELECT * FROM student ORDER BY math ASC,english ASC;


SELECT COUNT(english) FROM student;

SELECT COUNT(IFNULL(english,0)) FROM student;

SELECT COUNT(id) FROM student;

SELECT MAX(math) FROM student;
SELECT MIN(math) FROM student;

SELECT SUM(english) FROM student;

SELECT AVG(math) FROM student;

SELECT * FROM student;

-- 按照性别分组，分别查询男、女同学的平均分
SELECT sex,AVG(math), FROM student GROUP BY sex;

-- 按照性别分组，分别查询男、女同学的平均分，人数
SELECT sex,AVG(math),COUNT(id) FROM student GROUP BY sex;

-- 按照性别分组，分别查询男、女同学的平均分，人数 要求：分数低于70分的人，不参与分组。
SELECT sex,AVG(math),COUNT(id) FROM student WHERE math>70 GROUP BY sex  ;

-- 按照性别分组，分别查询男、女同学的平均分，人数 要求：分数低于70分的人，不参与分组,分组之后，人数要大于2个人
SELECT sex,AVG(math),COUNT(id) FROM student WHERE math>70 GROUP BY sex HAVING COUNT(id) >2 ;

-- 按照性别分组，分别查询男、女同学的平均分，人数 要求：分数低于70分的人，不参与分组,分组之后，人数要大于2个人
SELECT sex,AVG(math),COUNT(id) 人数 FROM student WHERE math>70 GROUP BY sex HAVING 人数 >2 ;

-- 每页显示三条记录
SELECT * FROM student LIMIT 0,3; -- 第一页
SELECT * FROM student LIMIT 3,3; -- 第二页
SELECT * FROM student LIMIT 6,3; -- 第三页

-- 公式，开始的索引 = (当前的页码-1) * 每页显示的条数



