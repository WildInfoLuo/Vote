package com.taobao.api.request;

import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.HttpdnsGetResponse;

/**
 * TOP API: taobao.httpdns.get request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.24
 */
public class HttpdnsGetRequest extends BaseTaobaoRequest<HttpdnsGetResponse> {
	
	

	@Override
	public String getApiMethodName() {
		return "taobao.httpdns.get";
	}

	@Override
	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	@Override
	public Class<HttpdnsGetResponse> getResponseClass() {
		return HttpdnsGetResponse.class;
	}

	@Override
	public void check() throws ApiRuleException {
	}
	

}