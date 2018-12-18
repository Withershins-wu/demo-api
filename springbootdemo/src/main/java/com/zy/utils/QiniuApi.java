package com.zy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.zy.accessory.ConfigBean;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * 七牛工具方法
 * 
 * @author:haimas
 * @date:2015年10月20日
 * @version:1.0
 */
public class QiniuApi {
    
	public static String SECRETKEY = ConfigBean.getQiniuSecretkey();
	public static String BUCKET_NAME = ConfigBean.getQiniuBucket();
	public static String ACCESSKEY = ConfigBean.getQiniuAccesskey();
	public static String QINIU_CDN_PREFIX = ConfigBean.getQiniuCdnPrefix();

	
	public static Auth auth; //  = Auth.create(ACCESSKEY, SECRETKEY);
	private static Logger log = LoggerFactory.getLogger(QiniuApi.class);

	// 上传管理对象，用于上传
	private static UploadManager uploadManager = new UploadManager();

	// 空间管理对象，用于空间文件操作，删除，重命名，复制等操作
	private static BucketManager bucketManager = new BucketManager(Auth.create(ACCESSKEY, SECRETKEY));

	public static String getUploadToken() {
		StringMap policy = new StringMap();
		policy.putNotEmpty(
				"returnBody",
				"{\"key\":$(key),\"hash\":$(etag),\"w\":$(imageInfo.width),\"h\":$(imageInfo.height),\"format\":$(imageInfo.format)}");

		return Auth.create(ACCESSKEY, SECRETKEY).uploadToken(BUCKET_NAME, null, 3600, policy);
	}

	public static String getUploadToken(String key) {
		StringMap policy = new StringMap();
		policy.putNotEmpty(
				"returnBody",
				"{\"key\":$(key),\"hash\":$(etag),\"w\":$(imageInfo.width),\"h\":$(imageInfo.height),\"format\":$(imageInfo.format)}");

		return Auth.create(ACCESSKEY, SECRETKEY).uploadToken(BUCKET_NAME, key, 3600, policy);
	}

	/**
	 * 根据key获取访问url
	 * @param key
	 * @return
	 */
	public static String getUrlByKey(String key) {

		return getUrlByKey(key, QINIU_CDN_PREFIX);
	}

	/**
	 * 根据key获取访问url，
	 * @param key 七牛空间中，该文件的key
	 * @param prefix 前缀
	 * @return
	 */
	public static String getUrlByKey(String key, String prefix) {
		return prefix + "/" + key;
	}

	public static String delete(String key) {
		try {
			bucketManager.delete(BUCKET_NAME, key);
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
			log.error(r.toString());
			try {
				// 响应的文本信息
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return null;
	}

	/**
	 * 简单上传，以文件名作为七牛空间中的键， 上传策略为默认的覆盖上传（如果有该键的，覆盖以前该键的文件）
	 * 
	 * @param file
	 * @return
	 */
	public static String uploadFile(File file) {
		try {

			String fileName = file.getName();

			Response res = uploadManager.put(file, fileName, getUploadToken());
			String body = res.bodyString();

			log.info("body = " + body);

			JSONObject jsonObject = JSON.parseObject(body);
			if (null != jsonObject) {
				return QINIU_CDN_PREFIX+jsonObject.getString("key");
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
			log.error(r.toString());
			try {
				// 响应的文本信息
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return null;
	}

	/**
	 * 指定键的上传 上传策略为默认的覆盖上传（如果有该键的，覆盖以前该键的文件）
	 * 
	 * @param key 七牛空间中的键
	 * @param file 文件
	 * @return
	 */
	public static String uploadFile(String key, File file) {
		try {

			Response res = uploadManager.put(file, key, getUploadToken(key));
			String body = res.bodyString();

			log.info("body = " + body);

			JSONObject jsonObject = JSON.parseObject(body);
			if (null != jsonObject) {
				return QINIU_CDN_PREFIX+jsonObject.getString("key");
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
			log.error(r.toString());
			try {
				// 响应的文本信息
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return null;
	}

	/**
	 * 指定键的上传 上传策略为默认的覆盖上传（如果有该键的，覆盖以前该键的文件）
	 * 
	 * @param key //七牛空间中的键
	 * @param data //file文件
	 * @return
	 */
	public static String uploadFile(String key, byte[] data) {
		try {
			Response res = uploadManager.put(data, key, getUploadToken(key));
			String body = res.bodyString();
			log.info("body = " + body);

			JSONObject jsonObject = JSON.parseObject(body);
			if (null != jsonObject) {
				return QINIU_CDN_PREFIX+jsonObject.getString("key");
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
			log.error(r.toString());
			try {
				// 响应的文本信息
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		
		return null;
	}



	/**
	 * 下载网络图片，传到七牛
	 * 
	 * @param urlString
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String downloadFile(String urlString, String key)throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 设置请求超时为5s
		con.setConnectTimeout(5 * 1000);
		// 输入流
		InputStream is = con.getInputStream();

		String savekey = uploadFile(key, input2byte(is));

		is.close();

		return savekey;
	}

	// InputStream转byte[]
	public static final byte[] input2byte(InputStream inStream)
	
			throws IOException {
		
		long time= System.currentTimeMillis();
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[1000];
		int len = 0;
		while ((len = inStream.read(buff)) > 0) {
			swapStream.write(buff, 0, len);
		}

		swapStream.close();

		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}


}
