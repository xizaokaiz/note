-- 创建表添加约束
CREATE TABLE stu(
	id INT,
	NAME VARCHAR(20) NOT NULL -- name为非空
);
-- 删除name的非空约束
ALTER TABLE stu MODIFY NAME VARCHAR(20);
-- 创建表完后，添加非空约束
ALTER TABLE stu MODIFY NAME VARCHAR(20) NOT NULL;


-- 创建表时，添加唯一约束
CREATE TABLE stu(
	id INT,
	phone_number VARCHAR(20) UNIQUE -- 添加了唯一的约束
);
-- 注意mysql中，唯一约束限定的列的值可以有多个null

-- 删除唯一约束
-- alter table stu modify phone_number VARCHAR(20);
ALTER TABLE stu DROP INDEX phone_number;
-- 在创建表后，添加唯一约束
ALTER TABLE stu MODIFY phone_number VARCHAR(20) UNIQUE;


CREATE TABLE stu(
	id INT PRIMARY KEY, -- 给id添加主键约束
	NAME VARCHAR(20)
);
-- 删除主键
-- 错误：alter table stu modify id int;
ALTER TABLE stu DROP PRIMARY KEY;
-- 创建完表后，添加主键
ALTER TABLE stu MODIFY id INT PRIMARY KEY;

CREATE TABLE stu(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 给id添加主键约束
	NAME VARCHAR(20)
);
-- 删除自动增长
ALTER TABLE stu MODIFY id INT;
-- 添加自动增长
ALTER TABLE stu MODIFY id INT AUTO_INCREMENT;

INSERT INTO stu VALUES(NULL,'ccc');

SELECT * FROM stu;
DROP TABLE stu;


