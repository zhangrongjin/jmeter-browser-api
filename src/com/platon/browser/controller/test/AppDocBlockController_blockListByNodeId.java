package com.platon.browser.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;
import com.platon.browser.util.SampleResultUtil;

public class AppDocBlockController_blockListByNodeId extends AbstractJavaSamplerClient {
	
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/block/blockListByNodeId");
		params.addArgument("body.pageNo", "1");
		params.addArgument("body.pageSize", "10");
		params.addArgument("body.nodeId", "0x0aa9805681d8f77c05f317efc141c97d5adb511ffb51f5a251d2d7a4a3a96d9a12adf39f06b702f0ccdff9eddc1790eb272dca31b0c47751d49b5931c58701e7");
		return params;
	}
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		String url = arg0.getParameter("url");
		String pageNo = arg0.getParameter("body.pageNo");
		String pageSize = arg0.getParameter("body.pageSize");
		String nodeId = arg0.getParameter("body.nodeId");
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("pageNo", pageNo);
		paramMap.put("pageSize", pageSize);
		paramMap.put("nodeId", nodeId);
		
		String requestBody = JSONObject.toJSONString(paramMap);
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		sr = SampleResultUtil.post(sr, url, requestBody);
		sr.sampleEnd();
		return sr;
	}
	
	public static void main(String[] args) {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/block/blockListByNodeId");
		params.addArgument("body.pageNo", "1");
		params.addArgument("body.pageSize", "10");
		params.addArgument("body.nodeId", "0x0aa9805681d8f77c05f317efc141c97d5adb511ffb51f5a251d2d7a4a3a96d9a12adf39f06b702f0ccdff9eddc1790eb272dca31b0c47751d49b5931c58701e7");
		JavaSamplerContext arg0 = new JavaSamplerContext(params);
		AppDocBlockController_blockListByNodeId test = new AppDocBlockController_blockListByNodeId();
		test.setupTest(arg0);
		SampleResult sampleResult = test.runTest(arg0);
		System.out.println("result:"+sampleResult.getResponseDataAsString());
	}
	
}
