# SmartJavaFtpSolution
探究关于使用Java实现FTP，FTPS, SFTP 三种文件传输协议的解决方案

Apache Commons Net™库实现了许多基本Internet协议的客户端。

其中这个类库中有如下三个类：

org.apache.commons.net.tftp.TFTPClient
支持不需要账号密码访问的FTP 协议文件传输，不支持带验证的FTP文件传输
org.apache.commons.net.ftp.FTPClient
支持FTP,不支持FTPS和SFTP
org.apache.commons.net.ftp.FTPSClient
支持FTPS,不支持SFTP

关于在Java中实现SFTP协议文件传输有两个库可供使用。

使用 JSch 库
使用sshj 库

更多博文讲解：

[在Java中实现SFTP协议文件传输的两种解决方案](https://xingyun.blog.csdn.net/article/details/104277386)
