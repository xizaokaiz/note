-- 账户表
CREATE TABLE account(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10),
	balance DOUBLE
);
-- 添加数据
INSERT INTO account(NAME,balance) VALUES('zhangsan',1000),('lisi',1000);

UPDATE account SET balance = 1000;
-- 张三给李四转账 500元
-- 0.开启事务
START TRANSACTION;
-- 1.张三账户-500
UPDATE account SET balance = balance - 500 WHERE NAME = 'zhangsan'; 
-- 2.李四账户+500
-- 出错了
UPDATE account SET balance = balance + 500 WHERE NAME = 'lisi';  
-- 发现执行没有问题，提交事务
COMMIT;
-- 发现出问题了，回滚事务
ROLLBACK;


SELECT @@autocommit; -- 1代表自动提交 0 代表手动提交
SET @@autocommit = 0;
SELECT * FROM account;

SELECT @@tx_isolation;



