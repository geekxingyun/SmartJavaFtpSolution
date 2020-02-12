package com.xingyun.constant;

/**
 * @author qing-feng.zhao
 */
public class MyServerInfoConstant {
	/**
	 * FTP IP 地址
	 *
	 */
	public static final String REMOTE_SERVER_IP="127.0.0.1";
	/**
	 * Sftp账号
	 */
	public static final String USER_NAME="root";
	/**
	 * Sftp密码
	 */
	public static final String PASS_WORD="toor";
	/**
	 * 测试远程服务器的文件路径
	 */
	public static final String SRC_FILE_PATH="/opt/app/remote.txt";
	/**
	 * 本地保存文件路径
	 */
	public static final String TARGET_FILE_PATH="C:/test/local.txt";
	/**
	 * 禁用构造方法
	 */
	private MyServerInfoConstant(){}
}
