-- 1.切换到mysql数据库	
USE mysql
-- 2.查询user表 
SELECT * FROM USER;

-- 创建用户
CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';

CREATE USER 'zhangsan'@'localhost' IDENTIFIED BY '123';
CREATE USER 'zhangsan'@'%' IDENTIFIED BY '123';

-- 删除用户
DROP USER '用户名'@'主机名';
DROP USER 'zhangsan'@'localhost';

-- 修改zhangsan用户密码为 abc
UPDATE USER SET PASSWORD = PASSWORD('新密码') WHERE USER = '用户名';
UPDATE USER SET PASSWORD = PASSWORD('abc') WHERE USER = 'zhangsan';

SET PASSWORD FOR '用户名'@'主机名' = PASSWORD('新密码');
SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123456');

-- 查询权限
SHOW GRANTS FOR '用户名'@'主机名';
SHOW GRANTS FOR 'zhangsan'@'%';
SHOW GRANTS FOR 'root'@'%';

-- 授予权限
GRANT 权限列表 ON 数据库.表名 TO '用户名'@'主机名';

GRANT SELECT,DELETE,UPDATE ON db3.account TO 'zhangsan'@'%';

-- 给张三用户授予所有权限，在任意数据库，任意表上
GRANT ALL ON *.* TO 'zhangsan'@'%';

-- 撤销权限：
REVOKE 权限列表 ON 数据库.表名 FROM '用户名'@'主机名';
REVOKE UPDATE ON db3.account FROM 'zhangsan'@'%';



