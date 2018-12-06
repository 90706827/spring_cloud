## 配置JEC

在使用配置服务的加密和解密功能，首先必须安装 JCE（Java Cryptography Extension），可以到 Oracle 的官方网站下载（下载地址），解压缩后会得到 local_policy.jar 和 US_export_policy.jar 两个 jar 包，将其复制到 $JAVA_HOME/jre/lib/security 目录中，即可完成安装。

jdk1.6下载路径：

https://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html

jdk1.7下载路径：

https://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html

jdk1.8下载路径：

https://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

```
cmd中
cd C:\Program Files\Java\jdk1.8.0_181\jre\bin
keytool -genkeypair -alias "config-server-key" -keyalg "RSA" -keystore "e:\temp\config-server-key.keystore" -validity 3560
```

![](img\jce.png)