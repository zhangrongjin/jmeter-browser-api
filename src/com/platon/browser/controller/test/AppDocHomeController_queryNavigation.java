package com.platon.browser.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;
import com.platon.browser.util.SampleResultUtil;

public class AppDocHomeController_queryNavigation extends AbstractJavaSamplerClient {

	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/home/queryNavigation");
		params.addArgument("body.parameter", "1");
		return params;
	}
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		String url = arg0.getParameter("url");
		String parameter = arg0.getParameter("body.parameter");
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("parameter", parameter);
		String requestBody = JSONObject.toJSONString(paramMap);
		
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		sr = SampleResultUtil.post(sr, url, requestBody);
		sr.sampleEnd();
		return sr;
	}
	
	public static void main(String[] args) {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/home/queryNavigation");
		params.addArgument("body.parameter", "1");
		JavaSamplerContext arg0 = new JavaSamplerContext(params);
		AppDocHomeController_queryNavigation test = new AppDocHomeController_queryNavigation();
		test.setupTest(arg0);
		SampleResult sampleResult = test.runTest(arg0);
		System.out.println("result:"+sampleResult.getResponseDataAsString());
	}
	
}
