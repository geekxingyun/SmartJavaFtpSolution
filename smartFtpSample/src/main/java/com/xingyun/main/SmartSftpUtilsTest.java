package com.xingyun.main;

import com.xingyun.constant.MyServerInfoConstant;
import com.xingyun.utils.SmartSftpUtils;

/**
 * http://www.jcraft.com/jsch/
 * @author qing-feng.zhao
 */
public class SmartSftpUtilsTest {

	public static void main(String[] args) {
		//FTP IP
		String remoteServerIp= MyServerInfoConstant.REMOTE_SERVER_IP;
		//默认是22端口
		//Sftp账号
		String username=MyServerInfoConstant.USER_NAME;
		//Sftp密码
		String password=MyServerInfoConstant.PASS_WORD;
		//远程服务器地址
		String remoteFilePath=MyServerInfoConstant.SRC_FILE_PATH;
		//本地保存文件路径
		String localFilePath=MyServerInfoConstant.TARGET_FILE_PATH;
		//调用工具类下载文件
		SmartSftpUtils.downloadFileBySftp(remoteServerIp,username,password,remoteFilePath,localFilePath);
	}
}
