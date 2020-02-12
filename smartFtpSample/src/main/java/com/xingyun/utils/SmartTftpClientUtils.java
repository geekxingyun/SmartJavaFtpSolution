package com.xingyun.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.tftp.TFTP;
import org.apache.commons.net.tftp.TFTPClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * 不支持带身份登录的FTP/FTPS/SFTP
 * @author qing-feng.zhao
 */
@Slf4j
public final class SmartTftpClientUtils {

	/**
	 * 默认超时时间
	 */
	private static final int DEFAULT_TIMEOUT=6000;
	/**
	 * 二进制传输模式
	 */
	private static final int TRANSFER_MODE = TFTP.BINARY_MODE;

	/**
	 * 使用TFTPClient 下载文件
	 * @param hostName
	 * @param port
	 * @param localFileName
	 * @param remoteFileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public static final Boolean downloadFileFromFtp(String hostName,int port,String localFileName,String remoteFileName) throws FileNotFoundException {
		Boolean downLoadResult=false;

		//获取本地文件对象
		File file = new File(localFileName);

		//检查本地文件是否已经存在
		//如果文件存在不要覆盖它
		if (file.exists())
		{
			log.error("Error: " + localFileName + " already exists.");
			System.exit(1);
		}

		//文件不存在开始下载
		//创建FTP 客户端
		TFTPClient tftpClient=new TFTPClient();
		//设置超时时间
		tftpClient.setDefaultTimeout(DEFAULT_TIMEOUT);
		//设置字符集
		tftpClient.setCharset(StandardCharsets.UTF_8);

		//尝试打开FTP 客户端连接
		try
		{
			tftpClient.open();
		}
		catch (SocketException e)
		{
			//打印错误日志
			log.error("Error: could not open local UDP socket.",e);
			//程序异常退出
			System.exit(1);
		}

		//写入文件
		try(FileOutputStream fileOutputStream= new FileOutputStream(localFileName)){
			//接受文件
			tftpClient.receiveFile(remoteFileName,TRANSFER_MODE,fileOutputStream,hostName,port);
			downLoadResult=true;
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}finally {
			tftpClient.close();
		}
		return downLoadResult;
	}
}
