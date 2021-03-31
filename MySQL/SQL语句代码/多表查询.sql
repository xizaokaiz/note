# 创建部门表
CREATE TABLE dept(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);
INSERT INTO dept(NAME) VALUES('开发部'),('市场部'),('财务部');
# 创建员工表
CREATE TABLE emp(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10),
	gender CHAR(1), -- 性别
	salary DOUBLE, -- 工资
	join_date DATE, -- 入职日期
	dept_id INT,
	FOREIGN KEY(dept_id) REFERENCES dept(id) -- 外键，关联部门表(部门表的主键)
);

INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('孙悟空','男',7200,'2013-02-24',1);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('猪八戒','男',5600,'2010-12-02',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('唐僧','男',9000,'2008-08-08',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('白骨精','女',5000,'2015-10-07',3);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('蜘蛛精','女',4500,'2011-03-14',1);




--

SELECT * FROM emp,dept;
-- 笛卡尔积 A,B
-- 消除无用的数据

-- 隐式内连接
-- 查询所有员工信息和对应的部门信息
SELECT * FROM emp,dept WHERE emp.dept_id = dept.id;
-- 查询员工表的名称，性别，部门表的名称
SELECT emp.name,emp.gender,dept.name FROM emp,dept WHERE emp.dept_id = dept.id;
-- 标准写法
SELECT 
	t1.name, -- 员工表的姓名
	t1.gender, -- 员工表的性别
	t2.name -- 部门表的名称
FROM 
	emp t1,
	dept t2
WHERE
	t1.dept_id = t2.id;

-- 显示内连接
SELECT * FROM emp INNER JOIN dept ON emp.dept_id = dept.id;
SELECT * FROM emp JOIN dept ON emp.dept_id = dept.id;


SELECT * FROM dept;
SELECT * FROM emp;
-- 查询所有员工信息，如果员工有部门，则查询部门的名称，如果没有部门，则不显示
SELECT	-- 内连接
	t1.*,t2.name
FROM 
	emp t1,dept t2
WHERE
	t1.dept_id = t2.id;
-- 左外连接
SELECT t1.*,t2.name FROM emp t1 LEFT JOIN dept t2 ON t1.dept_id = t2.id
-- 右外连接
SELECT t1.*,t2.name FROM emp t1 RIGHT JOIN dept t2 ON t1.dept_id = t2.id
SELECT * FROM dept t2 RIGHT JOIN emp t1 ON t1.dept_id = t2.id







