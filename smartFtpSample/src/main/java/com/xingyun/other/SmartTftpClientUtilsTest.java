package com.xingyun.other;


import com.xingyun.constant.MyServerInfoConstant;
import com.xingyun.utils.SmartTftpClientUtils;

import java.io.FileNotFoundException;

/**
 * @author qing-feng.zhao
 */
public class SmartTftpClientUtilsTest {
	public static void main(String[] args) throws FileNotFoundException {
		String hostName= MyServerInfoConstant.REMOTE_SERVER_IP;
		String remoteFileName=MyServerInfoConstant.SRC_FILE_PATH;
		String localFileName=MyServerInfoConstant.TARGET_FILE_PATH;
		int port=22;

		SmartTftpClientUtils.downloadFileFromFtp(hostName,port,localFileName,remoteFileName);

	}
}
