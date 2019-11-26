package com.zy.accessory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
public class ConfigBean {

	private String demo;
	/*
	七牛
	 */
	private static String qiniuAccesskey;// 七牛 QINIU_ACCESSKEY
	private static String qiniuSecretkey;// 七牛 QINIU_SECRETKEY
	private static String qiniuBucket;// 七牛 空间名
	private static String qiniuCdnPrefix;// 七牛 访问前缀

	public String getDemo() {
		return demo;
	}
	public void setDemo(String demo) {
		this.demo = demo;
	}

	public static String getQiniuAccesskey() {
		return qiniuAccesskey;
	}

	public static void setQiniuAccesskey(String qiniuAccesskey) {
		ConfigBean.qiniuAccesskey = qiniuAccesskey;
	}

	public static String getQiniuSecretkey() {
		return qiniuSecretkey;
	}

	public static void setQiniuSecretkey(String qiniuSecretkey) {
		ConfigBean.qiniuSecretkey = qiniuSecretkey;
	}

	public static String getQiniuBucket() {
		return qiniuBucket;
	}

	public static void setQiniuBucket(String qiniuBucket) {
		ConfigBean.qiniuBucket = qiniuBucket;
	}

	public static String getQiniuCdnPrefix() {
		return qiniuCdnPrefix;
	}

	public static void setQiniuCdnPrefix(String qiniuCdnPrefix) {
		ConfigBean.qiniuCdnPrefix = qiniuCdnPrefix;
	}
}
