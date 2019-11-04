package com.platon.browser.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;
import com.platon.browser.util.SampleResultUtil;

public class AppDocAddressController_details extends AbstractJavaSamplerClient {

	
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/address/details");
		params.addArgument("body.address", "0x60ceca9c1290ee56b98d4e160ef0453f7c40d219");
		return params;
	}
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		
		String url = arg0.getParameter("url");
		String address = arg0.getParameter("body.address");
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("address", address);
		String requestBody = JSONObject.toJSONString(paramMap);

		sr = SampleResultUtil.post(sr, url, requestBody);
		sr.sampleEnd();
		return sr;
	}

	public static void main(String[] args) {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/address/details");
		params.addArgument("body.address", "0x60ceca9c1290ee56b98d4e160ef0453f7c40d219");
		JavaSamplerContext arg0 = new JavaSamplerContext(params);
		AppDocAddressController_details test = new AppDocAddressController_details();
		test.setupTest(arg0);
		SampleResult sampleResult = test.runTest(arg0);
		System.out.println("result:"+sampleResult.getResponseDataAsString());
	}
}
