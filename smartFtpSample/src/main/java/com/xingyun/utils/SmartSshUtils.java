package com.xingyun.utils;

import lombok.extern.slf4j.Slf4j;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

import java.io.IOException;

/**
 * @Sees https://stackoverflow.com/questions/14617/how-to-retrieve-a-file-from-a-server-via-sftp
 * @author qing-feng.zhao
 */
@Slf4j
public final class SmartSshUtils {

	public static void downLoadFileBySsh(String hostName,
								String username,
								String password,
								String srcFilePath,
								String targetFilePath
	) {
		SSHClient ssh = new SSHClient();
		SFTPClient sftpClient = null;
		try {
			//ssh.loadKnownHosts(); to skip host verification
			ssh.addHostKeyVerifier(new PromiscuousVerifier());
			ssh.connect(hostName);
			ssh.authPassword(username, password);
			sftpClient = ssh.newSFTPClient();
			sftpClient.get(srcFilePath, targetFilePath);
			//create
			sftpClient.mkdir("/opt/app/testFolder");
			//sftpClient.mkdirs("");创建多级文件夹
			//sftpClient.rmdir("");重命名文件夹
			//sftpClient.ls(""); //列出当前目录
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if (null != sftpClient) {
				try {
					sftpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			try {
				ssh.disconnect();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 静态工具类应该禁用构造方法
	 */
	private SmartSshUtils(){}
}
