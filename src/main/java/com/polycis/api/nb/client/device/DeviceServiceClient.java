package com.polycis.api.nb.client.device;

import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.entity.device.UnionDevice;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "polycis-ns-dev-register", fallback = DeviceServiceClientHystrix.class)
public interface DeviceServiceClient {



    @RequestMapping(value = "/appisdevisExistExist", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    ApiResult selectDev(@RequestBody UnionDevice device);

    @RequestMapping(value = "/addDevice", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    ApiResult addDevice(@RequestBody UnionDevice unionDevice);


    @RequestMapping(value = "/deleteDev", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    ApiResult deleteDevice(@RequestBody UnionDevice unionDevice);



}
