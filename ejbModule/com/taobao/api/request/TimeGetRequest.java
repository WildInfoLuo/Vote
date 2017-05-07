package com.taobao.api.request;

import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TimeGetResponse;

/**
 * TOP API: taobao.time.get request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.28
 */
public class TimeGetRequest extends BaseTaobaoRequest<TimeGetResponse> {
	
	

	@Override
	public String getApiMethodName() {
		return "taobao.time.get";
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
	public Class<TimeGetResponse> getResponseClass() {
		return TimeGetResponse.class;
	}

	@Override
	public void check() throws ApiRuleException {
	}
	

}