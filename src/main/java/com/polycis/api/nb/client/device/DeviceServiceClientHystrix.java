package com.polycis.api.nb.client.device;

import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.entity.device.UnionDevice;
import org.springframework.stereotype.Component;

@Component
public class DeviceServiceClientHystrix implements DeviceServiceClient {
    ApiResult<String> apiResult = new ApiResult<>(CommonCode.ERROR);


    @Override
    public ApiResult selectDev(UnionDevice device) {
        return apiResult;
    }

    @Override
    public ApiResult addDevice(UnionDevice unionDevice) {
        return apiResult;
    }

    @Override
    public ApiResult deleteDevice(UnionDevice unionDevice) {
        return apiResult;
    }
}
