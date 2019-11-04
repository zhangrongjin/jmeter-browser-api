package com.platon.browser.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;
import com.platon.browser.util.SampleResultUtil;

public class AppDocProposalController_proposalList extends AbstractJavaSamplerClient {

	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/proposal/proposalList");
		params.addArgument("body.pageNo", "1");
		params.addArgument("body.pageSize", "10");
		return params;
	}
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		String url = arg0.getParameter("url");
		String pageNo = arg0.getParameter("body.pageNo");
		String pageSize = arg0.getParameter("body.pageSize");
		
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("pageNo", pageNo);
		paramMap.put("pageSize", pageSize);
		String requestBody = JSONObject.toJSONString(paramMap);
		
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		sr = SampleResultUtil.post(sr, url, requestBody);
		sr.sampleEnd();
		return sr;
	}

}
