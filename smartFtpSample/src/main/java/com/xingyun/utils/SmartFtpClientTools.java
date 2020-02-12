package com.xingyun.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * http://commons.apache.org/proper/commons-net/
 * @author qing-feng.zhao
 */
@Slf4j
public class SmartFtpClientTools {

	private static final String REMOTE_SERVER_IP="127.0.0.1";
	private static final int REMOTE_SERVER_PORT=22;

	private static final String USER_NAME="xing yun";
	private static final String USER_ACCOUNT="root";
	private static final String USER_PASSWORD="123456";

	public static void main(String[] args) {
		SmartFtpClientTools.downLoadFileFromFtp();
	}

	public static void downLoadFileFromFtp(){
		FTPClient ftpClient=new FTPClient();

		//是否使用代理
		//设置自动检测字符集是否为UTF-8
		ftpClient.setAutodetectUTF8(true);
		//设置字符集为UTF-8
		ftpClient.setCharset(StandardCharsets.UTF_8);

		//设置IPV4
		ftpClient.setUseEPSVwithIPv4(true);
		//设置FTP连接
		try {
			ftpClient.connect(REMOTE_SERVER_IP,22);
		} catch (IOException e) {
			log.error(REMOTE_SERVER_IP+":"+REMOTE_SERVER_PORT+"连接失败",e);
		}
		log.info("Connected to " + REMOTE_SERVER_IP + " on " + (REMOTE_SERVER_PORT>0 ? REMOTE_SERVER_PORT : ftpClient.getDefaultPort()));

		//尝试登陆
		try {
			//输入账号密码进行登录
			ftpClient.login(USER_NAME,USER_PASSWORD,USER_ACCOUNT);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}

		ftpClient.enterLocalPassiveMode();

		int reply = ftpClient.getReplyCode();
		log.info("login result:{}",reply);

		//下载文件
		try(InputStream inputStream = new FileInputStream("C:"+ File.separator+"test"+File.separator+"local.txt")
		) {
			//设置文件传输类型
			try {
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
			ftpClient.storeFile("/opt/app/remote.txt", inputStream);
		} catch (FileNotFoundException e) {
			log.error("File not Found Exception:",e);
		} catch (IOException e) {
			log.error("IO Exception:",e);
		}

		//断开连接
		try {
			ftpClient.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
