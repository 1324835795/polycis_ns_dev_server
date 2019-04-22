package com.polycis.api.nb.controller.device;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.common.vo.RequestVO;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;
import com.polycis.api.nb.service.device.IUnionAppService;
import com.polycis.api.nb.service.device.IUnionDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
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

            boolean b = iUnionDeviceService.deleteDev(unionDevice);
            apiResult.setData(b);
            if(b==false){
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg("设备不存在,删除失败");
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

            UnionDevice unionDevice = iUnionDeviceService.devisExist(device);
            if(unionDevice!=null){
                //查询到设备
                apiResult.setData(unionDevice);
            }else{
                //未查到数据
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg(CommonCode.NO_DATA.getValue());
                apiResult.setData(new UnionDevice());
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


        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("修改设备失败");
            Log.error(e.toString());
        }

        return apiResult;
    }


}

