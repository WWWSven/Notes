## 开启硬件加速

- help 里找到 vmoption，添加：-Dsun.java2d.opengl=true，以启动硬件加速

## idea2020.2 Tomcat Console 中文乱码

- change ApacheTomcat conf Directory `Logging.properties`
```properties
# java.util.logging.ConsoleHandler.encoding = UTF-8
java.util.logging.ConsoleHandler.encoding = GBK
```

## DataGrip 时区&编码
- url后面增加即可解决 `?serverTimezone=Asia/Shanghai&characterEncoding=utf8`
> 出自 https://songzixian.com/windowstooluse/769.html

## jetBrains 30 天重置
1. jetBrains 清除注册表（regedit ）

- HKEY_CURRENT_USER\Software\JavaSoft
    - HKEY_CURRENT_USER\Software\JetBrains 下只有 tollbox ，so，不是这个

2. rm -rf %APPDATA%/JetBrains/* 

> http://idea.npegeek.com/limitless.html    （写了几个不同平台的脚本）（会被检测到）
> https://www.quora.com/Is-there-a-way-to-extends-trial-period-of-Jetbrains-IDE
> https://tsukie.com/en/technologies/how-to-reset-trial-time-for-jetbrains-products/
> jetBrains 注册码 http://idea.medeming.com/jihuoma/
