package com.xingyun.utils;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @sees http://www.jcraft.com/jsch/
 * @author qing-fegn.zhao
 */
@Slf4j
public final class SmartSftpUtils {
	/**
	 *
	 * @param remoteServerIp
	 * @param username
	 * @param password
	 * @param remoteFilePath
	 * @param localFilePath
	 */
	public static void downloadFileBySftp(String remoteServerIp,
										  String username,
										  String password,
										  String remoteFilePath,
										  String localFilePath){
		JSch jsch = new JSch();
		try {
			Session session = jsch.getSession(username, remoteServerIp, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();

			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			sftpChannel.get(remoteFilePath, localFilePath);
			sftpChannel.exit();
			session.disconnect();
		} catch (JSchException e) {
			//To change body of catch statement use File | Settings | File Templates.
			log.error(e.getMessage(),e);
		} catch (SftpException e) {
			log.error(e.getMessage(),e);
		}
	}

	/**
	 * 禁用构造方法
	 */
	private SmartSftpUtils(){}
}
