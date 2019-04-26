package com.polycis.api.nb.client.device;


import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "polycis-ns-lora-service", fallback = DeviceServiceClientHystrix.class)
public interface LoraServiceClient {


}
