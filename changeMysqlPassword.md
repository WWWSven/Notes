# MySQL for WIN  改密码

- ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: YES)
 
以管理员权限运行powershell，关闭mysqld进程
> tasklist | findstr mysqld 
> taskkill /F /PID xxxx 

跳过登录授权，此时命令行阻塞
> mysqld --skip-grant-tables

新启一个powershell，进入mysql CLI，
``` sql
update mysql.user set authentication_string=password('this is password') where user = 'root';
flush privileges;
```

获得加密后的值 password (authentication_string)；
``` sql
SELECT * from mysql.user \G; 
```

更新密码
``` sql
update mysql.user set password = 'this is authentication_string' where user = 'root';
flush privileges;
```

-----------------
