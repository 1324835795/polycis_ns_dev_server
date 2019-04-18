package com.polycis.api.nb.controller.device;

import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.common.config.rabbit.MsgProducer;
import com.polycis.api.nb.entity.device.DeviceEntity;
import com.polycis.api.nb.service.device.IDeviceListService;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 问答数据同步接口，该接口提供的方法主要有car_job定时任务调用；
 * @author weitt
 * @date 2017-05-01
 */
@RestController
@RequestMapping("/lora")
public class NBListController
{
    private static final Logger logger = LoggerFactory.getLogger(NBListController.class);
    @Autowired
    IDeviceListService deviceListService;
    @Autowired
    MsgProducer msgProducer;


    /**
     * http://127.0.0.1:12500/lora/list
     * */
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public String getNextId(DeviceEntity deviceEntity) {
        ApiResult apiResult  = new ApiResult<List<DeviceEntity>>(CommonCode.SUCCESS);
        apiResult.setCode(CommonCode.SUCCESS.getKey());
        try {
            //设备
            System.out.println();
            List<DeviceEntity> deviceEntityList = deviceListService.getDeviceList(deviceEntity);
            apiResult.setData(deviceEntityList);
        }catch (Exception e){
            //捕获异常打印异常信息
            apiResult.setCode(CommonCode.ERROR.getKey());
            logger.error(String.format("获取主设备列表异常，异常信息：%s", ExceptionUtils.getFullStackTrace(e)));
        }
        return  apiResult.toString();
    }


    /**
     * http://127.0.0.1:12500/lora/mq/send
     * */
    @RequestMapping(value = "/mq/send", produces = {"application/json;charset=UTF-8"})
    public String send() {
        ApiResult apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        msgProducer.sendMsg("weitaoooo");
        return apiResult.toString();
    }


   /* *//**
     * http://127.0.0.1:12500/lora/devices
     * *//*
    @RequestMapping(value = "/devices", produces = {"application/json;charset=UTF-8"})
    public String devices() {
        ApiResult apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        List<DeviceEntity> deviceEntities=   deviceMapper.selectList(null);
        apiResult.setData(deviceEntities);
        return apiResult.toString();
    }*/


}
