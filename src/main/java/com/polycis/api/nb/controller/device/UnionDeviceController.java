package com.polycis.api.nb.controller.device;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.common.vo.RequestVO;
import com.polycis.api.nb.entity.device.Product;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;
import com.polycis.api.nb.entity.device.vo.DevQueueVO;
import com.polycis.api.nb.service.device.IUnionAppService;
import com.polycis.api.nb.service.device.IUnionDeviceService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cuiwenhao
 * @since 2019-04-18
 */
@RestController
@RequestMapping("/unionDevice")
public class UnionDeviceController {

    protected static Logger Log = LoggerFactory.getLogger(UnionDeviceController.class);
    @Autowired
    IUnionDeviceService iUnionDeviceService;

    /**
     * 对外新增设备
     * @param unionDevice
     * @return
     */
    @PostMapping(value = "/addDevice")
    public ApiResult addDevice(@RequestBody UnionDevice unionDevice) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Log.info("得到appEui"+unionDevice.getDevUuid());
            boolean b = iUnionDeviceService.addDev(unionDevice);
            apiResult.setData(b);
            if(b==false){
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("设备已存在");
            }
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("设备创建失败");
            Log.error(e.toString());
        }

        return apiResult;
    }


    /**
     * 删除设备信息
     * @param unionDevice
     * @return String
     */
    @PostMapping(value = "/deleteDev")
    public ApiResult deleteApp(@RequestBody UnionDevice unionDevice) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Log.info("得到appEui"+unionDevice.getDevUuid());
            boolean b = iUnionDeviceService.deleteDev(unionDevice);
            apiResult.setData(b);
            if(b==false){
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg("设备不存在,删除失败");
                Log.info("删除失败");
            }

        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("删除设备失败");
            Log.error(e.toString());
        }

        return apiResult;
    }


    /**
     * 查询设备
     * @param device
     * @return String
     */
    @PostMapping(value = "/devisExist")
    public ApiResult selectDev(@RequestBody UnionDevice device) {
        ApiResult<UnionDevice> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Log.info("得到appEui"+device.getDevUuid());
            UnionDevice unionDevice = iUnionDeviceService.devisExist(device);
            if(unionDevice!=null){
                //查询到设备
                apiResult.setData(unionDevice);
            }else{
                //未查到数据
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg(CommonCode.NO_DATA.getValue());

            }
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("查询应用失败");
            Log.error(e.toString());
        }
        return apiResult;
    }


    /**
     * 修改设备状态
     * @param device
     * @return String
     */
    @PostMapping(value = "/updateDev")
    public ApiResult updateDev(@RequestBody UnionDevice device) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            boolean b = iUnionDeviceService.updateDev(device);
            apiResult.setData(b);
            if (b==false){
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("修改设备失败");
            }
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("修改设备失败");
            Log.error(e.toString());
        }
        Log.info("得到appEui"+device.getDevUuid());
        return apiResult;
    }


    /**
     * 查询设备推送队列
     * @param
     * @return String
     */
    @PostMapping(value = "/devPushQueue")
    public ApiResult devPushQueue(@RequestParam (value = "devUuid", required = true)String devUuid) {
        ApiResult<DevQueueVO> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Log.info("设备进来"+devUuid);
            UnionDevice device = new UnionDevice();
            device.setDevUuid(devUuid);
            UnionDevice unionDevice = iUnionDeviceService.devisExist(device);

            if(unionDevice!=null){
                //查询到设备并查询推送信息
                DevQueueVO devQueueVO = iUnionDeviceService.deviQueue(unionDevice);
                Product devanaly = iUnionDeviceService.devanaly(unionDevice);
                devQueueVO.setProductId(devanaly.getId().toString());
                devQueueVO.setAnalysisWay(devanaly.getAnalysisWay());
                devQueueVO.setProtocolId(devanaly.getProtocolId());
                apiResult.setData(devQueueVO);
            }else{
                //未查到数据
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg(CommonCode.NO_DATA.getValue());
            }
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("查询设备推送队列失败");
            Log.error(e.toString());
        }
        return apiResult;
    }


    /**
     * 查询设备uuid Nb专用
     * @param device
     * @return String
     */
    @PostMapping(value = "/devuuid")
    public ApiResult selectDevuuid(@RequestBody UnionDevice device) {
        ApiResult<UnionDevice> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Log.info("得到appEui"+device.getNbDevId());
            UnionDevice unionDevice = iUnionDeviceService.devuuid(device);
            if(unionDevice!=null){
                //查询到设备
                apiResult.setData(unionDevice);
            }else{
                //未查到数据
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg(CommonCode.NO_DATA.getValue());

            }
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("查询应用失败");
            Log.error(e.toString());
        }
        return apiResult;
    }

}

