package com.platon.browser.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;
import com.platon.browser.util.SampleResultUtil;

public class AppDocProposalController_voteList extends AbstractJavaSamplerClient {
	
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/proposal/voteList");
		params.addArgument("body.pageNo", "1");
		params.addArgument("body.pageSize", "10");
		params.addArgument("body.proposalHash", "0xcbd49989cb154912896b8ae2278c8db05d5de65317ceec1b96a24d09466dbf76");
		params.addArgument("body.option", "1");
		return params;
	}
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		String url = arg0.getParameter("url");
		String pageNo = arg0.getParameter("body.pageNo");
		String pageSize = arg0.getParameter("body.pageSize");
		String proposalHash = arg0.getParameter("body.proposalHash");
		String option = arg0.getParameter("body.option");
		
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("pageNo", pageNo);
		paramMap.put("pageSize", pageSize);
		paramMap.put("proposalHash", proposalHash);
		paramMap.put("option", option);
		String requestBody = JSONObject.toJSONString(paramMap);
		
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		sr = SampleResultUtil.post(sr, url, requestBody);
		sr.sampleEnd();
		return sr;
	}
	
	public static void main(String[] args) {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/proposal/voteList");
		params.addArgument("body.pageNo", "1");
		params.addArgument("body.pageSize", "10");
		params.addArgument("body.proposalHash", "0x09ffb5916c2f40f86ab3d395957fb6b0d5881be5e61fe20c408b4300a811f232");
		params.addArgument("body.option", "1");
		JavaSamplerContext arg0 = new JavaSamplerContext(params);
		AppDocProposalController_voteList test = new AppDocProposalController_voteList();
		test.setupTest(arg0);
		SampleResult sampleResult = test.runTest(arg0);
		System.out.println("result:"+sampleResult.getResponseDataAsString());
	}
	
}
