package com.platon.browser.controller.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.alibaba.fastjson.JSONObject;
import com.platon.browser.util.SampleResultUtil;

public class AppDocTransactionController_transactionListByBlock extends AbstractJavaSamplerClient {

	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("url", "http://192.168.16.173:9061/browser-server/transaction/transactionListByBlock");
		params.addArgument("body.pageNo", "1");
		params.addArgument("body.pageSize", "10");
		params.addArgument("body.blockNumber", "1");
		return params;
	}
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		String url = arg0.getParameter("url");
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		Iterator<String> it = arg0.getParameterNamesIterator();
		while(it.hasNext()) {
			String name = it.next();
			if(!name.startsWith("body.")) continue;
			String val = arg0.getParameter(name);
			paramMap.put(name.replace("body.", ""), val);
		}
		String requestBody = JSONObject.toJSONString(paramMap);
		
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		sr = SampleResultUtil.post(sr, url, requestBody);
		sr.sampleEnd();
		return sr;
	}
	
}
