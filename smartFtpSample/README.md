## Getting Started

如何实现使用Java 连接FTP或SFTP 进行下载文件呢？

使用Java 实现FTP 的解决方案

## 方案一:
org.apache.commons.net.tftp.TFTPClient
缺点:无法进行账号密码登录
## 方案二：
org.apache.commons.net.ftp.FTPClient
缺点:支持FTP,不支持SFTP
org.apache.commons.net.ftp.FTPSClient
缺点:支持FTPS,不支持SFTP
## 方案三：
JSch  http://www.jcraft.com/jsch/
支持SFTP
## 方案四
https://camel.apache.org/components/latest/ftp-component.html

FTP 可以使用这个
[Apache Commons Net™]((https://commons.apache.org/proper/commons-net/))库实现了许多基本Internet协议的客户端。

支持的协议如下所示:
- FTP/FTPS
- FTP over HTTP (experimental)
- NNTP
- SMTP(S)
- POP3(S)
- IMAP(S)
- Telnet
- TFTP
- Finger
- Whois
- rexec/rcmd/rlogin
- Time (rdate) and Daytime
- Echo
- Discard
- NTP/SNTP