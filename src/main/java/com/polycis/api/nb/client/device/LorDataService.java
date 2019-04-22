package com.polycis.api.nb.client.device;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "polycis-lora-web-server", fallback = LoraDataServiceHystrix.class)
public interface LorDataService {
    @RequestMapping(value = "/lora/list", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    String getLoraList(@RequestParam(value = "id", required = true) Integer id,
                              @RequestParam(value = "name", required = true) String name);



    @RequestMapping(value = "/unionApp/addApply", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    String test(@RequestParam(value = "id", required = true) Integer id,
                       @RequestParam(value = "name", required = true) String name);
}
