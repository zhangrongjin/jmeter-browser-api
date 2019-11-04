package com.platon.browser.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String httpGet(String url, String param) {
		CloseableHttpResponse response = null;
		CloseableHttpClient client = null;
		try {
			HttpGet httpGet = new HttpGet(url + "?" + param);
			client = HttpClients.createDefault();
			response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Post发送json数据
	 */
	public static String httpPost(String url, String body) {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
			httpPost.setEntity(
					new StringEntity(body, ContentType.create("application/json", "UTF-8")));
			client = HttpClients.createDefault();
			response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
