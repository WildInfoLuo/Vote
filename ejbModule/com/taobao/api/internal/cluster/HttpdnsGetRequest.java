package com.taobao.api.internal.cluster;

import java.util.HashMap;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;

public class HttpdnsGetRequest extends BaseTaobaoRequest<HttpdnsGetResponse> {

	@Override
	public String getApiMethodName() {
		return "taobao.httpdns.get";
	}

	@Override
	public Map<String, String> getTextParams() {
		return new HashMap<String, String>();
	}

	@Override
	public Class<HttpdnsGetResponse> getResponseClass() {
		return HttpdnsGetResponse.class;
	}

	@Override
	public void check() throws ApiRuleException {
	}

}
