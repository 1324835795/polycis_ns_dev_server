package com.polycis.api.nb.client.device;

import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import org.springframework.stereotype.Component;

@Component
public class LoraDataServiceHystrix implements LorDataService {
    ApiResult<String> apiResult = new ApiResult<>(CommonCode.ERROR);

    @Override
    public String getLoraList(Integer id, String name) {
        return apiResult.toString();
    }
}
