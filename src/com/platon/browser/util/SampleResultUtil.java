package com.platon.browser.util;

import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;

public class SampleResultUtil {

	public static SampleResult post(SampleResult sr,String url,String requestBody) {
		String result = HttpUtil.httpPost(url, requestBody);
		JSONObject resultJson = JSONObject.parseObject(result);
		if(resultJson!=null && resultJson.getInteger("code")==0){
			sr.setResponseData(result, null);
			sr.setDataType(SampleResult.TEXT);
			sr.setSuccessful(true);
		}else {
			sr.setSuccessful(false);
		}
		return sr;
	}
	
}
