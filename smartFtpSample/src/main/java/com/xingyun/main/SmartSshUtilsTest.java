package com.xingyun.main;

import com.xingyun.constant.MyServerInfoConstant;
import com.xingyun.utils.SmartSshUtils;

/**
 * @author
 */
public class SmartSshUtilsTest {
	public static void main(String[] args) {
		String hostName= MyServerInfoConstant.REMOTE_SERVER_IP;
		String username=MyServerInfoConstant.USER_NAME;
		String password=MyServerInfoConstant.PASS_WORD;
		String srcFilePath=MyServerInfoConstant.SRC_FILE_PATH;
		String targetFilePath=MyServerInfoConstant.TARGET_FILE_PATH;

		SmartSshUtils.downLoadFileBySsh(hostName,username,password,srcFilePath,targetFilePath);
	}
}
