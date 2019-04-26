package com.polycis.api.nb.client.app;

import com.polycis.api.nb.client.device.DeviceServiceClientHystrix;
import com.polycis.api.nb.common.ApiResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "polycis-ns-lora-service", fallback = AppServiceClientHystrix.class)
public interface AppServiceClient {

    @RequestMapping(value="/lora/application",method = {RequestMethod.POST},produces = {"application/json;charset=UTF-8"})
    ApiResult deleteApplicationById(@RequestBody String loraAppId);

}
