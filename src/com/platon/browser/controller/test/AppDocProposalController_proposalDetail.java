package com.platon.browser.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;
import com.platon.browser.util.SampleResultUtil;

public class AppDocProposalController_proposalDetail extends AbstractJavaSamplerClient {

	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/proposal/proposalDetails");
		params.addArgument("body.proposalHash", "0x09ffb5916c2f40f86ab3d395957fb6b0d5881be5e61fe20c408b4300a811f232");
		return params;
	}
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		String url = arg0.getParameter("url");
		String proposalHash = arg0.getParameter("body.proposalHash");
		
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("proposalHash", proposalHash);
		String requestBody = JSONObject.toJSONString(paramMap);
		
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		sr = SampleResultUtil.post(sr, url, requestBody);
		sr.sampleEnd();
		return sr;
	}

	public static void main(String[] args) {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/proposal/proposalDetails");
		params.addArgument("body.proposalHash", "0x09ffb5916c2f40f86ab3d395957fb6b0d5881be5e61fe20c408b4300a811f232");
		JavaSamplerContext arg0 = new JavaSamplerContext(params);
		AppDocProposalController_proposalDetail test = new AppDocProposalController_proposalDetail();
		test.setupTest(arg0);
		SampleResult sampleResult = test.runTest(arg0);
		System.out.println("result:"+sampleResult.getResponseDataAsString());
	}
	
}
