package com.polycis.api.nb.client.app;

import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;

public class AppServiceClientHystrix implements AppServiceClient{

    /**
     * 线程共享对象apiResult,不能再向里边塞值了
     */
    ApiResult<String> apiResult = new ApiResult<>(CommonCode.ERROR);
    @Override
    public ApiResult deleteApplicationById(String loraAppId) {
        return apiResult;
    }
}
