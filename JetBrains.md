## DataGrip 时区&编码
- 连接字符串后面增加 `?serverTimezone=Asia/Shanghai&characterEncoding=utf8`

## idea2020.2 Tomcat Console 中文乱码

- change ApacheTomcat conf Directory `Logging.properties`
```properties
# java.util.logging.ConsoleHandler.encoding = UTF-8
java.util.logging.ConsoleHandler.encoding = GBK
```
