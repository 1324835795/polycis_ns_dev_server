package com.polycis.api.nb.service.device.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.reflect.TypeToken;
import com.polycis.api.nb.client.device.LorDataService;
import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.entity.device.DeviceEntity;
import com.polycis.api.nb.service.device.IDeviceListService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DeviceListService")
public class DeviceListService implements IDeviceListService {

    @Autowired
    LorDataService lorDataService;

    @Override
    public List<DeviceEntity> getDeviceList(DeviceEntity deviceEntity) {
        //调用微服务接口
        String json = lorDataService.getLoraList(deviceEntity.getId(),deviceEntity.getName());

        if(StringUtils.isBlank(json)){
           return  null;
        }else{
            //打印日志
            //log.info()
        }

        //对象反序列化,强制用这种方式，解决java泛型擦除的问题
        ApiResult<List<DeviceEntity>> result = JSON.parseObject(json, new TypeToken<ApiResult<List<DeviceEntity>>>() {
        }.getType());


        //根据你返回大获取业务数据
        if(result.getCode() == CommonCode.SUCCESS.getKey()){
            return  result.getData();
        }else{
            //打印日志 log.info()
            return null;
        }
    }
}
